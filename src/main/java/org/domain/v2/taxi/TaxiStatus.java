package org.domain.v2.taxi;

public enum TaxiStatus {

    NORMAL("일반"), RUNNING("운행중"), UNAVAILABLE("운행불가");

    TaxiStatus(String desc) {
    }
}
