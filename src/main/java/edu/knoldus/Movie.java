package edu.knoldus;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

class Movie {

    String moviename;
    Integer releaseYear;
    Integer rating;
    String Genre;

    public Movie(String moviename, Integer releaseYear, Integer rating, String genre) {
        this.moviename = moviename;
        this.releaseYear = releaseYear;
        this.rating = rating;
        Genre = genre;
    }

    public String toString() {
        return moviename;
    }

    public static void main(String[] args) {
        Movie movie1 = new Movie("Sultan", 2016, 10, "Comedy");
        Movie movie2 = new Movie("Dangal", 2017, 7, "Sci-Fi");
        Movie movie3 = new Movie("Pari", 2018, 5, "Comedy");
        List<Movie> movieinfo = Arrays.asList(movie1,movie2,movie3);

        List<Movie> comedyMovie = movieinfo.stream().filter(s -> s.rating > 8 && s.Genre.equals("Comedy")).collect(toList());
        System.out.println(" Movies with rating more than 8 and genre comedy" + comedyMovie);

        List<Movie> movieHavingRatingLessThaneight = movieinfo.stream().filter(s -> s.releaseYear > 2000 && s.rating < 8).collect(toList());
        System.out.println("Movies with release year greater than 2000 and rating less than 8" + movieHavingRatingLessThaneight);

        List<Movie> movieHavingRatingAsEvenInNumber = movieinfo.stream().filter(s -> s.rating % 2 == 0).collect(toList());
        System.out.println(" movies with rating as even number " + movieHavingRatingAsEvenInNumber);

        List<Movie> scifiMovies = movieinfo.stream().filter(s -> s.rating == 7 && s.Genre.equals("Sci-Fi")).collect(toList());
        System.out.println("movies with rating equals to 7 and genre Sci-Fi" + scifiMovies);

    }
}