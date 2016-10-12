package ca.dylancalado.sortingalgorithms.experimentcode;

import ca.dylancalado.sortingalgorithms.sortingcode.SortParameters;
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
    private static int numOfTrials;
    private static SortParameters p;
    
    private static void experiment(SortParameters p, int numOfTrials)
    {   arraySize = 10000;
        numOfTrials = 5;
        
        for(int i = arraySize; i <= 100000; i += 10000)
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
                        break;
                    case INSERTION_SORT:
                        //Logic for: Timing, insertion sort, file i/o.
                        break;
                    case SHELL_SORT:
                        //Logic for: Timing, shell sort, file i/o.
                        break;
                    default:
                        break;
                }
            }
        } 
    }
    
    public static void experiment1()
    {
       experiment(p, numOfTrials);
    }
    
    public static void experiment2()
    {
       experiment(p, numOfTrials);
    }
    
    public static void experiment3()
    {
       experiment(p, numOfTrials);
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
