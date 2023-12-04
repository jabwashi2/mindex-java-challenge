# mindex-java-challenge
Coding challenge for Mindex :)

## planing and other things
First step is to get familiar with the project and how it is organized.

### notes on project structure
- tests will be written in ChallengeApplicationTests.java
- employee_database.json lists the employees we have
- Employee class can be seen in Employee.java
- DataBootstrap.java makes employee objects from the JSON file (saves them in employeeRepository)
- EmployeeService sets up the methods used within EmployeeServiceImpl
  - will likely use a similar structure for ReportingStructure
    - may not need to though

### task 1: make new type
- ReportingStructure
  - employee (type: string) <-- employeeId
  - numberOfReports (type: int)

We'll get these numbers based on the number of directReports each employee has
- employees don't have the directReports value if they have no directReports, so check if directReports exists (if not, numberOfReports = 0)

There is an employee class, will likely need another class for the reporting structure (since employee class is for type: employee)

ReportingStructure.java will have getters and setters for the employee value and the numreports value

Plan:
- grab list of employees from the employee database
- loop through list
  - if currentEmployee has value directReports:
    - save employeeId to temp variable
    - save length of directReports array to temp variable
    - make new ReportingStructure object
      - set employeeId
      - set num of numberOfReports

### other notes:
- ran gradlew bootRun several time, program never finishes executing (problem present before editing)
  - will have to rely on tests to see if things work
 
### questions
- does EmployeeServiceImpl mean 'EmployeeServiceImplement'?
- how do you all usually structure your projects?
- could we take some time to find out why the program couldn't finish executing?
- what are some things I missed in the final results of this challenge?
