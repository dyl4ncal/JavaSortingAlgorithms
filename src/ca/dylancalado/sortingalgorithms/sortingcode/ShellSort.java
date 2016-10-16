package ca.dylancalado.sortingalgorithms.sortingcode;

import static java.lang.Math.floor;
import static java.lang.Math.pow;

/**
 * Logic for performing a shell sort.
 * 
 * @author dylan
 */
public class ShellSort implements SortFacade 
{
    public static void sort(SortParameters p)
    {
        for(int k = p.getGapSeqSize()-1; k >= 0; --k)
        {
            int gap = p.getGapSeq()[k];
            
            for(int i = gap; i < p.getArraySize(); ++i)
            {
                int value = p.getArray()[i];
                int j = i - gap;
                
                switch (p.getSortOrder())
                {
                    case ASCENDING:
                        while (j >= 0 && p.getArray()[j] > value)
                        {
                            p.getArray()[j + gap] = p.getArray()[j];
                            j -= gap;
                        }
                        break;
                    case DESCENDING:
                        while (j >= 0 && p.getArray()[j] < value)
                        {
                            p.getArray()[j + gap] = p.getArray()[j];
                            j -= gap;
                        }
                        break;
                    default:
                        break;
                }  
                p.getArray()[j+gap] = value;
            }
        }
    }

    public static void generateShellGap(SortParameters params)
    {
        double k = 1.0;
        for(int i = 0; params.getGapSeq()[i] > 1; ++i)
        {
            params.getGapSeq()[i] = (int) floor((params.getArraySize()/pow(2.0, k)));
            ++k;
        }
    }
    
    public static void generatePrattGap(SortParameters params)
    {
        double p = 0.0;
        double q = 0.0;
        
        for(int i = 0; params.getGapSeq()[i] < params.getArraySize(); ++i)
        {
            
        }
    }
    
    public static void generateKnuthGap(SortParameters params)
    {
        for(int i = 0; i < params.getArraySize(); ++i)
        {
            
        }
    }
}
