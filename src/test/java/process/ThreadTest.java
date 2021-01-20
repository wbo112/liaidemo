package process;

/**
 * 多线程的创建，方式一：继承与thread类
 * 1.创建一个继承于thread类的子类
 * 2.重写Thread的run（）方法
 * 3.创建一个thread子类的对象,通过此对象调用start（）
 * 例子：遍历100以内的所有偶数
 */

//1.创建一个继承于thread类的子类
    class Mythread extends Thread{

    //2.重写Thread的run（）方法
    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            if(i%2==0){
                System.out.println(i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
       // 3.创建一个thread子类的对象,通过此对象调用start（）:①启动当前线程；②调用当前线程的run（）
        Mythread t1=new Mythread();
        t1.start();
        //问题一：我们不能通过调用run()的方式启动线程
       // t1.run();
        //问题2：再启动一个线程，遍历100以内的偶数。不可以还让已经start()的线程去执行。
        //如下操作仍然是在main线程中执行的。
        for (int i = 0; i < 100; i++) {

           if(i%2==0){
               System.out.println(Thread.currentThread().getName()+":"+i+"**************main()*************");
           }
        }
    }

}
