package zarovizsga.potvizsga.cleaning;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CleaningService {

    List<Cleanable> cleanables = new ArrayList<>();

    public List<Cleanable> getCleanables() {
        return new ArrayList<>(cleanables);
    }

    public void add(Cleanable cleanable) {
        cleanables.add(cleanable);
    }

    public int cleanAll() {
        int sumClean = 0;
        for (Cleanable cleanable : cleanables) {
            sumClean += cleanable.clean();
        }
        cleanables.clear();
        return sumClean;
    }

    public int cleanOnlyOffices() {
        int sumClean = 0;
        Iterator<Cleanable> it = cleanables.iterator();
        while (it.hasNext()) {
            Cleanable cleanable = it.next();
            if (cleanable instanceof Office) {
                sumClean += cleanable.clean();
                it.remove();
            }
        }
        return sumClean;
    }

    public List<Cleanable> findByAddressPart(String address) {
        List<Cleanable> result = new ArrayList<>();
        for (Cleanable cleanable : cleanables) {
            if (cleanable.getAddress().contains(address)) {
                result.add(cleanable);
            }
        }
        return result;
    }

    public String getAddresses() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cleanables.size(); i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(cleanables.get(i).getAddress());
        }
        return sb.toString();
    }

}
