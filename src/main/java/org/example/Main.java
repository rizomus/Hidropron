package org.example;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        var populSize = 1035;
        var winSize = 45;
        var nEpochs = 100;
        var botSize = Data.botSize;
        var popul = new double[populSize][botSize];
        var errors = new double[populSize];
        var winners = new double[winSize][botSize];

        for (int i = 0; i < populSize; i++) {
            popul[i] = Data.newRandomBot();
        }

        for (int ep = 0; ep < nEpochs; ep++) {
            errors = new double[populSize];
            winners = new double[winSize][botSize];

            for (int i = 0; i < populSize; i++) {
                errors[i] = Data.getErr(popul[i]);
            }
            var sortedErrors = Arrays.stream(errors).sorted().toArray();
            var thresold = sortedErrors[winSize - 1];                           // порог ошибки для выживших

            int j = 0;
            for (int i = 0; i < populSize; i++) {
                if (errors[i] <= thresold) {          // нам нужны только истинные арийцы
                    winners[j] = popul[i];
                    j++;
                }
            }
            assert(j == winSize);

            var newPopul = Arrays.copyOf(winners, populSize);         // выжившие - основа новой популяции

            j = winSize;
            for (int i = 0; i < winSize; i++) {                                 // победители
                for (int k = i + 1; k < winSize; k++) {                         // скрещиваются каждый с каждым (можно выбрать другую стратегию)
                    newPopul[j] = Data.breeding(winners[i], winners[k]);        // и добавляются в новую популяцию
                    j++;
                }
            }
            popul = newPopul;
            System.out.println("Epoch " + ep + ": error = " + sortedErrors[0]);
        }
        Data.printResults(errors, popul);
    }
}