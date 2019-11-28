package Praktikum;

public class BinarySearchController {
    private Number[] data;
    private Number target;

    public BinarySearchController(Number[] data){
        this.data = data;
    }

    public void setTarget(Number target) {
        this.target = target;
    }

    //SORTING SEBELUM SEARCH
    private Number[] sortingData(){
        Number[] dataToSort = data;
        int idxI, idxJ , length = dataToSort.length;
        for (idxI = 0; idxI < length; idxI++){
            for (idxJ = 0; idxJ < length; idxJ++){
                if (dataToSort[idxJ].doubleValue() > dataToSort[idxI].doubleValue()){
                    //PROSES SWAP NAMA [J+1] DAN NAMA [i}
                    swap(idxI, idxJ, dataToSort);
                }
            }
        }
        return dataToSort;
    }

    //SWAP UNTUK SORTING ASCENDING
    private void swap(int idxI, int idxJ, Number[] dataToSort){
        Number c = dataToSort[idxI];
        dataToSort[idxI] = dataToSort[idxJ];
        dataToSort[idxJ] = c;
    }

    //SEARCH DARI DATA YANG SUDAH DI SORTING
    public boolean isTargetFound(){
        Number[] resultSorting = sortingData();

        int low = 0;
        int high = resultSorting.length - 1;
        while (high >= low){
            int middle = (low + high) / 2;
            if (resultSorting[middle].doubleValue() == target.doubleValue()){
                return true;
            }
            if (resultSorting[middle].doubleValue() < target.doubleValue()){
                low = middle + 1;
            }
            if (resultSorting[middle].doubleValue() > target.doubleValue()){
                high = middle -1;
            }
        }
        return false;
    }

    //CARI INDEXNYA
    public int indexFound(){
        Number[] resultSorting = sortingData();

        for (int i = 0; i < resultSorting.length; i++){
            if (target.equals(resultSorting[i])){
                System.out.println("Angka "+target+" Ditemukan pada index ke-"+i+"\n");
                break;
            }
        }
        return 0;
    }
}
