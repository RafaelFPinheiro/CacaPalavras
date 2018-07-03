import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Main {

	public static void main(String[] args) {
		File imageFile = new File("img\\teste_in.jpg");
		Tesseract instance = new Tesseract();
		instance.setLanguage("eng");
		
		try {
			String result = instance.doOCR(imageFile);
			System.out.println(result);
		} catch (TesseractException e) {
			System.err.println(e.getMessage());
		}

	}

}
