package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<SomeType> {
    private final SomeType[] array;

    public ArrayUtility(SomeType[] array) {
        this.array = array;
    }

    public Integer countDuplicatesInMerge(SomeType[] arrayToMerge, SomeType valueToEvaluate) {
        List<SomeType> mergedList = merge(array, arrayToMerge);
        Integer counter = 0;
        for (SomeType value : mergedList) if (value == valueToEvaluate) counter++;
        return counter;
    }

    public SomeType getMostCommonFromMerge(SomeType[] arrayToMerge) {
        List<SomeType> mergedList = merge(array, arrayToMerge);
        SomeType[] mergedArray = (SomeType[]) mergedList.toArray();
        Arrays.sort(mergedArray);

        int maxCount = 1, currentCount = 1;
        SomeType mostCommon = mergedArray[0];
        for (int i = 1; i < mergedArray.length; i++) {
            if (mergedArray[i] == mergedArray[i-1]) currentCount++;
            else currentCount = 1;
            if (currentCount > maxCount) {
                maxCount = currentCount;
                mostCommon = mergedArray[i-1];
            }
        }
        return mostCommon;
    }

    public Integer getNumberOfOccurrences(SomeType valueToEvaluate) {
        Integer counter = 0;
        for (SomeType value : array) if (value == valueToEvaluate) counter++;
        return counter;
    }

    public SomeType[] removeValue(SomeType valueToRemove) {
        List<SomeType> removed = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != valueToRemove) removed.add(array[i]);
        }
        return (SomeType[]) removed.toArray();
    }

    public List<SomeType> merge(SomeType[] array1, SomeType[] array2) {
        List<SomeType> mergedList = new ArrayList<>(Arrays.asList(array1));
        mergedList.addAll(Arrays.asList(array2));
        return mergedList;
    }
}
