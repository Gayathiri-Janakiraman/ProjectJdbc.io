package com.cognizant.moviecrusier.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecrusier.dao.FavoritesDao;
import com.cognizant.moviecrusier.dao.FavoritesDaoSqlImpl;
import com.cognizant.moviecrusier.dao.FavoritesEmptyException;

/**
 * Servlet implementation class RemoveFavorites
 */
@WebServlet("/RemoveFavorites")
public class RemoveFavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFavoritesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long userId = 1L;
		long movielistId = Long.parseLong(request.getParameter("movielistId"));
		FavoritesDao favoritesDao = new FavoritesDaoSqlImpl();
		favoritesDao.removeFavoritemovies(1, movielistId);

		try {
			request.setAttribute("movie", favoritesDao.getAllFavoritemovies(userId));
			request.setAttribute("deletefavoritesstatus",true);
			request.getRequestDispatcher("favorites.jsp").forward(request, response);
		} catch (FavoritesEmptyException e) {
			request.getRequestDispatcher("favorites-empty.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
