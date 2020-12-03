package fr.univrennes1.istic.wikipediamatrix;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WikipediaHTMLExtractor {
	
	CSVEditor csvEditor = new CSVEditor(); 
	
	public void extractor(String URL ) throws IOException {
		
		//R�cup�ration du HTML � partir de l'URL
		String BASE_WIKIPEDIA_URL = "https://en.wikipedia.org/wiki/";
	    String wurl = BASE_WIKIPEDIA_URL + URL; 
		Document doc = Jsoup.connect(wurl).get();

		//R�cup�ration des tables dans le DOM
		Elements table = doc.getElementById("mw-content-text") //Filtres
				.select("table:not(.navbox)")
				.select("table:not(.autocollapse)")
				.select("table:not(.metadata)")
				.select("table:not(.vertical-navbox)")
				.select(".sortable");
		
		
		
		

		//boucle sur tous les tableaux s�lectionn�s 
	    for(int i = 0; i < table.size(); i++) { 
	    	
	    	int nbrColonne = 0; 
	    	
	        Element currentTable = table.get(i);
	        Elements rows = currentTable.select("tr");

			String docPath = "./output/html/" + URL + "-" + (i+1) +".csv"; 

	        //je cr�e un tableau dont le nombre de ligne est �gale au nombre de ligne de mon tableau HTML et repr�sente le futur CSV 
			// On ajoutera les lignes du CSV au fur et � mesure du traitement
	        ArrayList<ArrayList<String>> dataTest = new ArrayList<ArrayList<String>>();
	        

	        //boucle sur toutes les lignes du tableau i 
		    for (int j = 0; j < rows.size() ; j++) {
		        Element row = rows.get(j);
		        ArrayList<String> tempLine = new ArrayList<String>();
		        
		        Elements headers = row.select("th"); 
		        Elements cols = row.select("td");
		        		        
		        //Ici je v�rifie s'il y a des headers tout en m'assurant de ne pas prendre de ligne compl�te 
		        if ((headers.size() != 0) & !(nbrColonne == headers.size())) {
		        	for (int k = 0; k < headers.size() ; k++) { 
		        		nbrColonne = headers.size();
				        Element col = headers.get(k);
		        		tempLine.add(col.text()); 
		        		
		        	}
		        }

		        //boucle sur tous les colonnes de la ligne j du tableau i 
		        for (int k = 0; k < cols.size() ; k++) { 
			        Element col = cols.get(k);
			        //On ajoute l'�l�ment � notre ligne
			        tempLine.add(col.text()); 
			    }
		        //On ajoute la ligne au CSV
		        dataTest.add(tempLine);  
		    }
		//On cr�e le CSV du tableau 
	    csvEditor.createCSVFile(docPath, dataTest);
	    }
	}

	
}
