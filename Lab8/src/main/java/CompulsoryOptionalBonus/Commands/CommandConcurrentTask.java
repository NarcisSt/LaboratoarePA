package CompulsoryOptionalBonus.Commands;

import CompulsoryOptionalBonus.Database.Connection.ConnectionSource;
import CompulsoryOptionalBonus.Database.DAO.MovieController;
import CompulsoryOptionalBonus.Model.Movie;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CommandConcurrentTask implements Runnable{
    private String name;
    private ConnectionSource connectionSource;

    public CommandConcurrentTask(String name, ConnectionSource connectionSource) {
        this.name = name;
        this.connectionSource = connectionSource;
    }

    @Override
    public void run() {
        Connection connection = connectionSource.getConnection();
        MovieController artistController = new MovieController(connection);

        List<Movie> movies = artistController.findAll();

        System.out.println(name + " retrieved " + movies.size() + " movies from the database!");

        if (connectionSource.getType().equals("connection-pool")) {
            try {
                connection.close();
            } catch (SQLException ignored) {
            }
        }
    }
}
