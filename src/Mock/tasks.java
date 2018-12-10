package Mock;

import java.util.List;

public class tasks {
    class task {
        int time;
        List<task> dependency;
        public task(int time, List<task> dependency) {
            this.time = time;
            this.dependency = dependency;
        }
    }

    public int getT4ime(List<task> tasks) {

    }
}
