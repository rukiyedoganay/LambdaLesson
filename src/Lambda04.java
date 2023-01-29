import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {
/*
TASK :
fields --> Universite (String)
           bolum (String)
           ogrcSayisi (int)
           notOrt (int)
           olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
 */


    public static void main(String[] args) {
        Universite u01 = new Universite("bogazici", "matematik", 571, 93);
        Universite u02 = new Universite("istanbul tk", "matematik", 600, 81);
        Universite u03 = new Universite("istanbul", "hukuk", 1400, 71);
        Universite u04 = new Universite("marmara", "bilg muh", 1080, 77);
        Universite u05 = new Universite("odtu", "gemi muh", 333, 74);

        List<Universite> unv = new ArrayList<>(Arrays.asList(u01, u02, u03, u04, u05));

        System.out.println(notOrt74BuyukUnv(unv));
        System.out.println();
        System.out.println(matBolumVarMi(unv));
        System.out.println();
        System.out.println(ogrSayisiBuyuktenKucugeSirala(unv));
        System.out.println();
        System.out.println(matematikBolumSayisi(unv));
        System.out.println();
        System.out.println(ogr550denFazlaEnBuyukNotOrt(unv));
        System.out.println();
        System.out.println(ogr1050denAzEnKucukOrt(unv));
    }

    //task 01--> Bütün universitelerin notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.

    public static boolean notOrt74BuyukUnv(List<Universite> unv) {
        return unv.stream().allMatch(t -> t.getNotOrt() > 74);
    }

    //task 02-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.
    public static boolean matBolumVarMi(List<Universite> unv) {
        return unv.
                stream().        //akış sağlandı
                        anyMatch(t -> t.getBolum(). //objelerin bölüm isimleri alındı
                        toLowerCase(). //bölüm isimlerindeki karakterler küçük harfe çevrildi
                        contains("mat")); //"mat" içeriyor mu kontrol edildi
    }

    //task 03-->universite'leri ogr sayilarina gore b->k siralayiniz.

    public static List<Universite> ogrSayisiBuyuktenKucugeSirala(List<Universite> unv) {
        return unv.
                stream(). //akış sağlandı
                        sorted(Comparator.comparing(Universite::getOgrSayisi).reversed()). //öğrenci sayısına göre büyükten küçüğe sıraladı
                        collect(Collectors.toList()); //list halinde

    }

    //task 04-->"matematik" bolumlerinin sayisini  print ediniz.

    public static int matematikBolumSayisi(List<Universite> unv) {

        return (int) unv.
                stream(). //akış sağlandı
                        filter(t -> t.getBolum().toLowerCase().contains("matematik")). //matematik bölümü olan ünileri seçtik
                        count(); //seçilen ünileri sayar. data type'i Long'dur. bu nedenle return (int) yaptık.

    }
    //task 05-->Ogrenci sayilari 550'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.

    public static OptionalInt ogr550denFazlaEnBuyukNotOrt(List<Universite> unv) {

        return unv.
                stream().
                filter(t->t.getOgrSayisi()>550).
                mapToInt(Universite::getNotOrt).
                max();

    }

    //task 06-->Ogrenci sayilari 1050'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.

    public static OptionalInt ogr1050denAzEnKucukOrt (List<Universite> unv){
        return
                unv.
                        stream().
                        filter(t->t.getOgrSayisi()<1050).
                        mapToInt(Universite::getNotOrt).
                        min();

    }
}
