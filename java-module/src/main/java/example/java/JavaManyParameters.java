package example.java;

public class JavaManyParameters {
    public static String createFile(String name,
                                    String extension,
                                    String location,
                                    boolean executable) {
        return String.format("n=%s|%s|l=%s|%b",
                name, extension, location, executable);
    }
}
