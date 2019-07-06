package leetcode.strprocess;

/**
 * 实现函数 ToLowerCase()，
 * 该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 */
public class ToLower {

    public static void main(String[] args) {
        System.out.println(toLowerCase("ZJL"));
    }

    public static String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                sb.append((char)(str.charAt(i)+32));
            } else {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();

    }

}
