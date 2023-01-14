package b.a.a.a.d;

import java.util.concurrent.Executor;

final class B implements Executor {
    B() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
