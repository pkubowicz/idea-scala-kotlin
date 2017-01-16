package example.runner;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        Arrays.asList(new Runnable[]{
                new NullsStatic(),
                new CaseDataDefaultParameters(),
                new ClassesInterfaces(),
                new Operators(),
                new Lambdas(),
                new Varargs(),
                new Collections(),
                new MoreNulls(),
        }).forEach(r -> {
            System.err.printf("=%s===========\n", r.getClass().getSimpleName());
            System.err.flush();
            r.run();
            System.out.flush();
            System.err.flush();
        });
    }
}
