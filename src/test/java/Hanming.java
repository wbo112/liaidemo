import java.util.Arrays;

public class Hanming {
    public int hamingWeight(int n){
        return Integer.bitCount(n);
 }

    public static void main(String[] args) {
        Hanming a =new Hanming();
     int n= a.hamingWeight(00000000000000000000000010000000);
        System.out.println(n);
    }
}
