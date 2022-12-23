package org.domain.v2.taxi;

import org.domain.v2.Drivable;
import org.domain.v2.Vehicle;
import org.domain.v2.valid.CapacityValidator;
import org.domain.v2.valid.Validator;

import static org.domain.v2.taxi.TaxiStatus.NORMAL;
import static org.domain.v2.taxi.TaxiStatus.RUNNING;

public class Taxi extends Vehicle<TaxiStatus>{

    private static Long sequence = 0L;
    public static final Integer ratePerDistance = 1000;
    public static final Integer maxPassenger = 4;
    public static final Integer basicDistance = 1;


    private static final Validator capacityValidator = CapacityValidator.getInstance();

    private Integer distance;
    private String destination;

    public Taxi() {
        this.id = sequence++;
        this.basicCharge = 3000;
        this.status = NORMAL;
    }


}
