import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String  before=sc.next();
//        char[] beforeChar=before.toCharArray();
//        char[] afterChar= new char[before.length()];
//        int[] offset= new int[before.length()];
//        int temp=0;
//        for(int i=0;i<before.length();i++){
//
//            if(i==0 || i==1){
//                offset[i]=1;
//            }
//
//            else {
//                offset[i]=offset[i-1]+offset[i-2];
//            }
//            temp= ((beforeChar[i]-'a')+ offset[i])%26+'a';
//            afterChar[i]=(char)temp;
//
//        }
//        System.out.println(new String(afterChar));

        int a=5;
        int b=a+++6;
        System.out.println(a+""+b);
    }
}
