package covid;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Vaccination {

    private final int citizensId;
    private final LocalDateTime vaccinationDateTime;
    private final VaccinationStatus status;
    private final String note;
    private final String vaccinationType;

    public Vaccination(int citizensId, LocalDateTime vaccinationDateTime, VaccinationStatus status, String note, String vaccinationType) {
        this.citizensId = citizensId;
        this.vaccinationDateTime = vaccinationDateTime;
        this.status = status;
        this.note = note;
        this.vaccinationType = vaccinationType;
    }

    public int getCitizensId() {
        return citizensId;
    }

    public LocalDateTime getVaccinationDateTime() {
        return vaccinationDateTime;
    }

    public VaccinationStatus getStatus() {
        return status;
    }

    public String getNote() {
        return note;
    }

    public String getVaccinationType() {
        return vaccinationType;
    }

    public String getVaccinationDateTimeString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd. HH:mm");
        return getVaccinationDateTime().format(formatter);
    }

    public String printVaccination() {
        return "dátum: " + getVaccinationDateTimeString() +
                ", oltás: " + status +
                ", oltóanyag típusa: " + vaccinationType +
                ", megjegyzés: " + note;
    }
}
