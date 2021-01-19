package week12d02;

import java.util.ArrayList;
import java.util.List;

public class Street {

    List<Site> sites = new ArrayList<>();

    public void sellSite(Site site) {
        sites.add(site);
    }

    public int getLastSiteNumber() {
        int[] numbers = new int[sites.size()];
        int countOdd = 1;
        int countEven = 2;

        for (int i = 0; i < sites.size(); i++) {
            if (sites.get(i).getSide() == 0) {
                numbers[i] = countEven;
                countEven += 2;
            } else {
                numbers[i] = countOdd;
                countOdd += 2;
            }
        }
        return numbers[numbers.length - 1];
    }

    public List<FenceStat> getFenceStats() {
        List<FenceStat> fenceStats = new ArrayList<>();

        for (Fence fence : Fence.values()) {
            fenceStats.add(new FenceStat(fence, 0));
        }

        for (FenceStat fenceStat : fenceStats) {
            for (Site site : sites) {
                if (site.getFence() == fenceStat.getFence()) {
                    fenceStat.setNumber();
                }
            }
        }
        return fenceStats;
    }
}
