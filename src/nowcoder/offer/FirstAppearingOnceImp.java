package nowcoder.offer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class FirstAppearingOnceImp {

    public static void main(String[] args) {
        FirstAppearingOnceImp f = new FirstAppearingOnceImp();
        for (char c: "google".toCharArray()) {
            f.Insert(c);
            System.out.println(f.FirstAppearingOnce());
        }
    }

    private int[] count = new int[256];
    private List<Character> list = new ArrayList<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (count[ch] == 0) {
            count[ch] = 1;
            list.add(ch);
        }else {
            if (count[ch] == 1) {
                Iterator<Character> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next().equals(ch)) {
                        it.remove();
                    }
                }
                count[ch]++;
            }
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        return list.isEmpty() ? '#' : list.get(0);
    }

}
