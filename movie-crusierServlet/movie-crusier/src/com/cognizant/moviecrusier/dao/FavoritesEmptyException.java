package com.cognizant.moviecrusier.dao;

public class FavoritesEmptyException extends Exception {
		/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	public FavoritesEmptyException() {
			super("Favorites Movie List is Empty");
	}

}


