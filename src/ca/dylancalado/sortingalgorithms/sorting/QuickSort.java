package ca.dylancalado.sortingalgorithms.sorting;

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
        int pivotValue = getPivotValue(p.getArray()[0], p.getArray()[(p.getArraySize()/2)-1], p.getArray()[p.getArraySize()-1]);
        
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
        
        p.setLeftIndex(0);
        p.setRightIndex(pivotPosition-1);
        QuickSort.sort(p);
        
        p.setLeftIndex(pivotPosition);
        p.setRightIndex(p.getArraySize()-1);
        QuickSort.sort(p);
    }
    
    public static int getPivotValue(int first, int middle, int last)
    {
        if((first - middle) * (last - first) >= 0)
        {
            return first;
        }
        else if((middle - first) * (last - middle) >= 0)
        {
            return middle;
        } 
        else 
        {
            return last;
        }
    }
}
