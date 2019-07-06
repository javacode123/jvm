package nowcoder.offer;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        System.out.println(new ReplaceSpace().replcaeSpace1(new StringBuffer("hello zjl l")));
    }

    public String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }

    // 在原 str 上修改
    public String replcaeSpace1(StringBuffer str) {

        int beforeLen = str.length();

        // 扩容, 替换之后的长度
        for (int i=0; i<beforeLen; i++) {
            if (str.charAt(i) == ' ') {
                // 空格替换 %20 先追加两个空格
                str.append("  ");
            }
        }

        int afterLen = str.length();
        char c;
        // 依次填充空格
        while (afterLen>beforeLen && beforeLen>0) {
            c = str.charAt(--beforeLen);
            if (c == ' ') {
                str.setCharAt(--afterLen, '0');
                str.setCharAt(--afterLen, '2');
                str.setCharAt(--afterLen, '%');
            } else {
                // 向前移动
                str.setCharAt(--afterLen, c);
            }
        }

        return str.toString();

    }

}
