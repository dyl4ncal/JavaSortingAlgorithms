package ca.dylancalado.sortingalgorithms.experimentcode;

import java.util.ArrayList;

/**
 * This class contains the code which calculates the 
 * memory usage of any sorting algorithm.
 *  
 * @author Dylan
 */
public class MemoryUsage 
{
    private static long currentlyUsedMemory;
    private static long finalMemoryUsage;
    private static long memoryUsage;
    private static long average;
    private static ArrayList<Long> memoryUsageList = new ArrayList<>();
    
    public static long memoryCurrentlyUsed()
    {
        currentlyUsedMemory = (Runtime.getRuntime().totalMemory()) - (Runtime.getRuntime().freeMemory());
        return currentlyUsedMemory;
    }
    
    public static long memoryUsageAfterSort()
    {
        finalMemoryUsage = (Runtime.getRuntime().totalMemory()) - (Runtime.getRuntime().freeMemory());
        return finalMemoryUsage;
    }
    
    public static long calculateMemoryUsage()
    {
        memoryUsage = (finalMemoryUsage - currentlyUsedMemory);
        return memoryUsage;
    }
    
    public static void storeMemoryValues(long memory)
    {
        memoryUsageList.add(memory);
    }
    
    public static ArrayList getStoredMemoryValues()
    {
        return memoryUsageList;
    }
    
    public static long calculateAverageMemoryUsage(int n, ArrayList memValues)
    {
        long sum = 0;
        for(int i = 0; i < memValues.size(); ++i)
        {
            sum += (long) memValues.get(i);
        }
        average = sum/n;
        
        return average;
    }
}
