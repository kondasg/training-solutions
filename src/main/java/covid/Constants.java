package covid;

import java.time.LocalTime;

public interface Constants {

    int MIN_AGE = 10;
    int MAX_AGE = 150;
    int VACCINATION_DIFFERENCE_DAY = 15;
    LocalTime START_VACCINATION_TIME = LocalTime.parse("08:00:00");
    int NEXT_VACCINATION_TIME = 30;

    String INPUT_SPACE_FORMAT = "%-44s";

    String MENU = "MENÜ";
    String SELECT_MENU = "Kérem válaszzon a menüpontok közül";

    String INPUT_SUCCES = "Sikeres adatfelvitel";
    String INPUT_ERROR = "Sikertelen adatfelvitel";

    String INPUT_NAME = "Teljes név";
    String INPUT_NAME_ERROR = "Túl rövid név!";
    String INPUT_ZIP = "Irányítószám";
    String INPUT_ZIP_CITIES = "Az irányítószámhoz tartozó település(ek)";
    String INPUT_ZIP_ERROR = "Nem létező irányítószám!";
    String INPUT_ZIP_NOT_CITIES = "Nem létezik ilyen irányítószám alatt település!";
    String INPUT_BIRTH = "Születési idő (formátum: éééé-hh-nn)";
    String INPUT_BIRTH_ERROR = "Hibás dátum, dátum formátum, túl öreg vagy túl fiatal az oltáshoz!";
    String INPUT_EMAIL = "Email cím";
    String INPUT_EMAIL_ERROR = "Hibás email cím formátum!";
    String INPUT_EMAIL_DUPLICATE = "Már létezik a email cím az adatbázisban!";
    String INPUT_EMAILRE = "Email cím mégegyszer";
    String INPUT_EMAILRE_ERROR = "Nem egyezik a két email cím!";
    String INPUT_TAJ = "TAJ szám";
    String INPUT_TAJ_ERROR = "Nem megfelelő TAJ szám!";
    String INPUT_TAJ_DUPLICATE = "Már létezik a TAJ szám az adatbázisban!";
    String INPUT_DATETIME = "Dátum (formátum: éééé-hh-nn óó:pp)";
    String INPUT_DATETIME_ERROR = "Hibás dátum vagy dátum formátum";
    String INPUT_FILE = "Kérem a file elérési útvonalát";
    String INPUT_FAILURE_NOTE = "Meghiúsulás oka";
    String INPUT_NOTE = "Megjegyzés";
    String NOT_FOUND_TAJ = "A TAJ szám nem található az adatbázisban!";
    String VACCINATION_HISTORY = "Oltási előzmény";
    String NO_VACCINATION_HISTORY = "nincs";
    String SECOND_VACCINATION_OK = "Mindkét oltás megvolt!";
    String SECOND_VACCINATION_FAILURE = "Nem telt még le a " + VACCINATION_DIFFERENCE_DAY + " nap!";
    String INPUT_VACCINATION_TYPE = "Vakcina típusa";
    String REG_NUMBER = "Regisztráltak száma";
    String FIRST_VACC_NUMBER = "Első oltást megkapta";
    String SECOND_VACC_NUMBER = "Második oltást megkapta";
    String NON_VACC_NUMBER = "Nem kapott oltást";

    String DATA_SOURCE_ERROR = "Can't create data source!";
    String DB_CONNECT_ERROR = "Adatbázis csatlakozási hiba!";
    String DB_RESULTSET_ERROR = "Adatbázis lekérdezés hiba!";
    String DB_INSERT_ERROR = "Adatbázis beszúrás hiba!";

    default String writeRedText(String text) {
        return "\033[31m" + text + "\033[0m";
    }

    default String writeGreenText(String text) {
        return "\033[32m" + text + "\033[0m";
    }

    default String writeBlueText(String text) {
        return "\033[34m" + text + "\033[0m";
    }

    default String menuNameUnderline(String text) {
        return "\n\033[0;4m" + text + "\033[0;0m";
    }
}
