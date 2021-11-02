package com.rizqi;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner userInput = new Scanner(System.in);
        int jarak,hasilKotor,penumpang;
        double hasilBersih,hasilAkhir = 0;
        int KM=2000;

        //masukkan jumlah penumpang
        penumpang = userInput.nextInt();

        for (int i=0;i < penumpang;i++) {
           //masukkan jarak
            System.out.println("masukkan jarak tempuh=");
            jarak = userInput.nextInt();
            hasilKotor = jarak * KM;

           //pembagian hasil dengan pihak gojek 80%
            hasilBersih = (double) hasilKotor * 0.8;
            hasilAkhir += hasilBersih;
        }
        //jika mendapatkan minimal 5 penumpang dapat 50000 rb
        if (penumpang>=5){
            hasilAkhir += 50000;
        }
        System.out.print(hasilAkhir);
    }
}
