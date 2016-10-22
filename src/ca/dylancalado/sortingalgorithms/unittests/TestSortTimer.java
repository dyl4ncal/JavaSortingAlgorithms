package ca.dylancalado.sortingalgorithms.unittests;

import ca.dylancalado.sortingalgorithms.experimentcode.SortTimer;
import java.util.ArrayList;

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
    
    public static boolean testEndTimer()
    {
        long expectedOutput = 0;
        long actualOutput = SortTimer.endTimer();
        
        boolean match = actualOutput > expectedOutput;
        
        System.out.print("End timer test passed? ");
        return match;
    }
    
    public static boolean testCalculateSortTime()
    {
        long actualOutput = SortTimer.calculateSortTime();
        long expectedOutput = 0; 
        
        boolean match = actualOutput > expectedOutput;
        
        System.out.print("Calculate sort time test passed? ");
        return match;
    }
    
    public static boolean testCalculateAverageSortTime()
    {
        ArrayList times = new ArrayList();
        long time1 = 502342;
        long time2 = 128923;
        long time3 = 183712;
        times.add(time1);
        times.add(time2);
        times.add(time3);
        
        long expectedOutput = 271659;
        long actualOutput = SortTimer.calculateAverageSortTime(3, times);
        
        boolean match = actualOutput == expectedOutput;
        
        System.out.print("Calculate average sort time test passed? ");
        return match;
    }
    
    public static void testAllSortTimerMethods()
    {
        System.out.println(testStartTimer());
        System.out.println(testEndTimer());
        System.out.println(testCalculateSortTime());
        System.out.println(testCalculateAverageSortTime() + "\n");
    }
}
