/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Que;

/**
 *
 * @author ACER
 */
public class Que {
    
    //mendeklarasikan variable int dalam bentuk array yang diberi nama queue
    private int[] queue;
    //menginisialisasikan variable currIndex dengan memberikan nilai 0
    int currIndex = 0;
    
    //membuat objek baru dengan nama queue
    public Que(int n) {
        queue = new int[n];

    }

    /**
     * increase antrian
     */
    
    //pada method berikut kita akan menambahkan size atau ukuran baru ke dalam objek queue 
    //yang telah kita deklarasikan diatas tadi
    private void incrementSize() {
        //kita buat nilai int dalam bentuk array dan kita tambahkan objek queue tadi dengan increment 1
        //length disini adalah bertujuan mencek panjang nilai objek queue diatas tadi
        int[] naik = new int[queue.length + 1];
        //disini kita akan melakukan perulangan 
        //kita defenisikan sebuah int i dengan nilai 0
        //mengapa harus nilai 0? Karena dalam kita melakukan perulangan pasti akan dimulai dari 0 
        //pengecekan datanya, lalu queue.length untuk mengecek nilai queue telah ada atau tidak
        //jika ada maka increment/tambahkan data pada variable i tersebut.
        for (int i = 0; i < queue.length; i++) {
            //maka nilai i akan bertambah sesuai dengan nilai increment/perulangannya berapa kali
            naik[i] = queue[i];
        }
        //disini kita cek apakah objek queue sama dengan variale naik yang telah kita defenisikan diatas
        queue = naik;
    }

    /**
     * tambah data ke antrian
     */
    //pada kode berikut ini kita akan membuat method dengan type void dengan
    //nama enquee, lalu kita akan masukkan parameter dengan type int di dalamnya
    public void enquee(int i) {
        //pada kode berikut ini merupakan cara kita untuk mencek 
        //menggunakan pengkondisian jika currindex merupakan lebih besar sama dengan
        //objek queue 
        if (currIndex >= queue.length) {
            //maka panggil method incrementSize untuk dilakukan proses inkremenisasi(proses menambahkan nilai pada queue)
            incrementSize();
        }
        //jika tidak maka nilai pada currIndex akan sama dengan variable i (i merupakan variable increment pada method diatas)
        queue[currIndex] = i;
        //currIndex akan bertambah jika sesuai dengan nilai i jika terdapat proses inkremenisasi
        currIndex++;
        //menampilkan nilai enquee yang bertambah jika terdapat increment
        System.out.println("enquee: " + i);
    }

    /**
     * move the queue up
     */
    //membuat method void dengan nama moveup
    //pada method ini berfungsi jika queue telah selesai maka akan 
    //antrian selanjunya akan di pindahkan ke atas/depan
    public void moveUp() {
        //pada proses ini terdapat perulangan 
        //*penjelasan : defenisikan variable x = 0, 0 karena setiap perulangan akan dicek apakah nilai
        //yang akan di ulang kurang dari 0. Jika x kurang dari object queue yang dikurang dengan 1, maka x++ (lakukan 
        //increment pada nilai x)
        for (int x = 0; x < queue.length - 1; x++) {
            //nilai x akan diletak pada object queue dan object queue yang berisi nilai increment x sama
            //dengan nilai increment x + 1
            queue[x] = queue[x + 1];
        }
    }

//    remove antrian
    
    //pada method ini kita akan menghapus antrian
    public int dequee() {
        //defenisikan variable r dengan type integer dengan isi object queue berisikan nilai 0
        int r = queue[0];
        //lalu kita panggil method moveUp, mengapa harus ada method moveUp disini?
        //karena dalam proses menghapus antrian pastinya akan memindahkan antrian yang belum
        //dilakukan, maka dari itu kita akan memanggil method move up disini
        moveUp();
        //lalu setelah proses moveUp atau memindahkan antrian selanjutnya keatas,
        //maka kita akan dekremenisasi nilai currIndex dengan menggunakan tanda decrement -- 
        currIndex--;
        //menampilkan ke layar menghapus antrian ke berapa pada variable r
        System.out.println("removing: quee:" + r);
        //mengembalikan nilai variable r
        return r;
    }

    /**
     * menampilkan data antrian
     */
    
    //pada method kali ini akan menampilkan antrian 
    public void display() {
        System.out.println("========= display ========== ");
        //mengapa menggunakan perulangan untuk menampilkan data queue?
        //karena setiap queue pasti ada beberapa data di dalamnya
        //maka untuk menampilkan data tanpa harus mengetikkan queue tersebut
        //dalam array keberapa lebih efesien kita menggunakan perulangan untuk menampilkan datanta
        for (int i = 0; i < queue.length; i++) {
            //menampilkan ke layar nilai antrian ke berapa
            System.out.println("[" + i + "] = " + queue[i]);
        }
        System.out.println("=============================");
    }

       //ini merupakan method yang akan ditampilkan sebelum queue di jalankan
    public void preCondition() {
        System.out.println("========= preCondition =========");
        //memanggil method display untuk menampilkan output
        display();
    }
    
    //ini merupakan method yang dijalankan ketika queue telah selesai di jalankan
    public void postCondition() {
        System.out.println(" ========= postCondition =========");
        //memanggil method display untuk menampilkan output
        display();
    }
    
    //ini merupakan method proses yang akan dijalankan ketika queue sedang berjalan
     public void process() {
        System.out.println("========= process =========");
        enquee(1);
        enquee(2);
        enquee(3);
        enquee(4);
        enquee(5);
        dequee();
        dequee();
        enquee(6);
        enquee(7);
    }

     //ini merupakan method utama atay static method
    public static void main(String[] args) {
        //mendefenisikan nilai size berisi nilai 5
        int size = 5;
        //mengecek jika argumen pada method utama berisikan panjang lebih dari 0
        if (args.length > 0) {
            //jika benar maka variable size akan diubah ke dalam bilangan bulat
            size = Integer.parseInt(args[0]);
        }
        //membuat objek baru untuk menampilkan semua method di dalam program
        Que q = new Que(size);
        //menampilkan method precondition 
        q.preCondition();
        //menampilkan method process 
        q.process();
        //menampilkan method postCondition 
        q.postCondition();
        
    }
}
