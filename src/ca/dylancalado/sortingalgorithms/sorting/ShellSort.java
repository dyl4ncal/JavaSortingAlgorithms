package ca.dylancalado.sortingalgorithms.sorting;

import ca.dylancalado.sortingalgorithms.experiments.MemoryUsage;
import static java.lang.Math.*;

/**
 * Logic for performing a shell sort and creating
 * different types of gap sequences.
 * 
 * @author dylan
 */
public class ShellSort implements SortInterface 
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
        MemoryUsage.memoryUsageAfterSort();
    }

    public static void generateShellGap(SortParameters params)
    {
        int counter = 0;
        params.getGapSeq().add((int) floor((params.getArraySize()/pow(2.0, 1.0))));
        
        for(double k = 2.0; params.getGapSeq().get(counter) >= 1; ++k)
        {
            params.getGapSeq().add((int) floor((params.getArraySize()/pow(2.0, k))));
            ++counter;
        }
        params.setGapSeqSize(counter);
    }
    
    public static void generatePrattGap(SortParameters params)
    {
        int i;
        int p = 0;
        int q = 0;
        params.getGapSeq().add(1);
        
        for(i = 0; params.getGapSeq().get(i) < params.getArraySize(); ++i)
        {
            if (2*params.getGapSeq().get(p) < 3*params.getGapSeq().get(q))
            {
                params.getGapSeq().add(2*params.getGapSeq().get(p));
                ++p;
            } 
            else if (2*params.getGapSeq().get(p) > 3*params.getGapSeq().get(q)) 
            {
                params.getGapSeq().add(3*params.getGapSeq().get(q));
                ++q;
            } 
            else
            {
                params.getGapSeq().add(2*params.getGapSeq().get(p));
                ++p;
                ++q;
            }
        }
        params.setGapSeqSize(i);
    }
    
    public static void generateKnuthGap(SortParameters params)
    {
        int counter = 0;
        params.getGapSeq().add((int)(pow(3.0, 1.0)-1)/2);
        
        for(double k = 2.0; params.getGapSeq().get(counter) < params.getArraySize(); ++k)
        {
            if(((pow(3.0, k)-1)/2) < ceil(params.getArraySize()/3))
            {
                params.getGapSeq().add((int)(pow(3.0, k)-1)/2);
                ++counter;
            }
            else
            {
                break;
            }
        }
        params.setGapSeqSize(counter);
    }
}
