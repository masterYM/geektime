package bsearch;
//查找最后一个小于等于某个值
public class Bsearch_3 {

    public static void main(String[] args) {
        int[] a = {0,1,2,2,2,2,3,4,5,6,7,8,9,10};
        System.out.println(bsearch(a,2));
    }

    public static int bsearch(int[] a,int key){
        int low = 0;
        int high = a.length -1;

        while (low <= high){
            int mid = low + ((high - low)>>1);
            if(a[mid] > key){
                high = mid -1;
            }else {
                if(mid ==0 || a[mid+1] > key){
                    return mid;
                }else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
