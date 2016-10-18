package ca.dylancalado.sortingalgorithms.experimentcode;

/**
 * This class contains the code which times the runtime of any sorting algorithm.
 * 
 * @author Dylan
 */
public class SortTimer
{
    public static long timeSort()
    {
        long tStart = System.nanoTime();
        long tFinish = System.nanoTime();
        long sortTime = tFinish - tStart;
        System.out.print(sortTime + "ns" + ", ");
        return sortTime;
    }
    
    public static long calculateAverageSortTime()
    {
        //Total time for 5 sort trials / 5;
        return 1;
    }
}
