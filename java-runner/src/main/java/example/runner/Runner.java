package example.runner;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        Arrays.stream(new Runnable[]{

                new Static(),
                new CaseDataDefaultParameters(),
                new Nulls(),
                new ClassesInterfaces(),
                new Varargs(),
                new Collections(),
                new Lambdas(),
                new Operators(),
                new MoreNulls(),
        })
                .filter(runnable -> classInArgs(runnable, args))
                .forEach(runnable -> {
                    System.err.printf("=%s===========\n", runnable.getClass().getSimpleName());
                    System.err.flush();
                    runnable.run();
                    System.out.flush();
                    System.err.flush();
                    System.err.println("\n\n");
                    System.err.flush();
                });
    }

    private static boolean classInArgs(Runnable runnable, String[] args) {
        return args.length == 0 || Arrays.stream(args).anyMatch(arg -> runnable.getClass().getSimpleName().contains(arg));
    }
}
