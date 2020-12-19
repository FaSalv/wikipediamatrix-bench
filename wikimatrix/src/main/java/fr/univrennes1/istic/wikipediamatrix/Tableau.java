package fr.univrennes1.istic.wikipediamatrix;

import java.util.ArrayList;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Tableau {
	
	boolean hasAlreadyHeader ; 
	boolean isRowspan ; 
	int nbrColonnes ; 
	int rowspan ; 
	String valueRowspan ;
	int rowspanPosition ; 
	int colspan ; 
	
	public void dealsWithRow(int whichColumn, Elements headers, Elements cols, ArrayList<String> tempLine) {
        	
		//Ici je vérifie s'il y a des headers tout en m'assurant de ne pas prendre deux fois un même headers
		if ((headers.size() > 0) & !(this.nbrColonnes == headers.size())) {
        	this.addHeaderContent(tempLine, headers);
        	if(hasAlreadyHeader == false) {
	        	this.nbrColonnes = headers.size();
	        	this.hasAlreadyHeader = true;
	        	
        	}
        	
        }
        this.addLineContent(tempLine, cols); 
	}
	

	public void addLineContent(ArrayList<String> tempLine, Elements cols) {
		for (int k = 0; k < cols.size() ; k++) { 
	        Element col = cols.get(k);
	        
	        if((isRowspan) & (k == rowspanPosition)) {
	        	dealWithRowspan(tempLine);
	        }
	        
	        String nbrRowspan = col.attr("rowspan"); 
        	int rowspanToInt = Integer.parseInt("0" + nbrRowspan);
        	
	        String nbrColspan = col.attr("colspan"); 
        	int colspanToInt = Integer.parseInt("0" + nbrColspan);
        	
    		if (colspanToInt > 0) { 
	        	for (int m = 0; m < colspanToInt ; m++) { 
	        		tempLine.add(col.text());
	        	}
	        } 
    		
    		if (rowspanToInt > 0) { 
    			this.isRowspan = true; 
    			this.rowspan = rowspanToInt;
    			this.valueRowspan = col.text() ; 
    			this.rowspanPosition = k ; 
	        } 
	        
	        tempLine.add(col.text()); 
	    }
	}
	
	
	public void addHeaderContent(ArrayList<String> tempLine, Elements headers) {
		for (int k = 0; k < headers.size() ; k++) { 
	        Element col = headers.get(k);
	        
	        if((isRowspan) & (k == rowspanPosition)) {
	        	dealWithRowspan(tempLine);
	        }
	        
	        String nbrRowspan = col.attr("rowspan"); 
        	int rowspanToInt = Integer.parseInt("0" + nbrRowspan);
        	
	        String nbrColspan = col.attr("colspan"); 
        	int colspanToInt = Integer.parseInt("0" + nbrColspan);
        	
    		if (colspanToInt > 0) { 
	        	for (int m = 0; m < colspanToInt ; m++) { 
	        		tempLine.add(col.text());
	        	}
	        } 
    		
    		if (rowspanToInt > 0) { 
    			this.isRowspan = true; 
    			this.rowspan = rowspanToInt;
    			this.valueRowspan = col.text() ; 
	        } 
    		
    		
	        tempLine.add(col.text());
    	}
	}
	
	
	public void dealWithRowspan(ArrayList<String> tempLine) {
		tempLine.add(valueRowspan); 
    	rowspan = rowspan - 1; 
    	if(colspan != 0) {
    		for (int m = 0; m < colspan ; m++) { 
        		tempLine.add(valueRowspan);
        	}
    	}
    	
    	if(rowspan == 0) {
    		isRowspan = false ; 
    	}
	}
	
	
	public Tableau() {
		super();
		this.isRowspan = false;
		this.nbrColonnes = 0;
		this.hasAlreadyHeader = false ; 
		
	}
	

}
