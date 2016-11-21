package ca.dylancalado.sortingalgorithms.sortingcode;

/**
 * Logic for performing a merge sort.
 * 
 * @author Dylan
 */
public class MergeSort implements SortFacade
{
    public static void sort(SortParameters p)
    {
        int[] left = p.getArray();
        int[] right = p.getArray();  
        
        if(left.length > 1)
        {
            MergeSort.sort(p);
        }
        if(right.length > 1)
        {
            MergeSort.sort(p);
        }
        
        merge(p.getArray(), left, right);
    }
    
    public static void merge(int[] list, int[] left, int[] right)
    {
        int l = 0;
        int r = 0;
        
        for(int i = 0; i < list.length-1; ++i)
        {
            if(left[l] < right[r])
            {
                list[++i] = left[++l];
            }
            else if(left[l] > right[r])
            {
                list[++i] = right[++r];
            }
            else
            {
                list[++i] = left[++l];
                list[++i] = right[++r];
            }
        }
    }
}
