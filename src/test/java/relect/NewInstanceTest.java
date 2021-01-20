package relect;

import java.util.Random;

/**
 *创建运行时类的对象
 */
public class NewInstanceTest {
    public  void test() throws IllegalAccessException, InstantiationException {
        Class<NewPerson> clazz=NewPerson.class;
        /*
        newInstance():调用此方法，创建对应的运行时类的对象，内部调用了运行时类的空参构造器
        要想此方法正常的创建运行时的类的对象要求：
        1.运行时类必须提供空参的构造器
        2.空参的构造i其的访问权限得够，通常，设置为public

在javabean中要求提供一个public的空参构造器，原因：
1.便于通过反射，创建运行时类的对象
2.便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器
         */

        NewPerson obj=clazz.newInstance();
        System.out.println(obj);
    }

    public void test2(){
        for(int i=0;i<100;i++){

            int num= new Random().nextInt(3);
            String classPath="";
            switch(num){
                case 0:
                    classPath="java.util.Date";
                    break;
                    case 1:
                        classPath="java.lang.object";
                        break;
                case 2:
                    classPath="test.java.relect.NewPerson";
            }
            try{
                 Object obj=  (classPath);
                System.out.println(obj);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        NewInstanceTest t= new NewInstanceTest();
        t.test();
    }
}
