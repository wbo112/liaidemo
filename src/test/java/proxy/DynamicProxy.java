package proxy;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        MyFoo myFoo = new MyFoo();
        InvocationHandler invocationHandler = new InvocationHandler() {


            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("hello")) {
                    System.out.println("开启事务");
                    myFoo.hello();
                    System.out.println("提交事务");
                    return null;
                }
                return method.invoke(myFoo, args);
            }
        };

        Foo f = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),
                new Class<?>[]{Foo.class},
                invocationHandler);
        f.hello();

    }

    private interface Foo {
        void hello();
    }

    private static class MyFoo implements Foo {

        @Override
        public void hello() {
            System.out.println("执行数据库查询操作");
        }
    }
}
