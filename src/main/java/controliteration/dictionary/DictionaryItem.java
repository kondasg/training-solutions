package controliteration.dictionary;

import java.util.ArrayList;
import java.util.List;

public class DictionaryItem {
    private final String word;
    private final List<String> translations = new ArrayList<>();

    public DictionaryItem(String word, List<String> translations) {
        this.word = word;
        addTranslations(translations);
    }

    public void addTranslations(List<String> words) {
        for (String word: words) {
            if (! translations.contains(word)) {
                translations.add(word);
            }
        }
    }

    public String getWord() {
        return word;
    }

    public List<String> getTranslations() {
        return translations;
    }
}
