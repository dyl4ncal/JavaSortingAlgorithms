package ca.dylancalado.sortingalgorithms.experimentcode;

import ca.dylancalado.sortingalgorithms.sortingcode.*;
import static ca.dylancalado.sortingalgorithms.sortingcode.GapSequenceType.*;
import static ca.dylancalado.sortingalgorithms.sortingcode.SortOrder.ASCENDING;
import ca.dylancalado.sortingalgorithms.sortingcode.SortParameters;
import static ca.dylancalado.sortingalgorithms.sortingcode.SortType.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class encapsulates the functionality of different types
 * of experiments.
 * 
 * @author dylan
 */
public class Experiment
{
    private static int[] array;
    private static int arraySize;
    private static ArrayList<Integer> gapSeq;
    private static int gapSeqSize;
    private static int numOfTrials;
    private static int maxArraySize;
    
    private static void experiment(SortParameters p, int numOfTrials)
    {  
        arraySize = 10000;
        numOfTrials = 5;
        
        if(p.getSortType() == SHELL_SORT)
        {
            maxArraySize = 300000;
        }
        else
        {
            maxArraySize = 100000;
        }
        
        for(int i = arraySize; i <= maxArraySize; i += 10000)
        {
            array = new int[arraySize];
            p.setArray(array);
            createRandomArray(array, arraySize);
            
            for(int j = numOfTrials; j > 0; --j)
            {
                switch(p.getSortType())
                {
                    case SELECTION_SORT:
                        //Logic for: Timing, selection sort, file i/o.
                        SelectionSort.sort(p);
                        break;
                    case INSERTION_SORT:
                        //Logic for: Timing, insertion sort, file i/o.
                        InsertionSort.sort(p);
                        break;
                    case SHELL_SORT:
                        //Logic for: Timing, shell sort, file i/o.
                        ShellSort.sort(p);
                        break;
                    default:
                        break;
                }
            }
        } 
    }
    
    public static void experiment1()
    {
        SortParameters p = new SortParameters(array, arraySize, ASCENDING, SELECTION_SORT);
        experiment(p, numOfTrials);
    }
    
    public static void experiment2()
    {
        SortParameters p = new SortParameters(array, arraySize, ASCENDING, INSERTION_SORT);
        experiment(p, numOfTrials);
    }
    
    public static void experiment3()
    {
        SortParameters p1 = new SortParameters(array, arraySize, SHELL, gapSeq, gapSeqSize, ASCENDING, SHELL_SORT);
        ShellSort.generateShellGap(p1);
        SortParameters p2 = new SortParameters(array, arraySize, PRATT, gapSeq, gapSeqSize, ASCENDING, SHELL_SORT);
        ShellSort.generatePrattGap(p2);
        SortParameters p3 = new SortParameters(array, arraySize, KNUTH, gapSeq, gapSeqSize, ASCENDING, SHELL_SORT);
        ShellSort.generateKnuthGap(p3);
        
        experiment(p1, numOfTrials);
        experiment(p2, numOfTrials);
        experiment(p3, numOfTrials);
    }
  
    public static void runAllExperiments()
    {
        experiment1();
        experiment2();
        experiment3();
    }

    //Creates a random array of integers of arbitrary size.
    public static void createRandomArray(int[] array, int arraySize)
    {
        Random randomNums = new Random();
        
        for (int i = 0; i < arraySize; ++i)
        {
            array[i] = randomNums.nextInt();
        }
    }
}
