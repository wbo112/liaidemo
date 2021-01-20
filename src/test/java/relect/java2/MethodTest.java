package relect.java2;

import relect.java1.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MethodTest {
    public void test1(){
        Class clazz= Person.class;
        //getMethods():获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods= clazz.getMethods();
        for(Method m :methods) {
            System.out.println(m);
        }
        System.out.println();
//getDeclaredMethods():获取当前运行时类中声明的所有方法，不包含父类中的方法
        Method[] declareMethods= clazz.getDeclaredMethods();
        for(Method m :declareMethods) {
            System.out.println(m);
        }

    }
    //权限修饰符  返回值类型  方法名（形参1，形参2，。。。） throws XException
    public void test2(){
        //获取注解
        Class clazz= Person.class;
        Method[] declareMethods= clazz.getDeclaredMethods();
        for(Method m :declareMethods) {
          Annotation[] annotations= m.getAnnotations();
          for(Annotation a:annotations){
              System.out.println(a);
          }

//            //2.获取每个方法的权限修饰符
//            System.out.print(Modifier.toString(m.getModifiers())+"\t");
//
//          //3.获取返回值类型
//            System.out.print(m.getReturnType().getName()+"\t");
//            //4.获取方法名
//            System.out.print(m.getName());
//            //5。获取形参列表
//           Class[] parameterTypes= m.getParameterTypes();
//           if(!(parameterTypes==null &&parameterTypes.length==0)){
//               for(int i=0;i<parameterTypes.length;i++){
//                   if(i==parameterTypes.length-1){
//                       System.out.print(parameterTypes[i].getName()+"args_"+i);
//                       break;
//                   }
//                   System.out.print(parameterTypes[i].getName()+"args_"+i+",");
//               }
//           }
//
//            System.out.println();
//           //6.抛出异常
//          Class[] exceptionTypes=  m.getExceptionTypes();
//          if( exceptionTypes.length>0){
//              System.out.print("throws ");
//              for(int i=0; i<exceptionTypes.length;i++){
//                  if(i==exceptionTypes.length-1){
//                      System.out.print(exceptionTypes[i].getName());
//                      break;
//                  }
//                  System.out.print(exceptionTypes[i].getName()+",");
//              }
//          }
 }


    }

    public static void main(String[] args) {
        MethodTest t=new MethodTest();
        t.test2();
    }
}
