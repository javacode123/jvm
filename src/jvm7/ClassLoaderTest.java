package jvm7;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {

        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {

                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1 ) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);

                    if (is == null) {
                        return super.loadClass(name);
                    }

                    byte[] b = new byte[is.available()];
                    System.out.println(b[0]);
                    is.read(b);
                    System.out.println(b[0]);

                    return defineClass(name, b, 0, b.length);

                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                    // throw 抛出一个指定的异常，通常在函数体内
                    // throws 在方法后面，可能抛出也可能不抛出
                }

            }
        };

        Object obj = myLoader.loadClass("jvm7.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof jvm7.ClassLoaderTest);
        // false 判断两个类是否相等时候，只有两个类是由同一个类加载器的前提下才有意义
        // 本例中，obj 是自定义的类加载器，而 jvm7.ClassLoaderTest 是属于系统加载器

    }

}
