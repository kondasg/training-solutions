package catalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatalogItem {

    private final List<Feature> features = new ArrayList<>();
    private final int price;
    private final String registrationNumber;

    public CatalogItem(String registrationNumber, int price, Feature... features) {
        this.registrationNumber = registrationNumber;
        this.price = price;
        this.features.addAll(Arrays.asList(features));
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public int getPrice() {
        return price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int fullLengthAtOneItem() {
        int fullLength = 0;
        for (Feature feature : getFeatures()) {
            if (feature instanceof AudioFeatures) {
                fullLength += ((AudioFeatures) feature).getLength();
            }
        }
        return fullLength;
    }

    public int numberOfPagesAtOneItem() {
        int numberOfPages = 0;
        for (Feature feature : getFeatures()) {
            if (feature instanceof PrintedFeatures) {
                numberOfPages += ((PrintedFeatures) feature).getNumberOfPages();
            }
        }
        return numberOfPages;
    }

    public List<String> getContributors() {
        List<String> contributors = new ArrayList<>();
        for (Feature feature : getFeatures()) {
            contributors.addAll(feature.getContributors());
        }
        return contributors;
    }

    public List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        for (Feature feature : getFeatures()) {
            titles.add(feature.getTitle());
        }
        return titles;
    }

    public boolean hasAudioFeature() {
        boolean has = false;
        for (Feature feature : getFeatures()) {
            if (feature instanceof AudioFeatures) {
                has = true;
            }
        }
        return has;
    }

    public boolean hasPrintedFeature() {
        boolean has = false;
        for (Feature feature : getFeatures()) {
            if (feature instanceof PrintedFeatures) {
                has = true;
            }
        }
        return has;
    }

}
