package bsearch;
//二分查找适用于近似查找
public class Bsearch {
    public static void main(String[] args) {
        int[] a = {1,2,3,6,19,20,21,56};
        int aa =  bsearch(a,56);
        System.out.println(aa);
        System.out.println(b(a,1));
    }

    public static int b(int[] a,int val){
        int n = a.length;
        return basearch(a,0,n-1,val);
    }

    public static int basearch(int[] a,int low,int high,int value){
        if(low > high)return -1;
        int mid = low+((high-low)>>1);
        if(a[mid] == value){
            return mid;
        }else if(a[mid] > value){
            return basearch(a,low,mid-1,value);
        }else {
            return basearch(a,mid+1,high,value);
        }
    }

    public static int bsearch(int[] a,int key){
        if(a.length==1){
            if(a[0]==key){
                return 0;
            }else {
                return -1;
            }
        }
        int s = 0;
        int e = a.length-1;

        int r;
        while (s<=e){
//            int m = (s+e)/2;//可能溢出
//            int m = s+(e-s)/2;//不是最快的
            int m = s+((e-s)>>1);//
            r = a[m];
            if(key==r){
                return m;
            }else if(key<r){
                e = m-1;
            }else {
                s = m+1;
            }
        }
        return -1;
    }
}
