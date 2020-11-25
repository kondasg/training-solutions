package week05d03;

import java.util.List;

public class UserValidator {

//    public void validate(List<User> users) {
//        for (User user: users) {
//            if ("".equals(user.getName())) throw new IllegalArgumentException("Üres String!");
//            if ( user.getAge() < 0 || user.getAge() > 120 ) throw new IllegalArgumentException("nem megfelő age!");
//        }
//    }

    public void validate(List<User> users) {
        if (users == null) throw new IllegalArgumentException("Users is null!");
        for (User user: users) {
            if (user == null) throw new IllegalArgumentException("User is null!");
            if (user.getName() ==  null || user.getName().isBlank()) throw new IllegalArgumentException("The user name can't be blank or null");
            if (user.getAge() < 0 || user.getAge() > 120) throw new IllegalArgumentException("The user age must be between 0 and 120!");
        }
    }
}
