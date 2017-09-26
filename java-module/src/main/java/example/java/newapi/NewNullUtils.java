package example.java.newapi;

import javax.annotation.Nullable;

public class NewNullUtils {
    @Nullable
    public static Integer maybeInspect(@Nullable Object object) {
        if (object == null) {
            return null;
        }
        return safeInspect(object);
    }

    public static Integer safeInspect(Object object) {
        return object.hashCode();
    }
}
