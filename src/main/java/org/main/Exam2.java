package org.main;

import org.domain.v2.Member;
import org.domain.v2.bus.Bus;
import org.domain.v2.taxi.Taxi;

import static org.domain.v2.bus.BusStatus.REST;
import static org.domain.v2.bus.BusStatus.RUNNING;


public class Exam2 {
    public static void main(String[] args) {
        Bus busA = new Bus();
        Bus busB = new Bus();
        System.out.println("bus1 객체 id = " + busA.getId());
        System.out.println("bus2 객체 id = " + busB.getId());

        busA.drive(2);
        System.out.println("탑승 승객 수 = " + busA.getPassenger());
        System.out.println("잔여 승객 수 = " + (Bus.maxPassenger - busA.getPassenger()));
        System.out.println("요금 확인 = " + busA.getPassenger() * busA.getBasicCharge());

        busA.changeFuel(-50);
        System.out.println("주유량 = "  + busA.getFuel());

        busA.setStatus(REST);
        busA.changeFuel(10);
        System.out.println("상태 : " + busA.getStatus());
        System.out.println("주유량 : " + busA.getFuel());

        busA.setStatus(RUNNING);
        busA.drive(45);

        Integer tmp1 = busA.getPassenger();
        busA.drive(5);
        Integer tmp2 = busA.getPassenger();

        busA.drive(0);
        System.out.println("탑승 승객 수 = " + (tmp2 - tmp1));
        System.out.println("잔여 승객 수 = " + (Bus.maxPassenger - busA.getPassenger()));
        System.out.println("요금 확인 = " + (tmp2 - tmp1) * busA.getBasicCharge());

        busA.changeFuel(-55);
        System.out.println("주유량 : " + busA.getFuel());
        busA.drive(0);
        System.out.println("상태 : " + busA.getStatus());
        System.out.println("========================================================구분선=========================================================");
        System.out.println("========================================================구분선=========================================================");
        Taxi taxiA = new Taxi();
        Taxi taxiB = new Taxi();

        System.out.println("taxiA 객체 id = " + taxiA.getId() + " 주유량 = " + taxiA.getFuel() + " 상태 = " + taxiA.getStatus());
        System.out.println("taxiB 객체 id = " + taxiB.getId() + " 주유량 = " + taxiB.getFuel() + " 상태 = " + taxiB.getStatus());

        Member member = new Member(2, "서울역", 2);
        taxiA.drive(member);

        System.out.println("탑승 승객 수 = " + taxiA.getPassenger() + " 잔여 승객 수 " + (Taxi.maxPassenger - taxiA.getPassenger()) + " 기본 요금 확인 = " + taxiA.getBasicCharge());
        System.out.println("목적지 = " + taxiA.getDestination() + " 목적지까지 거리 " + taxiA.getDistance() + "km 상태 = " + taxiA.getStatus());
        taxiA.changeFuel(-80);
        taxiA.pay();

        System.out.println("주유량 = " + taxiA.getFuel());
        System.out.println("누적 요금 " + taxiA.getWallet());

        Member memberB = new Member(5, "어디로 가야하죠~", 4);
        taxiA.drive(memberB);

        Member memberC = new Member(3, "구로디지털단지역", 12);
        taxiA.drive(memberC);
        System.out.println("탑승 승객 수 = " + taxiA.getPassenger() + " 잔여 승객 수 " + (Taxi.maxPassenger - taxiA.getPassenger()) + " 기본 요금 확인 = " + taxiA.getBasicCharge());
        System.out.println("목적지 = " + taxiA.getDestination() + " 목적지까지 거리 " + taxiA.getDistance() + "km 상태 = " + taxiA.getStatus());

        taxiA.changeFuel(-20);
        taxiA.pay();

        System.out.println( "주유량 = " + taxiA.getFuel() + " 상태 = " + taxiA.getStatus() + " 누적 요금 " + taxiA.getWallet());
    }
}
