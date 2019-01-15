package hash.linked_hash_map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 *  LinkedHashMap 是通过双向链表和散列表这两种数据结构组合实现的。
 *  LinkedHashMap 中的 Linked 实际上是指的是双向链表，并非指用链表法解决散列冲突
 */
public class LinkedHashMap_ {
    public static void main(String[] args) {
//        test();
        test1();
    }

    public static void test1(){
        HashMap<Integer, Integer> m = new LinkedHashMap<>(10,0.75f,true);
        m.put(3,11);
        m.put(2,16);
        m.put(5,14);
        m.put(7,12);

        m.put(3,22);
        m.get(5);

        for(Map.Entry e : m.entrySet()){
            System.out.println(e.getKey());
        }
    }

    public static void test(){
        HashMap<Integer, Integer> m = new LinkedHashMap<>();
        m.put(2,3);
        m.put(4,5);
        m.put(23,64);
        m.put(43,33);
        for(Map.Entry e : m.entrySet()){
            System.out.println(e.getKey());
        }
    }
}
