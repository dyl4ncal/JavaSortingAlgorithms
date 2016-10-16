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
                
                while(j >= 0 && p.getArray()[j] > value)
                {
                    p.getArray()[j+gap] = p.getArray()[j];
                    j -= gap;
                }
                p.getArray()[j+gap] = value;
            }
        }
    }

    public static void generateShellGap(SortParameters p)
    {
        double k = 1.0;
        for(int i = 0; p.getGapSeq()[i] < p.getArraySize(); ++i)
        {
            p.getGapSeq()[i] = (int) floor((p.getArraySize()/pow(2.0, k)));
            ++k;
        }
    }
    
    public static void generatePrattGap(SortParameters p)
    {
        for(int i = 0; i < p.getArraySize(); ++i)
        {
            
        }
    }
    
    public static void generateKnuthGap(SortParameters p)
    {
        for(int i = 0; i < p.getArraySize(); ++i)
        {
            
        }
    }
}
