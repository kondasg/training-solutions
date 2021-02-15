package week16d01;

import java.time.Duration;
import java.time.LocalDateTime;

public class CanoeRental {

    private final String name;
    private final CanoeType canoeType;
    private final LocalDateTime startTime;
    private LocalDateTime endTime;

    public CanoeRental(String name, CanoeType canoeType, String dateTimeString) {
        this.name = name;
        this.canoeType = canoeType;
        this.startTime = LocalDateTime.now().minusHours(Long.parseLong(dateTimeString)).plusMinutes(Long.parseLong(dateTimeString));
    }

    public String getName() {
        return name;
    }

    public CanoeType getCanoeType() {
        return canoeType;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public double calculateRentalSum() {
        return Duration.between(startTime, endTime).toHours();
    }

    @Override
    public String toString() {
        return "CanoeRental{" +
                "name='" + name + '\'' +
                ", canoeType=" + canoeType +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
