package company.service.impl;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import company.service.ITaxService;

public class EmployeeManagementImplTest {

	@Test
	public void test_getEmployeeName() throws Exception {

		// Given
		EmployeeManagementImpl employeeManagement = new EmployeeManagementImpl();

		// When
		String result = employeeManagement.getEmployeeName("E_0006");

		// Then
		assertEquals("김유닛", result);

	}

	@Test
	public void test_getDepartmentMembers() throws Exception {

		// Given
		EmployeeManagementImpl employeeManagement = new EmployeeManagementImpl();

		// When
		List<String> result = employeeManagement.getDepartmentMembers("D_0001");

		// Then
		assertThat(result, hasItem(startsWith("김")));

	}

	@Test
	public void test_getSalary() throws Exception {

		// Given
		EmployeeManagementImpl employeeManagement = new EmployeeManagementImpl();

		ITaxService mockTaxService = Mockito.mock(ITaxService.class);
		employeeManagement.setTaxService(mockTaxService);

		// When
		when(mockTaxService.getTaxRate(anyDouble())).thenReturn(0.1);
		double result = employeeManagement.getSalary("E_0005"); // 3400

		// Then
		assertThat(result, is(3060d));

	}

}
