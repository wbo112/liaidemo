import java.util.Scanner;

public class MakeSecStr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuffer stringBuffer = new StringBuffer();
        if (!str.isEmpty()) {
            stringBuffer.append(nextChar(str.charAt(0) + 1));
        }
        int a = 1;
        int b = 1;
        int c;
        for (int i = 1; i < str.length(); i++) {
            stringBuffer.append(nextChar(str.charAt(i) + b));
            c = b;
            b = nextInt(a, b);
            a = c;
            //System.out.print(b+" ");
        }
        System.out.println(stringBuffer.toString());
    }

    public static int nextInt(int a, int b) {
        return a + b;
    }

    public static char nextChar(int n) {
        int nn = (n - 'a') % ('z' - 'a');
        return (char) (nn + 'a');
    }


}
