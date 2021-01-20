package relect;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {

    public void test1(){
        NewPerson p1=new NewPerson("tom",12);
        p1.age=10;
        System.out.println(p1.toString());
    }
    public void test2() throws Exception {
        Class clazz= NewPerson.class;
        //1.通过反射，创建person类对象
       Constructor cons= clazz.getConstructor(String.class,int.class);
       Object obj=cons.newInstance("tom",12);
       NewPerson p=(NewPerson)obj;
        System.out.println(p.toString());
        //通过反射，调用对象指定的属性方法
        Field age=clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());

        //3/调用方法
      Method show= clazz.getDeclaredMethod("show");
      show.invoke(p);
        System.out.println("======================");
     //通过反射可以调用person类的私有结构的，比如，私有的构造器，方法、属性
        //调用私有的构造器
     Constructor cons1=   clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        NewPerson p1=(NewPerson)cons1.newInstance("Jerry");
        System.out.println(p1);

        //调用私有的属性
        Field name=clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"hanmeimei");
        System.out.println(p1);

        //调用私有方法
        Method showNation=clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        showNation.invoke(p1,"中国");
    }

    //什么时候会使用反射：比如编译时确定不下来运行时该造那个类对象，即可使用反射，反射的特征：动态性

    /*
    关于java.lang.Class类的理解
    1.类的加载过程：
    程序经过javac.exe命令后，或生成一个或多个字节码文件，接着我们使用java.exe命令对某个字节码文件进行解释运行，相当于将某个字节码文件加载到内存中，
    此过程就成为类加载。加载到内存中的类，就是运行时类，此运行时类就是Class的一个实例。
    2.Class的实例就对应一个运行时类
    3.加载到内存中的运行时类，会缓存一定的时间，再次时间之内，我们可以通过不同的方式来获取此运行时类
    */

    //获取大的Class的实例方式
    public void test3() throws ClassNotFoundException {
        //方式一：嗲用运行时类的属性：.class
        Class clazz1=NewPerson.class;
        System.out.println(clazz1);
        //方式二：通过运行时类的对象，调用getClass()
        NewPerson p1= new NewPerson();
        Class clazz2=p1.getClass();
        System.out.println(clazz2);
        //方式三：调用Class的静态方法：forName(String classPath)
        Class clazz3= Class.forName("relect.NewPerson");
        System.out.println(clazz3);
        System.out.println(clazz1==clazz2);
        System.out.println(clazz1==clazz3);
        //方式四：使用类加载器
        ClassLoader classLoader=ReflectionTest.class.getClassLoader();
        Class clazz4=classLoader.loadClass("relect.NewPerson");
        System.out.println(clazz4);

    }
    public void test4(){
        Class c1=Object.class;
        Class c2=Comparable.class;
        Class c3=String[].class;
        Class c4=int[][].class;
        Class c5= ElementType.class;
        Class c6=Override.class;
        Class c7=int.class;
        Class c8=void.class;

        int[] a=new int[10];
        int[] b=new int[100];
        Class c10=a.getClass();
        Class c11=b.getClass();
        System.out.println(c10==c11);
//只要数组的元素类型与维度一样，就是同一个class
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        ReflectionTest t=new ReflectionTest();
       // t.test1();
       // t.test2();
       // t.test3();
        t.test4();
    }

    public void testFiled() {
    }
}
