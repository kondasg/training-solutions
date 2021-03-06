package kepesitovizsgagyakorlasbykovacseni.covid;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Pfizer extends Vaccine {

    public Pfizer(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Person> getVaccinationList() {
        try (Connection conn = super.getDataSource().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM registrations WHERE pregnancy LIKE 'igen'");
             ResultSet rs2 = stmt.executeQuery("SELECT * FROM registrations WHERE age >= 65");
             ResultSet rs3 = stmt.executeQuery("SELECT * FROM registrations WHERE age < 65 AND pregnancy LIKE 'nem'")) {
            List<Person> res = new ArrayList<>();
            addPersons(rs, res);
            addPersons(rs2, res);
            addPersons(rs3, res);
            return res;
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot select registrations", se);
        }
    }

    private void addPersons(ResultSet rs, List<Person> res) throws SQLException {
        while (rs.next()) {
            String person_name = rs.getString("person_name");
            int age = rs.getInt("age");
            String chronic_disease = rs.getString("chronic_disease");
            String pregnancy = rs.getString("pregnancy");
            res.add(new Person(person_name, age,
                    ChronicDisease.valueOf(chronic_disease.toUpperCase()),
                    Pregnancy.valueOf(pregnancy.toUpperCase())));
        }
    }
}
