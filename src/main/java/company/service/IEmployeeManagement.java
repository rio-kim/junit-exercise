package company.service;

import java.util.List;

/**
 * 직원 정보 관련 모듈 부서와 직원 정보를 관리한다.
 * 
 * @author 김개발
 *
 */
public interface IEmployeeManagement {

	public String getEmployeeName(String empId) throws Exception;

	public List<String> getDepartmentMembers(String deptId);

	public double getSalary(String empId);

}