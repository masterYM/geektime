package sort;


public class InsertSort {

    public static void main(String[] args) {
        int[] a = {100,22,13,6,5,4};
        int[] s=insertSort(a);
        for(int i = 0;i < s.length;i++){
            System.out.println(s[i]);
        }
    }

    public static int[] insertSort(int[] a){
        int n = a.length;
        for(int i = 1;i<n;i++){
            int value = a[i];
            int j=i-1;
            for(;j>=0;j--){
                if(a[j]>value){
                    a[j+1]=a[j];
                }else {
                    break;
                }
//                a[j]=value;
            }
            a[j+1]=value;
        }
        return a;
    }
}
