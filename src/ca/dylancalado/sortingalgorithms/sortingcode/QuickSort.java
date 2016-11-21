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
        int pivotValue = getPivotValue(p.getArray()[0], p.getArray()[p.getArraySize()/2], p.getArray()[p.getArraySize()]);
        
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
    
    public static int getPivotValue(int first, int middle, int last)
    {
        if ((first - middle) * (last - first) >= 0) // a >= b and a <= c OR a <= b and a >= c
        {
            return first;
        }
        else if ((middle - first) * (last - middle) >= 0) // b >= a and b <= c OR b <= a and b >= c
        {
            return middle;
        } 
        else 
        {
            return last;
        }
    }
}
