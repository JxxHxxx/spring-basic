package org.main;

import org.domain.Bus;

import static org.domain.BusStatus.*;

public class Exam1 {
    public static void main(String[] args) {
        Bus bus1 = new Bus();
        Bus bus2 = new Bus();
        System.out.println("bus1 객체 id = " + bus1.getId());
        System.out.println("bus2 객체 id = " + bus2.getId());

        bus1.ride(2);
        System.out.println("탑승 승객 수 = " + bus1.getPassenger());
        System.out.println("잔여 승객 수 = " + (bus1.getMaxPassenger() - bus1.getPassenger()));
        System.out.println("요금 확인 = " + bus1.getPassenger() * bus1.getCharge());

        bus1.setGasAmount(-50);
        bus1.run();
        System.out.println("주유량 = "  + bus1.getGasAmount());

        bus1.setStatus(REST);
        bus1.setGasAmount(10);
        System.out.println("상태 : " + bus1.getStatus());
        System.out.println("주유량 : " + bus1.getGasAmount());

        bus1.setStatus(RUNNING);
        bus1.ride(45);

        Integer ridePassenger = bus1.ride(5);
        bus1.run();
        System.out.println("탑승 승객 수 = " + bus1.getPassenger());
        System.out.println("잔여 승객 수 = " + (bus1.getMaxPassenger() - bus1.getPassenger()));
        System.out.println("요금 확인 = " + ridePassenger * bus1.getCharge());

        bus1.setGasAmount(-55);
        System.out.println("주유량 : " + bus1.getGasAmount());
        bus1.run();
        System.out.println("상태 : " + bus1.getStatus());

    }
}