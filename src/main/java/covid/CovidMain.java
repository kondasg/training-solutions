package covid;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CovidMain implements Constants {

    private static CovidDao covidDao;
    private static FileManager fileManager;
    private final Validation validation = new Validation();
    private final Scanner scanner = new Scanner(System.in);
    private TreeMap<Integer, Menu> menuItems = new TreeMap<>();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static void main(String[] args) {
        CovidMain covidMain = new CovidMain();

        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3307/csxxdg_covid?useUnicode=true");
            dataSource.setUser("csxxdg_t360");
            dataSource.setPassword("sWRAiZGCTAGY");
        } catch (SQLException se) {
            System.out.println(covidMain.writeRedText(DATA_SOURCE_ERROR + " " + se.getMessage()));
            System.exit(1);
        }
        covidDao = new CovidDao(dataSource);
        fileManager = new FileManager(covidDao);

        covidMain.printMenu();
    }

    public void printMenu() {
        initMenu();
        System.out.println(menuNameUnderline(MENU));
        for (Integer item : menuItems.keySet()) {
            System.out.println(menuItems.get(item).getIdAndName());
        }
        String selectedMenu;
        boolean valid;
        do {
            System.out.printf(INPUT_SPACE_FORMAT, SELECT_MENU + ":");
            selectedMenu = scanner.nextLine();
            valid = validation.isVlalidMenuItem(selectedMenu, menuItems);
        } while (!valid);

        int intSelectedMenu = Integer.parseInt(selectedMenu);
        System.out.println(menuNameUnderline(intSelectedMenu));
        switch (intSelectedMenu) {
            case 99 -> exitCovid();
            case 1 -> registration();
            case 2 -> bulkRegistration();
            case 3 -> generation();
            case 4 -> vaccination();
            case 5 -> failureVaccination();
            case 6 -> report();
        }
    }

    private void initMenu() {
        menuItems = covidDao.fillMenu();
    }

    public void registration() {
        String taj = getInputTaj(true);
        String name = getInputName();
        String zip = getInputZip();
        String birth = getInputBirth();
        String email = getInputEmail();
        getInputEmailRe(email);

        Citizen citizen = new Citizen(name.trim(), zip, LocalDate.parse(birth), email.toLowerCase(), taj);
        if (covidDao.insertCitizen(citizen)) {
            System.out.println(writeGreenText(INPUT_SUCCES));
        } else {
            System.out.println(writeRedText(INPUT_ERROR));
        }
        printMenu();
    }

    private String getInputName() {
        String name;
        boolean valid;
        do {
            System.out.printf(INPUT_SPACE_FORMAT, INPUT_NAME + ":");
            name = scanner.nextLine();
            valid = validation.isVlalidName(name);
            if (!valid) {
                System.out.println(writeRedText(INPUT_NAME_ERROR));
            }
        } while (!valid);
        return name;
    }

    private String getInputZip() {
        String zip;
        boolean valid;
        do {
            System.out.printf(INPUT_SPACE_FORMAT, INPUT_ZIP + ":");
            zip = scanner.nextLine();
            valid = validation.isVlalidZip(zip);
            List<String> cities;
            if (!valid) {
                System.out.println(writeRedText(INPUT_ZIP_ERROR));
            } else if ((cities = covidDao.searchCitiesByZip(zip)).size() == 0) {
                System.out.println(writeRedText(INPUT_ZIP_NOT_CITIES));
                valid = false;
            } else {
                System.out.printf(INPUT_SPACE_FORMAT, INPUT_ZIP_CITIES + ":");
                System.out.println(cities.toString());
            }
        } while (!valid);
        return zip;
    }

    private String getInputBirth() {
        String birth;
        boolean valid;
        do {
            System.out.printf(INPUT_SPACE_FORMAT, INPUT_BIRTH + ":");
            birth = scanner.nextLine();
            valid = validation.isVlalidBirth(birth);
            if (!valid) {
                System.out.println(writeRedText(INPUT_BIRTH_ERROR));
            }
        } while (!valid);
        return birth;
    }

    private String getInputEmail() {
        String email;
        boolean valid;
        do {
            System.out.printf(INPUT_SPACE_FORMAT, INPUT_EMAIL + ":");
            email = scanner.nextLine();
            valid = validation.isVlalidEmail(email);
            if (!valid) {
                System.out.println(writeRedText(INPUT_EMAIL_ERROR));
            } else if (covidDao.isDataExists("citizens", "email", email)) {
                System.out.println(writeRedText(INPUT_EMAIL_DUPLICATE));
                valid = false;
            }
        } while (!valid);
        return email;
    }

    private void getInputEmailRe(String email) {
        String emailRe;
        boolean valid;
        do {
            System.out.printf(INPUT_SPACE_FORMAT, INPUT_EMAILRE + ":");
            emailRe = scanner.nextLine();
            valid = validation.isVlalidEmailRe(email, emailRe);
            if (!valid) {
                System.out.println(writeRedText(INPUT_EMAILRE_ERROR));
            }
        } while (!valid);
    }

    private String getInputTaj(boolean duplicateMessageOn) {
        String taj;
        boolean valid;
        do {
            System.out.printf(INPUT_SPACE_FORMAT, INPUT_TAJ + ":");
            taj = scanner.nextLine();
            valid = validation.isVlalidTaj(taj);
            if (!valid) {
                System.out.println(writeRedText(INPUT_TAJ_ERROR));
            } else if (duplicateMessageOn && covidDao.isDataExists("citizens", "taj", taj)) {
                System.out.println(writeRedText(INPUT_TAJ_DUPLICATE));
                valid = false;
            }
        } while (!valid);
        return taj;
    }

    public void bulkRegistration() {
        System.out.printf(INPUT_SPACE_FORMAT, INPUT_FILE + ":");
        String file = scanner.nextLine();
        fileManager.readBulkFile(file);
        printMenu();
    }

    public void generation() {
        String zip = getInputZip();
        System.out.printf(INPUT_SPACE_FORMAT, INPUT_FILE + ":");
        String file = scanner.nextLine();
        fileManager.writeGenerationFile(zip, file);
        printMenu();
    }

    public void vaccination() {
        String taj = getInputTaj(false);
        if (covidDao.isDataExists("citizens", "taj", taj)) {
            List<Vaccination> vaccinations = covidDao.previousVaccinations(taj);
            Map<String, LocalDateTime> vaccinationStatus = new HashMap<>();
            System.out.println(writeBlueText(VACCINATION_HISTORY + ":"));

            if (vaccinations.size() > 0) {
                vaccinationsHistory(vaccinations, vaccinationStatus);
            } else {
                System.out.println(writeBlueText(NO_VACCINATION_HISTORY));
            }

            boolean isVaccinated = true;
            String vaccinationNumber = "FIRST";
            String vaccinationDateTime = "";

            if (vaccinationStatus.containsKey("SECOND")) {
                System.out.println(writeRedText(SECOND_VACCINATION_OK));
                isVaccinated = false;
            } else {
                vaccinationDateTime = getInputDateTime();
                if (vaccinationStatus.containsKey("FIRST")) {
                    if (vaccinationStatus.get("FIRST").plusDays(VACCINATION_DIFFERENCE_DAY)
                            .isAfter(LocalDateTime.parse(vaccinationDateTime, formatter))) {
                        System.out.println(writeRedText(SECOND_VACCINATION_FAILURE));
                        isVaccinated = false;
                    }
                    vaccinationNumber = "SECOND";
                }
            }

            if (isVaccinated) {
                storeVaccination(taj, vaccinationNumber, vaccinationDateTime);
            }
        } else {
            System.out.println(writeRedText(NOT_FOUND_TAJ));
        }
        printMenu();
    }

    private void vaccinationsHistory(List<Vaccination> vaccinations, Map<String, LocalDateTime> vaccinationStatus) {
        for (Vaccination vaccination : vaccinations) {
            System.out.println(writeBlueText(vaccination.printVaccination()));
            if (vaccination.getStatus().equals(VaccinationStatus.SECOND)) {
                vaccinationStatus.put("SECOND", vaccination.getVaccinationDateTime());
            }
            if (vaccination.getStatus().equals(VaccinationStatus.FIRST)) {
                vaccinationStatus.put("FIRST", vaccination.getVaccinationDateTime());
            }
        }
    }

    private void storeVaccination(String taj, String vaccinationNumber, String vaccinationDateTime) {
        System.out.printf(INPUT_SPACE_FORMAT, INPUT_VACCINATION_TYPE + ":");
        String vaccType = scanner.nextLine();
        System.out.printf(INPUT_SPACE_FORMAT, INPUT_NOTE + ":");
        String note = scanner.nextLine();

        if (covidDao.insertVaccination(taj, vaccinationDateTime, vaccinationNumber, note, vaccType)) {
            System.out.println(writeGreenText(INPUT_SUCCES));
        } else {
            System.out.println(writeRedText(INPUT_ERROR));
        }
    }

    public void failureVaccination() {
        String taj = getInputTaj(false);
        if (covidDao.isDataExists("citizens", "taj", taj)) {
            String vaccinationDateTime = getInputDateTime();
            System.out.printf(INPUT_SPACE_FORMAT, INPUT_FAILURE_NOTE + ":");
            String note = scanner.nextLine();
            if (covidDao.insertVaccination(taj, vaccinationDateTime,
                    VaccinationStatus.FAILURE.name(), note, "")) {
                System.out.println(writeGreenText(INPUT_SUCCES));
            } else {
                System.out.println(writeRedText(INPUT_ERROR));
            }
        } else {
            System.out.println(writeRedText(NOT_FOUND_TAJ));
        }
        printMenu();
    }

    private String getInputDateTime() {
        String dateTime;
        boolean valid;
        do {
            System.out.printf(INPUT_SPACE_FORMAT, INPUT_DATETIME + ":");
            dateTime = scanner.nextLine();
            valid = validation.isVlalidDateTime(dateTime);
            if (!valid) {
                System.out.println(writeRedText(INPUT_DATETIME_ERROR));
            }
        } while (!valid);
        return dateTime;
    }

    public void report() {
        String zip = getInputZip();
        int reg = covidDao.countVaccStatusByZip(zip, "REG");
        int sec = covidDao.countVaccStatusByZip(zip, "SECOND");
        int non = covidDao.countVaccStatusByZip(zip, "NON");
        System.out.println(writeBlueText(REG_NUMBER + ": " + reg));
        System.out.println(writeBlueText(FIRST_VACC_NUMBER + ": " + (reg - non - sec)));
        System.out.println(writeBlueText(SECOND_VACC_NUMBER + ": " + sec));
        System.out.println(writeBlueText(NON_VACC_NUMBER + ": " + non));
        printMenu();
    }

    private void exitCovid() {
        System.exit(0);
    }

    private String menuNameUnderline(int menuItem) {
        return menuNameUnderline(menuItems.get(menuItem).getName());
    }
}