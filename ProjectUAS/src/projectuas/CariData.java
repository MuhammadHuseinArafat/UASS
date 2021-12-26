/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuas;
import java.time.LocalDate;
import java.time.Period;
/**
 *
 * @author hp
 */
public class CariData {
     //attribute untuk hitung usia karyawan
    private int h,b,t;
    
    // attribute dipakai statusnya
    public int statusK,banyakAnak,usia,tunK,tunjP,tunjA,gajiBruto,potongan,
            gajiAkhir ,gapok;
    
    // atribute karyawan
    public String idK,namaK,alamatK,tglK,golK;
    
    //attribute untuk cek status nikah,anak,umur
    boolean StatusTunjA = false,StatusTunjK = false,StatusTunjP = false;
    
    
    // konstruktor
    public CariData(String id, String nama, String alamat, String tgl, String golong, int status, int anak){
        this.idK = id;
        this.namaK = nama;
        this.alamatK = alamat;
        this.tglK = tgl;
        this.golK = golong;
        this.statusK = status;
        this.banyakAnak = anak;
        
        
        // hitung usia karyawan
        String tgllahir =  this.tglK;
        String[] lahir = tgllahir.split("-");
        int t = Integer.parseInt(lahir[0] );
        int b = Integer.parseInt(lahir[1] );
        int h = Integer.parseInt(lahir[2] );
        
        LocalDate from = LocalDate.of(t, b, h);
        
        //mengambil tanggal saat ini
        LocalDate today = LocalDate.now();
        
        //hitung usia
        int umur = Period.between(from, today).getYears();
        this.usia = umur;
        
        
        
        
        // gaji pokok karyawan tergantung golongan
        switch (golK) {
            case "a":
            case "A":
                gapok = 5000000;
                break;
            case "b":
            case "B":
                gapok = 6000000;
                break;
            case "c":
            case "C":
                gapok = 7000000;
                break;
        }
        
        
        // tunjangan tambahan jika karyawan sudah menikah
        switch(statusK ){
            case 1 : 
                this.tunK = gapok*10/100;
                this.StatusTunjK = true;
                break;
        }
        
        // tunjangan tambahan jika karyawan memiliki anak
        switch(statusK){
            case 1 :
                if(banyakAnak>0){
                    tunjA = banyakAnak*gapok*5/100;
                    StatusTunjA = true;
                }
                break;
        }
        
        
        
        // tunjangan tambahan jika umur karyawan lebih dari 30 tahun
        if(usia>30){
            tunjP = gapok*15/100;
            StatusTunjP = true;
            
        }

        
        
        
        // menentukan gaji kotor 
        gajiBruto = gapok + tunK + tunjP + tunjA;
        
        // pemotongan gaji
        potongan = gajiBruto*25/1000;
        
        // gaji akhir setelah perhitungan
        gajiAkhir = gajiBruto - potongan;
        
    }

    
    
    // output cari data
    public void print(){
        System.out.println("=========================================================");
        System.out.println("                  DATA PROFIL KARYAWAN                   ");
        System.out.println("---------------------------------------------------------");

        System.out.println("Kode Karyawan           : " + idK);
        System.out.println("Nama Karyawan           : " + namaK);
        System.out.println("Golongan                : " + golK);
        System.out.println("Usia                    : " + usia);

        // status menikah dan jumlah anak 
        switch( statusK ){
            case 0 :
                System.out.println("Status Menikah          : Belum Menikah");
                System.out.println("---------------------------------------------------------");
                break;
            
            case 1 :
                System.out.println("Status Menikah          : Sudah Menikah");
                System.out.println("Jumlah Anak             : " + banyakAnak);
                System.out.println("---------------------------------------------------------");
        }
        System.out.println("Gaji Pokok              : Rp" + gapok);
        
        //pengecekan tunjangan
        if(StatusTunjK){
            System.out.println("Tunjangan Suami/Istri   : Rp" + tunK );
        }if(StatusTunjP){
            System.out.println("Tunjangan Pegawai       : Rp" + tunjP);
        }if(StatusTunjA){
            System.out.println("Tunjangan Anak          : Rp" + tunjA); 
        }
        System.out.println("--------------------------------------------------------- +");
        System.out.println("Gaji Kotor              : Rp" + gajiBruto);
        System.out.println("Potongan                : Rp" + potongan);
        System.out.println("--------------------------------------------------------- -");
        System.out.println("Gaji Bersih             : Rp" + gajiAkhir);
    }
}
