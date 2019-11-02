package es.unileon.prg.date;

public class MainDate {

	public static void main(String[] args) {

		Date today;

		try {
			today = new Date(01, 6, 2019);
			System.out.println("A continuacion se muestra la fecha con toString()");
			System.out.println(today.toString());
			System.out.println(""); //Linea en blanco
			System.out.println("- El mes tiene "+today.daysOfMonth()+" dias");
			System.out.println("- El nombre del mes es: " +today.monthName());
			System.out.println(""); //Linea en blanco
			System.out.println("- *(Se toma como equinocio el dia 22 para todos los casos)*");
			System.out.println("La estacion del año en el Hemisferio Norte es: " +today.season());
			System.out.println(""); //Linea en blanco
			System.out.println("- Quedan "+today.monthsLeft()+" meses para que acabe el año");
			System.out.println(""); //Linea en blanco
			System.out.println("- Los meses con los mismos dias que "+today.monthName()+" son:");
			System.out.println(today.sameNumberOfDays());
			System.out.println(""); //Linea en blanco
			System.out.println("- Las fechas hasta que acabe el mes son:");
			System.out.println(today.datesEndMonth());
			System.out.println(""); //Linea en blanco
			System.out.println("Han pasado "+today.countDaysFromYearStart()+" dias desde que empezo el año");
			System.out.println(""); //Linea en blanco
			System.out.println("- A continuacion se muestra el numero de intentos que le ha tomado al");
			System.out.println(" ordenador generar una fecha igual a la de today: (sabiendo el año)");
			System.out.println("Intentos: "+today.randomDateEqualsToday());
		
		} catch (DateException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
