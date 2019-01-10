package bsearch;

//查找一个大于等于给定值的元素
public class Bsearch_2 {


    public static int bsearch(int[] a,int key){
        int low = 0;
        int high = a.length -1;

        while (low <= high){
            int mid = low + ((high-low)>>1);
            if(key > a[mid]){
                low = mid + 1;
            }else {
                if(mid == 0 || a[mid - 1] < key){
                    return mid;
                }else {
                    high = mid -1;
                }
            }
        }
        return -1;
    }
}
