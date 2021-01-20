public class OverrideEqualiser {
    public static void main(String[] args) {

    }

}
class  Person {

    private String name;
    private String idStr;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }


    public Person() {
    }

    public Person(String name, String idStr) {
        this.name = name;
        this.idStr = idStr;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Person) {
            Person personObj = (Person) obj;
            if (this.getIdStr().equals(personObj.getIdStr())) {
                return true;
            }
            return false;
        }
        return false;
    }
}