package ca.dylancalado.sortingalgorithms.experimentcode;

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
    
    /*public static long getMemoryCurrentlyUsed()
    {
        currentlyUsedMemory = (Runtime.getRuntime().totalMemory()) - (Runtime.getRuntime().freeMemory());
        return currentlyUsedMemory;
    }*/
    
    /*public static long memoryUsageAfterSort()
    {
        finalMemoryUsage = (Runtime.getRuntime().totalMemory()) - (Runtime.getRuntime().freeMemory());
        return finalMemoryUsage;
    }*/
    
    public static long calculateMemoryUsage()
    {
        memoryUsage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        return memoryUsage;
    }
    
    public static long getmemoryUsage()
    {
        return memoryUsage;
    }
}
