public class AutoBoxingUnboxing {

    public static void main(String[] args) {
        Integer inObj = 5;
        Object booObj = true;
        int it = inObj;
        if(booObj instanceof Boolean)
        {
            boolean b = (Boolean)booObj;
            System.out.println(b);
        }
    }
}
