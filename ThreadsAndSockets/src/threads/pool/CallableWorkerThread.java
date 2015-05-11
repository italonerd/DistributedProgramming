package threads.pool;

import java.util.concurrent.Callable;

public class CallableWorkerThread implements Callable<String> {
    private int workerNumber;
    private int waitTime;

    CallableWorkerThread(int number, int time) {
        workerNumber = number;
        waitTime = time;
    }

    public String call() {
        for (int i = 0; i <= 100; i += 20) {
            // Perform some work ...
            System.out.println("Worker number: "
                + workerNumber
                + "("+waitTime+"), percent complete: " + i );
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
            }
        }
        return("Ending worker: "+workerNumber+"("+waitTime+")");
    }
}