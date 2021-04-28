package optional;


import CompulsoryLab9.EntityClasses.Genres;
import CompulsoryLab9.EntityClasses.Movies;

public class Main2 {
    AbstractRepository<Genres>genresRepository = new AbstractRepository<>();
    Genres gen1 = genresRepository.create(new Genres((long) 6, "Fantasy"));

    AbstractRepository<Movies>moviesRepository = new AbstractRepository<>();
    Movies movie1 = moviesRepository.findById((long) 1);
}
