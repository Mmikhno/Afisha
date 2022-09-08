package ru.netology.repository;

import ru.netology.domain.Film;

public class FilmRepository {
    Film[] films = new Film[0];
    public void save(Film newItem) {
        Film[] tmp = new Film[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[tmp.length - 1] = newItem;
        films = tmp;
    }
    public Film[] findAll() {
        return films;
    }
    public void removeById(int id) {
        Film[] tmp = new Film[films.length - 1];
        int index = 0;
        for (Film film : films) {
            if (film.getId() != id) {
                tmp[index] = film;
                index = index + 1;
            }
        }
        films = tmp;
    }
    public void removeAll() {
        Film[] tmp = new Film[0];
        films = tmp;
    }
    public Film findById(int id) {
        Film result = null;
        for (Film film : films) {
            if (film.getId() == id) {
                result = film;
            }
        }
        return result;
    }
}
