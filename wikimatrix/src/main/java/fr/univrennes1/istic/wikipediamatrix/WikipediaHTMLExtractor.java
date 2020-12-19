package fr.univrennes1.istic.wikipediamatrix;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WikipediaHTMLExtractor {
	
	CSVEditor csvEditor = new CSVEditor(); 
	
	public void extractor(String URL, Statistique stat ) throws IOException {
		
		int tempLineLenght = 0 ; 
		boolean columnsAreGood = true ; 
	
		
		//Récupération du HTML à partir de l'URL
		String BASE_WIKIPEDIA_URL = "https://en.wikipedia.org/wiki/";
	    String wurl = BASE_WIKIPEDIA_URL + URL; 
	    stat.setNbrPageExtraites(stat.getNbrPageExtraites() + 1 );
	    
	    try {
	    	
			Document doc = Jsoup.connect(wurl).get();
			
			//Récupération des tables dans le DOM
			Elements table = doc.getElementById("mw-content-text") //Filtres
					.select("table:not(.metadata)")
					.select("table:not([class*=navbox])") //toutes les classes qui contiennent la valeur "navbox"
					.select(".wikitable");
					//.select("table:not([class*=collapse])");
			
			System.out.print("Extraction de " + URL + "...  \n");
	
			//boucle sur tous les tableaux sélectionné
		    for(int i = 0; i < table.size(); i++) { 

				stat.setNbrTableau(stat.getNbrTableau() + 1);
		    	
		    	//On crée un objet tableau 
		    	Tableau tableauInMaking = new Tableau() ; 
		    		    
		    	//On récupère les éléments HTML nécéssaires
		        Element currentTable = table.get(i);
		        Elements rows = currentTable.select("tr");
		
		        //On crée l'objet dans lequel on va temporairement stocker les données
		        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
		        
		        //on boucle sur les lignes pour extraires les données
		        for (int j = 0; j < rows.size() ; j++) {
		            Element row = rows.get(j);
		            ArrayList<String> tempLine = new ArrayList<String>();
		            
		            Elements headers = row.select("th"); 
		            Elements cols = row.select("td");

		            tableauInMaking.dealsWithRow(j, headers, cols, tempLine);
		            data.add(tempLine);  
		            if(j==0) {
		            	tempLineLenght = tempLine.size(); 
		            }
		            if((tempLineLenght != tempLine.size()) & (tempLine.size()!=0)) {
		            	columnsAreGood = false ; 
		            }
		            
		        }
		       
		        if(!columnsAreGood) {
		        	stat.setNbrTableauMauvaiseColonnes(stat.getNbrTableauMauvaiseColonnes() + 1);
		        }
		        //On crée le CSV du tableau 
		        String docPath = "./output/html/" + URL + "-" + (i+1) +".csv"; 
		        csvEditor.createCSVFile(docPath, data);
		    }

    	}
    	catch(Exception e) {
    		System.out.println("Erreur lors de l'extraction de la page " + wurl);
    		System.out.println(e);
    		stat.setNbr404Error(stat.getNbr404Error() + 1);
    	}
	    

	}
	    
}


	
