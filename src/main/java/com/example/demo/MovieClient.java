package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "movieClient", url = "https://api.themoviedb.org", configuration = FeignConfig.class)
public interface MovieClient {
    @GetMapping("/3/search/movie")
    MovieSearchResponse findMovie(@RequestParam("query") String query);

    @GetMapping("/3/search/moovie")
    MovieSearchResponse findMoovie(@RequestParam("query") String query);

    @GetMapping("/3/account/{account_id}/favorite/movies") //
    MovieSearchResponse findMovieByAccId(@RequestParam("account_id") Long id);

    @PostMapping("/3/account/{account_id}/favorite")
    MovieSearchResponse addMovieToFav(@RequestParam("account_id") Long id, @RequestBody FavoriteRequestDto favoriteRequestDto);
}
