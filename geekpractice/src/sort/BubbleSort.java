package sort;



public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {100,2,3,6,90,23};
//        int[] r = bubbleSort1(a);
        int[] r = bubbleSort2(a);
        for(int i = 0;i < r.length;i++){
            System.out.println(r[i]);
        }
    }

    public static int[] bubbleSort2(int[] a){
        int n = a.length;
        for(int i = 0;i<n;i++){
            boolean flag = true;
            for(int j = 0;j<n-1-i;j++){
                if(a[j]>a[j+1]){
                    int tmp = a[j];
                    a[j]=a[j+1];
                    a[j+1]=tmp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
        return a;

    }


    public static int[] bubbleSort1(int[] a){

        for(int i = 0;i<a.length;i++){
            for(int j = i+1;j<a.length;j++){
                if(a[i] > a[j]){
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
        return a;
    }
}
