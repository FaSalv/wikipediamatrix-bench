package fr.univrennes1.istic.wikipediamatrix;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.Test;

public class TestCsv {
	
	WikipediaHTMLExtractor extractor = new WikipediaHTMLExtractor(); 
	CSVEditor csvEditor = new CSVEditor(); 
		
	@Test
	public void testFileExists() throws Exception {		
		
		extractor.extractor("Comparison_of_iOS_e-book_reader_software");
		File tmpDir = new File("./output/html/Comparison_of_iOS_e-book_reader_software-1.csv");
		boolean exists = tmpDir.exists();
	    assertEquals(exists, true);
		}
	

	@Test
	public void  testNombreTableauxEBook() throws Exception {		
		
		int nbrTableaux = 7; 
		extractor.extractor("Comparison_of_iOS_e-book_reader_software");
		boolean wasCreated = false; 
		
		for(int i = 1; i < nbrTableaux+1; i++) { 
			File tmpDir = new File("./output/html/Comparison_of_iOS_e-book_reader_software-" + i + ".csv");
			wasCreated = tmpDir.exists();
		}
		
		//Si tous les fichiers ont bien �t� cr��, 
		if(wasCreated) {
			File tmpDir = new File("./output/html/Comparison_of_iOS_e-book_reader_software-" + (nbrTableaux+1) + ".csv");
			wasCreated = !tmpDir.exists(); //le fichier ne doit pas exister, donc on prends l'inverse du bool�en 
		}
	    assertEquals(wasCreated, true);
	}
	
	@Test
	public void  testNombreTableauxCamera() throws Exception {		
		
		int nbrTableaux = 1; 
		extractor.extractor("Comparison_of_digital_SLRs");
		boolean wasCreated = false; 
		
		for(int i = 1; i < nbrTableaux+1; i++) { 
			File tmpDir = new File("./output/html/Comparison_of_digital_SLRs-" + i + ".csv");
			wasCreated = tmpDir.exists();
		}

		if(wasCreated) {
			File tmpDir = new File("./output/html/Comparison_of_digital_SLRs-" + (nbrTableaux+1) + ".csv");
			wasCreated = !tmpDir.exists(); //le fichier ne doit pas exister, donc on prends l'inverse du bool�en 
		}
		
	    assertEquals(wasCreated, true);
	}
	
	@Test
	public void  testNombreTableauxLangage() throws Exception {		
		
		int nbrTableaux = 8; 
		extractor.extractor("Comparison_between_Esperanto_and_Ido");
		boolean wasCreated = false; 
		
		for(int i = 1; i < nbrTableaux+1; i++) { 
			File tmpDir = new File("./output/html/Comparison_between_Esperanto_and_Ido-" + i + ".csv");
			wasCreated = tmpDir.exists();
		}
		
		if(wasCreated) {
			File tmpDir = new File("./output/html/Comparison_between_Esperanto_and_Ido-" + (nbrTableaux+1) + ".csv");
			wasCreated = !tmpDir.exists(); //le fichier ne doit pas exister, donc on prends l'inverse du bool�en 
		}
	    assertEquals(wasCreated, true);
	}
	
	@Test
	public void  testNombreColonnesCamera() throws Exception {			
		int nbrColonnesTrouv�es = 0; 
		int nbrColonnesVoulues = 22; 
		String url = "Comparison_of_digital_SLRs"; 
		extractor.extractor(url);
		
		Reader reader = Files.newBufferedReader(Paths.get("./output/html/Comparison_of_digital_SLRs-1.csv"));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        CSVRecord firstRecord = csvParser.iterator().next(); //pbm : si colonnes agr�g�es 
		nbrColonnesTrouv�es = firstRecord.size(); 
        
        csvParser.close();
	    assertEquals(nbrColonnesTrouv�es, nbrColonnesVoulues);
	}
	
	@Test
	public void  testNombreLignesCamera() throws Exception {			
		int nbrLignesTrouv�es = 0; 
		int nbrLignesVoulues = 72; 
		String url = "Comparison_of_digital_SLRs"; 
		extractor.extractor(url);
		
		Reader reader = Files.newBufferedReader(Paths.get("./output/html/Comparison_of_digital_SLRs-1.csv"));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        
        csvParser.getRecordNumber(); 
		
        for (CSVRecord csvRecord : csvParser) {
        	nbrLignesTrouv�es = nbrLignesTrouv�es +1; 
        }
        csvParser.close();
	    assertEquals(nbrLignesTrouv�es, nbrLignesVoulues);
	}
		
}
