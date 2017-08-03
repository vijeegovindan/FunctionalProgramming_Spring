package com.tiy.movies;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class ModelController {

    public static List<Movie> getMovies(String route){
        RestTemplate template = new RestTemplate();
        ResultsPage rs = new ResultsPage();
        rs = template.getForObject(route, ResultsPage.class);
        return rs.getMovies();
    }

    @RequestMapping("//")
    public String home(){
        return "home";
    }


    @RequestMapping("/nowplaying")
    public String nowPlaying(Model model){
        List<Movie> movies = getMovies("https://api.themoviedb.org/3/movie/now_playing?api_key=be2a38521a7859c95e2d73c48786e4bb");
        model.addAttribute("movies", movies);
        return "now-playing";
    }

    @RequestMapping("/mediumpopular")
    public String popular(Model model){
        List<Movie> movies = getMovies("https://api.themoviedb.org/3/movie/now_playing?api_key=be2a38521a7859c95e2d73c48786e4bb");
        List<Movie> newMovieList = movies.stream()
                .filter(movie -> movie.getTitle().length() >= 10)
                .filter(movie -> movie.getPopularity() >= 34 && movie.getPopularity() <= 57)
                .collect( Collectors.toList());
        model.addAttribute("movies", newMovieList);
        return "medium-popular-long-name";
    }

}
