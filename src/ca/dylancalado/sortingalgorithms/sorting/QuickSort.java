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
        int[] array = p.getArray();
        int left = p.getLeftIndex();
        int right = p.getRightIndex();
        int i = p.getLeftIndex();
        int j = p.getRightIndex();
        
        int pivotValue = getPivotValue(array, i, j);
        
        while(i <= j)
        {
            switch (p.getSortOrder()) 
            {
                case ASCENDING:
                    while (array[i] < pivotValue)
                    {
                        i++;
                    }
                    while (array[j] > pivotValue)
                    {
                        j--;
                    }
                    if (i <= j) 
                    {
                        SelectionSort.swap(array, i, j);
                        i++;
                        j--;
                    }
                    break;
                case DESCENDING:
                    while (array[i] > pivotValue)
                    {
                        i++;
                    }
                    while (array[j] < pivotValue)
                    {
                        j--;
                    }
                    if (i <= j) 
                    {
                        SelectionSort.swap(array, i, j);
                        i++;
                        j--;
                    }
                    break;
            }        
        }
        pivotPosition = i;

        if(left < right)
        {
            p.setLeftIndex(left);
            p.setRightIndex(pivotPosition-1);
            QuickSort.sort(p);

            p.setLeftIndex(pivotPosition);
            p.setRightIndex(right);
            QuickSort.sort(p);
        }
    }
    
    public static int getPivotValue(int[] arr, int first, int last)
    {
        int pivot = arr[first+(last-first)/2];
        return pivot;
    }
}
