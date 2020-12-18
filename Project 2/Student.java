
public class Student {
	//instance variables
		private String name;
		private char gender;
		private Date birthdate;
		private Preference pref;
		private boolean matched;
		
		private int month;
		private int day;
		private int year;
		
		public Student() {
			name = "";
			gender = 'a';
			matched = false;
			birthdate = new Date(month, day, year);
		}
		
		
		//custom constructor
		public Student(String name, char gender, Date birthdate, Preference pref) {
			this.name = name;
			this.gender = gender;
			this.birthdate = birthdate;
			this.pref = pref;
			System.out.println("4 parameters");
		}
		//mutator, changes only one variable
		public void setName(String name) {
			this.name = name;
		}
		public void setGender(char gender) {
			this.gender = gender;
		}
		public void setBirthdate(Date birthdate) {
			this.birthdate = birthdate;
		}
		public void setPreference(Preference pref) {
			this.pref = pref;
		}
		public void setMatched(boolean matched) {
			this.matched = matched;
		}
		//getter
		public String getName() {
			return this.name;
		}
		public char getGender() {
			return this.gender;
		}
		public Date getBirthdate() {
			return this.birthdate;
		}
		public Preference getPreference() {
			return this.pref;
		}
		public boolean getMatched() {
			return this.matched;
		}
		
		/*
		• Highest score is 100 and lowest is 0
		• Different genders get a score 0 (only match same gender students as roommates)
		• The formula for computing the compatibility score is: (40 – Preferences) + (60 –
		  AgeDifference), where
		o Preferences is the absolute differences in each of the 4 activities added together
		o AgeDifference is the number of months between two birthdates with the maximum being
		5 years (60 months)
		Note: Use Math.abs() method call to calculate absolute value, e.g., Math.abs(age2 – age1);
		*/
		
		int score = 0;
		public int compare(Student st) {
			int compatScore = 0;
			if(st.getGender() != this.getGender()) {
				return 0;
			}
			else {
				int ageDifference = birthdate.compare(st.birthdate);
				int preferences = pref.compare(st.pref);
				compatScore = (40 - preferences) + (60 - ageDifference);
			}
			
			//if (get.Gender == get.Gender) {
				//score 
			//}
			//Math.abs(age2 – age1);.
			return compatScore;
		}

}
