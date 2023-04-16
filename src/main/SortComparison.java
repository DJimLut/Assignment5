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

    //Radix Sort
    public static void radixSort(String[] data) {
        // TODO: Implement Method
    }


    //Heap Sort
    //Source: https://www.geeksforgeeks.org/lexicographical-ordering-using-heap-sort/
    static int x = -1;
    static String[] heap = new String[200000];
    public static void heapForm(String k) {
        x++;
        heap[x] = k;
        int child = x;
        String tmp;
        int index = x/2;

        while (index >= 0) {
            if(heap[index].compareTo(heap[child]) > 0) {
                tmp = heap[index];
                heap[index] = heap[child];
                heap[child] = tmp;
                child = index;

                index = index/2;
            }
            else {
                break;
            }
        }
    }
    public static void sort() {
        int left, right;
        while(x >= 0) {
            String k;
            k = heap[0];
            heap[0] = heap[x];
            x = x - 1;
            String tmp;
            int index = 0;
            int length = x;

            left = 1;
            right = left + 1;

            while(left <= length) {
                if(heap[index].compareTo(heap[left]) <= 0 && heap[index].compareTo(heap[right]) <= 0) {
                    break;
                }
                else {
                    if(heap[left].compareTo(heap[right]) < 0) {
                        tmp = heap[index];
                        heap[index] = heap[left];
                        heap[left] = tmp;
                        index = left;
                    }
                    else {
                        tmp = heap[index];
                        heap[index] = heap[right];
                        heap[right] = tmp;
                        index = right;
                    }
                }

                left = 2 * left;
                right = left + 1;
            }
        }
    }
    public static void heapSort(String[] data) {
        for(int i = 0; i < data.length; i++) {
            heapForm(data[i]);
        }
        sort();
    }


    public static void main(String[] args) {
        boolean useLetters = true;
        boolean useNumbers = false;

        String[][] radixArr = new String[25][200000];

        for(int i = 0; i < radixArr.length; i++) {
            for(int j = 0; j < radixArr[i].length; j++) {
                // For every string in every string array, assign a random string with its index as its length, using only letters
                radixArr[i][j] = RandomStringUtils.random(i + 1, useLetters, useNumbers);
            }
        }

        String[][] heapArr = radixArr.clone(); // Clone the array for heapSorting

        System.out.println("ArrLen\tStrLen\tHeap\tRadix\n======\t======\t====\t=====");

        long startTime;
        long radixTime;
        long heapTime;
        for(int i = 0; i < radixArr.length; i++) {
            // Sort every string array, calculate the time and format it
            startTime = System.nanoTime();
            radixSort(radixArr[i]);
            radixTime = (System.nanoTime() - startTime) / 1000000;

            startTime = System.nanoTime();
            heapSort(heapArr[i]);
            heapTime = (System.nanoTime() - startTime) / 1000000;

            System.out.printf("%d\t%d\t\t%d\t\t%d%n", radixArr[i].length, radixArr[i][i].length(), heapTime, radixTime);
        }
    }
}
