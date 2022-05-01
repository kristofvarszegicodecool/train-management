package com.codecool.trainmanagement.train;

import java.math.BigDecimal;

public class ICTrain extends PeopleCarryingTrain {
    public ICTrain(int coachCount) {
        // TODO check for max coach count
        super(MonthlyCost.IC_COST, coachCount);
    }

    @Override
    protected BigDecimal getTicketPrice() {
        return BigDecimal.valueOf(2);
    }
}
