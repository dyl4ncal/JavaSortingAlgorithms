package ca.dylancalado.sortingalgorithms.sortingcode;

/**
 * Logic for performing a quick sort.
 * 
 * @author Dylan
 */
public class QuickSort implements SortFacade
{
    private static int pivotPosition;
    
    public static void sort(SortParameters p)
    {
        int pivotValue = choosePivotValue();
        
        int i = 0;
        int j = p.getArraySize()-1;
        
        while(i <= j)
        {
            while(p.getArray()[i] < pivotValue)
            {
                ++i;
            }
            while(p.getArray()[j] > pivotValue)
            {
                --j;
            }
            if(i <= j)
            {
                SelectionSort.swap(p.getArray(), i, j);
                ++i;
                --j;
            }
        }
        pivotPosition = i;
        
        QuickSort.sort(p);
        QuickSort.sort(p);
    }
    
    public static int choosePivotValue()
    {
        return 0;
    }
}
