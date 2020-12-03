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
		
		//Récupération du HTML à partir de l'URL
		String BASE_WIKIPEDIA_URL = "https://en.wikipedia.org/wiki/";
	    String wurl = BASE_WIKIPEDIA_URL + URL; 
		Document doc = Jsoup.connect(wurl).get();
		
		//Récupération des tables dans le DOM
		Elements table = doc.getElementById("mw-content-text") //Filtres
				.select("table:not(.autocollapse)")
				.select("table:not(.metadata)")
				.select("table:not([class*=navbox])") //toutes les classes qui contiennent la valeur "navbox"
				.select(".wikitable")
				.select(".sortable");

		//boucle sur tous les tableaux sélectionné
	    for(int i = 0; i < table.size(); i++) { 
	    	
	    	int nbrColonne = 0; 
	    		    	
	        Element currentTable = table.get(i);
	        Elements rows = currentTable.select("tr");

			String docPath = "./output/html/" + URL + "-" + (i+1) +".csv"; 

	        //je crée un tableau dont le nombre de ligne est égale au nombre de ligne de mon tableau HTML et représente le futur CSV 
			// On ajoutera les lignes du CSV au fur et à mesure du traitement
	        ArrayList<ArrayList<String>> dataTest = new ArrayList<ArrayList<String>>();
	        
	        //ATTENTION s'il y a du rowspan = n ~> colone imbriquée; il faut récupérer le rowspan et faire n ajout 
	    	// [attr] elements with an attribute named "attr" (with any value)
	        
	        //boucle sur toutes les lignes du tableau i 
		    for (int j = 0; j < rows.size() ; j++) {
		        Element row = rows.get(j);
		        ArrayList<String> tempLine = new ArrayList<String>();
		        
		        Elements headers = row.select("th"); 
		        Elements cols = row.select("td");
		        		        
		        //Ici je vérifie s'il y a des headers tout en m'assurant de ne pas prendre de ligne complète 
		        if ((headers.size() != 0) & !(nbrColonne == headers.size())) {
		        	for (int k = 0; k < headers.size() ; k++) { 
		        		
		        		nbrColonne = headers.size();
				        Element col = headers.get(k);
				        
				        String nbrRowspan = col.attr("colspan"); 
			        	int colspanToInt = Integer.parseInt("0" + nbrRowspan);
		        		if (colspanToInt > 0) { 
				        	for (int m = 0; m < colspanToInt ; m++) { 
				        		tempLine.add(col.text());
				        	}
				        } 
				        tempLine.add(col.text());
		        	}
		        }

		        //boucle sur tous les colonnes de la ligne j du tableau i 
		        for (int k = 0; k < cols.size() ; k++) { 
			        Element col = cols.get(k);
			        //On ajoute l'élément à notre ligne
			        tempLine.add(col.text()); 
			    }
		        //On ajoute la ligne au CSV
		        dataTest.add(tempLine);  
		    }
		//On crée le CSV du tableau 
	    csvEditor.createCSVFile(docPath, dataTest);
	    }
	}
	    
}


	
