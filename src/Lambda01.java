import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {


    public static void main(String[] args) {
     /*
      1)  Lambda --> mathod create  etme değil mevcut method'ları(library)secip kullanmaktır...
          Lambda'lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
      2) "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
          "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
      3)  "Functional Programming" hiz, code kisaligi, code okunabilirligi
          ve hatasiz code yazma acilarindan cok faydalidir.
      4)  Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.

*/
        List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));

        printElStructured(sayi);
        System.out.println("\n*******************");
        printElFunctional(sayi);

    }


    //TASK  : "Structured Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.
    public static void printElStructured(List<Integer> sayi) {
        for (Integer w : sayi) {
            System.out.print(w + " ");
        }

    }
    //TASK : "functional Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.

    public static void printElFunctional(List<Integer> sayi) {
        sayi.
                stream().
                forEach((t) -> System.out.print(t + " "));//lambda exspression
    }

    public static void printElFunctional1(List<Integer> sayi) {
        sayi.
                stream().
                forEach(System.out::print);//lambda referance
    }
    // Kendimiz bir method olusturalim

    public static void yazdir(int a) {
        System.out.print(a + " ");
    }

    public static void yazdir(String a) {
        System.out.print(a + " ");
    }

    public static void printElFunctional2(List<Integer> sayi) {

        sayi.
                stream().
                forEach(Lambda01::yazdir);//method referance'in yetersiz kaldiği yerde kendimizce uyarlama yaptik
    }

    //TASK  : functional Programming ile list elemanlarinin  cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void printCiftElFunctional(List<Integer> sayi) {

        sayi.
                stream().
                filter((t) -> t % 2 == 0). //lambda expression
                forEach(Lambda01::yazdir);
    }

    //yukarıdaki functional yapıdaki filter methodunun içini method referenceile yapalim:
    public static boolean ciftBul(int a) {
        return a % 2 == 0; //parametre olarak gelen a çiftse buradan true dönmüş olur.
    }

    public static void printCiftElFunctional1(List<Integer> sayi) {

        sayi.
                stream().
                filter(Lambda01::ciftBul).
                forEach(Lambda01::yazdir);
    }

    // TASK  : stractural Programming ile list elemanlarinin  cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void printCiftElStructured(List<Integer> sayi) {
        for (Integer w : sayi) {
            if (w % 2 == 0) {
                System.out.print(w + " ");
            } else break;

        }
    }


    //TASK :functional Programming ile list elemanlarinin 34 den kucuk cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void printCiftUtcKckFunctional(List<Integer> sayi) {

        sayi.
                stream().
                filter(t -> t % 2 == 0 && t < 34).
                forEach(Lambda01::yazdir);

    }

    //Task : functional Programming ile list elemanlarinin 34 den buyk veya cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void printCiftUtcBykFunctional(List<Integer> sayi) {

        sayi.
                stream().
                filter(t -> t > 34 || t % 2 == 0).
                forEach(Lambda01::yazdir);


    }
}
