package com.mindex.challenge;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.mindex.challenge.controller.ReportingStructureController;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ChallengeApplicationTests {

	List<Employee> reportEmps = new ArrayList<Employee>() {};
	private String structureIdUrl;

	@LocalServerPort
    private int port;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ReportingStructureService reportingStructureService;

	@Autowired
    private TestRestTemplate restTemplate;

	private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureController.class);

	@Before
	public void setup(){
		structureIdUrl = "http://localhost:" + port + "/reportingStructure/{id}";
	}

	@Test
	public void contextLoads() {

		Employee employee = employeeRepository.findByEmployeeId("16a596ae-edd3-4847-99fe-c4518e82c86f");
		Assertions.assertNotNull(employee.getEmployeeId());

		ReportingStructure empReport = restTemplate.getForEntity(structureIdUrl, ReportingStructure.class, employee.getEmployeeId()).getBody();

		Assertions.assertNotNull(empReport.getNumOfReports());
	}

}
