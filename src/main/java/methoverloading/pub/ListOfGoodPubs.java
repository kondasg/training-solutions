package methoverloading.pub;

import java.util.List;

public class ListOfGoodPubs {

    private final List<Pub> goodPubs;

    public ListOfGoodPubs(List<Pub> goodPubs) {
        if (goodPubs == null || goodPubs.size() == 0) {
            throw new IllegalArgumentException("Pub list is empty!");
        }
        this.goodPubs = goodPubs;
    }

    public Pub findTheBest() {
        Pub best = goodPubs.get(0);
        for (Pub pub: goodPubs) {
            if (pub.getOpenFrom().isEarlier(best.getOpenFrom()) ) {
                best = pub;
            }
        }
        return best;
    }
}
