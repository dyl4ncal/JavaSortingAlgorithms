package ca.dylancalado.sortingalgorithms.experimentcode;

/**
 * This class contains the code which times the runtime of any sorting algorithm.
 * 
 * @author Dylan
 */
public class SortTimer
{
    private static long tStart;
    private static long tFinish;
    private static long totalSortTime;
    
    public static long startTimer()
    {
        tStart = System.nanoTime();
        return tStart;
    }
    
    public static long calculateSortTime()
    {
        tFinish = System.nanoTime();
        totalSortTime = tFinish - tStart;
        return totalSortTime;
    }
    
    public static long calculateAverageSortTime()
    {
        //Total time for 5 sort trials / 5;
        return 1;
    }
}
