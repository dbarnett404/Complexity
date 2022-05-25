import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {

    /**
     * Looks for the first occurrence of a specific integer
     * @param number to find
     * @param array to search
     * @return either the index or -1 if not found
     */
    private static int findFirstIndexOfNumber(int number, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Finds the index of each occurrence of a specific number in an Array
     * @param number to search for
     * @param array to search
     * @return ArrayList of matching indexes - will be empty if not found
     */
    private static ArrayList<Integer>  findEachIndexOfNumber(int number, int[] array) {
        ArrayList<Integer> arrayOfIndexes = new ArrayList<>();
        int index = 0;
        for (int n: array) {
            if (n == number) {
                arrayOfIndexes.add(index);
            }
            index++;
        }
        return arrayOfIndexes;
    }

    /**
     * Checks to see if the first item stored in an unsorted array is greater than, less than or equal to the
     * last item in the array
     * @param array
     * @return String showing the status
     */
    private static String checkFirstLastHigherOrLower(int[] array) {
        int firstItem = array[0];
        int lastItem = array[array.length -1 ];
        String status = " equal to ";
        if (lastItem > firstItem) {
            status = " greater than ";
        } else if (lastItem < firstItem) {
            status = " less than ";
        }
        return lastItem + " is" + status + firstItem;
    }

    /**
     * Calculates the sum of a sequential array iof integers
     * @param array to sum
     * @return the actual total
     */
    private static int sumOfSequentialArray(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    /**
     * Alternative method to find the sum of a sequential array of integers (invented by Gauss)
     * @param array
     * @return
     */
    private static int sumOfSequentialArray2(int[] array) {
        return array.length * (array.length + 1)/2;
    }

    /**
     * Recursive binary search of a sorted Array
     * @param number to find
     * @param array sorted array to search
     * @param beginIndex index to start at (0 initially)
     * @param endIndex index to end at (array.length - 1 initially)
     * @return
     */
    private static int  searchSortedArray(int number, int[] array, int beginIndex, int endIndex) {
        int middleIndex = (int)Math.floor((beginIndex + endIndex)/2);
        if (array[middleIndex] == number) {
            return middleIndex;
        } else if (beginIndex >= endIndex) {
            return -1;
        } else if (array[middleIndex] < number) {
            beginIndex = middleIndex + 1;
            return searchSortedArray(number, array, beginIndex, endIndex);
        } else {
            endIndex = middleIndex - 1;
            return searchSortedArray(number, array, beginIndex, endIndex);
        }
    }

    private static class Indices {
        private int i, j;

        public Indices(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "i: " + i + ", j: " + j;
        }
    }

    /**
     * Method to compare two arrays, uses the indices class to store the indices where numbers actually match in either
     * array
     * @param array1
     * @param array2
     * @return ArrayList storing the matching indices
     */
    private static ArrayList<Indices> compareArrays(int[] array1, int[] array2) {
        ArrayList<Indices> arrayOfMatchingIndexes = new ArrayList<>();
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    arrayOfMatchingIndexes.add(new Indices(i, j));
                }
            }

        }
        return arrayOfMatchingIndexes;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    /**
     * Sorts an Array
     * @param array
     */
    private static void sortByValue(int[] array){
        int count = 1;
        boolean swapping = true;
        while (count < array.length & swapping) {
            swapping = false;
            for (int i = 0; i < array.length-count; i++) {
                if (array[i] > array[i+1]) {
                    swap(array, i, i+1);
                    swapping = true;
                }
            }
            count++;
        }
    }

    private static String arrayListStr(ArrayList<Integer> arrayList) {
        return arrayList.toString().replace("[", "").replace("]", "");
    }

    private static int[] getRandArray(int length, int bound) {
        Random r = new Random();
        int[] randNums = new int[length];
        for (int i = 0; i < length; i++) {
            randNums[i] = r.nextInt(bound);
        }
        return randNums;
    }

    public static void main(String[] args) {
        final int arraySize = 100;
        int[] randNums = getRandArray(arraySize, 25);
        System.out.println(Arrays.toString(randNums));
        ArrayList<Integer> arrayList = findEachIndexOfNumber(10, randNums);
        System.out.println("Num matching: " + arrayList.size());
        System.out.println(arrayListStr(arrayList));
        System.out.println(checkFirstLastHigherOrLower(randNums));
        int[] sequentialArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            sequentialArray[i] = i + 1;
        }
        System.out.println("Sum of array is " + sumOfSequentialArray(sequentialArray));
        System.out.println("Sum of array is " + sumOfSequentialArray2(sequentialArray));

        randNums = getRandArray(arraySize, 100);
        Arrays.sort(randNums);
        System.out.println(Arrays.toString(randNums));
        Random rnd= new Random();
        int randIndex = randNums[rnd.nextInt(randNums.length)];
        System.out.println("Searching for " + randNums[randIndex]);
        System.out.println("Found at index " + searchSortedArray(randNums[randIndex], randNums, 0, randNums.length - 1));

        int[] randNums1 = getRandArray(arraySize, 100);
        int[] randNums2 = getRandArray(arraySize, 100);
        System.out.println("Comparing");
        System.out.println(Arrays.toString(randNums1));
        System.out.println(Arrays.toString(randNums2));
        ArrayList<Indices> indicesList = compareArrays(randNums1, randNums2);
        System.out.print("Matching indices are : ");
        for (Indices indices: indicesList) {
            System.out.print("[" + indices + "] ");
        }

        System.out.println("Sorting");
        System.out.println(Arrays.toString(randNums1));
        sortByValue(randNums1);
        System.out.println(Arrays.toString(randNums1));
    }
}
