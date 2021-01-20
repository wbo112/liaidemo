public class Priimittive2string {
    public static void main(String[] args) {
        String intStr = "123";
        int it = Integer.parseInt(intStr);
        System.out.println(it);
        String floatStr ="4.56";
        float ft =Float.parseFloat(floatStr);
        System.out.println(ft);
        String ftStr = String.valueOf(3.14f);
        String dbDstr = String.valueOf(3.344);
        System.out.println(dbDstr);
        String boolStr =String.valueOf(true);
        System.out.print(boolStr.toUpperCase()
        );
    }
}
