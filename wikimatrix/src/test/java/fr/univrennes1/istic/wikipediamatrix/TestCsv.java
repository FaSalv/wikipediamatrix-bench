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
	Statistique stats = new Statistique(); 
		
	@Test
	public void testFileExists() throws Exception {		
		
		extractor.extractor("Comparison_of_iOS_e-book_reader_software", stats);
		File tmpDir = new File("./output/html/Comparison_of_iOS_e-book_reader_software-1.csv");
		boolean exists = tmpDir.exists();
	    assertEquals(exists, true);
		}
	

	@Test
	public void  test404() throws Exception {		
		
		//La page testé n'existe pas donc aucun tableau ne doit être créé
		extractor.extractor("Comparison_of_Axis_&_Allies_games", stats);
		boolean wasCreated = false; 
		
		File tmpDir = new File("./output/html/Comparison_of_Axis_&_Allies_games-1.csv");
		wasCreated = tmpDir.exists();
		
	    assertEquals(wasCreated, false);
	}
	

	@Test
	public void  testNombreTableauxEBook() throws Exception {		
		
		int nbrTableaux = 7; 
		extractor.extractor("Comparison_of_iOS_e-book_reader_software", stats);
		boolean wasCreated = false; 
		
		for(int i = 1; i < nbrTableaux+1; i++) { 
			File tmpDir = new File("./output/html/Comparison_of_iOS_e-book_reader_software-" + i + ".csv");
			wasCreated = tmpDir.exists();
		}
		
		//Si tous les fichiers ont bien été créé, 
		if(wasCreated) {
			File tmpDir = new File("./output/html/Comparison_of_iOS_e-book_reader_software-" + (nbrTableaux+1) + ".csv");
			wasCreated = !tmpDir.exists(); //le fichier ne doit pas exister, donc on prends l'inverse du booléen 
		}
	    assertEquals(wasCreated, true);
	}
	
	@Test
	public void  testNombreTableauxCamera() throws Exception {		
		
		int nbrTableaux = 1; 
		extractor.extractor("Comparison_of_digital_SLRs", stats);
		boolean wasCreated = false; 
		
		for(int i = 1; i < nbrTableaux+1; i++) { 
			File tmpDir = new File("./output/html/Comparison_of_digital_SLRs-" + i + ".csv");
			wasCreated = tmpDir.exists();
		}

		if(wasCreated) {
			File tmpDir = new File("./output/html/Comparison_of_digital_SLRs-" + (nbrTableaux+1) + ".csv");
			wasCreated = !tmpDir.exists(); //le fichier ne doit pas exister, donc on prends l'inverse du booléen 
		}
		
	    assertEquals(wasCreated, true);
	}
	
	
	@Test
	public void  testNombreTableauxProgrammeSpatial() throws Exception {		
		
		int nbrTableaux = 40; 
		extractor.extractor("Comparison_of_Asian_national_space_programs", stats);
		boolean wasCreated = false; 
		
		for(int i = 1; i < nbrTableaux+1; i++) { 
			File tmpDir = new File("./output/html/Comparison_of_Asian_national_space_programs-" + i + ".csv");
			wasCreated = tmpDir.exists();
		}

		if(wasCreated) {
			File tmpDir = new File("./output/html/Comparison_of_Asian_national_space_programs-" + (nbrTableaux+1) + ".csv");
			wasCreated = !tmpDir.exists(); //le fichier ne doit pas exister, donc on prends l'inverse du booléen 
		}
		
	    assertEquals(wasCreated, true);
	}
	
	
	@Test
	public void  testNombreTableauxLangage() throws Exception {		
		
		int nbrTableaux = 8; 
		extractor.extractor("Comparison_between_Esperanto_and_Ido", stats);
		boolean wasCreated = false; 
		
		for(int i = 1; i < nbrTableaux+1; i++) { 
			File tmpDir = new File("./output/html/Comparison_between_Esperanto_and_Ido-" + i + ".csv");
			wasCreated = tmpDir.exists();
		}
		
		if(wasCreated) {
			File tmpDir = new File("./output/html/Comparison_between_Esperanto_and_Ido-" + (nbrTableaux+1) + ".csv");
			wasCreated = !tmpDir.exists(); //le fichier ne doit pas exister, donc on prends l'inverse du booléen 
		}
	    assertEquals(wasCreated, true);
	}
	
	@Test
	public void  testNombreColonnesCamera() throws Exception {			
		int nbrColonnesTrouvées = 0; 
		int nbrColonnesVoulues = 22; 
		String url = "Comparison_of_digital_SLRs"; 
		extractor.extractor(url, stats);
		
		Reader reader = Files.newBufferedReader(Paths.get("./output/html/Comparison_of_digital_SLRs-1.csv"));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        CSVRecord firstRecord = csvParser.iterator().next(); //pbm : si colonnes agrégées 
		nbrColonnesTrouvées = firstRecord.size(); 
        
        csvParser.close();
	    assertEquals(nbrColonnesTrouvées, nbrColonnesVoulues);
	}
	
	@Test
	public void  testNombreLignesCamera() throws Exception {			
		int nbrLignesTrouvées = 0; 
		int nbrLignesVoulues = 72; 
		String url = "Comparison_of_digital_SLRs"; 
		extractor.extractor(url, stats);
		
		Reader reader = Files.newBufferedReader(Paths.get("./output/html/Comparison_of_digital_SLRs-1.csv"));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        
        csvParser.getRecordNumber(); 
		
        for (CSVRecord csvRecord : csvParser) {
        	nbrLignesTrouvées = nbrLignesTrouvées +1; 
        }
        csvParser.close();
	    assertEquals(nbrLignesTrouvées, nbrLignesVoulues);
	}
		
}
