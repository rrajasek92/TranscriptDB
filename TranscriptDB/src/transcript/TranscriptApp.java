package transcript;
import java.util.Scanner;
public class TranscriptApp {
	public static void main(String[] args){
		Scanner keyboard=new Scanner(System.in);
		String con="y";
		String a="",c="",stid="";
		int b=0;
		double gpa=0;
		while (con.equals("y")){
		stid=Validator.getString(keyboard,"Enter Student ID: ");
		a=Validator.getString(keyboard,"Enter Course: ");
		b=Validator.getInt(keyboard,"Enter Credits: ");
		c=Validator.getString(keyboard, "Enter grade: ");
		Transcript.Record(a,b,c);
		transcriptDB.updateInfo(stid, a, b, c);
		con=Validator.getString(keyboard, "Another one? (y/n) ");
		}
		gpa=Transcript.GPA();
		Transcript.print(gpa);
		keyboard.close();
		}
}
