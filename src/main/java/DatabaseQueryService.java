import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class DatabaseQueryService {
    private Connection connection;

    public DatabaseQueryService() {
        connection = Database.getInstance().getConnection();
    }

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> result = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            String queryScript = new String(Files.readAllBytes(Paths.get("./sql/find_max_projects_client.sql")));
            ResultSet resultSet = statement.executeQuery(queryScript);

            while (resultSet.next()) {
                MaxProjectCountClient client = new MaxProjectCountClient();
                client.setName(resultSet.getString("NAME"));
                client.setProjectCount(resultSet.getInt("num_projects"));
                result.add(client);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorkers() {
        List<MaxSalaryWorker> result = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            String queryScript = new String(Files.readAllBytes(Paths.get("./sql/find_max_salary_worker.sql")));
            ResultSet resultSet = statement.executeQuery(queryScript);

            while (resultSet.next()) {
                MaxSalaryWorker worker = new MaxSalaryWorker();
                worker.setName(resultSet.getString("NAME"));
                worker.setSalary(resultSet.getInt("SALARY"));
                result.add(worker);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<ProjectPrices> printProjectPrices() {
        List<ProjectPrices> result = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            String queryScript = new String(Files.readAllBytes(Paths.get("./sql/print_project_prices.sql")));
            ResultSet resultSet = statement.executeQuery(queryScript);

            while (resultSet.next()) {
                ProjectPrices prices = new ProjectPrices();
                prices.setName(resultSet.getString("NAME"));
                prices.setPrice(resultSet.getInt("PRICES"));
                result.add(prices);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    public List<YoungestEldestWorkers> findYoungesEldestWorkers() {
        List<YoungestEldestWorkers> result = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            String queryScript = new String(Files.readAllBytes(Paths.get("./sql/find_youngest_eldest_workers.sql")));
            ResultSet resultSet = statement.executeQuery(queryScript);

            while (resultSet.next()) {
                YoungestEldestWorkers workersOld = new YoungestEldestWorkers();
                workersOld.setType(resultSet.getString("TYPE"));
                workersOld.setName(resultSet.getString("NAME"));
                workersOld.setBirthday(resultSet.getDate("BIRTHDAY"));
                result.add(workersOld);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    public List<LongestCountMonthProjects> findLongestProject() {
        List<LongestCountMonthProjects> result = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            String queryScript = new String(Files.readAllBytes(Paths.get("./sql/find_longest_project")));
            ResultSet resultSet = statement.executeQuery(queryScript);

            while (resultSet.next()) {
                LongestCountMonthProjects countMonth = new LongestCountMonthProjects();
                countMonth.setName(resultSet.getString("NAME"));
                countMonth.setMonthCount(resultSet.getInt("monthCount"));
                result.add(countMonth);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
