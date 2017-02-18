package example.java;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class JavaManyParametersTest {
    @Test
    public void hasParametersNameInformation() throws Exception {
        Assert.assertEquals(Arrays.asList("name", "extension", "location", "executable"),
                ParametersReflection.parameterNames(JavaManyParameters.class, "createFile"));
    }
}
