package basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionImp {

    public static void main(String[] args) {
        /**
         * 线程不安全, 默认容量：10
         * 扩容：newCapacity = oldCapacity + (oldCapacity >> 1), 1.5 倍扩容, 同时数组拷贝, 尽量控制好初始数组大小
         * 删除元素：时间复杂度 o(n)
         * 线程不安全
         */
        ArrayList<Integer> arrayList = new ArrayList<>();
        /**
         * 线程安全, 使用读写分离,
         * 可以并发读数据, 读数据没有加锁
         * 写入数据, 先复制一份数据, 在副本中写入数据, 将副本复制到原数据中
         * 缺陷: 内存占用, 不能及时更新数据, 导致读操作可能读不到最新数据
         * 使用场景: 高并发读, 写入操作比较少
         */
        CopyOnWriteArrayList<Integer> carr = new CopyOnWriteArrayList<>();
        /**
         * 存储了两个指针 first, last, 节点有两个指针 （next, pre)
         * 与 arrayList 比较: 查找速度慢, 添加和删除开销比较小不用重新复制
         */
        LinkedList<Integer> linkedList = new LinkedList<>();
        /**
         *
         */
        Map<String, String> m = new HashMap<>();
        m.put("a","bb");

    }

}
