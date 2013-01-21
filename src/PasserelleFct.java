
public class PasserelleFct {


	public static String dateJour() {
		String format = "yyyy-MM-dd";

		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
		java.util.Date date = new java.util.Date();

		return formater.format( date );
	}
}
