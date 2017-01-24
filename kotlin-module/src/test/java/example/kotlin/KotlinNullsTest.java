package example.kotlin;

import org.junit.Assert;
import org.junit.Test;

public class KotlinNullsTest {
    @Test
    public void returnsNullIfNoEnvPassword() throws Exception {
        Assert.assertNull(new KotlinNulls().passwordFromEnv());
    }
}
