package company.service;

/**
 * <pre>
 * 세금 관련 모듈
 * TODO 다음달 말에 개발 예정임.
 * 김개발 선임 요청으로 인터페이스만 정의한 상태.
 * </pre>
 * 
 * @author 박다름
 */
public interface ITaxService {

	/**
	 * <pre>
	 * 입력된 연봉에 맞는 세금구간을 적용하여 세금이 반영된 연봉을 반환한다.
	 * 
	 * 2017년 현재 소득구간별 세율 정보
	 * 1억원 이하 7천만원 초과 : 35%
	 * 7천만원 이하 4천만원 초과 : 20%
	 * 4천만원 이하 2천만원 초과 : 10%
	 * 2천만원 이하 : 5%
	 * </pre>
	 */
	public double getTaxRate(double preTaxedSalary);

}
