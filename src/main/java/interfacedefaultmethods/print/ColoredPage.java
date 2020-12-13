package interfacedefaultmethods.print;

public class ColoredPage {

    private final String pageContent;
    private final String pageColor;

    public ColoredPage(String pageContent, String pageColor) {
        this.pageContent = pageContent;
        this.pageColor = pageColor;
    }

    public ColoredPage(String pageContent) {
        this.pageContent = pageContent;
        this.pageColor = Printable.BLACK;
    }

    public String getPageContent() {
        return pageContent;
    }

    public String getPageColor() {
        return pageColor;
    }
}
