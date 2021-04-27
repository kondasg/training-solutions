package covid;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    Validation validation = new Validation();

    @Test
    void isVlalidName() {
        assertFalse(validation.isVlalidName(null));
        assertFalse(validation.isVlalidName(""));
        assertFalse(validation.isVlalidName("      "));
        assertFalse(validation.isVlalidName("  a  a  "));
        assertFalse(validation.isVlalidName("Géza"));
        assertTrue(validation.isVlalidName("Kiss Aranka"));
    }

    @Test
    void isVlalidZip() {
        assertFalse(validation.isVlalidZip(null));
        assertFalse(validation.isVlalidZip(""));
        assertFalse(validation.isVlalidZip("123"));
        assertFalse(validation.isVlalidZip("12345"));
        assertFalse(validation.isVlalidZip("aaaa"));
        assertFalse(validation.isVlalidZip("1aa2"));
        assertTrue(validation.isVlalidZip("1234"));
    }

    @Test
    void isVlalidBirth() {
        assertFalse(validation.isVlalidBirth(null));
        assertFalse(validation.isVlalidBirth(""));
        assertFalse(validation.isVlalidBirth("123"));
        assertFalse(validation.isVlalidBirth("12345"));
        assertFalse(validation.isVlalidBirth("80-11-11"));
        assertFalse(validation.isVlalidBirth("1980-1-1"));
        assertFalse(validation.isVlalidBirth("1980-13-1"));
        assertFalse(validation.isVlalidBirth("1977-02-29"));
        assertFalse(validation.isVlalidBirth("1977-03-35"));

        assertTrue(validation.isVlalidBirth("1980-01-01"));
        assertTrue(validation.isVlalidBirth("1980-11-11"));

        assertFalse(validation.isVlalidBirth("2020-11-11"));
        assertFalse(validation.isVlalidBirth("1800-11-11"));
        assertTrue(validation.isVlalidBirth("2010-11-11"));
        assertTrue(validation.isVlalidBirth("1880-11-11"));
    }

    @Test
    void isVlalidEmail() {
        assertFalse(validation.isVlalidEmail(null));
        assertFalse(validation.isVlalidEmail(""));
        assertFalse(validation.isVlalidEmail("a@a"));
        assertTrue(validation.isVlalidEmail("as@bs.gov"));
        assertTrue(validation.isVlalidEmail("alma@alma.hu"));
    }

    @Test
    void isVlalidEmailRe() {
        assertFalse(validation.isVlalidEmailRe("alma@alma.hu", "alm@alma.hu"));
        assertTrue(validation.isVlalidEmailRe("alma@alma.hu", "alma@alma.hu"));
    }

    @Test
    void isVlalidTaj() {
        assertTrue(validation.isVlalidTaj("037687210"));
        assertFalse(validation.isVlalidTaj("037687211"));
        assertFalse(validation.isVlalidTaj("03768721"));
        assertFalse(validation.isVlalidTaj("0376a7211"));
    }

    @Test
    void isVlalidDateTime() {
        assertFalse(validation.isVlalidDateTime(null));
        assertFalse(validation.isVlalidDateTime(""));
        assertFalse(validation.isVlalidDateTime("123"));
        assertFalse(validation.isVlalidDateTime("12345"));
        assertFalse(validation.isVlalidDateTime("80-11-11"));
        assertFalse(validation.isVlalidDateTime("1980-11-11"));
        assertFalse(validation.isVlalidDateTime("10:00"));
        assertFalse(validation.isVlalidDateTime("80-01-01 1:3"));

        assertTrue(validation.isVlalidDateTime("1980-01-01 10:10"));
        assertTrue(validation.isVlalidDateTime("1980-11-11 01:09"));
    }
}