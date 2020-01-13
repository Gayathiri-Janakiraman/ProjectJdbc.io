package com.cognizant.moviecrusier.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.moviecrusier.model.Favorites;
import com.cognizant.moviecrusier.model.MovieList;

public class FavoritesDaoSqlImpl implements FavoritesDao {

	public static final String ADD_FAVORITES = "insert into favorites(fav_us_id,fav_mov_id) values (?,?)";

	public static final String GET_ALL_FAVORITES = "SELECT mov_id,mov_title,mov_gross,mov_active,mov_genre,mov_has_teaser FROM favorites\r\n"
			+ "INNER JOIN movie_list on mov_id = fav_mov_id\r\n" + "INNER JOIN user on us_id = fav_us_id\r\n"
			+ "WHERE us_id=?";

	public static final String GET_NO_OF_FAVORITES = "SELECT us_id, count(fav_id) as mov_no_of_fav FROM favorites\r\n"
			+ "	INNER JOIN movie_list on mov_id = fav_mov_id\r\n" + "INNER JOIN user on us_id = fav_us_id\r\n"
			+ "	WHERE us_id=?";

	public static final String DELETE_FAVORITES = "DELETE from favorites WHERE fav_us_id=? AND fav_mov_id = ? limit 1";

	@Override
	public void addFavoritemovies(long userId, long movieListId) {

		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement(ADD_FAVORITES);
			preparedstatement.setLong(1, userId);
			preparedstatement.setLong(2, movieListId);
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedstatement != null)
					preparedstatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Favorites getAllFavoritemovies(long userId) throws FavoritesEmptyException {

		ArrayList<MovieList> movieList = new ArrayList<MovieList>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatementFavorites = null;
		ResultSet resultSet = null;
		ResultSet resultSetFavorites = null;
		MovieList movie_list = null;
		Favorites favorites = new Favorites();
		try {
			preparedStatement = connection.prepareStatement(GET_ALL_FAVORITES);
			preparedStatement.setLong(1, userId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				movie_list = new MovieList();
				movie_list.setId(resultSet.getLong("mov_id"));
				movie_list.setTitle(resultSet.getString("mov_title"));
				movie_list.setGross(resultSet.getLong("mov_gross"));
				movie_list.setActive(resultSet.getString("mov_active").equals("Yes"));
				movie_list.setGenre(resultSet.getString("mov_genre"));
				movie_list.setHasteaser(resultSet.getString("mov_has_teaser").equals("Yes"));
				movieList.add(movie_list);
			}
			if (movieList.size() == 0) {
				throw new FavoritesEmptyException();
			}
			favorites.setMovieList(movieList);
			// No.Of.Favorites
			preparedStatementFavorites = connection.prepareStatement(GET_NO_OF_FAVORITES);
			preparedStatementFavorites.setLong(1, userId);
			resultSetFavorites = preparedStatementFavorites.executeQuery();
			long total = 0;
			while (resultSetFavorites.next()) {
				total = resultSetFavorites.getLong("mov_no_of_fav");
			}
			favorites.setTotal(total);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (preparedStatementFavorites != null) {
					preparedStatementFavorites.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return favorites;
	}

	@Override
	public void removeFavoritemovies(long userId, long movieListId) {

		@SuppressWarnings("unused")
		MovieListDao movieListDao = new MovieListDaoSqlImpl();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(DELETE_FAVORITES);
			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, movieListId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			try {

				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {

			}

		}
	}

}
