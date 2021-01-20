package relect.java2;

import relect.ReflectionTest;
import relect.java1.Person;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 调用运行时类中的指定结构：属性，方法及构造器
 */
public class RelectionTest {

  void testFiled() throws Exception {
    Class clazz= Person.class;
    //创建运行时类的对象
    Person p= (Person)clazz.newInstance();
    //获取指定的属性:要求属性必须时public
    Field id=clazz.getField("id");
    /**
     *
     *     设置当前属性的值
     *     set():参数1：那个对象的当前属性值
     *
     */
    id.set(p,1001);
    /**
     * 获取当前属性的值
     * get():参数1：获取那个对象的当前属性值
     */
    int pId=(int)id.get(p);
    System.out.println(pId);

}

    /**
     * 如何去操作运行时类中指定的属性+
     * @throws Exception
     */
    public  void testField1() throws Exception {
      Class clazz=Person.class;
      //创建运行时类的对象
      Person p=(Person)clazz.newInstance();
      //1.getDeclarcedField(String fieldName):获取运行时类中指定变量名的属性
    Field name=clazz.getDeclaredField("name");
    //2.保证当前属性是可访问的
    name.setAccessible(true);
    //3.获取指定对象的此属性值
    name.set(p,"tom");
    System.out.println(name.get(p));

}

public void testMethod() throws Exception {
    Class clazz=Person.class;
    //创建运行时类的对象
    Person p=(Person)clazz.newInstance();
    //1.获取指定的某个方法
    //getDeclaredMethod():参数1：指明获取的方法的名称 参数2：知名获取的方法的形参列表
   Method show=clazz.getDeclaredMethod("show",String.class);
   //保证方法是可访问的
    show.setAccessible(true);
    //调用方法的invoke():参数1：方法的调用者  参数2：给方法形参赋值的实参
    //invoke方法的返回值即为对应类中的调用的方法的返回值
    Object returnValue=show.invoke(p,"CHN");
    System.out.println(returnValue);
    System.out.println("==============如何调用静态方法=============");
    Method showDesc=clazz.getDeclaredMethod("showDesc");
    showDesc.setAccessible(true);
    //如果调用的运行时类中的方法没有返回值，则此invoke()返回null
    Object returnVal=showDesc.invoke(null);
    System.out.println(returnVal);


}


    public static void main(String[] args) throws Exception {
        RelectionTest t=new RelectionTest();
       //t.testField1();
        t.testMethod();
    }
}
