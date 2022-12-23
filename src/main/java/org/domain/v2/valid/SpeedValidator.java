package org.domain.v2.valid;

import org.domain.v2.Vehicle;

public class SpeedValidator implements Validator{

    private SpeedValidator() {
    }

    public static SpeedValidator getInstance() {
        return new SpeedValidator();
    }

    @Override
    public boolean execute(Vehicle vehicle) {
        if (vehicle.getSpeed() < 0) {
            System.out.println("MESSAGE : [속도를 0미만으로 설정할 수 없습니다.]");
            return true;
        }
        return false;
    }
}
