public class PrintObject {
    public static void main(String[] args) {
        Person1 p = new Person1("孙悟空");
        System.out.println(p);
    }

}
class  Person1 {
    private String name;
    public Person1(String name) {
        this.name=name;
    }
    public void info()
    {
        System.out.println("此人名为："+ name);
    }


}
