package fr.univrennes1.istic.wikipediamatrix;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class CSVEditor {

		public void createCSVFile(String path, ArrayList<ArrayList<String>> record ) throws IOException {	
			
			 BufferedWriter writer = Files.newBufferedWriter(Paths.get(path));
			 CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.EXCEL);
			 csvPrinter.printRecords(record);
			 csvPrinter.flush();            
		}


}
