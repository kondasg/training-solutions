package week02;

import java.util.ArrayList;
import java.util.List;

public class Office {
    List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void addMeetingRoom(MeetingRoom meetingRoom) {
        meetingRooms.add(meetingRoom);
    }

    public void printNames() {
        for (MeetingRoom item: meetingRooms) {
                System.out.print(" " + item.getName());
        }
    }

    public void printNamesReverse() {
        for (int i = meetingRooms.size() - 1; i >= 0; i--) {
             System.out.print(" " + meetingRooms.get(i).getName());
        }
    }

    public void printEvenName() {
        boolean even = false;

        for (MeetingRoom item: meetingRooms) {
            if (even) {
                System.out.print(" " + item.getName());
            }
            even = !even;
        }
    }

    public void printAreas() {
        for (MeetingRoom item: meetingRooms) {
            System.out.println(item.getName() + " tárgyaló: terület " + item.getArea() + " m2, szélesség: " + item.getLength() + " m, hosszúság: " + item.getWidth() + " m");
        }
    }

    public void printMeetingRoomsWithName(String name) {
        for (MeetingRoom item: meetingRooms) {
            if (item.getName().equals(name)) {
                System.out.println(item.getName() + " tárgyaló: terület " + item.getArea() + " m2, szélesség: " + item.getLength() + " m, hosszúság: " + item.getWidth() + " m");
            }
        }
    }

    public void printMeetingRoomsContains(String part) {
        for (MeetingRoom item: meetingRooms) {
            if (item.getName().toLowerCase().indexOf(part.toLowerCase()) >= 0) {
                System.out.println(item.getName() + " tárgyaló: terület " + item.getArea() + " m2, szélesség: " + item.getLength() + " m, hosszúság: " + item.getWidth() + " m");
            }
        }
    }

    public void printAreasLargerThan(int area) {
        for (MeetingRoom item: meetingRooms) {
            if (item.getArea() > area) {
                System.out.println(item.getName() + " tárgyaló: terület " + item.getArea() + " m2, szélesség: " + item.getLength() + " m, hosszúság: " + item.getWidth() + " m");
            }
        }
    }
}
