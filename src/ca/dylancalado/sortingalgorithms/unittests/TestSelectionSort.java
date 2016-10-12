package ca.dylancalado.sortingalgorithms.unittests;

import ca.dylancalado.sortingalgorithms.sortingcode.SelectionSort;
import ca.dylancalado.sortingalgorithms.sortingcode.SortParameters;
import java.util.Arrays;

/**
 * Unit tests related to selection sort.
 * 
 * @author dylan
 */
public class TestSelectionSort
{
    public static boolean testSelectionSort()
    {
        int[] testArray = {3, 6, 1, 10, 4, 8, 9, 2, 5, 7};
        int[] expectedOutput = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SortParameters p = new SortParameters(testArray, 10);
        
        SelectionSort.sort(p);
        
        /*for(int i = 0; i < 10; ++i)
        {
            System.out.print(testArray[i]); //Prints array to visually see if its sorted.
            if(i < 9)
            {
                System.out.print(", ");
            }
        }*/
        
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
    
    public static boolean testSwap()
    {
        int[] testArray = {9, 4};
        int[] expectedOutput = {4,9};
        int a = 1;
        int b = 0;
        SelectionSort.swap(testArray, a, b);
       
        if(Arrays.equals(testArray, expectedOutput))
        {
            System.out.print("Swap test passed? ");
            return true;
        }
        else
        {
            System.out.print("Swap test passed? ");
            return false;
        }
    }
    
    public static boolean testAllSelectionSortMethods()
    {
        testSwap();
        testSelectionSort();
        
        if(testSwap() == true && testSelectionSort() == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
