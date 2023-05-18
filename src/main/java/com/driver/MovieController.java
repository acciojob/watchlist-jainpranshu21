package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

  MovieService movieService=new MovieService();
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
      String ans=movieService.addMovie(movie);
      return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
      String ans=movieService.addDirector(director);
      return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }


    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("nameMovie")String nameMovie, @RequestParam("nameDirector")String nameDirector){
      String ans=movieService.addMovieDirectorPair(nameMovie,nameDirector);
      return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }


    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name")String name){
      Movie movie=movieService.getMovieByName(name);
      return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name")String name){
      Director director=movieService.getDirectorByName(name);
      return new ResponseEntity<>(director, HttpStatus.CREATED);
    }

    @GetMapping("/get-movies-by-director-name/{name}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("name")String name){
      List<String> ans=movieService.getMoviesByDirectorName(name);
      return new ResponseEntity<>(ans, HttpStatus.CREATED);
  }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
      List<String> ans=movieService.findAllMovies();
      return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name")String name){
      String ans=movieService.deleteDirectorByName(name);
      return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
      String ans=movieService.deleteAllDirectors();
      return  new ResponseEntity<>(ans,HttpStatus.CREATED);
    }
}
