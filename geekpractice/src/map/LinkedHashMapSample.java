package map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 有序Map  LinkedHashMap   TreeMap
 * LinkedHashMap ： 提供的是遍历顺序符合插入顺序，它的实现是通过为条目（键值对）维护一个双向链表。
 *
 *
 * 构建一个空间占用敏感的资源池，希望可以自动将最不常被访问的对象释放掉，这就可以利用LinkedHashMap提供的机制来实现
 */
public class LinkedHashMapSample {
    public static void main(String[] args) {
        LinkedHashMap<String,String> accessOrderdMap =
                new LinkedHashMap<String, String>(16,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                //实现自定义删除策略，否则行为就和普通Map 没有区别
                return size() > 3;
            }
        };
        accessOrderdMap.put("Project1","Valhalla");
        accessOrderdMap.put("Project2","Panama");
        accessOrderdMap.put("Project3","Loom");
        accessOrderdMap.forEach((k,v)->{
            System.out.println(k + " : " + v);
        });
        //模拟访问
        accessOrderdMap.get("Project2");
        accessOrderdMap.get("Project2");
        accessOrderdMap.get("Project3");
        System.out.println("Iterate over should be not affected");
        accessOrderdMap.forEach((k,v)->{
            System.out.println(k + " : " + v);
        });
        //触发删除
        accessOrderdMap.put("Project4","Mission Control");
        System.out.println("Oldest entry should be removed");
        accessOrderdMap.forEach((k,v)->{//遍历顺序不变
            System.out.println(k + " : " + v);
        });
    }

}
