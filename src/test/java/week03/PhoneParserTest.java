package week03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneParserTest {

    @Test
    void testParse() {
        // Given
        PhoneParser phoneParser = new PhoneParser();
        String s = "80-1231239";

        // Than
        Phone phone = phoneParser.parse(s);

        //
        assertEquals("+36 '80'1231239", phone.toString());

    }


}
