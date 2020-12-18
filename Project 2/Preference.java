

public class Preference {
	//instance variables  = 0 - 10;
		private int quietTime;
		private int music;
		private int reading;
		private int chatting;
		
		
		//constructor
		public Preference(int quietTime, int music, int reading, int chatting) {
			if(quietTime >= 1 && quietTime <= 10) { //range 1 to 10. 
				this.quietTime = quietTime;  //set quietTime
			}
			if(music >= 1 && music <= 10) { //range 1 to 10. 
				this.music = music;  //set music
			}
			if(reading >= 1 && reading <= 10) { //range 1 to 10. 
				this.reading = reading;  //set reading
			}
			if(chatting >= 1 && chatting <= 10) { //range 1 to 10. 
				this.chatting = chatting;  //set chatting
			}
		}
		
		
		//accessor methods
		public int getQuietTime() {
			return this.quietTime;
		}
		public int getMusic() {
			return this.music;
		}
		public int getReading() {
			return this.reading;
		}
		public int getChatting() {
			return this.chatting;
		}
		
		
		//method
		/*To calculate the difference between preferences returned by compare, you simply sum up the absolute
	differences in the 4 activities.*/
		public int compare(Preference pref) {
			int diff = 0;
			diff = diff + Math.abs(quietTime - pref.getQuietTime());
			diff = diff + Math.abs(music - pref.getMusic());
			diff = diff + Math.abs(reading - pref.getReading());
			diff = diff + Math.abs(chatting - pref.getChatting());
			return diff;
		}

}
