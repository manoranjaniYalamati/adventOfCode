package com.example.adventofcode;

import com.fasterxml.jackson.databind.deser.DataFormatReaders;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AOC3 {

    public int getMatchingMultipliedSum(String input) {
        String validRegEx = "mul\\((\\d{1,3}),(\\d{1,3})\\)";

        Pattern pattern = Pattern.compile(validRegEx);
        Matcher matcher = pattern.matcher(input);
        int sum = 0;
        while (matcher.find()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));
            sum += (x * y);
        }
        return sum;
    }

    public int getMatchingMultipliedSumWithDisablingDontEnablingDo(String input) {
        String mulRegEx = "mul\\((\\d{1,3}),(\\d{1,3})\\)";
        Pattern mulPattern = Pattern.compile(mulRegEx);
        Matcher mulMatcher = mulPattern.matcher(input);

        int sum = 0;
        boolean isEnabled = true;

        for (int i = 0; i < input.length(); i++) {
            if (input.startsWith("do()", i)) {
                isEnabled = true;
                i = i + 3;
            } else if (input.startsWith("don't()", i)) {
                isEnabled = false;
                i = i + 6;
            } else if (mulMatcher.find(i) && mulMatcher.start() == i) {
                if (isEnabled) {
                    int x = Integer.parseInt(mulMatcher.group(1));
                    int y = Integer.parseInt(mulMatcher.group(2));

                    sum = sum + (x * y);
                }
                i = mulMatcher.end() - 1;
            }
        }
        return sum;
    }

}

