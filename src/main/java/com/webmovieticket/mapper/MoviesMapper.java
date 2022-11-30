package com.webmovieticket.mapper;

import com.webmovieticket.dto.MoviesDTO;
import com.webmovieticket.models.Movies;
import com.webmovieticket.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MoviesMapper {
    public MoviesDTO toDto(Movies movies) {
        MoviesDTO result = new MoviesDTO();
        if (movies.getId() != null) {
            result.setId(movies.getId());
        }

        if (movies.getCreatedAt() != null) {
            result.setCreatedAt(movies.getCreatedAt());
        }

        if (movies.getDeletedAt() != null) {
            result.setDeletedAt(movies.getDeletedAt());
        }

        if (movies.getIsPresent() != null) {
            result.setIsPresent(movies.getIsPresent());
        }

        if (movies.getName() != null) {
            result.setName(movies.getName());
        }

        if (movies.getImage() != null) {
            result.setImage(movies.getImage());
        }

        if (movies.getRating() != null) {
            result.setRating(movies.getRating());
        }

        if (movies.getCast() != null) {
            result.setCast(movies.getCast());
        }

        if (movies.getDirector() != null) {
            result.setDirector(movies.getDirector());
        }

        if (movies.getMusic() != null) {
            result.setMusic(movies.getMusic());
        }

        if (movies.getDescription() != null) {
            result.setDescription(movies.getDescription());
        }

        if (movies.getLang() != null) {
            result.setLang(movies.getLang());
        }

        if (movies.getTrailerUrl() != null) {
            result.setTrailerUrl(movies.getTrailerUrl());
        }

        if (movies.getCategory() != null) {
            result.setCategory(movies.getCategory());
        }

        if (movies.getDebut() != null) {
            result.setDebut(movies.getDebut());
        }

        if (movies.getLanguage() != null) {
            result.setLanguage(movies.getLanguage());
        }

        if (movies.getMovieDuration() != null) {
            result.setMovieDuration(movies.getMovieDuration());
        }

        return result;
    }

    public Movies toEntity(MoviesDTO moviesDTO) {
        Movies result = new Movies();

        if (moviesDTO.getCreatedAt() != null) {
            result.setCreatedAt(moviesDTO.getCreatedAt());
        }

        if (moviesDTO.getDeletedAt() != null) {
            result.setDeletedAt(moviesDTO.getDeletedAt());
        }

        if (moviesDTO.getIsPresent() != null) {
            result.setIsPresent(moviesDTO.getIsPresent());
        }

        if (moviesDTO.getName() != null) {
            result.setName(moviesDTO.getName());
        }

        if (moviesDTO.getImage() != null) {
            result.setImage(moviesDTO.getImage());
        }

        if (moviesDTO.getRating() != null) {
            result.setRating(moviesDTO.getRating());
        }

        if (moviesDTO.getCast() != null) {
            result.setCast(moviesDTO.getCast());
        }

        if (moviesDTO.getDirector() != null) {
            result.setDirector(moviesDTO.getDirector());
        }

        if (moviesDTO.getMusic() != null) {
            result.setMusic(moviesDTO.getMusic());
        }

        if (moviesDTO.getDescription() != null) {
            result.setDescription(moviesDTO.getDescription());
        }

        if (moviesDTO.getLang() != null) {
            result.setLang(moviesDTO.getLang());
        }

        if (moviesDTO.getTrailerUrl() != null) {
            result.setTrailerUrl(moviesDTO.getTrailerUrl());
        }

        if (moviesDTO.getCategory() != null) {
            result.setCategory(moviesDTO.getCategory());
        }

        if (moviesDTO.getDebut() != null) {
            result.setDebut(moviesDTO.getDebut());
        }

        if (moviesDTO.getLanguage() != null) {
            result.setLanguage(moviesDTO.getLanguage());
        }

        if (moviesDTO.getMovieDuration() != null) {
            result.setMovieDuration(moviesDTO.getMovieDuration());
        }

        return result;
    }

    public Movies update(Movies oldMovies, Movies newMovies) {

        if (newMovies.getCreatedAt() != null) {
            oldMovies.setCreatedAt(newMovies.getCreatedAt());
        }

        if (newMovies.getDeletedAt() != null) {
            oldMovies.setDeletedAt(newMovies.getDeletedAt());
        }

        if (newMovies.getIsPresent() != null) {
            oldMovies.setIsPresent(newMovies.getIsPresent());
        }

        if (newMovies.getName() != null) {
            oldMovies.setName(newMovies.getName());
        }

        if (newMovies.getImage() != null) {
            oldMovies.setImage(newMovies.getImage());
        }

        if (newMovies.getRating() != null) {
            oldMovies.setRating(newMovies.getRating());
        }

        if (newMovies.getCast() != null) {
            oldMovies.setCast(newMovies.getCast());
        }

        if (newMovies.getDirector() != null) {
            oldMovies.setDirector(newMovies.getDirector());
        }

        if (newMovies.getMusic() != null) {
            oldMovies.setMusic(newMovies.getMusic());
        }

        if (newMovies.getDescription() != null) {
            oldMovies.setDescription(newMovies.getDescription());
        }

        if (newMovies.getLang() != null) {
            oldMovies.setLang(newMovies.getLang());
        }

        if (newMovies.getTrailerUrl() != null) {
            oldMovies.setTrailerUrl(newMovies.getTrailerUrl());
        }

        if (newMovies.getCategory() != null) {
            oldMovies.setCategory(newMovies.getCategory());
        }

        if (newMovies.getDebut() != null) {
            oldMovies.setDebut(newMovies.getDebut());
        }

        if (newMovies.getLanguage() != null) {
            oldMovies.setLanguage(newMovies.getLanguage());
        }

        if (newMovies.getMovieDuration() != null) {
            oldMovies.setMovieDuration(newMovies.getMovieDuration());
        }

        return oldMovies;
    }
}