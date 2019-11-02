package es.unileon.prg.date;

public class Date {

	private int day;
	private int month;
	private int year; 
	
	private int monthsLeft; 
	private String mes;
	private String season;
	

	public Date (int day, int month, int year) throws DateException {
			StringBuilder error = new StringBuilder();
			try {
				this.setMonth(month);
				this.setDay(day);
			} catch (DateException e) {
				error.append(e.getMessage());
			}

			this.setYear(year);
	}

	public void setMonth(int month) throws DateException{
		if (month<1 || month>12) {
			throw new DateException("Date error: month value "+month+" not valid. Should be from 1 to 12.");
		} else {
			this.month= month;
		}
	}
	
	public void setDay(int day) throws DateException{
		if (day<1 || day>this.daysOfMonth(this.month)) {
			throw new DateException("Date error: day value "+day+" not valid. Value should be from 1 to "+daysOfMonth(this.month));
		} else {
			this.day=day;
		}
	}
	
	public void setYear(int year) throws DateException{
		if(year<0) {
			throw new DateException("Date error: year value "+year+" not valid. Value should be bigger than 0");
		} else {
			this.year= year;
		}
	}
	
	public String toString() {
		StringBuffer dateString = new StringBuffer();

		dateString.append(this.day);
		dateString.append(" / ");
		dateString.append(this.month);
		dateString.append(" / ");
		dateString.append(this.year);
		

		return dateString.toString();
	}
	
	public String sameNumberOfDays() {
		StringBuffer sameNumberOfDays = new StringBuffer();
		
		int daysMonth= this.daysOfMonth();
		
		if(daysMonth==31) {
			sameNumberOfDays.append("Enero, Marzo, Mayo, Julio, Agosto, Octubre, Diciembre");
		} else if(daysMonth==30) {
			sameNumberOfDays.append("Abril, Junio, Septiembre, Noviembre");
		} else if(daysMonth==28) {
			sameNumberOfDays.append("No hay ningun mes a parte de Febrero con 28 dias :(");
		}
		
	return sameNumberOfDays.toString();
	}
	
	public String datesEndMonth() {
	
		StringBuffer datesEndMonth = new StringBuffer();
		
		for(int i= this.day; i<=this.daysOfMonth(); i++) {
			
			datesEndMonth.append(" "+i+" / "+this.month+" / "+this.year+" * ");
		}
		
	return datesEndMonth.toString();
	}
	
	public String season() {
	
		switch(month) {
			case 1: //next
			case 2: //next
			case 3: 
				if((month==3)&&(day>22)) {
					season= "Primavera";
					break;
				} else {
					season= "Invierno";
					break;
				}
			case 4: //next
			case 5: //next
			case 6: 
				if((month==6)&&(day>22)) {
					season= "Verano";
					break;
				} else {
					season= "Primavera";
					break;
				}
			case 7: //next
			case 8: //next
			case 9: 
				if((month==9)&&(day>22)) {
					season= "Otoño";
					break;
				} else {
					season= "Verano";
					break;
				}
			case 10: //next 
			case 11: //next
			case 12: 
				if((month==12)&&(day>22)) {
					season= "Invierno";
					break;
				} else {
					season= "Otoño";
					break;
				}
		}
	
	return season;	
	}
	
	public int monthsLeft() {
		
		monthsLeft= 12-month;
		
	return monthsLeft;
	}
	
	public String monthName() {
		
		switch(month){
			case 1: mes= "Enero"; break;
			case 2: mes= "Febrero"; break;
			case 3: mes= "Marzo"; break;
			case 4: mes= "Abril"; break;
			case 5: mes= "Mayo"; break;
			case 6: mes= "Junio"; break;
			case 7: mes= "Julio"; break;
			case 8: mes= "Agosto"; break;
			case 9: mes= "Septiembre"; break;
			case 10: mes= "Octubre"; break;
			case 11: mes= "Noviembre"; break;
			case 12: mes= "Diciembre"; break;
		}
		return mes;
	}
	
	
	

	// public void setMonth(int month) throws Date ACABAR
		/* StringBuilder error = new StringBuilder();
		if (month<1 || month>12) {
			error.append("Date error: month value"+month+"not valid. Value should be from 1 to 12."); //Error mes
		} else if (day<1 || day>this.daysOfMonth(month)) {
		//Error dia
		}
		
		if (year<0) {
			//Error year
	}
	if (error.length()>0) {
		throw new DateException(error.toString());
	} else {
		this.day=day;
		this.month=month;
		this.year=year;
}
*/

	private int daysOfMonth(int i){
		int diaMax=0;
		switch (i){
		case 1: //next
		case 3: //next
		case 5: //next
		case 7: //next
		case 8: //next
		case 10: //next
		case 12: diaMax=31; break;
		case 4: //next
		case 6: //next
		case 9: //next
		case 11: diaMax=30; break;
		case 2: diaMax=28; break;
		}
		
		return diaMax;
	}

	
	
	public int daysOfMonth(){
		return this.daysOfMonth(this.month);
	}

	public int randomDateEqualsToday(){
		int count= 0;
		int randomDay= 0;
		int randomMonth= 0;
		
		while(randomDay!=this.day){
			randomDay = (int) ((Math.random())*32);
			//System.out.println(randomDay);
			count= count+1;
		}
		
		do{
			randomMonth= (int) ((Math.random())*13);
			count= count+1;
		}while(randomMonth!=this.month);
			
	return count;
	}
	
	public int countDaysFromYearStart(){
		int count=this.day;
		for (int i=1; i<this.month; i++){
			count += this.daysOfMonth(i); // Puedo usar daysOfMonth sin nada delante por se un métdo hermano de la misma clase
		}
		
		return count;
	}
}