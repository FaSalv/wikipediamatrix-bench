package fr.univrennes1.istic.wikipediamatrix;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.jsoup.nodes.Document;
import org.junit.Test;

public class TestCsv {
	
	WikipediaHTMLExtractor extractor = new WikipediaHTMLExtractor(); 
	CSVEditor csvEditor = new CSVEditor(); 
		
	@Test
	public void testWikipediaHTMLExtractor() throws Exception {		
		

		extractor.extractor("Comparison_of_iOS_e-book_reader_software");
		File tmpDir = new File("./output/html/Comparison_of_iOS_e-book_reader_software-1.csv");
		boolean exists = tmpDir.exists();
		}

	
	
}
