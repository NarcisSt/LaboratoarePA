package CompulsoryOptionalBonus.Database.DAO;

import CompulsoryOptionalBonus.Database.Connection.Database;
import CompulsoryOptionalBonus.Exceptions.GenreCreationFailedException;
import CompulsoryOptionalBonus.Model.Genre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreController {
    private Connection connection;

    public GenreController(Connection connection) {
        this.connection = connection;
    }

    public GenreController(Database database) {
        connection = database.getConnection();
    }

    /**
     * Method that will create a new genre
     * @param name
     * @return
     * @throws GenreCreationFailedException
     */
    public Genre create(String name) throws GenreCreationFailedException {
        int id = createDB(name);
        if (id == -1) {
            throw new GenreCreationFailedException(name);
        }
        return new Genre(id, name);
    }

    public List<Genre> findAll() {
        return findAllDB();
    }

    public List<Genre> findByMovieId(int movieId) {
        return findByMovieIdDB(movieId);
    }

    /**
     * Method that returns a list of genres, each of them having movies_id = 'artistId'
     * @param movieId
     * @return
     */
    private List<Genre> findByMovieIdDB(int movieId) {
        String query = "SELECT * FROM genres WHERE movies_id = " + movieId;
        return findByQuery(query);
    }

    /**
     * Method that returns a list that contains all the genres from the database
     * @return
     */
    private List<Genre> findAllDB() {
        String query = "SELECT * FROM genres";
        return findByQuery(query);
    }

    /**
     * Method that returns a list of albums from the database
     * @param query
     * @return
     */
    private List<Genre> findByQuery(String query) {
        List<Genre> genres = new ArrayList<>();
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            if (resultSet != null) {
                while (resultSet.next()) {
                    Genre genre = new Genre(resultSet.getInt("id"), resultSet.getString("name"));
                    genres.add(genre);
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
            return genres;
        }
    }

    /**
     * Method that inserts a new genre in the database
     * @param name
     * @return its id
     */
    private int createDB(String name) {
        int id = -1;
        String query = "INSERT INTO genres (name) VALUES (?)";
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, name);

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
