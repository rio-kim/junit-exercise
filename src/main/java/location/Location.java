package location;

import java.util.List;

import store.StoreManager;
import subway.SubwayManager;

public class Location {

	private SubwayManager subwayManager;

	public Location() {
		this.subwayManager = new SubwayManager();
	}

	public void setSubwayManager(SubwayManager subwayManager) {
		this.subwayManager = subwayManager;
	}

	/**
	 * 해당 지역에 있는 모든 카페 이름의 목록을 반환한다.
	 */
	public List<String> getCafeList(String location) {
		StoreManager manager = new StoreManager();
		return manager.getCafeList(location);
	}

	/**
	 * <pre>
	 * 해당 지역이 번화가인지 여부를 반환한다.
	 * 기준은 지하철 역이 있는지 여부와 카페가 3개이상 있는지 여부이다.
	 * 현재 isStationExist 메서드는 미구현 상태이다.
	 * </pre>
	 */
	public boolean isHotArea(String location) {
		StoreManager manager = new StoreManager();
		return (subwayManager.isStationExist(location)) && (manager.getCafeList(location).size() >= 3);
	}

}