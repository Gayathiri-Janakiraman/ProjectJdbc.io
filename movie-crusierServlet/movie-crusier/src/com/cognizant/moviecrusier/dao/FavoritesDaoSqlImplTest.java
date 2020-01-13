package com.cognizant.moviecrusier.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cognizant.moviecrusier.model.Favorites;
import com.cognizant.moviecrusier.model.MovieList;

public class FavoritesDaoSqlImplTest {

	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	static DecimalFormat df = new DecimalFormat("#,###,###,###");
	static List<MovieList> movie_List;
	static ArrayList<MovieList> movielist;
	private static Scanner scan;

	public static void testaddFavoritemovies() throws FavoritesEmptyException, NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		long userId = 1;
		System.out.println("Enter the Id:");
		long movieListId = Long.parseLong(bf.readLine());
		new FavoritesDaoSqlImpl().addFavoritemovies(userId, movieListId);
	}

	public static void testgetAllFavoritemovies() throws FavoritesEmptyException {
		   System.out.println("Enter the Id:");
		   scan = new Scanner (System.in);
		   long userId = scan.nextLong();
	       Favorites favorites=new FavoritesDaoSqlImpl().getAllFavoritemovies(userId);
	       List<MovieList> movie_list = favorites.getMovieList();
	     	    	 
	       System.out.format("\n%-5s%-20s%-15s%-20s%-15s", "ID", "TITLE", "BOX OFFICE", 
	               "GENRE", "HAS TEASER");
	       for(MovieList movie_List : movie_list) {
	    	 
	       System.out.format("\n%-5s%-20s%-15s%-20s%-15s", movie_List.getId(), movie_List.getTitle(),
	               "$"+ df.format(movie_List.getGross()),
	               movie_List.getGenre(),movie_List.getHasteaser() ? "Yes" : "No");
	       }
	       System.out.println("\n\nNo.Of.Favorites: " + favorites.getTotal());
	    }

	public static void testremoveFavoritemovies() throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nEnter user id value to remove:");
        long userId = Long.parseLong(bf.readLine());
        System.out.println("Enter user movielist id value to remove");
        long movieListId = Long.parseLong(bf.readLine());
        new FavoritesDaoSqlImpl(). removeFavoritemovies(userId, movieListId);
	}

	public static void main(String[] args) throws FavoritesEmptyException, NumberFormatException, IOException {

		testaddFavoritemovies();
	    testgetAllFavoritemovies();
		testremoveFavoritemovies();
	}
}
