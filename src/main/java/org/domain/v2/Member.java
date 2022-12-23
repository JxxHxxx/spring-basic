package org.domain.v2;

public class Member {
    private Long id;
    private Integer number;
    private String destination;
    private Integer distance;

    public Member(Integer number, String destination, Integer distance) {
        this.number = number;
        this.destination = destination;
        this.distance = distance;
    }

    public Long getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public String getDestination() {
        return destination;
    }

    public Integer getDistance() {
        return distance;
    }
}
