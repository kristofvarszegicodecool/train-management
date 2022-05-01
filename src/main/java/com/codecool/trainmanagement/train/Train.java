package com.codecool.trainmanagement.train;

import java.math.BigDecimal;

public abstract class Train {
    protected enum MonthlyCost {
        IC_COST(BigDecimal.valueOf(1200)),
        PASSENGER_COST(BigDecimal.valueOf(1000)),
        FREIGHT_COST(BigDecimal.valueOf(1000));
        public final BigDecimal monthlyCost;    // TODO give a different name from the enum's name

        MonthlyCost(BigDecimal monthlyCost) {
            this.monthlyCost = monthlyCost;
        }
    }

    protected MonthlyCost monthlyCost;

    public Train(MonthlyCost monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    protected abstract BigDecimal getMonthlyCost();

    protected abstract BigDecimal getMonthlyRevenue();

    public BigDecimal getMonthlyProfit() {
         return getMonthlyRevenue().subtract(getMonthlyCost());
    }
}
