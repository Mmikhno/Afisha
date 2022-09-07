package ru.netology.Afisha;

public class Afisha {

    private String[] films = new String[0];
    private int limit;

    public Afisha() {
        this.limit = 10;
    }

    public Afisha(int limit) {
        this.limit = limit;
    }

    public void add(String newFilm) {

        String[] tmp = new String[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[tmp.length - 1] = newFilm;
        films = tmp;
    }

    public String[] findAll() {
        return films;
    }

    public String[] findLast() {
        int len;
        if (films.length < limit) {
            len = films.length;
        } else {
            len = limit;
        }
        String[] revItems = new String[len]; //массив для ответов
        for (int i = 0; i < revItems.length; i++) {
            revItems[i] = films[films.length - 1 - i];
        }
        return revItems;
    }


}
