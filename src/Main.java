import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Main {

	public static void main(String[] args) {
		File imageFile = new File("img\\teste_in.jpg");
		Tesseract instance = new Tesseract();
		instance.setDatapath("C:\\Users\\Rafael F Pinheiro\\Dropbox\\eclipse-workspace\\Tess4J"); //selecionar diretorio Tess4J
		instance.setLanguage("eng");
		
		try {
			String result = instance.doOCR(imageFile);
			setMatrizWords(result);
//			System.out.println(result.contains("PINTOR"));
		} catch (TesseractException e) {
			System.err.println(e.getMessage());
		}

	}
	
	public static void setMatrizWords(String result) {
		int size = result.split("\n").length;
		
		for(int i=0;i<size;i++) {
			getFromDictionary(result.split("\n")[i], i+1);
		}
	}
	
	public static void getFromDictionary(String line, int position) {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("dic.txt"));
			while(br.ready()) {
				String wordFromDictionary = br.readLine();
				if(line.toLowerCase().contains(wordFromDictionary) && wordFromDictionary.length() > 3) {
					System.out.println("Palavra encontrada: "+wordFromDictionary+", linha:"+ position);
				}
		      }
		      br.close();
		    } catch (IOException e) {
		        System.err.printf("Erro na abertura do arquivo: %s.\n",
		         e.getMessage());
		    }
		
	}

}
