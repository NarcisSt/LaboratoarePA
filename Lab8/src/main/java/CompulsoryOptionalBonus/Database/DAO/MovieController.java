package CompulsoryOptionalBonus.Database.DAO;

import CompulsoryOptionalBonus.Database.Connection.Database;
import CompulsoryOptionalBonus.Exceptions.MovieCreationFailedException;
import CompulsoryOptionalBonus.Exceptions.MovieNotFoundException;
import CompulsoryOptionalBonus.Model.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieController {
    private Connection connection;

    public MovieController(Connection connection) {
        this.connection = connection;
    }

    public MovieController(Database database) {
        connection = database.getConnection();
    }

    public static Movie create(String title, int releaseYear, int duration, int score) throws MovieCreationFailedException {
        int id = createDB(title, releaseYear, duration, score);
        if (id == -1) {
            throw new MovieCreationFailedException(title, releaseYear);
        }
        return new Movie(id, title, releaseYear, duration, score);
    }

    public List<Movie> findAll() {
        return findAllDB();
    }

    public Movie findByTitle(String title) throws MovieNotFoundException {
        Movie movie = findByTitleDB(title);
        if (movie == null) {
            throw new MovieNotFoundException(title);
        }
        return movie;
    }

    /**
     * Method that returns the movie wit the title = 'title'
     * @param title
     * @return
     */
    private Movie findByTitleDB(String title) {
        Movie movie = null;
        String query = "SELECT * FROM movies WHERE UPPER(title) = UPPER(?)";
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, title);

            resultSet = preparedStatement.executeQuery();
            if (resultSet != null && resultSet.next()) {
                movie = new Movie(resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getInt("release_year"),
                        resultSet.getInt("duration"),
                        resultSet.getInt("score"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException ignored) {
            }
            return movie;
        }
    }


    /**
     * Method that returns all movies from the database
     * @return
     */
    private List<Movie> findAllDB() {
        List<Movie> movies = new ArrayList<>();
        String query = "SELECT * FROM movies";
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            if (resultSet != null) {
                while (resultSet.next()) {
                    Movie movie = new Movie(resultSet.getInt("id"),
                            resultSet.getString("title"),
                            resultSet.getInt("release_year"),
                            resultSet.getInt("duration"),
                            resultSet.getInt("score"));
                    movies.add(movie);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ignored) {

            }
            return movies;
        }
    }

    /**
     * Method that inserts a movie in the database
     * @param title
     * @param releaseYear
     * @param duration
     * @param score
     * @return
     */
    private int createDB(String title, int releaseYear, int duration, int score) {
        int id = -1;
        String query = "INSERT INTO movies (title, release_year, duration, score) VALUES (?, ?, ?, ?)";
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, title);
            preparedStatement.setInt(2, releaseYear);
            preparedStatement.setInt(3, duration);
            preparedStatement.setInt(4, score);

            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet != null && resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException ignored) {

            }
            return id;
        }
    }
}
