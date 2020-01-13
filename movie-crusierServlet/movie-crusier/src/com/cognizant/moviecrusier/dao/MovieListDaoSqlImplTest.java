package com.cognizant.moviecrusier.dao;

import java.text.DecimalFormat;

import java.text.SimpleDateFormat;
import java.util.List;

import com.cognizant.moviecrusier.model.MovieList;
import com.cognizant.moviecrusier.util.Dateutil;

public class MovieListDaoSqlImplTest {

	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	static DecimalFormat df = new DecimalFormat("#,###,###,###");
		
	public static void testgetMovieListAdmin() {
		System.out.println("***Movie List for Admin***");
		List<MovieList> movie_List = new MovieListDaoSqlImpl().getMovieListAdmin();

		  System.out.format("\n%15s%25s%15s%20s%15s%20s%15s", "ID", "TITLE", "BOX OFFICE", "DATE OF LAUNCH", "ACTIVE",
	               "GENRE", "HAS TEASER");
		for (MovieList movieList : movie_List) {
			System.out.format("\n" + "%15s%25s%15s%15s%15s%20s%15s", movieList.getId(), movieList.getTitle(),df.format(movieList.getGross()),
					sdf.format(movieList.getDateofLaunch()),movieList.getActive() ? "Yes" : "No",movieList.getGenre(),movieList.getHasteaser() ? "Yes" : "No");
		}
			
		}
	
	public static void testgetMovieListCustomer() {
		System.out.println("\n\n***Movie List for Customer***");
		List<MovieList> movie_List = new MovieListDaoSqlImpl().getMovieListCustomer();
		 System.out.format("\n%15s%20s%15s%20s%15s%15s%15s", "ID", "TITLE", "BOX OFFICE", "DATE OF LAUNCH", "ACTIVE",
	               "GENRE", "HAS TEASER");
		for (MovieList movieList : movie_List) {
			System.out.format("\n" + "%15s%25s%15s%15s%15s%15s%15s", movieList.getId(), movieList.getTitle(),df.format(movieList.getGross()),
					sdf.format(movieList.getDateofLaunch()),movieList.getActive()? "Yes" : "No",movieList.getGenre(),movieList.getHasteaser()? "Yes" : "No");
		}
		
	}
	
	public static void testmodifyMovieList() {
		System.out.println("\n\n***Modified Movie Details***");
		MovieList movieList=new MovieList(1L,"Lion King",1256,true,new Dateutil().convertToDate("14/03/2017"),"Cartoon",true);
		new MovieListDaoSqlImpl().modifyMovieList(movieList);
	    System.out.println("\nModified "+movieList);
	}
	
	public static void testgetMovieList() {
		System.out.println("\n\n***Get Movie***");
		long movieListId = 2;
		MovieList movieList = new MovieListDaoSqlImpl().getMovieList(movieListId);
		System.out.format("\n\n%15s%25s%15s%15s%15s%15s%15s", "Id", "Name", "Price", "Date of Launch", "Active",
				"Category", "Free Delivery");
		System.out.format("\n" + "%15s%25s%15s%15s%15s%15s%15s", movieList.getId(), movieList.getTitle(),
				df.format(movieList.getGross()), sdf.format(movieList.getDateofLaunch()), movieList.getActive() ? "Yes" : "No",
				movieList.getGenre(), movieList.getHasteaser() ? "Yes" : "No");
		
	}
	
	public static void main(String[] args) {
		
		testgetMovieListAdmin();
		testgetMovieListCustomer();
		testmodifyMovieList();
		testgetMovieList();
	}
 
}
