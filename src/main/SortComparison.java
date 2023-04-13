/*
 * Bryan Floyd
 * David Jimenez
 * Mason Richardson
 * 
 * CSC445: Computer Algorithms
 * Homework Assignment 5
 */

package main;

import org.apache.commons.lang3.RandomStringUtils;

public class SortComparison {
    public static void radixSort(String[] data) {
        // TODO: Implement Method
    }

    public static void heapSort(String[] data) {
        // TODO: Implement Method
    }

    public static void main(String[] args) {
        boolean useLetters = true;
        boolean useNumbers = false;

        String[][] radixArr = new String[200000][25];

        for(int i = 0; i < radixArr.length; i++) {
            for(int j = 0; j < radixArr[i].length; j++) {
                // For every string in every string array, assign a random string with its index as its length, using only letters
                radixArr[i][j] = RandomStringUtils.random(j + 1, useLetters, useNumbers); 
            }
        }

        String[][] heapArr = radixArr.clone(); // Clone the array for heapSorting

        System.out.println("ArrLen\tStrLen\tHeap\tRadix\n======\t======\t====\t=====");

        long startTime;
        long radixTime;
        long heapTime;
        for(int i = 0; i < 25; i++) {
            // Sort every string array, calculate the time and format it
            startTime = System.nanoTime();
            radixSort(radixArr[i]);
            radixTime = (System.nanoTime() - startTime) / 1000000;

            startTime = System.nanoTime();
            heapSort(heapArr[i]);
            heapTime = (System.nanoTime() - startTime) / 1000000;

            System.out.printf("%d\t%d\t%d\t%d%n", radixArr.length, radixArr[i][i].length(), heapTime, radixTime);
        }
    }
}
