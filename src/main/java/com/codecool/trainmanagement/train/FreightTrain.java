package com.codecool.trainmanagement.train;

import java.math.BigDecimal;

public class FreightTrain extends Train {
    public enum CargoType {
        NORMAL(BigDecimal.valueOf(0)),
        NON_SOLID(BigDecimal.valueOf(150)),
        DANGEROUS(BigDecimal.valueOf(300));
        public final BigDecimal additionalFee;

        CargoType(BigDecimal additionalFee) {
            this.additionalFee = additionalFee;
        }
    }

    private static final BigDecimal MONTHLY_BASE_REVENUE = BigDecimal.valueOf(550);

    private CargoType cargoType;

    public FreightTrain(CargoType cargoType) {
        super(MonthlyCost.FREIGHT_COST);
        this.cargoType = cargoType;
    }

    public CargoType getCargoType() {
        return cargoType;
    }

    @Override
    protected BigDecimal getMonthlyCost() {
        return monthlyCost.monthlyCost;
    }

    @Override
    protected BigDecimal getMonthlyRevenue() {
        return MONTHLY_BASE_REVENUE.add(cargoType.additionalFee);
    }
}
