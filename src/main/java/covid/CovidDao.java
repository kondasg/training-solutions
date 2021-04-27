package covid;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class CovidDao implements Constants {

    private final DataSource dataSource;

    public CovidDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public TreeMap<Integer, Menu> fillMenu() {
        TreeMap<Integer, Menu> menuItems = new TreeMap<>();
        String sqlQuery = "SELECT `id`, `name` FROM `menu`";
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sqlQuery)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                menuItems.put(id, new Menu(id, name));
            }
        } catch (SQLException se) {
            System.out.println(writeRedText(DB_CONNECT_ERROR + "\n" + se.getMessage()));
            System.exit(0);
        }
        return menuItems;
    }

    public List<String> searchCitiesByZip(String zip) {
        String sqlQuery = "SELECT `city`, `part_of_city` FROM `cities` WHERE `zip` LIKE ? ORDER BY `city`, `part_of_city`";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setString(1, zip);

            return getCitiesSearchCitiesByZip(stmt);

        } catch (SQLException se) {
            System.out.println(writeRedText(DB_CONNECT_ERROR + "\n" + se.getMessage()));
            return new ArrayList<>();
        }
    }

    private List<String> getCitiesSearchCitiesByZip(PreparedStatement stmt) {
        try (ResultSet rs = stmt.executeQuery()) {
            List<String> cities = new ArrayList<>();
            while (rs.next()) {
                String city = rs.getString("city").trim();
                String partOfCity = rs.getString("part_of_city").trim();
                if (!"".equals(partOfCity)) {
                    city += "-" + partOfCity;
                }
                cities.add(city);
            }
            return cities;
        } catch (SQLException se) {
            System.out.println(writeRedText(DB_RESULTSET_ERROR + "\n" + se.getMessage()));
            return new ArrayList<>();
        }
    }

    public boolean isDataExists(String table, String column, String data) {
        String sqlQuery = "SELECT `" + column + "` FROM `" + table + "` WHERE `" + column + "` LIKE ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setString(1, data);

            return isDataExistsResult(stmt);
        } catch (SQLException se) {
            System.out.println(writeRedText(DB_CONNECT_ERROR + "\n" + se.getMessage()));
            return false;
        }
    }

    private boolean isDataExistsResult(PreparedStatement stmt) {
        try (ResultSet rs = stmt.executeQuery()) {
            rs.last();
            return rs.getRow() > 0;
        } catch (SQLException se) {
            System.out.println(writeRedText(DB_RESULTSET_ERROR + "\n" + se.getMessage()));
            return false;
        }
    }

    public boolean insertCitizen(Citizen citizen) {
        String sqlQuery = "INSERT INTO `citizens` (`name`, `zip`, `birth`, `email`, `taj`) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setString(1, citizen.getName());
            stmt.setString(2, citizen.getZip());
            stmt.setDate(3, java.sql.Date.valueOf(citizen.getBirth()));
            stmt.setString(4, citizen.getEmail());
            stmt.setString(5, citizen.getTaj());
            stmt.executeUpdate();
            return true;
        } catch (SQLException se) {
            System.out.println(writeRedText(DB_INSERT_ERROR + "\n" + se.getMessage()));
            return false;
        }
    }

    public boolean insertVaccination(String taj, String dateTime, String status, String note, String vaccinationType) {
        String sqlQuery = "INSERT INTO `vaccinations` (`citizens_id`, `vaccination_datetime`, `status`, `note`, `vaccination_type`) " +
                "VALUES ((SELECT `citizens_id` FROM `citizens` WHERE `taj` LIKE ?), ?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setString(1, taj);
            stmt.setString(2, dateTime);
            stmt.setString(3, status);
            stmt.setString(4, note);
            stmt.setString(5, vaccinationType);
            stmt.executeUpdate();
            return true;
        } catch (SQLException se) {
            System.out.println(writeRedText(DB_INSERT_ERROR + "\n" + se.getMessage()));
            return false;
        }
    }

    public List<Vaccination> previousVaccinations(String taj) {
        String sqlQuery = "SELECT `citizens_id`, `vaccination_datetime`, `status`, `note`, `vaccination_type` " +
                "FROM `vaccinations` " +
                "WHERE `citizens_id` = (SELECT `citizens_id` FROM `citizens` WHERE `taj` LIKE ?) " +
                "ORDER BY `vaccination_datetime`";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setString(1, taj);
            List<Vaccination> vaccinations = new ArrayList<>();

            return getVaccinations(stmt, vaccinations);
        } catch (SQLException se) {
            System.out.println(writeRedText(DB_CONNECT_ERROR + "\n" + se.getMessage()));
            return new ArrayList<>();
        }
    }

    private List<Vaccination> getVaccinations(PreparedStatement stmt, List<Vaccination> vaccinations) {
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int citizensId = rs.getInt("citizens_id");
                LocalDateTime vaccinationDateTime =
                        rs.getTimestamp("vaccination_datetime").toLocalDateTime();
                String status = rs.getString("status");
                String note = rs.getString("note");
                String vaccinationType = rs.getString("vaccination_type");
                vaccinations.add(
                        new Vaccination(citizensId, vaccinationDateTime,
                                VaccinationStatus.valueOf(status), note, vaccinationType));
            }
            return vaccinations;
        } catch (SQLException se) {
            System.out.println(writeRedText(DB_RESULTSET_ERROR + "\n" + se.getMessage()));
            return new ArrayList<>();
        }
    }

    public List<Citizen> selectNonVaccination(String zip) {
        String sqlQuery = "SELECT `name`, `zip`, `birth`, `email`, `taj` FROM `citizens` " +
                "WHERE `zip` LIKE ? AND `citizens_id` NOT IN " +
                "(SELECT DISTINCT `citizens_id` FROM `vaccinations` WHERE `status` LIKE 'FIRST' OR `status` LIKE 'SECOND') " +
                "ORDER BY `birth`, `name` LIMIT 0,16";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setString(1, zip);
            List<Citizen> citizens = new ArrayList<>();

            return getCitizens(stmt, citizens);
        } catch (SQLException se) {
            System.out.println(writeRedText(DB_CONNECT_ERROR + "\n" + se.getMessage()));
            return new ArrayList<>();
        }
    }

    private List<Citizen> getCitizens(PreparedStatement stmt, List<Citizen> citizens) {
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String name = rs.getString("name");
                String citizenZip = rs.getString("zip");
                LocalDate birth = rs.getDate("birth").toLocalDate();
                String email = rs.getString("email");
                String taj = rs.getString("taj");
                citizens.add(new Citizen(name, citizenZip, birth, email, taj));
            }
            return citizens;
        } catch (SQLException se) {
            System.out.println(writeRedText(DB_RESULTSET_ERROR + "\n" + se.getMessage()));
            return new ArrayList<>();
        }
    }

    public int countVaccStatusByZip(String zip, String queryType) {
        String sqlQuery = "SELECT COUNT(`name`) AS `db` FROM `citizens` WHERE `zip` LIKE ?";
        switch (queryType) {
            case "NON" -> sqlQuery += " AND `citizens_id` NOT IN (SELECT DISTINCT `citizens_id` " +
                    "FROM `vaccinations` WHERE `status` LIKE 'FIRST' OR `status` LIKE 'SECOND')";
            case "SECOND" -> sqlQuery += "AND `citizens_id` IN (SELECT `citizens_id` " +
                    "FROM `vaccinations` WHERE `status` LIKE 'SECOND')";
        }

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setString(1, zip);

            return countVaccStatusByZipResult(stmt);
        } catch (SQLException se) {
            System.out.println(writeRedText(DB_CONNECT_ERROR + "\n" + se.getMessage()));
            return 0;
        }
    }

    private int countVaccStatusByZipResult(PreparedStatement stmt) {
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("db");
            }
            return 0;
        } catch (SQLException se) {
            System.out.println(writeRedText(DB_CONNECT_ERROR + "\n" + se.getMessage()));
            return 0;
        }
    }
}