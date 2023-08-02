import java.util.List;

class Main {
    public static void main(String[] args) {

            List<MaxProjectCountClient> maxProjectCountClients = new DatabaseQueryService().findMaxProjectsClient();
            List<MaxSalaryWorker> maxSalaryWorkers = new DatabaseQueryService().findMaxSalaryWorkers();
            List<ProjectPrices> projectPrices = new DatabaseQueryService().printProjectPrices();
            List<YoungestEldestWorkers> youngestEldestWorkers = new DatabaseQueryService().findYoungesEldestWorkers();
            List<LongestCountMonthProjects> longestCountMonthProjects = new DatabaseQueryService().findLongestProject();

            System.out.println("Max Project Count Clients:");
            for (MaxProjectCountClient client : maxProjectCountClients) {
                System.out.println("Name: " + client.getName() + ", Projects count: " + client.getProjectCount());
            }
            System.out.println("Max Salary Workers:");
            for (MaxSalaryWorker worker : maxSalaryWorkers) {
                System.out.println("Name: " + worker.getName() + ", Salary: " + worker.getSalary());
            }
            System.out.println("Project Prices:");
            for (ProjectPrices prices : projectPrices) {
                System.out.println("Name: " + prices.getName() + ", Prices: " + prices.getPrice());
            }
            System.out.println("Eldest & youngest workers:");
            for (YoungestEldestWorkers workerOld : youngestEldestWorkers) {
                System.out.println("Type: " + workerOld.getType() + ", Name: " + workerOld.getName() +
                                    ", Birthday: " + workerOld.getBirthday());
            }
            System.out.println("Longest project:");
            for (LongestCountMonthProjects monthProjects : longestCountMonthProjects) {
                System.out.println("Name: " + monthProjects.getName() + ", Month: " + monthProjects.getMonthCount());
            }

    }



}
