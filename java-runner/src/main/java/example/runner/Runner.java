package example.runner;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        Arrays.asList(new Runnable[]{

                new Static(),
                new CaseDataDefaultParameters(),
                new Nulls(),
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
            System.err.println("\n\n");
            System.err.flush();
        });
    }
}
