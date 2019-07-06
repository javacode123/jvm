package leetcode.strprocess;

/**
 * 深入理解 String
 */
public class StringCharacter {

    public static void main(String[] args) {
        // 存储在方法区中
        String s1 = "abc";
        // 堆内存中
        String s2 = new String("abc");
        String s3 = "ab" + "c";
        // s1 在常量池中, s2 堆内存中, s3 也在常量池中
        System.out.println(s1 == s2);
        System.out.println(s3 == s1);
        String s = "ab";
        String s4 = s + "c";
        // s 在常量池中, 调用了 StringBulder.append 方法, s4 在堆内存中
        System.out.println(s4 == s1);
        new StringBuilder().reverse();
    }

    // 不能改变 main 函数中的 str, str 是一个常量
    public static void replace(String str) {
        str += "c";
    }

}
