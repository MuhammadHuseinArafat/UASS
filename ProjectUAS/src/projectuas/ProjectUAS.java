/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuas;

import java.lang.annotation.Annotation;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class ProjectUAS {

    
    public static void main(String[] args) {
         Override dataK = new Override() {
             @Override
             public Class<? extends Annotation> annotationType() {
                 throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             }
         };
        
        //attribute pengecekan untuk looping
        boolean ulang = true;
        while (ulang){
            System.out.println("");
            Scanner input = new Scanner(System.in);
            String ul="",lagi;
            System.out.println("---- SELAMAT DATANG-----");
            System.out.println("");
            System.out.println(" Menu Utama ");
            System.out.println("1. Tambah Data");
            System.out.println("2. Hapus Data");
            System.out.println("3. Cari Data");
            System.out.println("4. Lihat Data");
            System.out.println("5. Exit");
            System.out.println("==============================");
            System.out.println("Pilih Menu dulu ya [1/2/3/4/5] =  "); int pilih = input.nextInt();
            System.out.println("==============================");
            switch (pilih){
                case 1 : 
                    boolean tambahdata = true;
                    while( tambahdata ){
                        System.out.println("");
                        System.out.println("===========================================");
                        System.out.println("               Menu Tambah Data            ");
                        System.out.println("-------------------------------------------");
                        String cb = input.nextLine();
                        
                        //input nama karyawan
                        System.out.print("Masukan Kode Karyawan             : ");
                        String koKar = input.nextLine();
                        
                        //input alamat karyawan
                        System.out.print("Masukan Nama Karyawan             : ");
                        String namkar = input.nextLine();
                        
                        //input alamat karyawan
                        System.out.print("Masukan Alamat                    : ");
                        String alamat = input.nextLine();
                        
                        //input tanggal lagir karyawan
                        System.out.print("Masukan Tanggal Lahir (YYYY-MM-DD): ");
                        String tL = input.nextLine();
                        
                        //input golongan karyawan
                        System.out.print("Masukan Golongan (A/B/C)          : ");
                        String Gol = input.nextLine();
                        System.out.println("");
                        
                        //input status karyawan sudah menikah atau belum
                        System.out.println("Masukan Status Menikah");
                        System.out.println("0.belum");
                        System.out.println("1.menikah");
                        System.out.print("Status Karyawan                   : ");
                        int statKar = input.nextInt();
                        
                        //attribut untuk jumlah anak
                        int banyakAnak;
                        if( statKar == 1 ){
                            System.out.print("Jumlah Anak                       : ");
                            banyakAnak = input.nextInt();
                        } else {
                            statKar = 0;
                            banyakAnak = 0;
                        }
                        

                        //data akan dimasukkan ke class Data
                        //dan nantinya akan di masukkan ke arraylist
                        CariData karyawan = new CariData(
                                koKar,
                                namkar,
                                alamat,
                                tL,
                                Gol,
                                statKar,
                                banyakAnak
                        );
                        
                        // data ditambahkan ke array list
                        dataK.add(karyawan);
                        
                        //input submenu
                        System.out.println("\n");
                        System.out.println("Pilih Submenu : ");
                        System.out.println("1 Kembali ke menu utama");
                        System.out.println("2 Tambah Data Kembali");
                        System.out.println("");
                        System.out.print("Menu Pilihan : ");
                        
                        //cek inputan submenu
                        int inpSub = input.nextInt();
                        if( inpSub == 1 ){
                            tambahdata = false;
                        }else if(inpSub != 2) {
                            System.out.println("pilihan sub menu tidak ada");
                        }  
                    }
                    break;
                
                    
                case 2 : 
                    boolean inpHapus = true;
                    while( inpHapus ) {
                        System.out.println("");
                        System.out.println("===========================================");
                        System.out.println("                 Hapus Data                ");
                        System.out.println("-------------------------------------------");
                        String cb = input.nextLine();
                        
                        System.out.print("Masukan kode karyawan yg ingin dihapus : ");
                        String kode_karyawan = input.nextLine();
                        
                        // menghapus data karyawan 
                        dataK.delete(kode_karyawan);
                        

                        //input submenu
                        System.out.println("Pilih Submenu : ");
                        System.out.println("1 Kembali ke menu utama");
                        System.out.println("2 Hapus Data Kembali");
                        System.out.println("");
                        System.out.print("Menu Pilihan : ");
                        
                        //cek inputan submenu
                        int inpSub = input.nextInt();
                        if( inpSub == 1 ){
                            inpHapus = false;
                        } else if(inpSub != 2) {
                            System.out.println("pilihan sub menu tidak ada");
                        }
                        
                    }
                    break;
                
                case 3 :                     
                    boolean menu_cari_data = true;
                    while( menu_cari_data ){
                        System.out.println("");
                        System.out.println("===========================================");
                        System.out.println("                 Cari Data                 ");
                        System.out.println("-------------------------------------------");
                        String cb = input.nextLine();
                        
                        System.out.print("Masukan Kode Karyawan untuk dicari : ");
                        String inputID = input.nextLine();

                        // mencari ID karywan
                        dataK.search(inputID);

                        //input submenu
                        System.out.println("");
                        System.out.println("Pilih SubMenu : ");
                        System.out.println("1.Kembali ke menu utama");
                        System.out.println("");
                        System.out.print("Menu Pilihan : ");
                        
                        int inpSub = input.nextInt();
                        if( inpSub == 1 ){
                            menu_cari_data = false;
                        } else{
                            System.out.println("pilihan sub menu tidak ada");
                        }
                    }
                    break;
                
                case 4 : 
                    boolean agar = true;
                    while( agar ){
                        //menampilkan data karyawan
                        dataK.print();
                        
                        
                        //input submenu
                        System.out.println("");
                        System.out.println("Pilih SubMenu : ");
                        System.out.println("1.Kembali ke menu utama");
                        System.out.println("");
                        System.out.print("Menu Pilihan : ");

                        int inpSub = input.nextInt();
                        if( inpSub == 1 ){
                            agar = false;
                        } else {
                            System.out.println("pilihan sub menu tidak ada");
                        }
                    }
                    break;

                    
                case 5 : 
                    System.exit(0);
                
                default: 
                    System.out.println("Menu yang anda pilih tidak ada dalam daftar");
                    System.out.println("");
                
                break;   
        }
            System.out.println("==========================================");
            System.out.println("Apakah kamu ingin mengulangi lagi(y/n) ?");
            ulang = input.next();
        }
    }
    
}
