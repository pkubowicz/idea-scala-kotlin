package example.java;

import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ParametersReflection {
    public static List<String> parameterNames(Class clazz, String methodName) {
        return Arrays.stream(clazz.getDeclaredMethods())
                .filter(method -> method.getName().equals(methodName))
                .sorted(Comparator.comparing(method -> method.getParameters().length,
                        Comparator.reverseOrder()))
                .findFirst()
                .map(method -> Arrays.stream(method.getParameters())
                        .map(Parameter::getName).collect(Collectors.toList()))
                .orElseThrow(() -> new NoSuchElementException(clazz.getSimpleName()
                        + " does not have method " + methodName));
    }
}
