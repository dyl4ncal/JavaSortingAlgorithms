package ca.dylancalado.sortingalgorithms.unittests;

import ca.dylancalado.sortingalgorithms.experimentcode.MemoryUsage;
import java.util.ArrayList;

/**
 * Unit tests related to the memory usage calculations.
 * 
 * @author Dylan
 */
public class TestMemoryUsage 
{  
    public static boolean testMemoryCurrentlyUsed()
    {
        long notExpectedOutput = 0;
        long actualOutput = MemoryUsage.memoryCurrentlyUsed();
        
        boolean match = actualOutput > notExpectedOutput;
        
        System.out.print("Memory currently used test passed? ");
        return match;
    }
    
    public static boolean testMemoryUsageAfterSort()
    {
        long notExpectedOutput = 0;
        long actualOutput = MemoryUsage.memoryUsageAfterSort();
        
        boolean match = actualOutput > notExpectedOutput;
        
        System.out.print("Memory usage after sort test passed? ");
        return match;
    }
    
    public static boolean testCalculateMemoryUsage()
    {
        long expectedOutput = 0;
        long actualOutput = MemoryUsage.calculateMemoryUsage();
        
        boolean match = actualOutput >= expectedOutput;
        
        System.out.print("Calculate memory usage test passed? ");
        return match;
    }
    
    public static boolean testCalculateAverageMemoryUsage()
    {
        ArrayList memValues = new ArrayList();
        long mem1 = 96;
        long mem2 = 4;
        long mem3 = 1200;
        memValues.add(mem1);
        memValues.add(mem2);
        memValues.add(mem3);
        
        long expectedOutput = 1300/3;
        long actualOutput = MemoryUsage.calculateAverageMemoryUsage(3, memValues);
        
        boolean match = actualOutput == expectedOutput;
        
        System.out.print("Calculate average memory usage test passed? ");
        return match;
    }
    
    public static void testAllMemoryUsageMethods()
    {
        System.out.println("Unit Tests Related to Memory Usage:\n");
        System.out.println(testMemoryCurrentlyUsed());
        System.out.println(testMemoryUsageAfterSort());
        System.out.println(testCalculateMemoryUsage());
        System.out.println(testCalculateAverageMemoryUsage() + "\n");
    }
}
