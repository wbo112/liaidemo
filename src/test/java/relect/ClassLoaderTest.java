package relect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClassLoaderTest {
    /*
    properties:用来读取配置文件

     */

    public void test2() throws IOException {
        Properties pros= new Properties();
        //此时的文件默认在当前demodule下
//        FileInputStream fis=new FileInputStream("jdbc.properties");
//        pros.load(fis);
        ClassLoader classLoader=ClassLoaderTest.class.getClassLoader();
        //配置文件默认识别为：当前module的src下
        InputStream  is =classLoader.getResourceAsStream("jdbc1.properties");
        pros.load(is);
        String user=pros.getProperty("user");
        String password=pros.getProperty("password");
        System.out.println("user="+user+",password="+password);
    }

    public static void main(String[] args) throws IOException {
        ClassLoaderTest t=new ClassLoaderTest();
        t.test2();
    }


}
