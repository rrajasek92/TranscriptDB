package transcript;
import java.util.ArrayList;
import java.util.Scanner;
public class TranscriptApp {
	public static void main(String[] args){
		ArrayList<String> stList=new ArrayList<String>();
		Scanner keyboard=new Scanner(System.in);
		String con="y";
		String a="",c="",stid="";
		int b=0;
		double gpa=0;
		while (con.equals("y")){
		stid=Validator.getString(keyboard,"Enter Student ID: ");
		if(!stList.contains(stid)){
			stList.add(stid);
		}
		a=Validator.getString(keyboard,"Enter Course: ");
		b=Validator.getInt(keyboard,"Enter Credits: ");
		c=Validator.getString(keyboard, "Enter grade: ");
		Transcript.Record(a,b,c);
		transcriptDB.updateInfo(stid, a, b, c);
		con=Validator.getString(keyboard, "Another one? (y/n) ");
		}
		for (int i=0;i<stList.size();i++){
			gpa=transcriptDB.studentGPA(stList.get(i));
			System.out.println(stList.get(i)+": "+gpa);
			transcriptDB.updateStudentRec(stList.get(i), gpa);
		}
		
		//Transcript.print(gpa);
		keyboard.close();
		}
}
