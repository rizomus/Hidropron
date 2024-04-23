package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.DoubleStream;


public class Data {

   static HashMap<Integer, String> elements = new HashMap<>();
   static HashMap<String, Double> target_elements = new HashMap<>();
   static List<double[]> fertilizers = new ArrayList<double[]>();
   static double[] target = new double[]{200.,0.,0.35,200.,0.06,     1.2,0.55,0.35,0.,0.,      0.,0.,0.,0.,0.06,    0.,0.,40.,310.,55.,         0.};
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
        elements.put(20, "Mg");
        elements.put(21, "Na");

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

        fertilizers.add(new double[]{14.9,0.,0.,(19.305),0.,     0.,0.,0.,0.,0.,      0.,0.,0.,0.,0.,     0.,0.,0.,0.,0.,       0.});
        fertilizers.add(new double[]{0.,0.,0.,0.,0.,         0.,0.,0.,0.,0.,       0.,0.,0.,0.,0.,         0.,0.,(21.8),(27.389),0.,     0.});
        fertilizers.add(new double[]{0.,13.5,0.,0.,0.,      0.,0.,0.,0.,0.,     0.,0.,0.,0.,0.,      0.,0.,0.,0.,(10.1907),        0.});
        fertilizers.add(new double[]{13.5,0.,0.03,0.,0.15,   0.09,0.16,0.04,0.,0.,     0.,0.,0.,0.,0.002,    0.,0.,0.,(31.208),0.,      0.});
        fertilizers.add(new double[]{11.1, 0.,0.,0.715,0.,     0.,0.,0.,0.,0.,      0.,0.,0.,0.,0.,     0.,0.,0.,0.,(9.3465),       0.});
        fertilizers.add(new double[]{0.,17.,0.,0.,0.,     0.,0.,0.,0.,0.,      0.,0.,0.,0.,0.,     0.,0.,0.,41.5,0.,     0.});
        fertilizers.add(new double[]{15.5,0.,0.,0.,0.,     0.,0.,0.,0.,0.,     0.,0.,0.,0.,0.,     0.,0.,0.,0.,0.,        0.});
        fertilizers.add(new double[]{0.,0.,0.,0.,0.,     11.7,0.,0.,0.,0.,      0.,0.,0.,0.,0.,     0.,0.,0.,0.,0.,        0.});
        fertilizers.add(new double[]{0.,0.,0.,0.,0.,     0.,0.,15.,0.,0.,      0.,0.,0.,0.,0.,     0.,0.,0.,0.,0.,        0.});
        fertilizers.add(new double[]{12.,0.7,0.,0.,0.01,     0.054,0.042,0.014,0.,0.,      0.,0.,0.,0.,0.,     0.,0.,(5.232),(29.05),(0.603),       0.});
        fertilizers.add(new double[]{0.,1.98,0.12,0.,0.032,     0.32,0.16,0.036,0.0024,0.008,      6e-4,0.0048,0.002,0.001,0.0102,     8e-4,0.0024,0.,0.,1.5,       0.48});
        fertilizers.add(new double[]{0.,0.,0.25,(14.3),0.,     0.,0.,0.,0.,0.,      0.,0.,0.,0.,0.,     0.,0.,(4.36),(13.28),(1.206),             0.});
        fertilizers.add(new double[]{13.6,0.,0.,0.,0.,     0.,0.,0.,0.,0.,      0.,0.,0.,0.,0.,     0.,0.,0.,(38.18),0.,           0.});
        fertilizers.add(new double[]{33.,0.,0.03,0.,0.15,     0.09,0.16,0.04,0.,0.,      0.,0.,0.,0.,0.002,     0.,0.,0.,0.,0.,           0.});
        fertilizers.add(new double[]{13.5,0.,0.003,0.013,0.003,     0.019,0.013,0.003,0.,0.,      0.,0.,0.,0.,7e-4,     0.,0.,0.,45.8,0.,          0.});
        fertilizers.add(new double[]{0.,0.,0.79,3.9,0.8,     5.8,3.9,0.8,0.,0.,      0.,0.,0.,0.,0.19,     0.,0.,0.,0.,0.,           0.});
        fertilizers.add(new double[]{0.,12.8,0.,0.,0.,     0.,0.,0.,0.,0.,      0.,0.,0.,0.,0.,     0.,0.,0.,0.,(9.7083),            0.});

        var targetSum = Arrays.stream(target).sum();
        for (int i = 0; i < target.length; i++) {
            target[i] /= targetSum;
        }
    }

    static double getErr(double[] bot) throws IOException {

        var solution = new double[]{0.,0.,0.,0.,0.,0.,0.,0.,0.,0.,0.,0.,0.,0.,0.,0.,0.,0.,0.,0.,0.};
        assert(solution.length == target.length);
        int count = (int)Arrays.stream(target).filter(x -> x != 0).count();
        double[] err = new double[count];
        double errSum = 0.;

        for (double[] f: fertilizers) {

            for (int i = 0; i < target.length; i++) {
                solution[i] = solution[i] + bot[i] * f[i];
            }

            double sum = Arrays.stream(solution).sum();

            var n = 0;                                      // количество не нулевых элементов в target
            for (int i = 0; i < target.length; i++) {
                if (target[i] != 0) {
                    err[n] += Math.pow((target[i] - (solution[i] / sum)), 2);
                    err[n] /= target[i];
                    System.out.println("      err[" + n + "] = " + err[n] + "       " + solution[i] + "         " + sum);
                    n++;
                }
            }
        }
        errSum = Arrays.stream(err).sum();
        System.out.println("err: " + errSum / count);
        System.in.read();
        return errSum / count;
    }

    static double[] breeding(double[] bot1, double[] bot2) {

        var child = new double[bot1.length];

        for (int i = 0; i < bot1.length; i++) {
            if (random.nextBoolean()) child[i] = bot1[i];
            else child[i] = bot2[i];
        }
        var childSum = Arrays.stream(child).sum();
        for (int i = 0; i < child.length; i++) {
            child[i] /= childSum;
        }

        return child;
    }

    static double[] newRandomBot() {
//        Random random = new Random();
        var bot = random.doubles(target.length, 0, 1).toArray();
        double sum = Arrays.stream(bot).sum();
        DoubleStream newBot = Arrays.stream(bot).map(x -> x / sum);
        return newBot.toArray();
    }

}
