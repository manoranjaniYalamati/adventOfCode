package com.example.adventofcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ADC1 {

    public int getDiffSum(List<Integer> list1, List<Integer> list2) {
        List<Integer> sortedList1 = list1.stream().sorted().toList();
        List<Integer> sortedList2 = list2.stream().sorted().toList();
        int sum = 0;
        for (int i = 0; i < sortedList1.size(); i++) {
            sum += Math.abs(sortedList1.get(i) - sortedList2.get(i));
        }

        System.out.println("sum " + sum);
        return sum;
    }

    public int getSimilarityScore(List<Integer> list1, List<Integer> list2) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(Integer i : list2) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }
        int sum = 0;
        for (Integer i : list1) {
            sum = sum + (i * freqMap.getOrDefault(i, 0));
        }
        return sum;
    }

    public static void main(String[] args) {

//        List<Integer> list1 = new ArrayList<>();
//        List<Integer> list2 = new ArrayList<>();
//
//        try(Scanner scanner = new Scanner(new File("/Users/a1989/Documents/adventOfCode/src/main/resources/inputADC1.txt"))) {
//            while(scanner.hasNextLine()) {
//                String s = scanner.nextLine();
//                String[] list = s.split("   ");
//                list1.add(Integer.parseInt(list[0]));
//                list2.add(Integer.parseInt(list[1]));
//            }
//        }
//        catch (FileNotFoundException ex) {
//            ex.printStackTrace();
//        }
//        List<Integer> list1 = new ArrayList<>(Arrays.asList(3,4,2,1,3,3));
//        List<Integer> l1 = new ArrayList<>();
//        l1.add(1);
//        l1.add(2);
//
//        List<Integer> l2 = new ArrayList<>();
//        l2.add(0);
//        l2.add(2);
//
//        List<Integer> list2 = new ArrayList<>(Arrays.asList(4,3,5,3,9,3));

//        getDiffSum(list1, list2);
    }
}
