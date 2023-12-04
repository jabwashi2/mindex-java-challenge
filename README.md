# mindex-java-challenge
Coding challenge for Mindex :)

## planing and other things
First step is to get familiar with the project and how it is organized.

### notes on project structure
- tests will be written in ChallengeApplicationTests.java
- employee_database.json lists the employees we have
- Employee calss can be seen in Employee.java
- DataBootstrap.java makes employee objects from the JSON file

task 1: make new type
- ReportingStructure
-- employee (type: string) <-- employeeId
-- numberOfReports (type: int)

We'll get these numbers based on the number of directReports each employee has
- employees don't have the directReports value if they have no directReports, so check if directReports exists (if not, numberOfReports = 0)

There is an employee class, will likely need another class for the reporting structure (since employee class is for type: employee)

Notes:
- ran gradlew bootRun several time, program never finishes executing (problem present before editing)
-- will have to rely on tests to see if things work
