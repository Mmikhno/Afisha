package ru.netology.Afisha;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.Film;
import ru.netology.repository.FilmRepository;
import static org.mockito.Mockito.*;

public class AfishaMockTest {

    FilmRepository repo = Mockito.mock(FilmRepository.class); //Заглушка для репозитория
    Afisha afisha = new Afisha(repo);

    Film film1 = new Film("Film1",1);
    Film film2 = new Film("Film2",2);
    Film film3 = new Film("Film3",3);
    Film film4 = new Film("Film4",4);
    Film film5 = new Film("Film5",5);

    @Test
    public void shouldFindLast() {

        Film[] films = {film1,film2,film3,film4,film5};
        doReturn(films).when(repo).findAll();
        Film[] expected = {film5, film4, film3,film2,film1};
        Film[] actual = afisha.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
}
