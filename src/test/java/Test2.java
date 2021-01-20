import org.apache.catalina.util.ToStringUtil;
import org.springframework.util.StringUtils;

import java.util.Scanner;

public class Test2 {
    static final String ABSENT="absent";
    static final String LATE="late";
    static final String LEAVEEARLY="leaveearly";
    static final String PRESNET="present";
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int n= Integer.parseInt(s.nextLine().trim());
        String[] str= new String[n];
        for(int i =0;i<n;i++){
            str[i]=s.nextLine().trim();
        }
        s.close();
        Test2 test= new Test2();
        boolean[] a =test.cal(str);
        for(int i=0;i<a.length;i++){
            System.out.print(" ");
            System.out.print(a[i]);
        }



    }
    public boolean[] cal(String[] str){
        int a=0;
        int b=0;
        int ab=0;
        boolean[] bea=new boolean[str.length];
       // String[][] ss= new String[str.length][10000];
        for(int i=0;i<str.length;i++){
            String[] s= str[i].toString().trim().split(" ");
            if(s.length>10000){
                bea[i]=false;
                return bea;
            }else{
             for(int j=0;j<s.length;j++){
               //ss[i][j]=s[j];
                   if(s[j].equals(ABSENT)){
                      ab++;
                   }else if(s[j].equals(LATE)||s[j].equals(LEAVEEARLY)){
                       a++;
                   }else if (j+7<s.length) {
                       for(int k=j;k<j+7;k++){
                           if(s[k].equals(ABSENT) || s[k].equals(LEAVEEARLY) || s[k].equals(LATE)){
                               b++;
                           }
                       }
                       if(b>=3){
                           bea[i]=false;
                           return bea;
                       }
                       b=0;
                   }
              }

             if(a<2 || ab<2){
                 bea[i]=true;
                 return bea;
             }
            }
        }
        return bea;
    }
}
