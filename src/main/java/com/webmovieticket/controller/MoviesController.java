package com.webmovieticket.controller;

import com.webmovieticket.dto.MoviesDTO;
import com.webmovieticket.models.Movies;
import com.webmovieticket.repository.MoviesRepository;
import com.webmovieticket.service.MoviesService;
import io.prometheus.client.Gauge;
import io.prometheus.client.Histogram;
import io.prometheus.client.Summary;
import io.prometheus.client.Counter;
import io.prometheus.metrics.model.snapshots.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static java.lang.String.valueOf;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "test/movies")
public class MoviesController {
    @Autowired
    private MoviesService moviesService;

    @Autowired
    private MoviesRepository moviesRepository;

    @Autowired
    private Counter restApiCounter;

    @Autowired
    private Gauge restApiGauge;

    @Autowired
    private Histogram restApiHistogram;

    @Autowired
    private Summary restApiSummary;
    @Autowired Counter httpExceptionCounter;

//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ResponseEntity<Object> handleException(Exception ex, WebRequest request) {
//        HttpServletRequest requests = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        // Extract method, path, and status
//        String method = requests.getMethod();
//        String path = requests.getRequestURI();
//        httpExceptionCounter.labels(method, path).inc();
//        return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @GetMapping("")
    public List<MoviesDTO> getAllMovies() {
        return moviesService.findAll();
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        // Extract method, path, and status
//        String method = request.getMethod();
//        String path = request.getRequestURI();
//        int status = HttpServletResponse.SC_OK;
//        restApiCounter.labels(method, path, valueOf(status)).inc();
////        restApiGauge.set(1024);
//        Histogram.Timer start = restApiHistogram. labels(method, path, valueOf(status)).startTimer();
//        try {
//            return moviesService.findAll();
//        } finally {
//            start.observeDuration();
//        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMoviesById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(moviesService.findById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("can not found film by id: " + id);
        }
    }

//    Đưa ra Top Movies có rating cao nhất
    @GetMapping("/toprating")
    public List<MoviesDTO> getMoviesByRating(@RequestParam(defaultValue = "5") int ratingSize) {
        return moviesService.findByRating(ratingSize);
    }

    @PostMapping("")
    public ResponseEntity<?> insertMovies(@RequestBody Movies movies) {
//        Không được thêm 2 phim có tên trùng nhau
        if (moviesRepository.findByName(movies.getName()) == null) {
            return ResponseEntity.status(HttpStatus.OK).body(moviesService.insert(movies));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("film is exist!");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMovies(@PathVariable Long id, @RequestBody Movies movies) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(moviesService.update(id, movies));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("can not found film by id: " + id);
        }
    }

    @DeleteMapping("")
    public ResponseEntity<?> delete(@RequestBody Long[] ids) {
        try {
            moviesService.delete(ids);
            return ResponseEntity.status(HttpStatus.OK).body("Delete success!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id film is not exist!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        try {
            moviesService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Delete success!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id film is not exist!");
        }
    }
}
