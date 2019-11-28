package Praktikum;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void kegiatan1(){
        Number[] numberz = {2.3D, 2, 1034923L, 1};

        BinarySearchController bsc = new BinarySearchController(numberz);
        bsc.setTarget(2);

        boolean isFound = bsc.isTargetFound();
        if (isFound){
            System.out.println("Target Found");
            bsc.indexFound();
        }else{
            System.out.println("Target Not Found");
        }
    }

    public static void kegiatan2(){
        Scanner scan = new Scanner(System.in);

        System.out.print("Input DataSet Sentence : ");
        String kalimat = scan.nextLine();

        String[] arr = kalimat.split(" ");

        BubbleSort bs = new BubbleSort(arr);
        bs.doSorting();
        System.out.println("Result Sorting : "+Arrays.toString(arr));
        FiboanacciController fc = new FiboanacciController(arr);
        System.out.print("Enter the word you want to search : ");
        String kata = scan.next();
        fc.setTarget(kata);

        int resultTarget = fc.searchTarget();
        if (resultTarget != -1){
            System.out.println("Target found at index : " + resultTarget);
        }else {
            System.out.println("Teaget not found");
        }
    }

    public static void driver(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Choose : " +
                "\n1. Kegiatan 1" +
                "\n2. Kegiatan 2" +
                "\n>>>>>>> ");

        int pil = scan.nextInt();
        switch (pil){
            case 1 :
                kegiatan1();
                break;
            case 2 :
                kegiatan2();
                break;
            default:
                System.out.println("Yo tak lalap ta!!!!");
                break;
        }
    }


    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        driver();
        System.out.print("Want Again ? Y/N" +
                "\n>>>> ");
        Character jwb = scan.next().charAt(0);
        if (jwb.equals('Y') || jwb.equals('y')){
            driver();
        }else{
            System.out.println("Goodbye Love!");
        }
    }



}
