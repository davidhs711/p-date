package es.unileon.prg.date;

public class MainDate {

	public static void main(String[] args) {

		Date today;

		try {
			today = new Date(01, 6, 2019);
			System.out.println(today.toString());
			System.out.println("El mes tiene estos dias: " +today.daysOfMonth());
			System.out.println("El nombre del mes es: " +today.nombreMes());
			//System.out.println("La estacion del año es: " +today.estacionAño());
			//System.out.println("Los meses que quedan del año son: " +today.mesesQuedanAño());
		} catch (DateException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
