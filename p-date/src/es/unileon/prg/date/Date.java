package es.unileon.prg.date;

public class Date {
	private int i;
	private int day;
	private int month;
	private int year;
	
	public Date(int day, int mounth, int year) throws DateException{
		/*
		- Este thows DayException tiene que quedarse porque aunque dentro no haya un 
		- throws los metodos llamados si que lo tienen y se "propaga"
		*/
		StringBuilder error= new StringBuilder();
		
		try{
			this.setMonth(month);
			this.setDay(day);
			this.satYear(year);
		} catch(DateException e){
			error.append(e.getMessage());
		}
	}

	/*
	public void setDay(int day) throws DateException{
		
		StringBuilder error= new StringBuilder();

		if((month<1) || (month>12)){
			//Error mes
			error.append("- Date error: month value "+".../"+month+"/..."+" not valid. Should be 1 to 12");

		} else if((day<1) || (day>this.daysOfMonth(month))){
			//Error dia

		}
		
		if(year<0){
			//Error año
		
		}
		
		if(error.length()>0){
			throw new DateException(error.toString());
		
		} else{
			this.day= day;
			this.month= month;
			this.year= year;		
		}
	}
	*/

	public void setMonth(int month) throws DateException{
		if((month<1) || (month>12)){
			//Error mes
			throw new DateException("- Date error: month value "+".../"+month+"/..."+" not valid. Should be 1 to 12");
		} else{
			this.month= month;
		}
	}

	public void setDay(int day) throws DateException{
		if((day<1) || (day>this.daysOfMonth(month))){
			//Error dia
			throw new DateException("noseq");

		} else{
			this.day= day;
		}
	}


	private int daysOfMonth(int i){
		int diaMax= 0;
		switch (i){
			case 1: //next 
			case 2: diaMax=28; break;
			case 3: //next
			case 4: //next
			case 5: //next
			case 6: //next
			case 7: //next
			case 8: //next
			case 9: //next
			case 10: //next
			case 11: diaMax=30; break;
			case 12: diaMax=31; break;
		}
		return diaMax;
	}
	
	public int daysOfMonth(){
		return this.daysOfMonth(this.month);
	}

	public int countDaysFromYearStart(){
		int count=this.day;
		int prueba= 3;
		for(i=1; i<this.month; i++){
			count+= this.daysOfMonth(i); //Puede usar daysOfMonth potrque es un metodo hermano en esta clase
		}
		return count;
	}




}



