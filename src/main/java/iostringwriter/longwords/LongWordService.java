package iostringwriter.longwords;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

public class LongWordService {

    public void writer(Writer writer, List<String> words) {
        PrintWriter printWriter = new PrintWriter(writer);
        for(String word : words){
            printWriter.print(word);
            printWriter.print(":");
            printWriter.println(word.length());
        }
    }

    public String writeWithStringWriter(List<String> words) {
        try (StringWriter stringWriter = new StringWriter()) {
            writer(stringWriter, words);
            return stringWriter.toString();
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write", ioe);
        }
    }
}
