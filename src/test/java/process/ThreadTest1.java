package process;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建多线程的方式二:实现Runnnable接口
 * 1.创建一个实现了Runnable接口的类
 * 2，实现类去实现Runnable中的抽象方法：run()
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5.通过Thread类的对象调用start()
 *
 *
 * 比较线程的两种方式：
 * 开发中：优先选择：实现Runnable接口的方式；
 * 原因：1.实现的方式没有类的单继承性的局限性
 * 2.实现的方式更合适来处理多个线程有共享数据的情况
 * 联系：public class Thread implements Runnable
 * 相同点：两种方式都需要重写run()方法，将线程要执行的逻辑声明在run()中。
 */

//1.创建一个实现了Runnable接口的类
class   MyThread implements  Runnable{
   //2，实现类去实现Runnable中的抽象方法：run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(i);
            }
        }
    }
}

class MyTask implements Callable<Boolean>{
    @Override
    public Boolean call() throws Exception {

            return Thread.currentThread().getName()!=null;
        }

}
public class ThreadTest1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //3.创建实现类的对象
      // MyThread myThread= new MyThread();
        //4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
    // Thread t1= new Thread(myThread);
        //5.通过Thread类的对象调用start():①启动线程 ② 调用当前线程的run()-->调用了Runnable类型的target形参
    // t1.start();
     MyTask myTask=new MyTask();
        //需要一个FutureTask，而且在两个线程里传入同一个futureTask，只会执行一次
        FutureTask<Boolean> futureTask = new FutureTask<>(myTask);

        new Thread(futureTask,"A").start();
        System.out.println(futureTask.get());

    }
}
