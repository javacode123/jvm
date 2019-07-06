import java.util.Scanner;

public class Input {

   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       //while(sc.hasNext()){
       //    int n = sc.nextInt();
       //    int m = sc.nextInt();
       //    System.out.println(n + " " + m);
       //}

       //注意： nextInt()和nextLine()不可同时使用，否则nextLine()可能读到空字符串
       //输入一组数据并输出
       String str=sc.nextLine();
       System.out.printf("%s\n",str);

       //输入多组数据并输出
       //String str;
       while(sc.hasNextLine()){
           str = sc.nextLine();
           System.out.printf("%s\n",str);
       }
   }

}
