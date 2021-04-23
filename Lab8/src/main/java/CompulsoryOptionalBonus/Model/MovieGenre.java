package CompulsoryOptionalBonus.Model;

public class MovieGenre {
    private int id;
    private int movieId;
    private int genreId;

    public MovieGenre(int id, int movieId, int genreId) {
        this.id = id;
        this.movieId = movieId;
        this.genreId = genreId;
    }

    public int getId() {
        return id;
    }

    public int getMovieId() {
        return movieId;
    }

    public int getGenreId() {
        return genreId;
    }
}
