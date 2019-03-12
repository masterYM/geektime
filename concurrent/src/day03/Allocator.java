package day03;

import java.util.ArrayList;
import java.util.List;

/**
 * 破坏占用且等待条件
 * 同时申请所有资源
 *
 * 锁的范围是个大问题。允许A->B 和 C->D可以并行还是很重要的
 */
public class Allocator {

    private volatile static Allocator uniqueInstance;

    private Allocator(){

    }

    public static Allocator getInstance(){
        if(uniqueInstance == null){
            synchronized (Allocator.class){
                if(uniqueInstance == null){
                    uniqueInstance = new Allocator();
                }
            }
        }
        return uniqueInstance;
    }

    private List<Object> als = new ArrayList<>();
    //一次性申请所有资源
    synchronized boolean apply(Object from,Object to){
        if(als.contains(from) || als.contains(to)){
            return false;
        }else {
            als.add(from);
            als.add(to);
        }
        return true;
    }
    //归还资源
    synchronized void free(Object from,Object to){
        als.remove(from);
        als.remove(to);
    }
}
