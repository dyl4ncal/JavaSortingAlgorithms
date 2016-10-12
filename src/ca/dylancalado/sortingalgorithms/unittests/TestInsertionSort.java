package ca.dylancalado.sortingalgorithms.unittests;

import ca.dylancalado.sortingalgorithms.sortingcode.InsertionSort;
import ca.dylancalado.sortingalgorithms.sortingcode.SortParameters;
import java.util.Arrays;

/**
 * Unit tests related to insertion sort.
 * 
 * @author dylan
 */
public class TestInsertionSort 
{
    public static boolean testInsertionSort()
    {
        int[] testArray = {3, 6, 1, 10, 4, 8, 9, 2, 5, 7};
        int[] expectedOutput = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SortParameters p = new SortParameters(testArray, 10);
        
        InsertionSort.sort(p);
        
        if(Arrays.equals(testArray, expectedOutput))
        {
            System.out.print("Selection sort test passed? ");
            return true;
        }
        else
        {
            System.out.print("Selection sort test passed? ");
            return false;
        }
    }    
    
    public static boolean testAllInsertionSortMethods()
    {
        return true;
    }
}
