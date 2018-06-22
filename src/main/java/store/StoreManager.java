package store;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StoreManager {

	/**
	 * <pre>
	 * "잠실": "빽다방", "스타벅스", "롤링핀", "투썸플레이스", "탐앤탐스", "쥬씨"
	 * "강남": "스타벅스", "파리크라상", "투썸플레이스", "탐앤탐스", "폴바셋"
	 * "우면": "토다", "쥬씨"
	 * </pre>
	 */

	public List<String> getCafeList(String location) {

		if ("잠실".equals(location)) {
			return Arrays.asList("빽다방", "스타벅스", "롤링핀", "투썸플레이스", "탐앤탐스", "쥬씨");
		}

		if ("강남".equals(location)) {
			return Arrays.asList("스타벅스", "파리크라상", "투썸플레이스", "탐앤탐스", "폴바셋");
		}

		if ("우면".equals(location)) {
			return Arrays.asList("토다", "쥬씨");
		}

		return Collections.emptyList();
	}

}
