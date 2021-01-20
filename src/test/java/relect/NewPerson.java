package relect;

public class NewPerson {
    private String name;
    public int age;

    public NewPerson() {
    }

    public NewPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private NewPerson(String name) {
        this.name = name;

    }

    public String toString(){
        return "{name="+name+",age="+age+"}";
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

    public  void show(){
        System.out.println("你好，我是一个人");
    }
    private String showNation(String nation){
        System.out.println("我的国籍是："+nation);
        return  nation;
    }
}
