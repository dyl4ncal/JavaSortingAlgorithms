package ca.dylancalado.sortingalgorithms.sorting;

/**
 * Logic for performing a merge sort hybrid.
 * 
 * @author Dylan
 */
public class MergeSortHybrid implements SortFacade
{
    private static int threshold;
    
    public static void sort(SortParameters p)
    {
        int[] left = p.getArray();
        int[] right = p.getArray();

        if (left.length > threshold) 
        {
            MergeSort.sort(p);//left,threshold
        }
        else
        {
            InsertionSort.sort(p);//left
        }
        
        if (right.length > threshold)//right,threshold 
        {
            MergeSort.sort(p);
        }
        else
        {
            InsertionSort.sort(p);//right
        }

        MergeSort.merge(p.getArray(), left, right);
    }
}
