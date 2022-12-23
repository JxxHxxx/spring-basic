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

        Assertions.assertTrue(bus1.getId() != bus2.getId());

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

    @DisplayName("주유량 10 미만일 경우 운행 상태는 REST 입니다.")
    @Test
    void ifGasLowerThan10() {
        Bus bus = new Bus();
        bus.setGasAmount(5);
        bus.run();
        Assertions.assertTrue(bus.getStatus().equals(REST));
    }

    @DisplayName("주유량 10 이상일 경우 운행 상태는 RUNNING 입니다.")
    @Test
    void ifGasOver10() {
        Bus bus = new Bus();
        bus.run();
        Assertions.assertTrue(bus.getStatus().equals(RUNNING));
    }

    @DisplayName("버스에 탑승하면 탑승객만큼 탑승자 수가 증가합니다.")
    @Test
    void ifRide() {
        Bus bus = new Bus();
        bus.ride(5);
        Assertions.assertEquals(bus.getPassenger(), 5);
    }

    @DisplayName("버스 탑승객이 30명을 넘을 경우 탑승객의 변화가 발생하지 않습니다.")
    @Test
    void ifPassengerMoreThan30() {
        Bus bus = new Bus();
        bus.ride(25);
        Assertions.assertEquals(bus.getPassenger(), 25);
        bus.ride(6);
        Assertions.assertEquals(bus.getPassenger(), 25);
    }

    @DisplayName("차고지행인 버스에는 탑승할 수 없습니다.")
    @Test
    void ifBusStatusIsRest() {
        Bus bus = new Bus();
        bus.setStatus(REST);

        bus.ride(25);
        Assertions.assertEquals(bus.getPassenger(), 0);
    }

    @DisplayName("주유량이 10미만인 버스는 상태가 차고지행입니다.")
    @Test
    void ifGasLessThan10() {
        Bus bus = new Bus();
        bus.setGasAmount(5);
        bus.run();

        Assertions.assertEquals(bus.getStatus(), REST);
    }

    @DisplayName("주유량은 0미만으로 만들 경우 주유를 하더라도 변화가 일어나지 않습니다.")
    @Test
    void isGasLessThanZero() {
        Bus bus = new Bus();
        bus.setGasAmount(-200);

        Assertions.assertEquals(bus.getGasAmount(), 100);
    }
}
