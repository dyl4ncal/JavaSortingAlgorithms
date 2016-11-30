package ca.dylancalado.sortingalgorithms.experiments;

import java.util.ArrayList;

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
    private static long average;
    private static ArrayList<Long> sortTimesList = new ArrayList<>();
    
    public static long startTimer()
    {
        tStart = System.nanoTime();
        return tStart;
    }
    
    public static long endTimer()
    {
         tFinish = System.nanoTime();
         return tFinish;
    }
    
    public static long calculateSortTime()
    {
        totalSortTime = tFinish - tStart;
        return totalSortTime;
    }
    
    public static void storeSortTimes(long runTime)
    {
        sortTimesList.add(runTime);
    }
    
    public static ArrayList getStoredTimes()
    {
        return sortTimesList;
    }
    
    public static long getAverageSortTime()
    {
        return average;
    }
    
    public static long calculateAverageSortTime(int n, ArrayList times)
    {
        long sum = 0;
        for(int i = 0; i < times.size(); ++i)
        {
            sum += (long) times.get(i);
        }
        average = sum/n;
        
        return average;
    }
}
