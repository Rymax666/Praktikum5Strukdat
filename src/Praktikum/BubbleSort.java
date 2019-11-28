package Praktikum;

public class BubbleSort {
    String[] arr;

    BubbleSort(String[] arr){
        this.arr = arr;
    }

    public void doSorting(){
        for (int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length - i - 1; j++){
                if (arr[j].compareTo(arr[j+1]) > 0){
                    //PROSES SWAP NAMA[J+1] DAN NAMA[I]
                    String temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
