package com.codecool.trainmanagement.company;

import com.codecool.trainmanagement.train.FreightTrain;
import com.codecool.trainmanagement.train.ICTrain;
import com.codecool.trainmanagement.train.PassengerTrain;
import com.codecool.trainmanagement.train.Train;

import java.util.ArrayList;
import java.util.List;

public class Company {
    public static final byte MONTHLY_DAY_COUNT = 30;

    private List<Train> trains;

    public Company() {
        this.trains = new ArrayList<>();
        createDummyTrains();
    }

    public List<FreightTrain> getFreightTrainsCarryingDangerousCargo() {
        List<FreightTrain> freightTrainsWithDangerousCargo = new ArrayList<>();
        for (final Train train: trains) {
            if (train instanceof final FreightTrain freightTrain) {
                if (freightTrain.getCargoType() == FreightTrain.CargoType.DANGEROUS) {
                    freightTrainsWithDangerousCargo.add(freightTrain);
                }
            }
        }
        return freightTrainsWithDangerousCargo;
    }

    private void createDummyTrains() {
        trains.add(new PassengerTrain(20));
        trains.add(new ICTrain(5));
        trains.add(new FreightTrain(FreightTrain.CargoType.DANGEROUS));
    }
}
