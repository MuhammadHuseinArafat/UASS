/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuas;
import java.util.ArrayList;
/**
 *
 * @author hp
 */
public class LihatData implements HapusData {
     ArrayList<CariData> listdata = new ArrayList<CariData>();
    
    
    // method tambah karyawan
    

    @java.lang.Override
    public void add(CariData data){
        listdata.add(data);
    }
    
    // hapus karyawan
    boolean terhapus = false;

    @java.lang.Override
    public void delete(String id ){
        for(int i = 0; i < listdata.size(); i++){
            if(listdata.get(i).idK.equals(id)){
                listdata.remove(i);
                terhapus = true;
                System.out.println("Karyawan berhasil dihapus dari data");
            }else{
                System.out.println("Kode karyawan tidak ada dalam data");
            }
        }
    }
    
    // cari karyawan 
    boolean ditemukan = false;
    int index = 0;

    
    
    @java.lang.Override
    public void search(String kode){
        for(int i = 0; i < listdata.size(); i++){            
            if(listdata.get(i).idK.equals(kode)){
                
                // mengambil index untuk menampilkan data
                index = i;
                ditemukan = true;
                
            }
        }
        
        // memanggil method print() jika data ditemukan
        if(ditemukan){
            listdata.get(index).print();
        }
        
    }
    
    
    
    
    // Method override print
    @java.lang.Override
    public void print(){
        System.out.println("=============================================================================");
        System.out.println("                                DATA KARYAWAN                                ");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("KODE" + "\t" + "NAMA" + "\t"+ "GOL"+ "\t"+  "USIA"+ "\t" + "STATUS NIKAH" + "\t" + "JUMLAH ANAK");
        System.out.println("-----------------------------------------------------------------------------");
        
        
        //looping print data
        for(int i=0; i <listdata.size(); i++){
            String kode = listdata.get(i).idK;
            String nama = listdata.get(i).namaK;
            String gol = listdata.get(i).golK;
            int usia = listdata.get(i).usia;
            String status = "Belum Menikah";
            int JmlAnak = 0;
            if( listdata.get(i).statusK == 1){
                status = "Sudah Menikah";
                JmlAnak = listdata.get(i).banyakAnak;
            }else if( listdata.get(i).statusK == 0){
                status = "Belum Menikah";
                JmlAnak = 0;
            }
            
            //menampilkan output dari data
            System.out.println(kode + "\t" + nama + "\t"+ gol+ "\t"+ usia+"\t"+ status +"\t"+ JmlAnak );
        }
        
        System.out.println("-----------------------------------------------------------------------------");
        
        //menampilkan jumlah data karyawan dalam arraylist
        System.out.println("Jumlah Data : " + listdata.size());
    }

    
}
