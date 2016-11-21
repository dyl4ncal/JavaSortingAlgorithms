package ca.dylancalado.sortingalgorithms.sortingcode;

/**
 * Logic for performing an insertion sort.
 * 
 * @author dylan
 */
public class InsertionSort implements SortFacade
{
    private static int value;
    private static int j;
    
    public static void sort(SortParameters p)
    {
        insertionSort(p.getArray(), 0, p.getArraySize()-1);
        /*for(int i = 1; i < p.getArraySize(); ++i)
        {
            value = p.getArray()[i];
            j = i - 1;
            
            switch (p.getSortOrder())
            {
                case DESCENDING:
                    while (j >= 0 && p.getArray()[j] < value)
                    {
                        p.getArray()[j + 1] = p.getArray()[j];
                        --j;
                    }
                    break;
                default:
                    while (j >= 0 && p.getArray()[j] > value)
                    {
                        p.getArray()[j + 1] = p.getArray()[j];
                        --j;
                    }
                    break;
                    
            }
            p.getArray()[j+1] = value;
        }*/
    } 
    
    public static void insertionSort(int[] list, int left, int right)
    {
        
    }
}
