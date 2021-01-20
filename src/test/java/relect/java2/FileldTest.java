package relect.java2;

import relect.java1.Person;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取运行时类的属性结构
 */
public class FileldTest {
    public void  test1(){
        Class clazz= Person.class;
        //获取属性结构
        //getFields():获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields=clazz.getFields();
        for(Field field:fields){
            System.out.println(field);
        }
        System.out.println("====================");

        //getDeclaredFields():获取当前运行时类中声明的所有属性，不包含父类中的属性
        Field[] declareFields= clazz.getDeclaredFields();
        for(Field field:declareFields){
            System.out.println(field);

        }

    }
    //权限修饰符 数据类型 变量名
    public void test2(){
        Class clazz= Person.class;
        Field[] declareFields= clazz.getDeclaredFields();
        for(Field field:declareFields){
            //1.权限修饰符
         int modifier= field.getModifiers();
            System.out.print(Modifier.toString(modifier)+"\t");
            //2.数据类型
            Class type= field.getType();
            System.out.print(type+"\t");

            //变量名
            String fName= field.getName();
            System.out.print(fName);
            System.out.println();
        }

    }

    public static void main(String[] args) {
        FileldTest t= new FileldTest();
       // t.test1();
        t.test2();
    }
}
