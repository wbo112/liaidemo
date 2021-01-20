import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TestCollection {

    public static void main(String[] args) {
        Collection c= new ArrayList();
        c.add("zhangsan");
        c.add(6);
        System.out.println("c集合的元素个数为："+c.size());
        //删除指定元素
        c.remove(6);
        System.out.println("c集合的元素个数为："+c.size());
        System.out.println("c集合中是否有zhansan:"+c.contains("zhangsan"));
        c.add("qingliang");
        System.out.println("c集合的元素："+c);
        Collection books= new HashSet();
        books.add("aaa");
        books.add("qingliang");
        System.out.println("c集合是否完全包含books集合？"+c.containsAll(books));
        c.removeAll(books);
        System.out.println("c集合的元素："+c);
        books.retainAll(c);
        System.out.println("books集合的元素："+books);
    }
}
