package stringmethods.filename;

public class FileNameManipulator {

    public char findLastCharacter(String str) {
        if (isEmpty(str)) throw new IllegalArgumentException("Empty string!");
        str = str.trim();
        return str.charAt(str.length() - 1);
    }

    public String findFileExtension(String fileName) {
        if (isEmpty(fileName) || fileName.length() < 4 || !fileName.contains(".")) throw new IllegalArgumentException("Invalid file name!");

        fileName = fileName.trim();
        int point = fileName.lastIndexOf(".");
        return fileName.substring(point);
    }

    public boolean identifyFilesByExtension(String ext, String fileName) {
        if (isEmpty(ext) || isEmpty(fileName) || fileName.indexOf(".") < 2) throw new IllegalArgumentException("Invalid argument!");
        ext = ext.trim();
        fileName = fileName.trim();
        int point = fileName.lastIndexOf(".");
        return ext.equals(fileName.substring(point + 1));
    }

    public boolean compareFilesByName(String searchedFileName, String actualFileName) {
        if (isEmpty(searchedFileName) || isEmpty(actualFileName)) throw new IllegalArgumentException("Invalid argument!");
        searchedFileName = searchedFileName.trim();
        actualFileName = actualFileName.trim();
        return searchedFileName.equalsIgnoreCase(actualFileName);
    }

    public String changeExtensionToLowerCase(String fileName) {
        if (isEmpty(fileName)) throw new IllegalArgumentException("Empty string!");
        if (fileName.indexOf(".") < 2) throw new IllegalArgumentException("Invalid argument!");
        fileName = fileName.trim();
        int point = fileName.lastIndexOf(".");
        String oldExt = fileName.substring(point + 1);
        String newExt = oldExt.toLowerCase();
        return fileName.replace(oldExt, newExt);
    }

    public String replaceStringPart(String fileName, String present, String target) {
        if (isEmpty(fileName)) throw new IllegalArgumentException("Empty string!");
        fileName = fileName.trim();
        return fileName.replace(present, target);
    }

    public boolean isEmpty(String str) {
        return (str == null || "".equals(str.trim()));
    }
}
