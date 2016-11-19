package ca.dylancalado.sortingalgorithms.sortingcode;

import ca.dylancalado.sortingalgorithms.experimentcode.MemoryUsage;

/**
 * Logic for performing a selection sort.
 * 
 * @author dylan
 */
public class SelectionSort implements SortFacade
{    
    private static int nextPosition;
    private static int minElemSoFar;
    
    public static void sort(SortParameters p)
    {
        nextPosition = 0;
        
        while(nextPosition < p.getArraySize())
        {
            minElemSoFar = nextPosition;
            
            for(int i = nextPosition; i < p.getArraySize(); ++i)
            {
                switch (p.getSortOrder()) 
                {
                    case DESCENDING:
                        if (p.getArray()[i] > p.getArray()[minElemSoFar]) 
                        {
                            minElemSoFar = i;
                        }
                        break;
                    default:
                        if (p.getArray()[i] < p.getArray()[minElemSoFar])
                        {
                            minElemSoFar = i;
                        }
                        break;
                }
            }
            swap(p.getArray(), nextPosition, minElemSoFar);
            ++nextPosition;
        }
    }

    public static void swap(int[] array, int nextPos, int minElemSoFar)
    {
        int value = array[nextPos];
        array[nextPos] = array[minElemSoFar];
        array[minElemSoFar] = value;
    }
}
