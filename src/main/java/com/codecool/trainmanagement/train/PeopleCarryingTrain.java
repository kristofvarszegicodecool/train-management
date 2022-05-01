package com.codecool.trainmanagement.train;

import java.math.BigDecimal;

import static com.codecool.trainmanagement.company.Company.MONTHLY_DAY_COUNT;

public abstract class PeopleCarryingTrain extends Train {
    protected static final int DAILY_PASSENGER_COUNT = 50;
    protected static final double PERCENTAGE_OF_PEOPLE_WHO_BUY_TICKET_ON_THE_TRAIN = 25.;
    private static final BigDecimal EXTRA_FEE_FOR_BUYING_TICKET_ON_THE_TRAIN = BigDecimal.valueOf(2);
    protected int coachCount;

    public PeopleCarryingTrain(MonthlyCost monthlyCost, int coachCount) {
        super(monthlyCost);
        this.coachCount = coachCount;
    }

    protected abstract BigDecimal getTicketPrice();  // TODO with enum

    @Override
    protected BigDecimal getMonthlyCost() {
        return BigDecimal.valueOf(MONTHLY_DAY_COUNT).multiply(monthlyCost.monthlyCost);
    }

    @Override
    protected BigDecimal getMonthlyRevenue() {
        final BigDecimal perc = BigDecimal.valueOf(PERCENTAGE_OF_PEOPLE_WHO_BUY_TICKET_ON_THE_TRAIN);
        final BigDecimal hundred = BigDecimal.valueOf(100);
        final BigDecimal passCnt = BigDecimal.valueOf(DAILY_PASSENGER_COUNT);

        return BigDecimal.valueOf(MONTHLY_DAY_COUNT).multiply(
                passCnt.multiply(perc.divide(hundred))).multiply(getTicketPrice()   // TODO round
                    .add(EXTRA_FEE_FOR_BUYING_TICKET_ON_THE_TRAIN)).add(
                passCnt.multiply(hundred.subtract(perc).divide(hundred)).multiply(getTicketPrice()));
    }
}
