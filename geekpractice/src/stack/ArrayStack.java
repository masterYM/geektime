package stack;
//leetcode:20,155,232,844,224,682,496
public class ArrayStack {
    //数组
    private String[] items;
    //栈中元素个数
    private int count;
    //栈的大小
    private int n;

    //初始化一个数组，申请一个大小为n的数组空间
    public ArrayStack(int n){
        this.items = new String[n];
        this.n = n;
        this.count = 0;
    }

    //入栈操作
    public boolean push(String item){

        if(count == n) return false;
        items[count] = item;
        count ++;
        return true;
    }

    //出栈操作
    public String pop(){
        if(count == 0)return null;
        String tmp = items[--count];
        return tmp;

    }
}
