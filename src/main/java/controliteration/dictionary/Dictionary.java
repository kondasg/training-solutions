package controliteration.dictionary;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {

    private final List<DictionaryItem> dictionaryItems = new ArrayList<>();

    public void addItem(String s, List<String> l) {
        boolean found = false;
        for (DictionaryItem item: dictionaryItems) {
            if (item.getWord().equals(s)) {
                item.addTranslations(l);
                found = true;
            }
        }
        if (!found) {
            dictionaryItems.add(new DictionaryItem(s, l));
        }
    }

    public List<String> findTranslations(String s) {
        for (DictionaryItem dictionary: dictionaryItems) {
            if (dictionary.getWord().equals(s)) {
                return dictionary.getTranslations();
            }
        }
        return new ArrayList<>();
    }

}
