package com.driver;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MovieService {

    MovieRepository movieRepository=new MovieRepository();
    public String addMovie(Movie movie){
      String ans=movieRepository.addMovie(movie);
      return ans;
    }

    public String addDirector(Director director){
     String ans=movieRepository.addDirector(director);
     return ans;
    }


    public String addMovieDirectorPair(String nameMovie,String nameDirector){
        String ans=movieRepository.addMovieDirectorPair(nameMovie,nameDirector);
        return ans;
    }
    public Movie getMovieByName(String name){
        List<Movie> movies=movieRepository.getAllMovie();
        Movie ans=null;
      //  System.out.println("name"+name);
        for(Movie movie:movies){
          //  System.out.println("movie"+movie.getName());
            if(movie.getName().equals(name)){
                 ans=movie;
            //     System.out.println("check");
            }
        }
        return ans;
    }

    public Director getDirectorByName(String name){
        List<Director> directors=movieRepository.getAllDirector();
        Director ans=null;
        for(Director director:directors){
            if(director.getName().equals(name)){
                ans=director;
            }
        }
        return ans;
    }

    public List<String> getMoviesByDirectorName(String name){
        List<String>director=movieRepository.getMoviesByDirectorName(name);
        return director;
    }

    public List<String> findAllMovies(){
        List<Movie> temp=movieRepository.getAllMovie();
        List<String>ans=new ArrayList<>();
        for(Movie movie:temp){
            ans.add(movie.getName());
        }
        return ans;
    }

    public String deleteDirectorByName(String name){
        String ans=movieRepository.deleteDirectorByName(name);
        return ans;
    }

    public String deleteAllDirectors(){
        String ans=movieRepository.deleteAllDirectors();
        return ans;
    }
}
