/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraymhs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author ayaya
 */
public class DataMahasiswa {
    String nim, nama,jk,tgl;
    int gen;
    int jml;
    int pil;
    int menu;
    
    //ArrayList<ArrayList<String>>mhs=new ArrayList<ArrayList<String>>();
    ArrayList<ArrayList<String>>mhs=new ArrayList<ArrayList<String>>();
    int[] jns=new int[gen];

    void input(){
        Scanner n=new Scanner(System.in);
        System.out.print("Masukkan jumlah mahasiswa: ");
        this.jml=n.nextInt();
        
        for(int i=0; i<jml; i++){
            //mhs.add(new ArrayList<String>(Arrays.asList()));
            System.out.println("Mahasiswa ke-"+(i+1));
            System.out.print("Masukkan NIM: ");
            nim=n.next();
        
            System.out.print("Masukkan nama: ");
            nama=n.next();
            
            System.out.print("Masukkan tanggal lahir (dd-mm-yyyy): ");
            this.tgl=n.next();
        
            System.out.print("Masukkan jenis kelamin (0: Laki-laki, 1: Perempuan): ");
            this.gen=n.nextInt();
            if(gen==0){
                jk="Laki-laki";
            }
            else if(gen==1){
                jk="Perempuan";
            }
        
            mhs.add(new ArrayList<String>(Arrays.asList(nim,nama,tgl,jk)));
            System.out.println(mhs);
        }
    }
    
    void hapusnim(){
        this.mhs.removeIf(data -> data.contains(nim));
        System.out.println("Ok");
        System.out.println(mhs);
    }
    
    void searchjk(){
        if(gen==0){
            System.out.println(mhs.get(gen));
        }
        if(gen==1){
            System.out.println(mhs.get(gen));
        }
    }
    
    void searchnim(){
        boolean y=false;
        int index=-1;
        for(int i=0; i<this.mhs.size(); i++){
            if(this.mhs.get(i).contains(nim)){
                index=i;
                y=true;
            }
        }
        if(y==true){
            System.out.println(this.mhs.get(index));
        }
        else{
            System.out.println("Hmm.. datanya nggak ada");
        }
    }
    
    void menu(){
        Scanner n=new Scanner(System.in);
        
        System.out.println("Sekarang apa?");
        System.out.println("1. Cari data mahasiswa");
        System.out.println("2. Hapus data mahasiswa");
        System.out.println("3. Tambah data mahasiswa");
        System.out.println("4. Tampilkan data mahasiswa");
        System.out.println("5. Keluar");
        System.out.println("Hm?");
        menu=n.nextInt();
        
        if(menu==1){
            System.out.println("Hooo.. Mau cari dari apanya?");
            System.out.println("1. NIM");
            System.out.println("2. Jenis kelamin");
            System.out.println("Hm?");
            pil=n.nextInt();
            
            if(pil==1){
                System.out.println("Hooo.. Mau cari dari NIM nya ya?");
                System.out.println("Berapa NIM nya?");
                System.out.println("Hm?");
                this.nim=n.next();
                searchnim();
            }
            if(pil==2){
                System.out.println("Hooo.. Mau cari dari jenis kelaminnya ya..");
                System.out.println("Apa jenis kelaminnya? (0: Laki-laki, 1: Perempuan)");
                System.out.println("Hm?");
                this.gen=n.nextInt();
                searchjk();
            }
        }
        if(menu==2){
            System.out.println("Hooo.. Mau hapus data?");
            System.out.println("Berapa NIM nya?");
            nim=n.next();
            hapusnim();
        }
        if(menu==3){
            System.out.println("Hooo.. Masih kurang? Mau tambah lagi? Silakan.");
            input();
        }
        if(menu==4){
            System.out.println("Ok");
            System.out.println(mhs);
        }
        if(menu==5){
            System.out.println("Bye");
            System.exit(0);
        }
        else{
            do{
                menu();
            }while(menu !=1 && menu !=2 && menu !=3 && menu !=4 && menu !=5);
        }
    }
}
