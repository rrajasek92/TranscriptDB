package transcript;
import java.util.ArrayList;
public class Transcript {
	public static ArrayList<String> course=new ArrayList<String>();
	public static ArrayList<Integer> credits=new ArrayList<Integer>();
	public static ArrayList<String> grade=new ArrayList<String>();
	public static ArrayList<Double> gradePoint=new ArrayList<Double>();
	public static int l=0;
	
	public static void Record(String co, Integer cr, String gr){
		course.add(co);
		credits.add(cr);
		grade.add(gr);
		gradePoint.add(gp(gr));	
		l++;
	}
	public static double gp(String grade){
		switch(grade){
		case "A": return 4;
		case "B": return 3;
		case "C": return 2;
		case "D": return 1;
		case "F": return 0;
		default: return 0;
		}
	}
	public static double GPA(){
		double q=0,c=0,gpa=0;
		for(int i=0;i<l;i++){
			q+=gradePoint.get(i)*credits.get(i);
			c+=credits.get(i);
		}
		gpa=q/c;
		return gpa;
	}
	public static void print(Double gpa){
		String Display=String.format("%-15s %-10s %-10s %-15s","Courses","Credits","Grade","Quality Points\n");
		Display+=String.format("%-15s %-10s %-10s %-15s", "-----","-----","-----","-----");
		Display+="\n";
		for (int i=0;i<l;i++){
			String a=course.get(i);
			int b=credits.get(i);
			String c=grade.get(i);
			Double d=gradePoint.get(i);
			Display+=String.format("%-15s %-10s %-10s %-15s", a,Integer.toString(b),c,Double.toString(d));
			Display+="\n";
		}
		System.out.println(Display+"\n\t\t\tGPA:  "+gpa);
	}
	

}
