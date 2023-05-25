package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return "MovieDirectorPair added successfully";
    }

    public List<Movie> getAllMovie(){
        List<Movie>movies=new ArrayList<>();
        for(Movie movie:movieDb.values())
            movies.add(movie);
        return movies;
    }

    public List<Director> getAllDirector(){
        List<Director>directors=new ArrayList<>();
        for(Director director:directorDb.values())
            directors.add(director);
        return directors;
    }

    public List<String> getMoviesByDirectorName(){
        List<String>name=new ArrayList<>();
        for (String s:movieDirectorDb.values())
            name.add(s);
        return name;
    }

    public List<String> getMoviesByDirectorName2(){

        List<String>name=new ArrayList<>();
        for (String s:movieDirectorDb.keySet())
            name.add(s);
        return name;
    }

    public String deleteDirectorByName(String name){
         directorDb.remove(name);
         for(Map.Entry<String,String>entry:movieDirectorDb.entrySet()){
             if(entry.getValue().equals(name)){
                 String temp=entry.getKey();
                 movieDb.remove(temp);
                 movieDirectorDb.remove(temp);
             }
         }
          return "movies deleted successfully";
    }

    public String deleteAllDirectors(){
        for(String s:directorDb.keySet()){
            directorDb.remove(s);
            for(Map.Entry<String,String>entry:movieDirectorDb.entrySet()){
                if(entry.getValue().equals(s)){
                    String temp=entry.getKey();
                    movieDb.remove(temp);
                    movieDirectorDb.remove(temp);
                }
            }
        }

        return "deleted successfully";
    }
}
