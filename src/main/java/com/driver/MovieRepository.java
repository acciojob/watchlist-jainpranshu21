package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    HashMap<String,Movie>movieDb=new HashMap<>();
    HashMap<String,Director>directorDb=new HashMap<>();
    HashMap<String,String>movieDirectorDb=new HashMap<>();

    public String addMovie(Movie movie){
      String name=movie.getName();
      movieDb.put(name,movie);
      return "movie added successfully";
    }

    public  String addDirector(Director director){
        String name=director.getName();
        directorDb.put(name,director);
        return "director added successfully";
    }

    public String addMovieDirectorPair(String nameMovie,String nameDirector){
        movieDirectorDb.put(nameMovie,nameDirector);
        return "MovieDirectorPair added successully";
    }

    public List<Movie> getAllMovie(){

        return movieDb.values().stream().toList();
    }

    public List<Director> getAllDirector(){
        return directorDb.values().stream().toList();
    }

    public List<String> getMoviesByDirectorName(){
        return movieDirectorDb.values().stream().toList();
    }

    public List<String> getMoviesByDirectorName2(){
        return movieDirectorDb.keySet().stream().toList();
    }
}
