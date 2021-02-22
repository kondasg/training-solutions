package exam03retake01;

import java.util.ArrayList;
import java.util.List;

public class MailBox {

    private final List<Mail> mails = new ArrayList<>();

    public List<Mail> getMails() {
        return new ArrayList<>(mails);
    }

    public void addMail(Mail mail) {
        mails.add(mail);
    }

    public List<Mail> findByCriteria(String criteria) {
        List<Mail> result;
        if (criteria.startsWith("from:")) {
            String pattern = criteria.substring(5);
            result = findByFrom(pattern);
        } else if (criteria.startsWith("to:")) {
            String pattern = criteria.substring(3);
            result = findByTo(pattern);
        } else {
            result = findByOther(criteria);
        }
        return result;
    }

    private List<Mail> findByFrom(String pattern) {
        List<Mail> result = new ArrayList<>();
        for (Mail mail : mails) {
            if (mail.getFrom().getEmail().equals(pattern) || mail.getFrom().getName().equals(pattern)) {
                result.add(mail);
            }
        }
        return result;
    }

    private List<Mail> findByTo(String pattern) {
        List<Mail> result = new ArrayList<>();
        for (Mail mail : mails) {
            for (Contact to : mail.getTo()) { // ezt még illene kiszervezni ;)
                if (to.getEmail().equals(pattern) || to.getName().equals(pattern)) {
                    result.add(mail);
                }
            }
        }
        return result;
    }

    private List<Mail> findByOther(String pattern) {
        List<Mail> result = new ArrayList<>();
        for (Mail mail : mails) {
            if (mail.getSubject().contains(pattern) || mail.getMessage().contains(pattern)) {
                result.add(mail);
            }
        }
        return result;
    }
}
