package ru.netology.Afisha;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;
import ru.netology.repository.FilmRepository;


public class AfishaTest {
    FilmRepository repo = new FilmRepository();

    Film film1 = new Film("Film1",1);
    Film film2 = new Film("Film2",2);
    Film film3 = new Film("Film3",3);
    Film film4 = new Film("Film4",4);
    Film film5 = new Film("Film5",5);
    @BeforeEach
    public void setup(){
        repo.save(film1);
        repo.save(film2);
        repo.save(film3);
        repo.save(film4);
        repo.save(film5);
    }

    @Test
    public void shouldSaveNewFilms(){
        Afisha afisha = new Afisha(repo);
        Film[] expected = {film1,film2,film3,film4,film5};
        Film[] actual = afisha.findAll();
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldRemoveById(){
        Afisha afisha = new Afisha(repo);
        afisha.removeById(2);
        Film[] expected = {film1,film3,film4,film5};
        Film[] actual = afisha.findAll();
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldRemoveAllItems(){
        Afisha afisha = new Afisha(repo);
        afisha.removeAll();
        Film[] expected = {};
        Film[] actual = afisha.findAll();
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldFindLast() {
        Afisha afisha = new Afisha(repo, 3);
        afisha.findLast();
        Film[] expected = {film5, film4, film3};
        Film[] actual = afisha.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById(){
        Afisha afisha = new Afisha(repo);
        Film expected = film3;
        Film actual = afisha.findById(3);
        Assertions.assertEquals(expected,actual);
    }
/*    @Test
    public void shouldAddNewFilm() {
        Afisha afisha = new Afisha();
        afisha.add("Film1");
        afisha.add("Film2");
        afisha.add("Film3");

        String[] expected = {"Film1", "Film2", "Film3"};
        String[] actual = afisha.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindLast() {

        Afisha afisha = new Afisha();

        afisha.add("Film1");
        afisha.add("Film2");
        afisha.add("Film3");

        String[] expected = {"Film3", "Film2", "Film1"};
        String[] actual = afisha.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWithLimit() {
        Afisha afisha = new Afisha(2);
        afisha.add("Film1");
        afisha.add("Film2");
        afisha.add("Film3");
        String[] expected = {"Film3", "Film2"};
        String[] actual = afisha.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastAbove10() {
        Afisha afisha = new Afisha();
        //добавление 12 новых фильмов в афишу
        int counter = 1;
        while (counter != 13) {
            afisha.add("Film" + counter);
            counter = counter + 1;
        }
        String[] expected = {"Film12", "Film11", "Film10", "Film9", "Film8", "Film7", "Film6", "Film5", "Film4", "Film3"};
        String[] actual = afisha.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindLastNineFilms() {
        Afisha afisha = new Afisha(9);
        int counter = 1;
        while (counter != 16) {
            afisha.add("Film" + counter);
            counter = counter + 1;
        }
        String[] expected = {"Film15", "Film14", "Film13", "Film12", "Film11", "Film10", "Film9", "Film8", "Film7"};
        String[] actual = afisha.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }*/

}
