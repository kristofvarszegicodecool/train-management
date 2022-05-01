package com.codecool.trainmanagement.train;

import java.math.BigDecimal;

public class PassengerTrain extends PeopleCarryingTrain {
    public PassengerTrain(int coachCount) {
        super(MonthlyCost.PASSENGER_COST, coachCount);
    }

    @Override
    protected BigDecimal getTicketPrice() {
        return BigDecimal.valueOf(1.5);
    }
}
