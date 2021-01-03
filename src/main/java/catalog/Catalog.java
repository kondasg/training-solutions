package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalogItem) {
        catalogItems.add(catalogItem);
    }

    public double averagePageNumberOver(int page) {
        if (page < 1) {
            throw new IllegalArgumentException("Page number must be positive");
        }
        if (page > 9999) {
            throw new IllegalArgumentException("No page");
        }
        int count = 0;
        int sumPage = 0;
        for (CatalogItem catalogItem : getPrintedLibraryItems()) {
            int item = catalogItem.numberOfPagesAtOneItem();
            if (item > page) {
                sumPage += item;
                count++;
            }
        }
        return (double) sumPage / count;
    }

    public void deleteItemByRegistrationNumber(String registrationNumber) {
        List<CatalogItem> catalogItemsCopy = new ArrayList<>(catalogItems);
        for (CatalogItem catalogItem : catalogItemsCopy) {
            if (registrationNumber.equals(catalogItem.getRegistrationNumber())) {
                catalogItems.remove(catalogItem);
            }
        }
    }

    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {
        List<CatalogItem> items = new ArrayList<>();
        for (CatalogItem catalogItem : catalogItems) {
            for (Feature feature : catalogItem.getFeatures()) {
                if (searchCriteria.getTitle().equals(feature.getTitle()) ||
                        feature.getContributors().contains(searchCriteria.contributor)) {
                    items.add(catalogItem);
                }
            }
        }
        return items;
    }

    public int getAllPageNumber() {
        int allPageNumber = 0;
        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.hasPrintedFeature()) {
                allPageNumber += catalogItem.numberOfPagesAtOneItem();
            }
        }
        return allPageNumber;
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> audioLibraryItems = new ArrayList<>();
        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.hasAudioFeature()) {
                audioLibraryItems.add(catalogItem);
            }
        }
        return audioLibraryItems;
    }

    public int getFullLength() {
        int fullLength = 0;
        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.hasAudioFeature()) {
                fullLength += catalogItem.fullLengthAtOneItem();
            }
        }
        return fullLength;
    }

    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> printedLibraryItems = new ArrayList<>();
        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.hasPrintedFeature()) {
                printedLibraryItems.add(catalogItem);
            }
        }
        return printedLibraryItems;
    }
}
