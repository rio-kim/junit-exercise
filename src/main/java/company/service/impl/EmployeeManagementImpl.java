package company.service.impl;

import java.util.ArrayList;
import java.util.List;

import company.service.IEmployeeManagement;
import company.service.ITaxService;
import company.vo.Employee;

public class EmployeeManagementImpl implements IEmployeeManagement {

	// 부서와 직원간의 관계를 나타내는 DAO
	private DepartmentEmployeeDao dao;

	// 세금 관련 모듈
	private ITaxService taxService = null;

	public EmployeeManagementImpl() {
		dao = new DepartmentEmployeeDao();
	}

	/**
	 * 세금 관련 모듈을 설정하는 setter 메서드
	 */
	public void setTaxService(ITaxService taxService) {
		this.taxService = taxService;
	}

	/**
	 * 직원 아이디(empId)를 사용하여 전체 부서에서 해당하는 직원의 이름을 반환한다.
	 */
	// TODO Sample Method 1 (using BDD)
	public String getEmployeeName(String empId) {
		Employee emp = dao.getEmployee(empId);

		if (emp == null) {
			// 같은 ID를 가지는 직원이 없는 경우 예외 발생.
			throw new RuntimeException("There is no employee who has id : " + empId);
		}

		return emp.getName();
	}

	/**
	 * 부서 아이디(deptId)를 사용하여 해당 부서에 있는 모든 직원의 이름을 List로 반환한다.
	 */
	// TODO Sample Method 2 (using BDD and Hamcrest)
	@Override
	public List<String> getDepartmentMembers(String deptId) {
		// 조회된 부서에 있는 모든 직원의 이름을 List에 모아서 반환한다.
		List<Employee> employees = dao.getEmployeesIn(deptId);

		List<String> employeeNameList = new ArrayList<String>();
		for (Employee employee : employees) {
			employeeNameList.add(employee.getName());
		}

		return employeeNameList;
	}

	/**
	 * <pre>
	 * 직원의 아이디(empId)를 사용하여 해당하는 직원의 연봉을 조회한다.
	 * 반환된 연봉은 세금이 반영된 결과임.
	 * </pre>
	 */
	// TODO Sample Method 3 (using BDD, Hamcrest and Mocking)
	@Override
	public double getSalary(String empId) {
		// 해당 ID를 가지는 임직원을 찾아서
		Employee emp = dao.getEmployee(empId);

		// 같은 ID를 가지는 직원이 없는 경우 예외 발생.
		if (emp == null) {
			throw new RuntimeException("There is no employee who has id : " + empId);
		}

		double preTaxSalary = emp.getSalary(); // 세전 연봉을 조회한 뒤
		double taxRate = taxService.getTaxRate(preTaxSalary); // 해당 연봉에 적용되는 세율을 taxService에서 조회해서

		return preTaxSalary * (1.0 - taxRate); // 해당 세율을 적용한 세후 연봉을 반환한다.
	}

}
