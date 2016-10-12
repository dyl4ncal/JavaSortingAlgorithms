package ca.dylancalado.sortingalgorithms.sortingcode;

/**
 * Logic for performing a shell sort.
 * 
 * @author dylan
 */
public class ShellSort implements SortFacade 
{
    private static int gapSeqSize;
    private static int[] gapSeq;
    
    public static void sort(SortParameters p)
    {
        for(int k = gapSeqSize-1; k >= 0; --k)
        {
            int gap = gapSeq[k];
            
            for(int i = gap; i < p.getArraySize(); ++i)
            {
                int value = p.getArray()[i];
                int j = i - gap;
                
                while(j >= 0 && p.getArray()[j] > value)
                {
                    p.getArray()[j+gap] = p.getArray()[j];
                    j -= gap;
                }
                p.getArray()[j+gap] = value;
            }
        }
    }

    public static void generateGapSequence(GapSequenceType type)
    {
        switch(type)
        {
            case SHELL:
                
                break;
            case PRATT:
                
                break;
            case KNUTH:
                
                break;
            case OTHER:
                
                break;
            default:
                break;
            
        }
    }
}
