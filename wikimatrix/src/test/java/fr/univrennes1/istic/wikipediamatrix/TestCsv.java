package fr.univrennes1.istic.wikipediamatrix;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.Test;

public class TestCsv {
		
	@Test
	public void testWikipediaHTMLExtractor() throws Exception {		
			
		Reader in = new FileReader("./output/html/Comparison_of_digital_SLRs.csv");
		Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
		}

}
