package linked_list;

/**
 * 在数组 a 中，查找key，返回key所在的位置
 * n 表示 a 的长度
 *
 * 重点留意边界条件处理
 */
public class Main {

    public static void main(String[] args) {
        int[] a = {0,1,2,3,4,5,6,7,8,9};
        int index = find2(a,10,  3);
        System.out.println(index);
    }


    //哨兵
    public static int find2(int[] a,int n,int key){
        if(a == null || n <= 0){
            return -1;
        }

        if(a[n-1] == key){ //通过哨兵 a[n-1] == key ，成功省掉一个比较语句 i<n.
            return n-1;
        }

        int tmp =  a[n-1];
        a[n-1] = key;

        int i = 0;
        while (a[i] != key){
            ++i;
        }
        a[n-1] = tmp;

        if(i == n-1){
            return -1;
        }else {
            return i;
        }

    }
    public static int find1(int[] a,int n,int key){
        if(a == null || n <= 0){
            return -1;
        }

        int i = 0;
        while (i < n){
            if(a[i] == key){
                return i;
            }
            ++i;
        }
        return -1;
    }


}
