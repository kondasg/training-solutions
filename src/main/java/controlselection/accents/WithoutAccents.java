package controlselection.accents;

public class WithoutAccents {
    public char convertToCharWithoutAccents(char c) {
        String accent = "áéíóöőúüűÁÉÍÓÖÚÚÜŰ";
        String withoutAccent = "aeiooouuuAEIOOOUUU";
        int x = accent.indexOf(c);
        if ( x >= 0) return withoutAccent.charAt(x);
        else return c;
    }
}
