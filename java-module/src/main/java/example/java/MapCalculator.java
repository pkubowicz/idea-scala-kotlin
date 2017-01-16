package example.java;

import javax.annotation.concurrent.Immutable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class MapCalculator {
    @Immutable
    public static final class Result {
        private final String status;
        private final long time;

        Result(String status, long time) {
            this.status = status;
            this.time = time;
        }

        public String getStatus() {
            return status;
        }

        public long getTime() {
            return time;
        }
    }

    public static Map<String, Map<String, Result>> calculate() {
        Map<String, Map<String, Result>> results = new HashMap<>();
        results.put("host1", Collections.singletonMap("process1", new Result("starting", 10)));
        Map<String, Result> host2Results = new HashMap<>();
        host2Results.put("process2", new Result("running", 50));
        host2Results.put("process3", new Result("stopping", 2));
        results.put("host2", host2Results);
        return results;
    }
}
