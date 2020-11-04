package stringtype.registration;

public class UserValidator {
    private String username;
    private String psw;
    private String email;

    public boolean isValidUsername(String username) {
        return (username.length() > 0);
    }

    public boolean isValidPassword(String password1, String password2) {
        return ( (password1.length() > 7) && password1.equals(password2) );
    }

    public boolean isValidEmail(String email) {
        int atPos = email.indexOf('@');
        int dotPos = email.indexOf('.');
        return ( atPos > 0 && atPos+1 < dotPos && email.length()-1 > dotPos );
    }

}
