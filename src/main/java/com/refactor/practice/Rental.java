package com.refactor.practice;

public class Rental {
	private Movie _movie;

	private int _dayRented;
	public Rental(Movie movie, int dayRented) {
		_movie = movie;
		_dayRented = dayRented;
	}

	public Movie getMovie() {
		return _movie;
	}

	public double getCharge(){
		return _movie.getCharge(_dayRented);
	}
	public int getFrequentRenterPoints(){
		return _movie.getFrequentRenterPoints(_dayRented);
	}
}
