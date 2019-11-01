package es.unileon.prg.date;

public class MainDate {

	public static void main(String[] args) {

		Date today;

		try {
			today = new Date(01, 6, 2019);
			System.out.println(today.toString());
			System.out.println(""); //Linea en blanco
			System.out.println("Hoy es "+today.getDay()+" de "+today.nombreMes());
			System.out.println("El mes tiene "+today.daysOfMonth()+" dias");
			System.out.println("El nombre del mes es: " +today.nombreMes());
			System.out.println(""); //Linea en blanco
			System.out.println("*(Se toma como equinocio el dia 22 para todos los casos)*");
			System.out.println("La estacion del año en el Hemisferio Norte es: " +today.season());
			System.out.println("Quedan "+today.monthsLeft()+" meses para que acabe el año");
		} catch (DateException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
