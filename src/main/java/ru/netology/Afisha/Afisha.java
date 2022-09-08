package ru.netology.Afisha;

import ru.netology.domain.Film;
import ru.netology.repository.FilmRepository;

public class Afisha {

    private FilmRepository repo = new FilmRepository();
    private int limit;

    public Afisha(FilmRepository repo){
        this.repo = repo;
        this.limit = 10;
    }
    public Afisha(FilmRepository repo, int limit){
        this.repo = repo;
        this.limit = limit;
    }
    public int getLimit(){
        return limit;
    }
    public void setLimit(){
        this.limit = limit;
    }
    public void save(Film newItem){
        repo.save(newItem);
    }
    public Film[] findAll(){
        return repo.findAll();
    }
    public void removeById(int id){
        repo.removeById(id);
    }
    public Film findById(int id){
        return repo.findById(id);
    }

    public void removeAll(){
        repo.removeAll();
    }
    public Film[] findLast(){
        int len;
        Film[] films = repo.findAll();
        if(films.length < limit){
            len = films.length;
        }else{
            len = limit;
        }
        Film[] revItems = new Film[len];

        for(int i = 0;i < revItems.length;i++){
            revItems[i]=films[films.length-1-i];
        }
        return revItems;
    }

  /*  /// старые методы
   // public void add(String newFilm) {

     //   String[] tmp = new String[films.length + 1];
     //   for (int i = 0; i < films.length; i++) {
      //      tmp[i] = films[i];
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
    }*/


}
