package CompulsoryLab9;

import CompulsoryLab9.EntityClasses.Genres;
import CompulsoryLab9.EntityClasses.Movies;
import CompulsoryLab9.RepoClasses.GenresRepo;
import CompulsoryLab9.RepoClasses.MoviesRepo;

import java.sql.Date;

public class MainLab9 {
    public static void main(String[] args) {
        MoviesRepo moviesRepo = new MoviesRepo();
        Movies movie1 = new Movies((long)1, "Miami Beach", (long)90, (long)7);
        movie1.setReleaseDate(new Date(System.currentTimeMillis()));
        moviesRepo.create(movie1);

        GenresRepo genresRepo = new GenresRepo();
        Genres genre1 = new Genres((long)1, "Action");
        Genres genre2 = new Genres((long)2, "Comedy");
        Genres genre3 = new Genres((long)3, "Thriller");
        genresRepo.create(genre1);
        genresRepo.create(genre2);
        genresRepo.create(genre3);

        System.out.println(moviesRepo.findMovieByName("Miami Beach"));
        System.out.println(moviesRepo.findMovieById((long)1));


    }
}
