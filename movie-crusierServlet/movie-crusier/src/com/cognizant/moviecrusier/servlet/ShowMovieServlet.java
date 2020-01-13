package com.cognizant.moviecrusier.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecrusier.dao.MovieListDao;
import com.cognizant.moviecrusier.dao.MovieListDaoSqlImpl;
import com.cognizant.moviecrusier.model.MovieList;

/**
 * Servlet implementation class ShowMovie
 */
@WebServlet("/ShowMovie")
public class ShowMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieListDao movieListDao  = new MovieListDaoSqlImpl();
		long movielistId = Long.parseLong(request.getParameter("movielistId"));
		MovieList movielist =movieListDao.getMovieList(movielistId);
		request.setAttribute("movie", movielist);
		request.getRequestDispatcher("edit-movie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
