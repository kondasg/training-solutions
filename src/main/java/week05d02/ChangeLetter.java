package week05d02;

public class ChangeLetter {

    public String changeVowels(String target) {
        String s = "";
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == 'a' || target.charAt(i) == 'e' || target.charAt(i) == 'i' || target.charAt(i) == 'o' || target.charAt(i) == 'u') s+= "*";
            else s += target.substring(i,i+1);
        }
        return s;
    }
}
