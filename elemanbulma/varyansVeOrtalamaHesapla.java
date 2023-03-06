package algoritmaodev1;
import java.util.Random;

public class varyansVeOrtalamaHesapla {

  public static void main(String[] args) {
    int[][] table = { // 10'a 13'lük matrisimizi oluşturduk
      {10 ,30 ,45 ,50 ,58 ,71 ,79 ,86 ,89 ,93 ,99 ,107,112},
      {13 ,34 ,48 ,66 ,69 ,78 ,85 ,88 ,94 ,96 ,100,115,118},
      {15 ,44 ,51 ,67 ,72 ,83 ,87 ,91 ,97 ,103,105,117,121}, 
      {17 ,46 ,53 ,70 ,74 ,84 ,90 ,93 ,98 ,104,109,120,189},
      {23 ,55 ,64 ,77 ,81 ,93 ,101,111,116,122,130,147,201}, 
      {37 ,65 ,73 ,80 ,82 ,106,110,119,125,129,152,169,205}, 
      {39 ,68 ,76 ,102,108,113,114,124,131,137,161,178,210},
      {40 ,93 ,123,126,140,144,148,150,157,160,162,202,267},
      {43 ,128,133,135,149,164,166,171,177,183,192,204,301},
      {400,500,600,700,800,900,901,902,903,904,905,906,909}
    };
    //Random oluşturduk:
    Random random = new Random();
    
    //Toplamı 0'dan başlatıyoruz:
    int toplam = 0;
    //Karsilastirma için int tipinde 50 boyutlu
    //bir dizi oluşturduk:
    int[] karsilastirma = new int[50];
    //For döngüsünü karsilastirma dizinin uzunluğu kadar çalıştırdım:
    for (int i = 0; i < karsilastirma.length ; i++) {
        //x değişkenine 1-130 arası random değerler atadım:
        int x = random.nextInt(130);
        //m değişkenini ve n değişkenini sutun sayısına göre
        //atamalarını yaptık:
        int m = x / 13;
        int n = x % 13;
        //table[m][n] değerlerini deger değişkenine attık:
        int deger = table[m][n];
        
        //karsilastirmaSayaci değerini 0'dan başlattık:
        int karsilastirmaSayaci = 0;
        //For döngüsüyle satır sütünü dolaştık:
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 13; k++) {
                    //Satır ve sutun bizim üstten gelen
                    //değer değişkenimize eşitse if bloğuna girer:
                    if (table[j][k] == deger) {
                        //Ve while döngüsünü sonlandırır:
                        break;
                     }
            //Karşılaştırma Sayacı değer değişkeni ve tableda bulunun değer
            //eşleştiği için if bloğu breakle sonlanır. Eşleşme olmazsa sayaç artırlır.
            karsilastirmaSayaci++;
          }
        }
        //Karsilastirma dizisinin i değeğrini karsilastirma sayaci yapıyoruz:
        karsilastirma[i] = karsilastirmaSayaci;
        //Toplam değişkenine karşılaştırma sayacını topluyoruz:
        toplam += karsilastirmaSayaci;
        }
        
        //Ortalama hesaplamak için ortalama değişkeni oluşturulur ve
        //toplam değişkeni random değer sayısına bölünür:
        double ortalama = (double) toplam / 50;
        //Varyans değerimizi 0'dan baslattık:
        double varyans = 0;
        
        //Karsilastirma dizisi boyutunca for döngüsüyle dolaştık:
        for (int i = 0; i < karsilastirma.length; i++) {
            //Math kütüphanesi yardımıyla varyans hesaplaması yaptık:
            varyans += Math.pow(karsilastirma[i] - ortalama, 2);
        }
        //Varyans değerini karsilastirma dizi boyutuna böldük:
        varyans /= karsilastirma.length;
        //Standart Sapma içinse math kütüphanesinin sqrt fonksiyonuyla karekök
        //alıyoruz:
        double standartSapma = Math.sqrt(varyans);
        
        //Ekrana değerleri yazdırıyoruz:
        System.out.println("Ortalama: " + ortalama);
        System.out.println("Standart Sapma: " + standartSapma);
    }
}
