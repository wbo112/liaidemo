package relect.java2;

import relect.java1.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class OtherTest {
    /**
     * 获取运行时类的带泛型的父类的泛型
     */
    public void test(){
        Class classz= Person.class;
        Type genericSupperClass=classz.getGenericSuperclass();
        ParameterizedType parameterizedType=(ParameterizedType)genericSupperClass;
        //获取泛型
        Type[] actualTypeArguments=parameterizedType.getActualTypeArguments();
        System.out.println(((Class) actualTypeArguments[0]).getName());

    }

    /**
     * 获取运行时类的接口
     */
    public void test5(){
        Class classz= Person.class;
        Class[] interfaces=classz.getInterfaces();
        for(Class c :interfaces){
            System.out.println(c);
        }
        System.out.println();
        //获取运行时类的父类实现的接口
        Class[] interfaces1=classz.getSuperclass().getInterfaces();
        for(Class c:interfaces1){
            System.out.println(c);
        }
    }

    /**
     *获取运行时类所在的包
     */
    public void test6(){
        Class clazz=Person.class;
   Package pack=clazz.getPackage();
        System.out.println(pack);
    }

    /**
     *获取运行时类的注解
     *
     */
    public void test7(){
        Class clazz=Person.class;
       Annotation[] annotations= clazz.getAnnotations();
       for(Annotation anos:annotations){
           System.out.println(anos);
       }
    }

    public static void main(String[] args) {
        OtherTest t= new OtherTest();
        //t.test();
       // t.test5();
        //t.test6();
        t.test7();
    }

}
