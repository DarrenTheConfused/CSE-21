

public class Date {
	//instance variables
		private int year; // = 1900 - 3000;
		private int month; // = 1 -12;
		private int day; // = 1 -31;

		
		//constructor
		public Date(int year, int month, int day) {
			if (year >= 1900 && year <= 3000)
				this.year = year;
			if (month <= 12 && month >= 1)
				this.month = month;
			if (day <= 31 && day >= 1)
				this.day = day;
		}
		//mutator methods
		//set
		public void setYear(int year) {
			this.year = year;
		}
		public void setMonth(int month) {
			this.month = month;
		}
		public void setDay(int day) {
			this.day = day;
		}
		//accessor methods
		//get
		public int getYear() {
			return year;
		}
		public int getMonth() {
			return month;
		}
		public int getDay() {
			return day;
		}
		
		public int dayOfYear() {
	        int totalDays = 0;
	        switch (month) {
	           case 12: totalDays += 30;
	           case 11: totalDays += 31;
	           case 10: totalDays += 30;
	           case 9 : totalDays += 31;
	           case 8 : totalDays += 31;
	           case 7 : totalDays += 30;
	           case 6 : totalDays += 31;
	           case 5 : totalDays += 30;
	           case 4 : totalDays += 31;
	           case 3 : totalDays += 28;
	           case 2 : totalDays += 31;
	        }
	        totalDays += day;
	        return totalDays;

		}
		
		public int compare(Date dt) {
			int yearsDifferenceInDays = (Math.abs(this.getYear() - dt.getYear())) * 365;

			int daysDifference = (Math.abs(dayOfYear() - dt.dayOfYear()));
			
			int totalDifference = Math.abs(yearsDifferenceInDays - daysDifference);

			int monthsDifference = totalDifference/30;
			if(monthsDifference > 60) {
				monthsDifference = 60;
			}
			return monthsDifference;
		}
}
