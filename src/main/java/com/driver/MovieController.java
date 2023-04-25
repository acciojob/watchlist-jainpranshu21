package com.driver;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

  MovieService movieService=new MovieService();
    @PostMapping("/add-movie")
    public String addMovie(@RequestBody Movie movie){
      String ans=movieService.addMovie(movie);
      return ans;
    }

    @PostMapping("/add-director")
    public String addDirector(@RequestBody Director director){
      String ans=movieService.addDirector(director);
      return ans;
    }


    @PutMapping("/add-movie-director-pair")
    public String addMovieDirectorPair(@RequestParam("name")String nameMovie, @RequestParam("name")String nameDirector){
      String ans=movieService.addMovieDirectorPair(nameMovie,nameDirector);
      return ans;
    }


    @GetMapping("/get-movie-by-name/{name}")
    public Movie getMovieByName(@PathVariable("name")String name){
      Movie movie=movieService.getMovieByName(name);
      return movie;
    }

    @GetMapping("/get-director-by-name/{name}")
    public Director getDirectorByName(@PathVariable("name")String name){
      Director director=movieService.getDirectorByName(name);
      return director;
    }

    @GetMapping("/get-movies-by-director-name/{name}")
    public List<String> getMoviesByDirectorName(@PathVariable("namer")String name){
      List<String> ans=movieService.getMoviesByDirectorName(name);
      return ans;
  }

    @GetMapping("/get-all-movies")
    public List<String> findAllMovies(){
      List<String> ans=movieService.findAllMovies();
      return ans;
    }


}
