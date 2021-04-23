package CompulsoryOptionalBonus.Database.Connection;

import java.sql.Connection;

public class ConnectionSourceSingleton implements ConnectionSource{
    @Override
    public Connection getConnection() {
        return Database.getInstance().getConnection();
    }

    @Override
    public String getType() {
        return "singleton";
    }
}
