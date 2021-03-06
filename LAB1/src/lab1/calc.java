package lab1;

import java.util.Scanner;

public class calc {
	
	public static double kwota; // Robimy dla prostoty na polach publicznych (mimo, ze sie nie powinno)
	public static double kwota_zwrotu;
	public static double rata;
	public static double wynik;
	public static double RataMal(double kwota, double opr, double okr) {
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
	
	public static double RataSt(double kwota, double opr, double okr) {
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
	
	public static void main(String[] args) {
		
		System.out.println("Kalkulator kredytowy");
		
		System.out.print("Podaj kwote: ");
		double kwota;
		Scanner scan = new Scanner(System.in);
		kwota = scan.nextDouble();
		if (kwota <= 0)
			throw new IllegalArgumentException("Kwota kredytu musi byc wieksza od 0!");
		
		System.out.print("Podaj oprocentowanie: ");
		double opr;
		opr = scan.nextDouble();
		if (opr < 0)
			throw new IllegalArgumentException("Oprocentowanie nie moze byc mniejsze od 0!");
		
		System.out.print("Podaj okres kredytu w miesiacach: ");
		int okr;
		okr = scan.nextInt();
		if (okr <= 0)
			throw new IllegalArgumentException("Okres kredytu musi byc wiekszy od 0!");
		
		System.out.print("Rata malejaca, czy stala? Dla malejacej wpisz 1, a dla stalej 2: ");
		int rata_rodzaj;
		rata_rodzaj = scan.nextInt();
		
		
		if (rata_rodzaj == 1) {
			RataMal(kwota, opr, okr);
		}
		else if (rata_rodzaj == 2) {
			RataSt(kwota, opr, okr);
		}
	}
}