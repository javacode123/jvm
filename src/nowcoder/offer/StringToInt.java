package nowcoder.offer;

import java.math.BigInteger;

public class StringToInt {

    public static void main(String[] args) {
        Solution s = new Solution();
        int a = -76786579;
        System.out.println(s.StrToInt("-09999090"));
    }

    private static class Solution {

        public int StrToInt(String str) {

            // 符号位置
            int flag = 1, i=0;
            int result = 0;
            char c;

            if (str==null || str.trim().equals("")) {
                return 0;
            }

            if (str.charAt(0) == '-') {
                flag = -1;
                i = 1;
            } else if (str.charAt(0) == '+') {
                flag = 1;
                i = 1;
            }

            for (; i<str.length(); i++) {
                c = str.charAt(i);

                if ( c>='0' && c<='9') {
                    result =  result*10 + (int)(c-'0');
                } else {
                    return 0;
                }

            }


            result = result*flag;

            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }

            return (int)result;

        }

    }

}
