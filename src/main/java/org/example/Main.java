package org.example;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        var populSize = 1035;
        var winSize = 45;
        var nEpochs = 100;
        var targetSize = Data.target.length;
        var botSize = Data.fertilizers.size();
        var popul = new double[populSize][botSize];
        var errors = new double[populSize];
        var winners = new double[winSize][botSize];
        double[] result = new double[targetSize];

        for (int i = 0; i < populSize; i++) {
            popul[i] = Data.newRandomBot();
        }

        for (int ep = 0; ep < nEpochs; ep++) {
            errors = new double[populSize];
            winners = new double[winSize][botSize];

            for (int i = 0; i < populSize; i++) {
                errors[i] = Data.getErr(popul[i]);
//                System.out.println("err[i] = " + errors[i]);
            }
            var sortedErrors = Arrays.stream(errors).sorted().toArray();
            var thresold = sortedErrors[winSize - 1];
//            System.out.println("threshold = " + thresold);

            int j = 0;
            for (int i = 0; i < populSize; i++) {
                if (errors[i] <= thresold) {
                    winners[j] = popul[i];
//                    Data.printArr(winners[j], "   winner: ");
                    j++;
                }
            }
            assert(j == winSize);

            var newPopul = Arrays.copyOf(winners, populSize);

            j = winSize;
            for (int i = 0; i < winSize; i++) {
                for (int k = i + 1; k < winSize; k++) {
                    newPopul[j] = Data.breeding(winners[i], winners[k]);
                    j++;
                }
            }
            popul = newPopul;
//            Data.printArr(popul[0], "   popul[0]: ");
//            Data.printArr(popul[populSize - 1], "   popul[-1]: ");
            System.out.println("Epoch " + ep + ": error = " + sortedErrors[0]);
        }
        Data.printResults(errors, popul);
    }
}