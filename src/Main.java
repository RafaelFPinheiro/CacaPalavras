import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Main {

	public static void main(String[] args) {
		File imageFile = new File("img\\teste_in.jpg");
		Tesseract instance = new Tesseract();
		instance.setDatapath("C:\\Users\\RafaelFelipePinheiro\\eclipse-workspace\\Tess4J"); //selecionar diretorio Tess4J
		instance.setLanguage("eng");
		
		try {
			String result = instance.doOCR(imageFile);
			getFromDictionary(result);
//			System.out.println(result.contains("PINTOR"));
		} catch (TesseractException e) {
			System.err.println(e.getMessage());
		}

	}
	
	public static void getFromDictionary(String result) {
		System.out.println(result.split("\n"));
		
	}

}
