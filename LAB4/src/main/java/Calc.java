import java.util.Scanner;

public class Calc {

    public static double kwota; // Robimy dla prostoty na polach publicznych (mimo, ze sie nie powinno)
    public static double opr;
    public static int okr;
    public static int rata_rodzaj;
    public static double kwota_zwrotu;
    public static double rata;
    public static double wynik;
    public static double doplata;

    public static double wczytKwota(double kwota) {
        System.out.print("Podaj kwote: ");
        Scanner scan = new Scanner(System.in);
        kwota = scan.nextDouble();
        if (kwota <= 0)
            throw new IllegalArgumentException("Kwota kredytu musi byc wieksza od 0!");
        return kwota;
    }

    public static double wczytOpr(double opr) {
        System.out.print("Podaj oprocentowanie: ");
        Scanner scan = new Scanner(System.in);
        opr = scan.nextDouble();
        if (opr < 0)
            throw new IllegalArgumentException("Oprocentowanie nie moze byc mniejsze od 0!");
        return opr;
    }

    public static int wczytOkres(int okr) {
        System.out.print("Podaj okres kredytu w miesiacach: ");
        Scanner scan = new Scanner(System.in);
        okr = scan.nextInt();
        if (okr <= 0)
            throw new IllegalArgumentException("Okres kredytu musi byc wiekszy od 0!");
        return okr;
    }

    public static int wczytRodzaj(int rata_rodzaj) {
        System.out.print("Rata malejaca, czy stala? Dla malejacej wpisz 1, a dla stalej 2: ");
        Scanner scan = new Scanner(System.in);
        rata_rodzaj = scan.nextInt();
        return rata_rodzaj;
    }

    public static double rataMal(double kwota, double opr, double okr) {
        kwota_zwrotu = 0;
        rata = 0;
        int i = 1;
        double podstawa_do_splaty = kwota/okr;
        for (rata = 0; okr >= 1; okr--) {
            rata = (((opr/100)*kwota)/12)+podstawa_do_splaty;
            rata *= 100;
            rata = Math.round(rata);
            rata /= 100;

            System.out.println(i + ". Rata: " + rata + "zl");

            kwota_zwrotu = kwota_zwrotu + rata;
            kwota_zwrotu *= 100;
            kwota_zwrotu = Math.round(kwota_zwrotu);
            kwota_zwrotu /= 100;
            kwota = kwota - podstawa_do_splaty;
            i++;
        }
        System.out.println("Kwota do splacenia: " + kwota_zwrotu + "zl");
        return kwota_zwrotu;
    }

    public static double rataSt(double kwota, double opr, double okr) {
        kwota_zwrotu = 0;
        rata = 0;
        double q = 1 + ((opr/100)/12);
        wynik = 1;
        for(int i = 0; i < okr; i++)
        {
            wynik = wynik * q;
        }

        q = q - 1;

        double wynik2 = wynik - 1;

        rata = kwota * wynik * q / wynik2;
        kwota_zwrotu = rata * okr;
        kwota_zwrotu *= 100;
        kwota_zwrotu = Math.round(kwota_zwrotu);
        kwota_zwrotu /= 100;

        rata *= 100;
        rata = Math.round(rata);
        rata /= 100;

        System.out.println("Rata: " + rata + "zl");
        System.out.println("Kwota do splacenia: " + kwota_zwrotu + "zl");
        return kwota_zwrotu;
    }

    public static double odsetki(double kwota, double kwota_zwrotu) {
        doplata = kwota_zwrotu - kwota;
        doplata *= 100;
        doplata = Math.round(doplata);
        doplata /= 100;
        return doplata;
    }

    public static void main(String[] args) {

        System.out.println("Kalkulator kredytowy");
        kwota = wczytKwota(kwota);
        opr = wczytOpr(opr);
        okr = wczytOkres(okr);
        int temp = wczytRodzaj(rata_rodzaj);

        if (temp == 1) {
            rataMal(kwota, opr, okr);
        }
        else if (temp == 2) {
            rataSt(kwota, opr, okr);
        }
        System.out.println("Odsetki: "+ odsetki(kwota, kwota_zwrotu));
    }
}