package activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Track {

    private final List<TrackPoint> trackPoints = new ArrayList<>();

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }

    public void addTrackPoint(TrackPoint trackPoint) {
        trackPoints.add(trackPoint);
    }

    public double getFullElevation() {
        double fullElevation = 0;
        double elevation1 = trackPoints.get(0).getElevation();
        for (TrackPoint trackPoint : trackPoints) {
            double elevation2 = trackPoint.getElevation();
            if (elevation2 > elevation1) {
                fullElevation += elevation2 - elevation1;
            }
            elevation1 = elevation2;
        }
        return fullElevation;
    }

    public double getFullDecrease() {
        double fullDecrese = 0;
        double elevation1 = trackPoints.get(0).getElevation();
        for (TrackPoint trackPoint : trackPoints) {
            double elevation2 = trackPoint.getElevation();
            if (elevation2 < elevation1) {
                fullDecrese += elevation2 - elevation1;
            }
            elevation1 = elevation2;
        }
        return Math.abs(fullDecrese);
    }

    public double getDistance() {
        double distance = 0;
        TrackPoint trackPoint1 = trackPoints.get(0);
        for (TrackPoint trackPoint : trackPoints) {
            distance += trackPoint1.getDistanceFrom(trackPoint);
            trackPoint1 = trackPoint;
        }
        return distance;
    }

    public Coordinate findMinimumCoordinate() {
        double minLat = 0;
        double minLon = 0;
        for (TrackPoint trackPoint : trackPoints) {
            double actualLat = trackPoint.getCoordinate().getLatitude();
            double actualLon = trackPoint.getCoordinate().getLongitude();
            if (actualLat < minLat) {
                minLat = actualLat;
            }
            if (actualLon < minLon) {
                minLon = actualLon;
            }
        }
        return new Coordinate(minLat, minLon);
    }

    public Coordinate findMaximumCoordinate() {
        double maxLat = 0;
        double maxLon = 0;
        for (TrackPoint trackPoint : trackPoints) {
            double actualLat = trackPoint.getCoordinate().getLatitude();
            double actualLon = trackPoint.getCoordinate().getLongitude();
            if (actualLat > maxLat) {
                maxLat = actualLat;
            }
            if (actualLon > maxLon) {
                maxLon = actualLon;
            }
        }
        return new Coordinate(maxLat, maxLon);
    }

    public double getRectangleArea() {
        double a1 = findMinimumCoordinate().getLatitude();
        double a2 = findMinimumCoordinate().getLongitude();
        double b1 = findMaximumCoordinate().getLatitude();
        double b2 = findMaximumCoordinate().getLongitude();

        return (a1 - b1) * (a2 - b2);
    }

    public void loadFromGpx(InputStream is) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            Coordinate coordinate = null;
            while ((line = reader.readLine()) != null) {
                if (line.trim().startsWith("<trkpt")) {
                    String[] trkpt = line.split("\"");
                    coordinate = new Coordinate(Double.parseDouble(trkpt[1]), Double.parseDouble(trkpt[3]));
                }
                if (line.trim().startsWith("<ele")) {
                    int firstSeparatorIndex = line.indexOf(">");
                    int lastSeparatorIndex = line.lastIndexOf("<");
                    addTrackPoint(new TrackPoint(coordinate,
                            Double.parseDouble(line.substring(firstSeparatorIndex + 1, lastSeparatorIndex))));
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}
