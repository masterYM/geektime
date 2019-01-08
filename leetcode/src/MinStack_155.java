

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class MinStack_155 {


    private int[] items;
    private int n;
    private int count;
    public MinStack_155(int n) {
        this.items = new int[n];
        count = 0;
        this.n = n;
    }

    public static void main(String[] args) {
        MinStack_155 minStack = new MinStack_155(10);
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   //--> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());      //--> 返回 0.
        System.out.println(minStack.getMin());   //--> 返回 -2.
    }

    public void push(int x) {
        if(count == n) return;
        items[count] = x;
        count ++;
    }

    public void pop() {
        if(count == 0) throw new IllegalArgumentException("没有元素");
        count--;
    }

    public int top() {
        return  items[count-1];
    }

    public int getMin() {
        int min = items[0];
        for(int i = 0;i<count;i++){
            int item = items[i];
            if(item<min){
                min = item;
            }
        }
        return min;
    }
}
