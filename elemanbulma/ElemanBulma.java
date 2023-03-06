/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algoritmaodev1;
import java.util.Scanner;

    /**
 *
 * @author asus
 */
public class AlgoritmaOdev1 {
 public static void main(String[] args) {
    int table[][] = {
      {10, 30, 45, 50, 58, 71, 79, 86, 89, 93, 99, 107, 112},
      {13, 34, 48, 66, 69, 78, 85, 88, 94, 96, 100, 115, 118},
      {15, 44, 51, 67, 72, 83, 87, 91, 97, 103, 105, 117, 121},
      {17, 46, 53, 70, 74, 84, 90, 93, 98, 104, 109, 120, 189},
      {23, 55, 64, 77, 81, 93, 101, 111, 116, 122, 130, 147, 201},
      {37, 65, 73, 80, 82, 106, 110, 119, 125, 129, 152, 169, 205},
      {39, 68, 76, 102, 108, 113, 114, 124, 131, 137, 161, 178, 210},
      {40, 93, 123, 126, 140, 144, 148, 150, 157, 160, 162, 202, 267},
      {43, 128, 133, 135, 149, 164, 166, 171, 177, 183, 192, 204, 301},
      {400, 500, 600, 700, 800, 900, 901, 902, 903, 904, 905, 906, 909}
    };
    
    // satır için değişken oluşturduk
    int rows = table.length; 
    // sütun için değişken oluşturduk
    int columns = table[0].length;

    // kullanıcıdan aranacak ddeğeri aldık
    Scanner scanner = new Scanner(System.in);
    System.out.print("Arancak anahtar degeri giriniz: ");
    // key değişkenine atadık
    int key = scanner.nextInt(); 
    scanner.close();

    //search metodunu çağırdık
    int karsilastirmasayaci = search(table, rows, columns, key);
    // toplam karşılaştırma sayısını ekrana bstırdık 
    System.out.println("Toplam karsilastirma sayisi: " + karsilastirmasayaci);
    
  
  }
   
public static int search(int table[][], int rows, int columns, int key) { // binary search aramsı yapmsı için metodumuzu tanımladık 
    
      int karsilastirma = 0; // karşılaştırma sayısını bu değişkende tutuyoruz
       int sonuc = 0; // 93 değeri tekrarlı olduğu için ona ekstra değişken tanımladık
      
    for (int i = 0; i < table.length; i++) { 
        int enSol= 0;// en baştaki değer için değişken
        int enSag = table[i].length - 1;// en sondaki değer için değişken
        while (enSol <= enSag) { // en baştkai ve en sondaki değişkenlerin yer kontrolünü yaptık
            int ortanca = (enSol + enSag) / 2; // bu değişkenlere göre ortanca değeri bulduk
            karsilastirma++; // karşılaştırma sayısını artırdık
            if (key == table[i][ortanca]) { //tekrar eden 93 lerin karşılaştırma sayısı için bir kontrol daha sağladık
                  sonuc += karsilastirma; // 93 ler için tuttuğumuz sonuç değişkenine karşılaştırma ve sonucun toplamını gönderdik
                break;
            }
            
            if (key < table[i][ortanca]) { // aranan değer ortancadan küçükse daha küçük değerlere bakmasını söyledik 
                enSag = ortanca - 1;
            } else { // aranan değer ortancadan büyükse daha büyüklere bakmasını söyledik
                enSol = ortanca + 1;
            }
            
        }
        karsilastirma =0;
    }
    return sonuc;
}


    
}
  



    

