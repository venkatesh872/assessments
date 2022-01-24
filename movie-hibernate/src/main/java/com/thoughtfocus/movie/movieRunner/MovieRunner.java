package com.thoughtfocus.movie.movieRunner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.thoughtfocus.movie.movieDAO.MovieDAO;
import com.thoughtfocus.movie.movieDTO.MovieDTO;
import com.thoughtfocus.movie.moviehqlDAO.MovieHqlDAO;

public class MovieRunner {
public static void main(String[] args) {
	MovieDTO dto = new MovieDTO();
	dto.setId(111);
	dto.setName("kgf2");
	dto.setLanguage("kannada");
	dto.setBudget(78.00);
	dto.setNoOfActor(12);
	dto.setIsColor(false);
	
	MovieDAO dao = new MovieDAO();
	//dao.saveMovie(dto);
	
	MovieHqlDAO hqldao = new MovieHqlDAO();
	
	System.out.println(hqldao.getBudgetByName("Baahubali"));                 //1st method
	
	Object[] obj=hqldao.getLanguageAndActorById(102);
	System.out.println(obj[0]+" "+obj[1]);                                    //2nd method
	
	System.out.println(hqldao.getColorByNameAndLanguage("kgf","kannada"));    //3rd method
	
	
	List<Object[]> obj2 =hqldao.getNameAndBudgetByLanguage("telugu");                //4th method
	for(Object[] object:obj2) {
    	System.out.println(object[0]+" "+object[1]);
    }                                 
	
    List li=hqldao.getAllMovies();          //5th method 
    for(Object object:li) {
    	System.out.println(object);
    }
    
    List li1=hqldao.getAllColorMovies();          //6th method 
    for(Object object:li1) {
    	System.out.println(object);
    }
	
     //hqldao.updateBudgetById(101, 345.99);
	//hqldao.updateColorByNameAndBudget("rebel", 34, true);
	//hqldao.updateNoOfActorsByNameBudgetAndLanguage("robo", 34, "tamil", 153);
	//hqldao.deleteById(105);
    //hqldao.deleteByColorAndActorCountlessThan15(false);
    
    
}
}
