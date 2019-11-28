package Praktikum;

public class FiboanacciController {
    private String[] dataset;
    private String target;
    private int lengthArr;

    //dataSet merupakan data yang ingin diuji coba untuk mencari nilai sesuai target
    public FiboanacciController(String[] dataset) {
        this.dataset = dataset;
        this.lengthArr = dataset.length;
    }

    //method untuk set data pencarian
    public void setTarget(String target) {
        this.target = target;
    }

    public int min(int x, int y) {
        return (x <= y) ? x : y;
    }

    //method untuk mencari nilai minumum dari dua angka

    public int searchTarget() {
        //inisialisasi angka fibonacci
        int fibMMm0 = 0; //variabel angka fibonacci pertama dengan inisialisasi nilai 0
        int fibMMm1 = 1; //variabel angka fibonacci pertama dengan inisialisasi nilai 1
        int fibM = fibMMm0 + fibMMm1; //rumus untuk mencari angka fibonacci jika n > 1

        //mencari angka fibonacci sebelum atau sama dengan n
        while (fibM < lengthArr) {
            fibMMm0 = fibMMm1;
            fibMMm1 = fibM;
            fibM = fibMMm0 + fibMMm1;
        }

        // penanda untuk pengurangan bilangan fibonacci jika target masih tidak ditemukan
        int offset = -1;

        //jika angka fibonacci yang saat ini sedang di looping lebih dari angka 1 maka akan masuk pada
        //proses looping dibawah ini
        while (fibM > 1) {
            //mendapatkan akses ke array (index) dengan cara membandingkan angka fibonacci pertama dikurangi satu
            //dngan nilai panjang array dikurangi satu (karena index array dimulai dari 0)
            int i = min(offset + fibMMm0, lengthArr - 1);
            //jika nilai target lebih dari nilai dalam array yang diakses saat ini maka perbarui semua angka
            //fibonacci dengan begitu aaray yang didapat mulai dari offset hingga nilai terakhir i
            if (dataset[i].compareTo(target) < 0) {
                fibM = fibMMm1;
                fibMMm1 = fibMMm0;
                fibMMm0 = fibM - fibMMm1;
                offset = i;
            }

            //kondisi kedua jika target lebih kecil dari nilai dalam array yang yang diakses
            //saat ini maka pemotongan akan dilakukan ke array bagian kiri
            else if (dataset[i].compareTo(target) > 0) {
                fibM = fibMMm0;
                fibMMm1 = fibMMm1 - fibMMm0;
                fibMMm0 = fibM - fibMMm1;
            }
            //nilai default pengembalian method adalah alamat index dari array

            else return i;
        }
        //jika angka target ditemukan dan parameter fibMMml sama dengan 1 yang menandakan angka fibonacci
        //terkecil maka target ditemukan dan mengembalikan nilai dari alamat index

        if (fibMMm1 == 1 && dataset[offset + 1].equals(target)) {
            return offset + 1;
        }

        //jika target tidak ditemukan maka mereturn angka -1
        return -1;
    }


}
