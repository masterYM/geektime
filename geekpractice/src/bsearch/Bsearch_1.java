package bsearch;

//查找第一个值等于给定值的元素
public class Bsearch_1 {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,8,9,10,10,10,10,10,11,12,12,12,14};
        System.out.println(bsearch1(a,12));
        System.out.println(bsearch1(a,10));
    }

    public static int bsearch1(int[] a,int key){
        int low = 0;
        int high = a.length-1;

        while (low <= high){
            int mid = low + ((high - low)>>1);
            if(a[mid] > key){
                high = mid -1;
            }else if(key > a[mid]){
                low = mid + 1;
            }else {
                if(mid == 0 || a[mid-1] != key){
                    return mid;
                }else {
                    high = mid -1;
                }

            }
        }
        return -1;
    }
}
