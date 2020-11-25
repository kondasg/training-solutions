package week05d03;

import java.util.List;

public class UserValidator {

    public void validate(List<User> users) {
        for (User user: users) {
            if ("".equals(user.getName())) throw new IllegalArgumentException("Üres String!");
            if ( user.getAge() < 0 || user.getAge() > 120 ) throw new IllegalArgumentException("nem megfelő age!");
        }
    }
}
