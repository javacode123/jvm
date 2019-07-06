package basic;

/**
 * String 是不可变类型:
 *  1：线程安全不可修改
 *  2：作为 key, 因为对应的 hashcode 不可变
 *  3：字符串池
 * StringBuilder 不是线程安全的, StringBuffer 是线程安全的
 */
public class StringPool {

    /**
     * 字符串常量池（String Pool) 保存这所有字符串字面量, 这些字面量在编译时就确定。
     * 可以使用 String 的 intern() 方法在运行中将字符串添加到 String Pool 中。
     *
     * 调用 intern() 方法, 如果 String Pool 中存在一个字符串与该字符串相等（
     * 使用 equals() 确定), 那么就返回 String Pool 中字符串的引用, 否则, 就会
     * 在 String Pool 中添加一个新的字符串, 并返回这个新字符串的引用。
     */
    public static void main(String[] args) {
        String str1 = new String("abcd"); // 创建两个对象,字符串对象, 一个指向 String Pool(暂时没 "abcd"),
        String str2 = new String("abcd"); // 创建一个对象, String Pool 中已经存在（"abcd"）
        System.out.println(str1 == str2); // false 表示不同对象
        String str3 = str1.intern(); // 来自 String Pool
        System.out.println(str3 == str1); // false
        String str4 = str2.intern(); // 来自 String Pool
        System.out.println(str3 == str4); // true
    }

}
