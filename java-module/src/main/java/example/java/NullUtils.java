package example.java;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class NullUtils {
    public static final int VERSION = 1;
    public static String describe() {
        return "version " + VERSION;
    }

    // standard javax.annotation, not JetBrains
    public static int inspectNonnull(@Nonnull Object object) {
        return object.hashCode();
    }

    @Nullable
    public static Integer safeInspect(@Nullable Object object) {
        if (object == null) {
            return -1;
        }
        return inspectNonnull(object);
    }

    public static Integer unknownInspect(Object object) {
        return safeInspect(object);
    }
}
