/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taba2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author yalemisew
 */
public class Country {
    // the arraylist that contains all the 10 countries

    static ArrayList<Integer>[] countries = new ArrayList[10];
    // the data that contains the statisitistics of each country
    long sum[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    float average[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int min[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int max[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public Country() {
    }
    
    // The code that generates the country data using random function

    public static ArrayList[] generateData() {
        Random random = new Random();
        // for testing purpose you may fix the random value to a constant
         random.setSeed(4);
        for (int i = 0; i < 10; i++) {
            // Generates 10000 random numbers between -10,000 and 10,000
            int[] numbers = random.ints(10000, -10000, 10000).toArray();
            countries[i] = new ArrayList<Integer>();
            for (int j = 0; j < numbers.length; j++) {
                countries[i].add(numbers[j]);

            }
        }
        return countries;

    }

    // Sets the sum of each country stat. the index represent the respective country
    public void setSum(long sum, int index) {
        this.sum[index] = sum;
    }

    public void setAverage(float average, int index) {
        this.average[index] = average;
    }

    public void setMin(int min, int index) {
        this.min[index] = min;
    }

    public void setMax(int max, int index) {
        this.max[index] = max;
    }

    public float[] getAverage() {
        return average;
    }

    public int[] getMin() {
        return min;
    }

    public int[] getMax() {
        return max;
    }
    

    public long computeGrandSum() {
        long grandSum = 0;
        for (int i = 0; i < sum.length; i++) {
            grandSum += sum[i];
        }
        return grandSum;
    }

    public float computeGrandAverage() {
        float grandAvgSum = 0;
        for (int i = 0; i < average.length; i++) {
            grandAvgSum += average[i];
        }
        return (float)grandAvgSum / average.length;
    }

    public int computeGrandMin() {
        int grandMin = min[0];
        for (int i = 0; i < min.length; i++) {
            if (grandMin > min[i]) {
                grandMin = min[i];
            }
        }
        return grandMin;
    }

    public int computeGrandMax() {
        int grandMax = max[0];
        for (int i = 0; i < max.length; i++) {
            if (grandMax < max[i]) {
                grandMax = max[i];
            }
        }
        return grandMax;
    }

}
