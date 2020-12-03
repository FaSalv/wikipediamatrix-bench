package fr.univrennes1.istic.wikipediamatrix;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		WikipediaHTMLExtractor extractor = new WikipediaHTMLExtractor(); 
		CSVEditor csvEditor = new CSVEditor(); 
		
		extractor.extractor("Comparison_of_iOS_e-book_reader_software");
		//Comparison_of_digital_SLRs
		//Comparison_between_Esperanto_and_Ido
		//Comparison_of_file_managers
		//Comparison_of_iOS_e-book_reader_software
		//Comparison_of_open-source_wireless_drivers
		//Comparison_of_portable_media_players
		
	}


}
