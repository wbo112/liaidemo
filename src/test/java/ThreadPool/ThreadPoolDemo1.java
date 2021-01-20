package ThreadPool;

import java.util.concurrent.*;

public class ThreadPoolDemo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor= Executors.newCachedThreadPool();
        Runnable runnable=()-> System.out.println(Thread.currentThread().getName());
        Callable<String> callable=()->"callable";
        executor.execute(runnable);
        Future<String> submit = executor.submit(callable);
        System.out.println(submit.get());
        //executor.shutdown();
    }
}
