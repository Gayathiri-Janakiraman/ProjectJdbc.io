package com.cognizant.moviecrusier.model;

import java.util.Date;

import com.cognizant.moviecrusier.util.Dateutil;

public class MovieList {
	private long id;
	private String title;
	private long gross;
	private Boolean active;
	private Date dateofLaunch;
	private String genre;
	private Boolean hasteaser;
	
	public MovieList(long id, String title, long gross, Boolean active, Date dateofLaunch, String genre,
			Boolean hasteaser) {
		super();
		this.id = id;
		this.title = title;
		this.gross = gross;
		this.active = active;
		this.dateofLaunch = dateofLaunch;
		this.genre = genre;
		this.hasteaser = hasteaser;
	}
	
	public MovieList() {
		
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getGross() {
		return gross;
	}
	public void setGross(long gross) {
		this.gross = gross;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Date getDateofLaunch() {
		return dateofLaunch;
	}
	public void setDateofLaunch(Date dateofLaunch) {
		this.dateofLaunch = dateofLaunch;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Boolean getHasteaser() {
		return hasteaser;
	}
	public void setHasteaser(Boolean hasteaser) {
		this.hasteaser = hasteaser;
	}
	
	@Override
	public String toString() {
		return "MovieList [id=" + id + ", title=" + title + ", gross=$" + gross + ", active=" + active+ 
				", dateofLaunch=" + new Dateutil().convertToString(dateofLaunch) + ", genre=" + genre + ", hasteaser=" + hasteaser + "]";
	}
		
}