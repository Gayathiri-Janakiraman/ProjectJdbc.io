package com.cognizant.moviecrusier.dao;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.List;

import com.cognizant.moviecrusier.model.Favorites;

import com.cognizant.moviecrusier.model.MovieList;

public class FavoritesDaoCollectionImpl implements FavoritesDao {

	private static HashMap<Long, Favorites> userFavorites;

	public FavoritesDaoCollectionImpl() {
		super();
		if (userFavorites == null) {
			userFavorites = new HashMap<>();
		}
	}

	@Override
	public void addFavoritemovies(long userId, long movieListId) {
		MovieListDao movieListDao = new MovieListDaoCollectionImpl();
		MovieList movieList = movieListDao.getMovieList(movieListId);
		if (userFavorites.containsKey(userId)) {
			userFavorites.get(userId).getMovieList().add(movieList);
		} else {
			Favorites favorites = new Favorites();
			ArrayList<MovieList> movieLists = new ArrayList<>();
			movieLists.add(movieList);
			favorites.setMovieList(movieLists);
			userFavorites.put(userId, favorites);
		}
	}
	@Override
	public Favorites getAllFavoritemovies(long userId) throws FavoritesEmptyException {
		Favorites favorites = userFavorites.get(userId);
	    long total=0;
		if (favorites == null || favorites.getMovieList().isEmpty()) {
			throw new FavoritesEmptyException();
		}
		List<MovieList> movieListDao = userFavorites.get(userId).getMovieList();
		for(MovieList favorite : movieListDao) {
		total += favorite.getGross();
		}
		favorites.setTotal(total);
		//System.out.println("Total Gross:" +total);
		return favorites;
	}
	@Override
	public void removeFavoritemovies(long userId, long movielistId) {
		List<MovieList> movieList = userFavorites.get(userId).getMovieList();
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId() == movielistId) {
				movieList.remove(i);
				return;
			}
		}

	}

}
