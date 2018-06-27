package location;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

import subway.SubwayManager;

public class LocationTest {

	@Test
	public void getCafeList_잠실에_빽다방이_존재하는지_테스트한다() throws Exception {

		// Given
		Location location = new Location();
		String targetCafe = "빽다방";

		// When
		List<String> cafeList = location.getCafeList("잠실");

		// Then
		assertThat(cafeList, hasItem(targetCafe));

	}

	@Test
	public void getCafeList_잠실에_폴바셋이_존재하지_않는지_테스트한다() throws Exception {

		// Given
		Location location = new Location();
		String targetCafe = "폴바셋";

		// When
		List<String> cafeList = location.getCafeList("잠실");

		// Then
		assertThat(cafeList, not(hasItem(targetCafe)));

	}

	@Test
	public void isHotArea_우면이_번화가인지_테스트한다() throws Exception {

		Location location = new Location();

		// Mock 객체 생성
		SubwayManager mockSubwayManager = mock(SubwayManager.class);

		// 정상 반환값 설정
		when(mockSubwayManager.isStationExist("우면")).thenReturn(false);

		// Mock 객체 주입
		location.setSubwayManager(mockSubwayManager);

		// Verify
		boolean is우면HotArea = location.isHotArea("우면");
		assertFalse(is우면HotArea);
		verify(mockSubwayManager).isStationExist("우면"); // 실제 mock객체가 호출되었는지?

	}

	@Test
	public void isHotArea_강남이_번화가인지_테스트한다() throws Exception {

		Location location = new Location();

		// Mock 객체 생성
		SubwayManager mockSubwayManager = mock(SubwayManager.class);

		// 정상 반환값 설정
		when(mockSubwayManager.isStationExist("강남")).thenReturn(true);

		// Mock 객체 주입
		location.setSubwayManager(mockSubwayManager);

		// Verify
		boolean is강남HotArea = location.isHotArea("강남");
		assertTrue(is강남HotArea);
		verify(mockSubwayManager).isStationExist("강남"); // 실제 mock객체가 호출되었는지?

	}

}
