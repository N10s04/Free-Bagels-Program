import java.io.File;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class PerformOCR {
	public static String performOCR() {
		
		String text = null;
		
		Tesseract tesseract = new Tesseract();
		try {
			//path of tess data folder
			tesseract.setDatapath("/Users/ndt/Downloads/tessdata");
			
			//path of image file
			text = tesseract.doOCR(new File("/Users/ndt/Desktop/testreceipt.jpeg"));
			
			text = text.replaceAll("\\s", "");
			System.out.println(text);
		}
		
		catch (TesseractException e) {
			e.printStackTrace();
		}
		return text;
	}
}
