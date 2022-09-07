package ru.netology.Afisha;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AfishaTest {

    @Test
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

    }

}
