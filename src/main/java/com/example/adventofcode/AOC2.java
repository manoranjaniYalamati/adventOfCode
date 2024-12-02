package com.example.adventofcode;

import java.util.ArrayList;
import java.util.List;

public class AOC2 {

    public static final int MIN_DIFF = 1;
    public static final int MAX_DIFF = 3;

    public int getSafeReportsCount(List<List<Integer>> reportsList) {
        int safeReportsCount = 0;

        for (List<Integer> report : reportsList) {
            if (isReportSafe(report)) {
                safeReportsCount++;
            }
        }
        return safeReportsCount;
    }

    public int getSafeReportsCountWithOneBadLevelIgnore(List<List<Integer>> reportsList) {
        int safeReportsCount = 0;

        for (List<Integer> report : reportsList) {
            if (isReportSafe(report)) {
                safeReportsCount++;
            } else {
                for (int i = 0; i < report.size(); i++) {
                    List<Integer> modifiedReport = new ArrayList<>(report);
                    modifiedReport.remove(i);
                    if (isReportSafe(modifiedReport)) {
                        safeReportsCount++;
                        break; // Count as safe and move to the next report
                    }
                }
            }
        }
        return safeReportsCount;
    }

    private boolean isReportSafe(List<Integer> report) {
        int reportSize = report.size();
        if (reportSize == 1) return true;

        boolean isIncreasing = report.get(1) > report.get(0);

        for (int i = 1; i < reportSize; i++) {
            Integer currentEl = report.get(i);
            Integer prevEl = report.get(i - 1);

            if ((currentEl < prevEl && isInRange(currentEl, prevEl) && !isIncreasing) ||
                    (currentEl > prevEl && isInRange(currentEl, prevEl) && isIncreasing)) {
                continue; // Valid pair, continue checking
            } else {
                return false; // Invalid sequence
            }
        }
        return true; // Entire report is safe
    }

    public boolean isInRange(int currentEl, int prevEl) {
        int diff = Math.abs(currentEl - prevEl);
        return diff >= MIN_DIFF && diff <= MAX_DIFF;
    }
}

