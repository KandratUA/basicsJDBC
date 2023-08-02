SELECT
    client.NAME AS NAME,
    SUM(worker.SALARY * (DATEDIFF('MONTH', project.START_DATE, project.FINISH_DATE) + 1)) AS PRICES
FROM
    project
JOIN
    project_worker ON project.ID = project_worker.PROJECT_ID
JOIN
    worker ON project_worker.WORKER_ID = worker.ID
JOIN
    client ON project.CLIENT_ID = client.ID
GROUP BY
    project.ID, client.NAME
ORDER BY
    PRICES DESC

