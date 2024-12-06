package com.example.adventofcode;


import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;


public class AOC5 {

    public int getSumOfMiddlePageOfValidUpdatePages(Map<Integer, Set<Integer>> validTransitions, List<List<Integer>> updatePagesList) {
        int sum = 0;

        for (List<Integer> updatePageList : updatePagesList) {
            boolean isUpdatePageListValid = isUpdatePageListValid(updatePageList, validTransitions);


            if (isUpdatePageListValid) {
                sum = sum + updatePageList.get(updatePageList.size() / 2);
            }
        }

        return sum;
    }

    public int getSumOfMiddlePageOfInValidUpdatePagesOnceMadeValid(Map<Integer, Set<Integer>> validTransitions, List<List<Integer>> updatePagesList) {
        int sum = 0;
        for (List<Integer> updatePageList : updatePagesList) {
            int middleElement = getMiddleElement(validTransitions, updatePageList);
            sum = sum + middleElement;
        }
        return sum;

    }

    private int getMiddleElement(Map<Integer, Set<Integer>> validTransitions, List<Integer> updatePageList) {
        Pair<List<Integer>, Boolean> orderedPair = isListAlreadyOrdered( validTransitions, updatePageList);
        List<Integer> orderedList = orderedPair.getLeft();
        boolean isListOrderedAlready = orderedPair.getRight();
        if(isListOrderedAlready) return 0;
        return orderedList.get(orderedList.size() / 2);
    }

    public Pair<List<Integer>, Boolean> isListAlreadyOrdered(Map<Integer, Set<Integer>> validTransitions, List<Integer> updatePageList) {
        boolean flag = true;
        for (int i = 1; i < updatePageList.size(); i++) {
            int beforePage = updatePageList.get(i-1);
            int afterPage = updatePageList.get(i);

            if (!validTransitions.containsKey(beforePage) || !validTransitions.get(beforePage).contains(afterPage)) {
                flag = false;
                Collections.swap(updatePageList, i-1, i);
                int k=i-1;
                while(k>0){
                    beforePage = updatePageList.get(k-1);
                    afterPage = updatePageList.get(k);
                    if (!validTransitions.containsKey(beforePage) || !validTransitions.get(beforePage).contains(afterPage)) {
                        Collections.swap(updatePageList, k-1, k);
                        k--;
                    } else {
                        break;
                    }
                }
            }
        }
        return new ImmutablePair<>(updatePageList, flag);
    }


    private static boolean isUpdatePageListValid(List<Integer> updatePageList, Map<Integer, Set<Integer>> validTransitions) {
        for (int i = 0; i < updatePageList.size() - 1; i++) { //check if it can be incremented by i+2
            int beforePage = updatePageList.get(i);
            int afterPage = updatePageList.get(i + 1);

            if (!validTransitions.containsKey(beforePage) || !validTransitions.get(beforePage).contains(afterPage)) {
                return false;
            }
        }
        return true;
    }

}
