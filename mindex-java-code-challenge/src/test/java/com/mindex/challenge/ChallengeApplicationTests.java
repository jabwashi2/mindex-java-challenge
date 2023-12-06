package com.mindex.challenge;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.service.ReportingStructureService;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ChallengeApplicationTests {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ReportingStructureService reportingStructureService;

	@Autowired
	private CompensationService compService;

	@Test
	public void contextLoads() {

		// test reporting structure creation
		// see if reporting structure equals 4 for id "16a596ae-edd3-4847-99fe-c4518e82c86f"
		ReportingStructure testReport = new ReportingStructure();

		// id 1
		Employee test1 = employeeRepository.findByEmployeeId("16a596ae-edd3-4847-99fe-c4518e82c86f");
		assertNotNull(test1);

		testReport = reportingStructureService.read(test1.getEmployeeId());
		Assertions.assertEquals(4, testReport.getNumOfReports());

		// test compensation creation
		// see if comp object not null on create
		// see if comp object not null on read
		// compare passed in employee object to comp.employee
		Compensation testComp = new Compensation();
		testComp = compService.create(test1); // struggling to access JSON file, can get feedback/assistance (commented out file writing code in CompensationServiceImpl.java)
		assertNotNull(testComp.getEmployee());

		// can't test read due to file reading problems :(
	}
}
