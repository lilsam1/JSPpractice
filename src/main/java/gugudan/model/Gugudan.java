package gugudan.model;

public class Gugudan {

	public String multiple(String gugu) {
	
		String str = "";
		int dan = Integer.parseInt(gugu);
		for(int times = 1; times <= 9; times++) {
			str += dan + " X " + times + " = " + dan * times + "<br>";
		}
		return str;
	}
}