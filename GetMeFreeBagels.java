import javax.swing.JOptionPane;

public class GetMeFreeBagels {
	
	public static String receiptCode = null;
	public static String bagelCode;

	public static void main(String[] args) {
		
		//receiptCode
		receiptCode = PerformOCR.performOCR();
		
		//bagelCode
		bagelCode = PerformWebStuff.performWebStuff(receiptCode);
		
		System.out.println(bagelCode);
		JOptionPane.showMessageDialog(null, bagelCode);

	}

}
