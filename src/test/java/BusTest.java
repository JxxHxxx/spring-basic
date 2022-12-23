import org.domain.Bus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.domain.BusStatus.*;

public class BusTest {

    @DisplayName("Bus 객체의 ID는 유일한 값이여야 합니다.")
    @Test
    void uniqueId() {
        Bus bus1 = new Bus();
        Bus bus2 = new Bus();
        Bus bus3 = new Bus();

        Assertions.assertTrue(bus1.getId() != bus2.getId());
        Assertions.assertTrue(bus3.getId() == 2L);
    }

    @DisplayName("Bus 객체 생성 시, 상태의 초기화 값은 운행입니다.")
    @Test
    void isRunning() {
        Bus bus = new Bus();

        Assertions.assertTrue(bus.getStatus().equals(RUNNING));
    }

    @DisplayName("Bus 객체 생성 시, 초기값 승객 0 속도 0 주유량 100 요금 1000")
    @Test
    void initValid() {
        Bus bus = new Bus();

        Assertions.assertEquals(bus.getPassenger(), 0);
        Assertions.assertEquals(bus.getSpeed(), 0);
        Assertions.assertEquals(bus.getGasAmount(), 100);

    }
}
