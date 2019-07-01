package com.zipcodewilmington.arrayutility;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    T[] typeArray;

    ArrayUtility(T[] typeArray) {
        this.typeArray = typeArray;
    }

    public Integer countDuplicatesInMerge(T[] array, T type) {

        Integer counter = 0;

        for(T value : typeArray) {
            if(value.equals(type)) counter++;
        }

        for(T value : array) {
            if(value.equals(type)) counter++;
        }

        return counter;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {

        T result = null;
        Integer most = 0;

        for(T value : typeArray) {
            Integer count = countDuplicatesInMerge(arrayToMerge, value);
            if(count > most) {
                result = value;
                most = count;
            }
        }

        for(T value : arrayToMerge) {
            Integer count = countDuplicatesInMerge(arrayToMerge, value);
            if(count > most) {
                result = value;
                most = count;
            }
        }


        return result;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {

        Integer counter = 0;

        for(T value : typeArray) {
            if(value.equals(valueToEvaluate)) counter++;
        }
        return counter;
    }

    public T[] removeValue(T valueToRemove) {

        /*
        NOTE TO SELF:

        If you need to copy a generic array. Use a pre-existing array and use Arrays.copyOf() with the correct length as a parameter;
         */

        T[] remove = Arrays.copyOf(typeArray, typeArray.length - getNumberOfOccurrences(valueToRemove));
        int index = 0;

        for(T value : typeArray) {
            if(!value.equals(valueToRemove)) {
                remove[index] = value;
                index++;
            }
        }

        return remove;
    }
}
