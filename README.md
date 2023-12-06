# mindex-java-challenge
Coding challenge for Mindex :) questions at the bottom!

## planning and other things
First step is to get familiar with the project and how it is organized.

### notes on project structure
- tests will be written in ChallengeApplicationTests.java
- employee_database.json lists the employees we have
- Employee class can be seen in Employee.java
- DataBootstrap.java makes employee objects from the JSON file (saves them in employeeRepository)
- EmployeeService sets up the methods used within EmployeeServiceImpl
  - will likely use a similar structure for ReportingStructure
#
### task 1: make new type
- ReportingStructure
  - employee (type: string) <-- employeeId
    - could be an employee object? will have to try
  - numberOfReports (type: int)

##### general plan:
- ~~grab list of employees from the employee database~~
- ~~loop through list~~
  - ~~if currentEmployee has value directReports:~~
    - ~~save employeeId to temp variable~~
    - ~~save length of directReports array to temp variable~~
      - ~~for each directReport,~~
    - make new ReportingStructure object
      - set employeeId or employee object (based on what is passed in)
      - set num of numberOfReports
- We'll get these numbers based on the number of directReports each employee has
  - employees don't have the directReports value if they have no directReports, so check if directReports exists (if not, numberOfReports = 0)
  - **note: numberOfReports includes direct reports from direct reports (ex: jane has 2 direct report ids, max and leah, leah has 1, so jane has 3)**
- employee data is read from JSON file and objects are created in DataBootstrap.java, so we'd likely create each employees ReportingStructure in that file, as well

#### first: make the class
- There is an employee class, will likely need another class for the reporting structure (since employee class is for type: employee)
- ReportingStructure.java will have getters and setters for the employee value and the numreports value

#### next: make the REST endpoint
- what do we need to be able to do at this endpoint?
  - **read** an existing reporting structure
    - takes an id, returns reporting structure object
    - **note: be sure to check if id is null**
- Files to create:
  - ReportStructureController (similar to EmployeeController)
  - ReportStructureService (similar to EmployeeService)
  - ReportStructureServiceImpl (similar to EmployeeServiceImpl)
#
### task 2: make another new type!
- Compensation
  - employee (object)
  - salary (number/int)
  - effectiveDate (date)
- what do we need to be able to do at this endpoint?
  - **create** a new compensation object
  - **read** the compensation information for a specific employee id
- data at endpoint must persist!
  - we can write compensation data to a compensation.json file (main/resources/static)
#
### other notes:
- ran **gradlew bootRun** several times, program never finishes executing (problem present before editing, makes it to 75%)
  - will have to rely on tests to see if things work ![image](https://github.com/jabwashi2/mindex-java-challenge/assets/76271302/2953f53d-fd1f-45f9-a562-6b31940dd5f0)
- ~~tests randomly could no longer run (this screenshot is from EmployeeServiceImplTest.java)~~ ![image](https://github.com/jabwashi2/mindex-java-challenge/assets/76271302/7e6e0cd4-201f-4d12-bc17-418f55e2a1b7)
  - ~~hoping that tests return the values expected~~
  - **UPDATE**: later found the issue, was missing @Service above CompensationServiceImpl class declaration ![image](https://github.com/jabwashi2/mindex-java-challenge/assets/76271302/c193b7d2-7327-4fe9-a8b7-b330d37dd467)
- issues testing Compensation create (errors when writing to JSON file, would love some feedback/guidance)
  - subsequent issues testing Compensation read (depends on the JSON file)

#
### questions
- how do you all usually structure your projects?
- could we take some time to find out why the program couldn't finish executing?
- what are some things I missed in the final results of this challenge?
- am I expected to make changes to the employee_daabase.json file?
- do you have any advice for writing tests/feedback on the tests I've written?
- was it better to use the employeeId or the employee object for the ReportingStructure?
- how does the EmployeeRepository create new employee objects without being given all of the information?
- where would the value for the salary come from for the Compensation type?
- does DataBootstrap.java need to be updated to read in info from the new Compensation.json file I made?
