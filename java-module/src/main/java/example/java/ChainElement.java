package example.java;

import javax.annotation.Nonnull;

public interface ChainElement<T> {
    boolean handles(@Nonnull Object o);

    @Nonnull
    T handle(@Nonnull Object o);
}
