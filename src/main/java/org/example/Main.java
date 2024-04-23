package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {

        var populSize = 1035;
        var winSize = 45;
        var nEpochs = 100;
        var targetSize = Data.target.length;
        var popul = new double[populSize][targetSize];

        for (int i = 0; i < populSize; i++) {
            popul[i] = Data.newRandomBot();
        }

        for (int ep = 0; ep < nEpochs; ep++) {
            var errors = new double[populSize];
            var winners = new double[winSize][targetSize];

            for (int i = 0; i < populSize; i++) {
                errors[i] = Data.getErr(popul[i]);
            }
            var thresold = Arrays.stream(errors).sorted().toArray()[winSize - 1];

            int j = 0;
            for (int i = 0; i < populSize; i++) {
                if (errors[i] < thresold) {
                    winners[j] = popul[i];
                    j++;
                }
            }

            var newPopul = new double[populSize][targetSize];
            for (int i = 0; i < winSize; i++) {
                newPopul[i] = winners[i];
            }

            for (int i = 0; i < winSize; i++) {
                for (int k = i + 1; k < winSize; k++) {
//                    System.out.printf("i = %d, k = %d, (%b)", i, k, i < winSize);
//                    System.out.println();
                    newPopul[winSize + i] = Data.breeding(winners[i], winners[k]);
                }
            }
            popul = newPopul;
            System.out.println("Epoch " + ep + ": error = " + Arrays.stream(errors).min().getAsDouble());
        }
    }
}