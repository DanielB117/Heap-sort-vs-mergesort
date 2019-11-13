import java.util.PriorityQueue;



import java.util.Arrays;
import java.util.Timer;
public class main {

    public static void main(String[] args) {
        // write your code here

        int[] arreglo1 = new int[10];
        int[] arreglo2 = new int[10];



        for (int i = 0; i<arreglo1.length;i++){
            int temp = (int)(Math.random()*10)+1;
            arreglo1[i] = temp;
            arreglo2[i] = temp;
        }

        arreglo1 = mergeSort(arreglo1);




        Timer timer = new Timer();
        long Time = System.currentTimeMillis();

        System.out.println("-----------------MERGE SORT-----------------");
        for (int i = 0; i < arreglo1.length; i++) {

            System.out.print(arreglo1[i]+", ");
            System.out.println(Time+" Miliseconds");

        }



        System.out.println("----------------------HEAP SORT---------------");
        System.out.println("Antes de Heap Sort");

        System.out.print(Arrays.toString(arreglo2));
        System.out.println(Time+" Miliseconds");

        System.out.println("Despues de Heap sort.");
        long TIME = System.currentTimeMillis();
        arreglo2 = heapSort(arreglo2);
        System.out.print(Arrays.toString(arreglo2));
        System.out.println(TIME+" Miliseconds");System.out.println();

        System.out.println("Merge Sort Arreglado");

        System.out.print(Arrays.toString(arreglo1));
        System.out.println(Time+" Miliseconds");


    }





    public static void armarheap(int []arr) {

        for(int i=(arr.length-1)/2; i>=0; i--){
            heapify(arr,i,arr.length-1);
        }
    }

    public static void heapify(int[] arr, int i,int size) {
        int left = 2*i+1;
        int right = 2*i+2;
        int max;
        if(left <= size && arr[left] > arr[i]){
            max=left;
        } else {
            max=i;
        }

        if(right <= size && arr[right] > arr[max]) {
            max=right;
        }

        if(max!=i) {
            intercambiar(arr,i, max);
            heapify(arr, max,size);
        }
    }

    public static void intercambiar(int[] arr,int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static int[] heapSort(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        armarheap(arr);
        int sizeOfHeap = arr.length - 1;
        for (int i = sizeOfHeap; i > 0; i--) {
            intercambiar(arr, 0, i);
            sizeOfHeap = sizeOfHeap - 1;
            heapify(arr, 0, sizeOfHeap);
        }
        return arr;
    }

    public  static int[] mergeSort(int[] arr){
        //caso base.
        if(arr.length <= 1){
            return arr;
        }
        // caso recursivo.

        int medio = arr.length /2;

        int[] inferior = new int[medio];
        int[] superior = new int[arr.length - medio];
        for (int i = 0; i < medio; i++) {
            inferior[i] = arr[i];
        }

        for (int i = 0; i < superior.length ; i++) {
            superior[i] = arr[i + inferior.length];
        }
        return  merge(mergeSort(inferior), mergeSort(superior));
    }


    public static int[] merge(int[] a, int[] b){
        int[] retval = new int[a.length+ b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (j < a.length && k < b.length ){
            if(a[j] < b[k]){
                retval[i++] = a[j++];
            }else{
                retval[i++] = b[k++];
            }
        }

        while (j < a.length){
            retval[i++] = a[j++];
        }

        while (k < b.length){
            retval[i++] = b[k++];
        }
        return retval;

    }
}