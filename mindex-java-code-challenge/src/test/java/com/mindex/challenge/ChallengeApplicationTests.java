package com.mindex.challenge;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ChallengeApplicationTests {

	List<Employee> reportEmps = new ArrayList<Employee>() {};

	@Test
	public void contextLoads() {
		// test reporting structure object
		ReportingStructure report = new ReportingStructure();

		// temporary employee: will have employees in it's reporting structure
		Employee tempEmployee = new Employee();
		String randID = UUID.randomUUID().toString();
		tempEmployee.setEmployeeId(randID);

		// employee in the reporting structure
		Employee repEmployee = new Employee();
		repEmployee.setEmployeeId(UUID.randomUUID().toString());
		reportEmps.add(repEmployee);

		// setting temp employees direct ports
		tempEmployee.setDirectReports(reportEmps);

		// setting reporting structure direct reports
		report.setEmployeeId(tempEmployee.getEmployeeId());
		report.setNumOfReports(tempEmployee.getDirectReports().size());

		// testing that all values are true
		Assertions.assertNotNull(tempEmployee.getEmployeeId());
		Assertions.assertEquals(report.getEmployeeId(), randID);
		Assertions.assertEquals(report.getNumOfReports(), tempEmployee.getDirectReports().size());

	}

}
