package net.sahet.vatinfo.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sahet.vatinfo.domain.mongo.Movie;
import net.sahet.vatinfo.service.MovieService;

public class MovieResource {

    @Autowired
    private MovieService movieService;

    @ResponseBody
    @RequestMapping(value = "/getMovies", method = RequestMethod.GET)
    public List<Movie> getMovies(@RequestParam(name = "name") String name) {
        // movieService.getMovie(movie);
        // TODO impl
        return null;

    }

    @ResponseBody
    @RequestMapping(value = "/insertMovie", method = RequestMethod.POST)
    public String isertMovie(Movie movie) {

        movie.setId(23L);
        movie.setName("Aygytly Adim");
        movie.setActors(Arrays.asList("Eziz han - Muhammet Çerkezow", "Artyk - Baba Annanow",
                "Aýna - Žanna Smelýanskaýa", "Mawy - Hommat Müllük", "Alty Garlyýew", "Aşyr - Artyk Jallyýew",
                "Pökgi bala - Akmyrat Bäşimow", "Bally - Aleksandr Ýakubow"));
        movie.setSazy(" Nury Halmämmedow ");

        /*
         * 
         * [ { "_id" : ObjectId("55b5ffa5511fee0e45ed614b"), "_class" :
         * "org.baeldung.model.User", "name" : "Alex" }, { "_id" :
         * ObjectId("55b5ffa5511fee0e45ed614c"), "_class" : "org.baeldung.model.User",
         * "name" : "Alex" } ]
         * 
         */

        /**
         * { "_id" : ObjectId("55b4fda5830b550a8c2ca25a"), "_class" :
         * "org.baeldung.model.User", "name" : "Jon" }
         */

        movieService.insert(movie);
        // TODO
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/updateMovie", method = RequestMethod.POST)
    public String updateMovie(Movie movie) {
        movieService.save(movie);
        // TODO
        return null;
    }

}
