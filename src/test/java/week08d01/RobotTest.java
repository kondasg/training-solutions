package week08d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    @Test
    void move() {
        Robot robot = new Robot();
        assertEquals("x: 3, y: -3", robot.move("FFLLLLLBBBBJJJJJJJ"));
    }
}