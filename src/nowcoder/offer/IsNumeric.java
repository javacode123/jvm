package nowcoder.offer;

import javax.swing.plaf.PanelUI;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class IsNumeric {

    /**
     * []  ： 字符集合
     * ()  ： 分组
     * ?   ： 重复 0 ~ 1
     * +   ： 重复 1 ~ n
     * *   ： 重复 0 ~ n
     * .   ： 任意字符
     * \\. ： 转义后的 .
     * \\d ： 数字
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str) {

        if (str==null || str.length==0) {
            return false;
        }
        // +-(0到多次) 数字（0到多次）.（0到多次）
        // e（一次）+-（0到多次）数字（1到多次）
        return new String(str).matches("[+-]?\\d*\\.?\\d*([eE][+-]?\\d+)?");
    }


}
