import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class TestIterator {
    public static void main(String[] args) {
        Collection books=new HashSet();
        books.add("轻量级");
        books.add("权威指南");
        books.add("Ajax宝典");
        Iterator it = books.iterator();
        while(it.hasNext()){
            String book =(String)it.next();
            System.out.println(book);
            if(book.equals("权威指南")){
                it.remove();
            }
            book="测试字符串";
        }
        System.out.println(books);

    }
}
