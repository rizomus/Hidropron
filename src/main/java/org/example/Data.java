package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;


public class Data {

   static HashMap<Integer, String> elements = new HashMap<>();
   static HashMap<String, Double> target_elements = new HashMap<>();
   static List<double[]> fertilizers = new ArrayList<double[]>();

   static int botSize;
   static double targetSumML;

    static List<String> fertNames = new ArrayList<>();
   static double[] target = new double[]{200.,0.,0.35,200.,0.06,     1.2,0.55,0.35,0.,0.,      0.,0.,0.,0.,0.06,    0.,0.,40.,310.,55.,         0.};

   static double target0ML = target[0];
   static Random random = new Random();

   static {
        elements.put(0, "N");
        elements.put(1, "S");
        elements.put(2, "B");
        elements.put(3, "Ca");
        elements.put(4, "Cu");
        elements.put(5, "Fe");
        elements.put(6, "Mn");
        elements.put(7, "Zn");
        elements.put(8, "Li");
        elements.put(9, "I");
        elements.put(10, "Br");
        elements.put(11, "Co");
        elements.put(12, "Ni");
        elements.put(13, "Se");
        elements.put(14, "Mo");
        elements.put(15, "W");
        elements.put(16, "V");
        elements.put(17, "P");
        elements.put(18, "K");
        elements.put(19, "Mg");
        elements.put(20, "Na");

        target_elements.put("N", 200.0);
        target_elements.put("P", 40.0);
        target_elements.put("K", 310.0);
        target_elements.put("Ca", 200.0);
        target_elements.put("Mg", 55.0);
        target_elements.put("B", 0.35);
        target_elements.put("Fe", 1.2);
        target_elements.put("Mn", 0.55);
        target_elements.put("Zn", 0.35);
        target_elements.put("Cu", 0.06);
        target_elements.put("Mo", 0.06);

       fertNames.add("Селитра кальциевая Буйск");
       fertilizers.add(new double[]{14.9,0.,0.,(19.305),0.,     0.,0.,0.,0.,0.,      0.,0.,0.,0.,0.,     0.,0.,0.,0.,0.,       0.});
       fertNames.add("Монокалий фосфат Буйск");
       fertilizers.add(new double[]{0.,0.,0.,0.,0.,         0.,0.,0.,0.,0.,       0.,0.,0.,0.,0.,         0.,0.,(21.8),(27.389),0.,     0.});
       fertNames.add("Сульфат магния Буйск");
       fertilizers.add(new double[]{0.,13.5,0.,0.,0.,      0.,0.,0.,0.,0.,     0.,0.,0.,0.,0.,      0.,0.,0.,0.,(10.1907),        0.});
       fertNames.add("Селитра калиевая Мегастрой");
       fertilizers.add(new double[]{13.5,0.,0.03,0.,0.15,   0.09,0.16,0.04,0.,0.,     0.,0.,0.,0.,0.002,    0.,0.,0.,(31.208),0.,      0.});
       fertNames.add("Селитра магниевая");
       fertilizers.add(new double[]{11.1, 0.,0.,0.715,0.,     0.,0.,0.,0.,0.,      0.,0.,0.,0.,0.,     0.,0.,0.,0.,(9.3465),       0.});

       fertNames.add("Сульфат калия Буйск");
       fertilizers.add(new double[]{0.,17.,0.,0.,0.,     0.,0.,0.,0.,0.,      0.,0.,0.,0.,0.,     0.,0.,0.,41.5,0.,     0.});
       fertNames.add("Селитра кальциевая Fertika");
       fertilizers.add(new double[]{15.5,0.,0.,0.,0.,     0.,0.,0.,0.,0.,     0.,0.,0.,0.,0.,     0.,0.,0.,0.,0.,        0.});
       fertNames.add("Хелат железа");
       fertilizers.add(new double[]{0.,0.,0.,0.,0.,     11.7,0.,0.,0.,0.,      0.,0.,0.,0.,0.,     0.,0.,0.,0.,0.,        0.});
       fertNames.add("Хелат цинка");
       fertilizers.add(new double[]{0.,0.,0.,0.,0.,     0.,0.,15.,0.,0.,      0.,0.,0.,0.,0.,     0.,0.,0.,0.,0.,        0.});
       fertNames.add("Акварин плодово-ягодный");
       fertilizers.add(new double[]{12.,0.7,0.,0.,0.01,     0.054,0.042,0.014,0.,0.,      0.,0.,0.,0.,0.,     0.,0.,(5.232),(29.05),(0.603),       0.});

       fertNames.add("УНИФЛОР-МИКРО");
       fertilizers.add(new double[]{0.,1.98,0.12,0.,0.032,     0.32,0.16,0.036,0.0024,0.008,      6e-4,0.0048,0.002,0.001,0.0102,     8e-4,0.0024,0.,0.,1.5,       0.48});
       fertNames.add("Борофоска");
       fertilizers.add(new double[]{0.,0.,0.25,(14.3),0.,     0.,0.,0.,0.,0.,      0.,0.,0.,0.,0.,     0.,0.,(4.36),(13.28),(1.206),             0.});
       fertNames.add("Селитра калиевая Буйск");
       fertilizers.add(new double[]{13.6,0.,0.,0.,0.,     0.,0.,0.,0.,0.,      0.,0.,0.,0.,0.,     0.,0.,0.,(38.18),0.,           0.});
       fertNames.add("Артем Аммиачка мткро");
       fertilizers.add(new double[]{33.,0.,0.03,0.,0.15,     0.09,0.16,0.04,0.,0.,      0.,0.,0.,0.,0.002,     0.,0.,0.,0.,0.,           0.});
       fertNames.add("Артем КалиСелитБуйсМик");
       fertilizers.add(new double[]{13.5,0.,0.003,0.013,0.003,     0.019,0.013,0.003,0.,0.,      0.,0.,0.,0.,7e-4,     0.,0.,0.,45.8,0.,          0.});

       fertNames.add("Артем Аквамикс Хелат");
       fertilizers.add(new double[]{0.,0.,0.79,3.9,0.8,     5.8,3.9,0.8,0.,0.,      0.,0.,0.,0.,0.19,     0.,0.,0.,0.,0.,           0.});
       fertNames.add("Артем магний сернокислый");
       fertilizers.add(new double[]{0.,12.8,0.,0.,0.,     0.,0.,0.,0.,0.,      0.,0.,0.,0.,0.,     0.,0.,0.,0.,(9.7083),            0.});

       targetSumML = Arrays.stream(target).sum();
       target[target.length - 1] = 1000 - targetSumML;      // балласт и вода
       arrNormalize(target);
       botSize = fertilizers.size();

       for(var f: fertilizers) {
           f[f.length - 1] = 100 - Arrays.stream(f).sum();          // балласт
           arrNormalize(f);
       }
    }

    static double getErr(double[] bot) throws IOException {

        var solution = Stream.generate(()->0.).limit(target.length).mapToDouble(Double::doubleValue).toArray();         // целевой раствор, инициализируется массивом нулей
        var relevantTarget = arrNotZero(target);
        var relevantSolution = arrNotZero(solution, target);

        for (int i = 0; i < fertilizers.size(); i++) {
                solution = arrSum(solution, arrMultiply(fertilizers.get(i), bot[i]));           // Каждое удобрение (fertilizers.get(i)) умножается на свой коэффициент (bot[i])
        }
        arrNormalize(solution);                                 // нормализация к 1
        relevantSolution = arrNotZero(solution, target);        // берём в расчёт только элементы присутствующие в целевом растворе
        return MSPE(relevantTarget, relevantSolution);          // считаем ошибку
    }

    static double[] breeding(double[] bot1, double[] bot2) {        // скрещивание

        assert (bot1.length == bot2.length);

        var child = new double[bot1.length];

        for (int i = 0; i < bot1.length; i++) {
            if (random.nextBoolean()) child[i] = bot1[i];
            else child[i] = bot2[i];
        }
        return arrNormalize(child);
    }

    static double[] newRandomBot() {                // создаёт нового рандомного бота
        Random random = new Random();
        var bot = random.doubles(botSize).toArray();
        return arrNormalize(bot);                               // нормализация к 1
    }

    static double[] arrMultiply (double[] arr1, double k) {             // поэлементно домнажает элементы массива на коэффициент
        double[] result = new double[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i] * k;
        }
        return result;
    }

    static double[] arrSum (double[] arr1, double[] arr2) {         // поэлементно суммирует 2 массива
        assert(arr1.length == arr2.length);
        double[] result = new double[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i] + arr2[i];
        }
        return result;
    }

    static double MSPE (double[] target, double[] computed) {        // mean square percentage error = mean((y_true - y_pred)^2 / y_true)
        assert(target.length == computed.length);

        double[] result = new double[target.length];
        double sum = 0;
        for (int i = 0; i < target.length; i++) {
            result[i] = Math.pow((target[i] - computed[i]), 2) / target[i];
            sum += result[i];
        }
        return sum / target.length;
    }

    static double[] arrNormalize(double[] arr) {            // нормализация массива, так чтобы сумма элементов была = 1
        var sum = Arrays.stream(arr).sum();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / sum;
        }
        return arr;
    }

    static double[] arrNotZero(double[] arr) {                  // создаёт массив из не нулевых элементов входящего массива
        double[] positives = new double[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                positives[j] = arr[i];
                j++;
            }
        }
        return Arrays.copyOf(positives, j);
    }

    static double[] arrNotZero(double[] arrTarget, double[] arrTempl) {         // создаёт массив из элементов arrTarget, индексы которого соответствуют индексам ненулевых эелементов arrTempl
        assert(arrTarget.length == arrTempl.length);
        double[] positives = new double[arrTarget.length];
        int j = 0;
        for (int i = 0; i < arrTarget.length; i++) {
            if (arrTempl[i] > 0) {
                positives[j] = arrTarget[i];
                j++;
            }
        }
        return Arrays.copyOf(positives, j);
    }

    static void printArr(double[] arr, String prefix) {     // вывод массива на экран
        System.out.print(prefix + "[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("]");
    }


    static void printResults(double[] errors, double[][] popul) {           // Отображение результатов
        System.out.println();

        var k = target0ML / target[0];                                      // коэффициент для перевода процентов в мл.
        var minErr = Arrays.stream(errors).min().getAsDouble();
        double[] winner = new double[botSize];

        for (int i = 0; i < popul.length; i++) {
            if (errors[i] == minErr) {
                winner = popul[i];
            }
        }

        var solution = Stream.generate(()->0.).limit(target.length).mapToDouble(Double::doubleValue).toArray();     // получившийся раствор

        for (int i = 0; i < fertilizers.size(); i++) {
            solution = arrSum(solution, arrMultiply(fertilizers.get(i), winner[i]));        // добавляем все удобрения со своими коэффициентами
        }
        arrNormalize(solution);

        for (int i = 0; i < target.length; i++) {
            if (target_elements.containsKey(elements.get(i))) {
                System.out.printf("%s:             %.2f                (%.2f) \n", elements.get(i), (solution[i] * k), target_elements.get(elements.get(i)));
            }
        }
        System.out.println();
        for (int i = 0; i < target.length; i++) {
            if (!target_elements.containsKey(elements.get(i))) {
                System.out.printf("%s:             %.2f \n", elements.get(i), (solution[i] * k));
            }
        }

        System.out.println();

        for (int i = 0; i < fertNames.size(); i++) {
            System.out.printf("%-30s ", fertNames.get(i) + ":");
            System.out.printf("%10.2f мг/л \n", (winner[i] * k), "%");
        }
    }
}
