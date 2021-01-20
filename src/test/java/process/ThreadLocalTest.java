package process;

public class ThreadLocalTest {
    private  static  ThreadLocal<Long> threadLocal=new ThreadLocal<>();
    public static  void main(String[] args) throws InterruptedException {
        Task1 task=new Task1();
        new Thread(task).start();
        Thread.sleep(10);
        new Thread(task).start();
    }
    static class Task1 implements  Runnable{
        @Override
        public void run() {
            Long result= threadLocal.get();
            if(result==null){
                threadLocal.set(System.currentTimeMillis());
            }
            System.out.println(Thread.currentThread().getName()+"->"+threadLocal.get());
        }
    }
}

