package example.scala;

import org.junit.Test;

public class ScalaNullsTest {
    @Test (expected = NullPointerException.class)
    public void throwsNPEWhenCalled() throws Exception {
        new ScalaNulls().passwordFromEnv();
    }
}
