import java.io.FileNotFoundException;
import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.FileReader;

public class Match {

	public void main(){
		Student[] stuArray = new Student[100];
		
		System.out.println("Enter a file name: ");
		Scanner scan = new Scanner(System.in);
		String filename = scan.next();
		Scanner file;
		try {
			file = new Scanner(new FileReader(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = 0;
		while (file.hasNextLine()) {
			Scanner scanline = new Scanner(file.nextLine());
			scanline.useDelimiter("[\t\r]");
			String name = scanline.next();
			String gender = scanline.next();
			String date = scanline.next();

			Scanner birthReader = new Scanner(date);
			birthReader.useDelimiter("-");
			int month = birthReader.nextInt();
			int day = birthReader.nextInt();
			int year = birthReader.nextInt();

			int quietTime = scanline.nextInt();
			int music = scanline.nextInt();
			int reading = scanline.nextInt();
			int chatting = scanline.nextInt();

			Date birthdate = new Date(month, day, year);
			Preference pref = new Preference(quietTime, music, reading, chatting);
			Student newKid = new Student(name, gender.charAt(0), birthdate, pref);
			stuArray[i++] = newKid;
		}
		


	}
}
