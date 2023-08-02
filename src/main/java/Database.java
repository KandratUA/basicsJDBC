import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class Database {
    private static final Database INSTANCE = new Database();
    private Connection connection;
    private boolean isClosed = false;

    private Database() {
        try {
            String connectionUrl = "jdbc:h2:./test";
            this.connection = DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            throw new RuntimeException("Create connection exception");
        }

        // Реєструємо завершення з'єднання під час завершення роботи програми
        Runtime.getRuntime().addShutdownHook(new Thread(() -> closeConnection()));
    }

    public static Database getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        if (isClosed) {
            throw new IllegalStateException("Connection is closed");
        }
        return connection;
    }

    public int executeUpdate(String query) {
        try (Statement statement = INSTANCE.getConnection().createStatement()) {
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeConnection() {
        if (!isClosed) {
            try {
                connection.close();
                isClosed = true;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}