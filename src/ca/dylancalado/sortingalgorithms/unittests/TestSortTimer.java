package ca.dylancalado.sortingalgorithms.unittests;

import ca.dylancalado.sortingalgorithms.experimentcode.SortTimer;

/**
 * Unit tests related to the sort timer.
 * 
 * @author Dylan
 */
public class TestSortTimer 
{
    public static boolean testStartTimer()
    {
        long expectedOutput = 0;
        long actualOutput = SortTimer.startTimer();
        
        boolean match = actualOutput > expectedOutput;
        
        System.out.print("Start timer test passed? ");
        return match;
    }
    
    public static boolean testCalculateSortTime()
    {
        SortTimer.startTimer();
        long actualOutput = SortTimer.calculateSortTime();
        long expectedOutput = 0; 
        
        boolean match = actualOutput > expectedOutput;
        
        System.out.print("Calculate sort time test passed? ");
        return match;
    }
    
    public static boolean testCalculateAverageSortTime()
    {
        System.out.print("Calculate average sort time test passed? ");
        return false;
    }
    
    public static void testAllSortTimerMethods()
    {
        System.out.println(testStartTimer());
        System.out.println(testCalculateSortTime());
        System.out.println(testCalculateAverageSortTime() + "\n");
    }
}
