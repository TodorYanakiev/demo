package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    private final MovieClient movieClient;

    @Autowired
    public MovieController(MovieClient movieClient) {
        this.movieClient = movieClient;
    }

    @GetMapping("/movie")
    public ResponseEntity<MovieSearchResponse> findMovie(@RequestParam("query") String query){
        MovieSearchResponse movieSearchResponse = movieClient.findMovie(query);
        return ResponseEntity.ok(movieSearchResponse);
    }
    @GetMapping("/moovie")
    public ResponseEntity<MovieSearchResponse> findMoovie(@RequestParam("query") String query){
        MovieSearchResponse movieSearchResponse = movieClient.findMoovie(query);
        return ResponseEntity.ok(movieSearchResponse);
    }

    @GetMapping("/movie-account")
    public ResponseEntity<MovieSearchResponse> findMovieByAccount(@RequestParam("account_id") Long id) {
        MovieSearchResponse movieSearchResponse = movieClient.findMovieByAccId(id);
        return ResponseEntity.ok(movieSearchResponse);
    }

    @PostMapping("/movie-account")
    public ResponseEntity<MovieSearchResponse> addMovieToFavAcc(@RequestParam("account_id") Long id,  @RequestBody FavoriteRequestDto favoriteRequestDto) {
        MovieSearchResponse movieSearchResponse = movieClient.addMovieToFav(id, favoriteRequestDto);
        return ResponseEntity.ok(movieSearchResponse);
    }
}
