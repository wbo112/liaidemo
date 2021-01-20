package relect.java1;

@MyAnnotation(value="hi")
public class Person extends Creatrue<String> implements Comparable<String>,MyInterface {
    private String name;

    int age;
    public int id;

    public Person() {
    }
    @MyAnnotation(value="abc")
    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    @MyAnnotation
    private String show(String nation){
        System.out.println("我的国籍："+nation);
        return nation;
    }
    public String display(String interests) throws  NullPointerException{
        return interests;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    private static void showDesc(){
        System.out.println("asddsfddsfj");
    }
}
