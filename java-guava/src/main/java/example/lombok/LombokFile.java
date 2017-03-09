package example.lombok;

import lombok.Value;

@Value
public class LombokFile {
    String file;
    String extension;
    String location;
    boolean executable;
}
