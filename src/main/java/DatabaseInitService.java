import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

class DatabaseInitService {

    public static void main(String[] args) {
        try (Connection connection = Database.getInstance().getConnection();
             Statement statement = connection.createStatement()) {

            String sqlScript = new String(Files.readAllBytes(Paths.get("./sql/init_db.sql")));
            String[] sqlCommands = sqlScript.split(";");

            for (String sqlCommand : sqlCommands) {
                statement.executeUpdate(sqlCommand);
            }

            System.out.println("Database initialized successfully.");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
