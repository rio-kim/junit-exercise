package company.service.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import company.vo.Department;
import company.vo.Employee;

public class DepartmentEmployeeDao {

	// 부서와 직원간의 관계를 나타내는 Map
	private Map<Department, List<Employee>> departmentEmployeesMap = new HashMap<Department, List<Employee>>();

	public DepartmentEmployeeDao() {
		this.setDepartmentMember();
	}

	/**
	 * deptId로 Department를 조회한다.
	 */
	public Department getDepartment(String deptId) {
		for (Department department : departmentEmployeesMap.keySet()) {
			if (department.getId().equals(deptId)) {
				return department;
			}
		}
		return null;
	}

	/**
	 * empId로 Employee를 조회한다.
	 */
	public Employee getEmployee(String empId) {
		for (Department department : departmentEmployeesMap.keySet()) { // 각 부서에 있는
			for (Employee employee : departmentEmployeesMap.get(department)) { // 모든 직원들 중에
				if (employee.getId().equals(empId)) { // ID를 비교해서 같은 ID가 있으면 이름을 반환한다.
					return employee;
				}
			}
		}
		return null;
	}

	/**
	 * deptId에 해당하는 Department에 속한 Employee의 목록을 조회한다.
	 */
	public List<Employee> getEmployeesIn(String deptId) {
		for (Department department : departmentEmployeesMap.keySet()) {
			if (department.getId().equals(deptId)) {
				return departmentEmployeesMap.get(department);
			}
		}
		return Collections.emptyList();
	}

	/**
	 * 기본 데이터를 생성함
	 */
	private void setDepartmentMember() {

		Department dept1 = new Department("화면개발그룹", "D_0001");

		Employee emp1 = new Employee("김자바", "E_0001");
		emp1.setSalary(5500.0);

		Employee emp2 = new Employee("조유이", "E_0002");
		emp2.setSalary(4300.0);

		departmentEmployeesMap.put(dept1, Arrays.asList(emp1, emp2));

		Department dept2 = new Department("아키텍쳐그룹", "D_0002");

		Employee emp3 = new Employee("이구조", "E_0003");
		emp3.setSalary(5200.0);

		Employee emp4 = new Employee("박맞춤", "E_0004");
		emp4.setSalary(4700.0);

		Employee emp5 = new Employee("김위치", "E_0005");
		emp5.setSalary(3400.0);

		departmentEmployeesMap.put(dept2, Arrays.asList(emp3, emp4, emp5));

		Department dept3 = new Department("테스트그룹", "D_0003");

		Employee emp6 = new Employee("김유닛", "E_0006");
		emp6.setSalary(7300.0);

		Employee emp7 = new Employee("윤자동", "E_0007");
		emp7.setSalary(5200.0);

		Employee emp8 = new Employee("조시험", "E_0008");
		emp8.setSalary(1900.0);

		departmentEmployeesMap.put(dept3, Arrays.asList(emp6, emp7, emp8));

	}

}
