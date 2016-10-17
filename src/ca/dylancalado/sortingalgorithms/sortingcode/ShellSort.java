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
            int gap = p.getGapSeq().get(k);
            
            for(int i = gap; i < p.getArraySize(); ++i)
            {
                int value = p.getArray()[i];
                int j = i - gap;
                
                switch (p.getSortOrder())
                {
                    case DESCENDING:
                        while (j >= 0 && p.getArray()[j] < value)
                        {
                            p.getArray()[j + gap] = p.getArray()[j];
                            j -= gap;
                        }
                        break;
                    default:
                        while (j >= 0 && p.getArray()[j] > value)
                        {
                            p.getArray()[j + gap] = p.getArray()[j];
                            j -= gap;
                        }
                        break;
                }  
                p.getArray()[j+gap] = value;
            }
        }
    }

    public static void generateShellGap(SortParameters p)
    {
        int counter = 0;
        p.getGapSeq().add((int) floor((p.getArraySize()/pow(2.0, 1.0))));
        
        for(double k = 2.0; p.getGapSeq().get(counter) >= 1; ++k)
        {
            p.getGapSeq().add((int) floor((p.getArraySize()/pow(2.0, k))));
       
            ++counter;
        }
    }
    
    public static void generatePrattGap(SortParameters params)
    {
        double p = 0.0;
        double q = 0.0;
        
    }
    
    public static void generateKnuthGap(SortParameters params)
    {
      
    }
}
