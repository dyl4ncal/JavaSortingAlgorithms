package ca.dylancalado.sortingalgorithms.experiments;

import ca.dylancalado.sortingalgorithms.sorting.*;
import ca.dylancalado.sortingalgorithms.fileio.FileIO;
import static ca.dylancalado.sortingalgorithms.sorting.GapSequenceType.*;
import static ca.dylancalado.sortingalgorithms.sorting.SortOrder.*;
import static ca.dylancalado.sortingalgorithms.sorting.SortType.*;
import java.io.IOException;
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
    private static ArrayList<Integer> gapSeq = new ArrayList<>();
    private static int gapSeqSize;
    private static int numOfTrials;
    private static int maxArraySize;
    private static long runTime;
    private static long memUsage;
    
    //Logic for performing non-recursive type experiments(Selection, Insertion, and Shell Sort)
    private static void nonRecursiveExperiment(SortParameters p, int numOfTrials) throws IOException
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
        FileIO.writeRuntimeHeader();
        FileIO.writeMemoryUsageHeader();
        
        for(int i = arraySize; i <= maxArraySize; i += 10000)
        {
            array = new int[i];
         
            for(int j = numOfTrials; j >= 0; --j)
            {
                p.setArray(createRandomArray(array, arraySize));
                switch(p.getSortType())
                {
                    case SELECTION_SORT:
                        SortTimer.startTimer();
                        SelectionSort.sort(p);
                        SortTimer.endTimer();
                        runTime = SortTimer.calculateSortTime();
                        SortTimer.storeSortTimes(runTime);
                        memUsage = MemoryUsage.calculateMemoryUsage();
                        MemoryUsage.storeMemoryValues(memUsage);
                        verifySortCorrectness(p.getArray(), p.getSortOrder());
                        break;
                    case INSERTION_SORT:
                        SortTimer.startTimer();
                        InsertionSort.sort(p);
                        SortTimer.endTimer();
                        runTime = SortTimer.calculateSortTime();
                        SortTimer.storeSortTimes(runTime);
                        memUsage = MemoryUsage.calculateMemoryUsage();
                        MemoryUsage.storeMemoryValues(memUsage);
                        verifySortCorrectness(p.getArray(), p.getSortOrder());
                        break;
                    case SHELL_SORT:
                        SortTimer.startTimer();
                        ShellSort.sort(p);
                        SortTimer.endTimer();
                        runTime = SortTimer.calculateSortTime();
                        SortTimer.storeSortTimes(runTime);
                        memUsage = MemoryUsage.calculateMemoryUsage();
                        MemoryUsage.storeMemoryValues(memUsage);
                        verifySortCorrectness(p.getArray(), p.getSortOrder());
                        break;
                    default:
                        System.out.println("Invalid Sort Type");
                        break;
                }
            }
            long averageTime = SortTimer.calculateAverageSortTime(numOfTrials, SortTimer.getStoredTimes());
            FileIO.writeTimingDataToCSV(i, averageTime);
            long averageMemory = MemoryUsage.calculateAverageMemoryUsage(numOfTrials, MemoryUsage.getStoredMemoryValues());
            FileIO.writeMemoryDataToCSV(i, averageMemory);
        }
        SortTimer.getStoredTimes().clear();
        MemoryUsage.getStoredMemoryValues().clear();
        FileIO.closeWriter();
    }
    
    //Logic for performing recursive type experiments(Merge, Quick, and Hybrid Sorts)
    private static void recursiveExperiment(SortParameters p, int numOfTrials) throws IOException
    {  
        arraySize = 50000;
        numOfTrials = 5;
        maxArraySize = 1000000;
        
        FileIO.writeRuntimeHeader();
        FileIO.writeMemoryUsageHeader();
        
        for(int i = arraySize; i <= maxArraySize; i += 50000)
        {
            array = new int[i];
       
            for(int j = numOfTrials; j >= 0; --j)
            { 
                p.setArray(createRandomArray(array, arraySize));
                switch(p.getSortType())
                {
                    case MERGE_SORT:
                        SortTimer.startTimer();
                        MergeSort.sort(p);
                        SortTimer.endTimer();
                        runTime = SortTimer.calculateSortTime();
                        SortTimer.storeSortTimes(runTime);
                        memUsage = MemoryUsage.calculateMemoryUsage();
                        MemoryUsage.storeMemoryValues(memUsage);
                        verifySortCorrectness(p.getArray(), p.getSortOrder());
                        break;
                    case QUICK_SORT:
                        SortTimer.startTimer();
                        QuickSort.sort(p);
                        SortTimer.endTimer();
                        runTime = SortTimer.calculateSortTime();
                        SortTimer.storeSortTimes(runTime);
                        memUsage = MemoryUsage.calculateMemoryUsage();
                        MemoryUsage.storeMemoryValues(memUsage);
                        verifySortCorrectness(p.getArray(), p.getSortOrder());
                        break;
                    case MERGE_SORT_HYBRID:
                        SortTimer.startTimer();
                        MergeSortHybrid.sort(p);
                        SortTimer.endTimer();
                        runTime = SortTimer.calculateSortTime();
                        SortTimer.storeSortTimes(runTime);
                        memUsage = MemoryUsage.calculateMemoryUsage();
                        MemoryUsage.storeMemoryValues(memUsage);
                        verifySortCorrectness(p.getArray(), p.getSortOrder());
                        break;
                    case QUICK_SORT_HYBRID:
                        p.setRightIndex(arraySize-1);//////////////////////////////////////////////////////////////////////
                        SortTimer.startTimer();
                        QuickSortHybrid.sort(p);
                        SortTimer.endTimer();
                        runTime = SortTimer.calculateSortTime();
                        SortTimer.storeSortTimes(runTime);
                        memUsage = MemoryUsage.calculateMemoryUsage();
                        MemoryUsage.storeMemoryValues(memUsage);
                        verifySortCorrectness(p.getArray(), p.getSortOrder());
                        break;
                    case SHELL_SORT:
                        SortTimer.startTimer();
                        ShellSort.sort(p);
                        SortTimer.endTimer();
                        runTime = SortTimer.calculateSortTime();
                        SortTimer.storeSortTimes(runTime);
                        memUsage = MemoryUsage.calculateMemoryUsage();
                        MemoryUsage.storeMemoryValues(memUsage);
                        verifySortCorrectness(p.getArray(), p.getSortOrder());
                        break;
                    default:
                        System.out.println("Invalid Sort Type");
                        break;
                }
            }
            long averageTime = SortTimer.calculateAverageSortTime(numOfTrials, SortTimer.getStoredTimes());
            FileIO.writeTimingDataToCSV(i, averageTime);
            long averageMemory = MemoryUsage.calculateAverageMemoryUsage(numOfTrials, MemoryUsage.getStoredMemoryValues());
            FileIO.writeMemoryDataToCSV(i, averageMemory);
        }
        SortTimer.getStoredTimes().clear();
        MemoryUsage.getStoredMemoryValues().clear();
        FileIO.closeWriter();
    }
    
    //The following methods perform particular experiments.
    public static void experiment1A2() throws IOException
    {
        System.out.print("Enter name for Experiment 1 runtime data file: ");
        FileIO.setTimingCSVName();
        FileIO.createCSVTimingFile();
        System.out.print("Enter name for Experiment 1 memory usage data file: ");
        FileIO.setMemoryCSVName();
        FileIO.createCSVMemoryFile();
        SortParameters p = new SortParameters(array, arraySize, ASCENDING, SELECTION_SORT);
        System.out.println("Experiment 1 running...\n");
        nonRecursiveExperiment(p, numOfTrials);
    }
    
    public static void experiment2A2() throws IOException
    {
        System.out.print("Enter name for Experiment 2 runtime data file: ");
        FileIO.setTimingCSVName();
        FileIO.createCSVTimingFile();
        System.out.print("Enter name for Experiment 2 memory usage data file: ");
        FileIO.setMemoryCSVName();
        FileIO.createCSVMemoryFile();
        SortParameters p = new SortParameters(array, arraySize, ASCENDING, INSERTION_SORT);
        System.out.println("Experiment 2 running...\n");
        nonRecursiveExperiment(p, numOfTrials);
    }
    
    public static void experiment3ShellGapA2() throws IOException
    {
        System.out.print("Enter name for Experiment 3 (Shell's gap) runtime data file: ");
        FileIO.setTimingCSVName();
        FileIO.createCSVTimingFile();
        System.out.print("Enter name for Experiment 3 (Shell's gap) memory usage data file: ");
        FileIO.setMemoryCSVName();
        FileIO.createCSVMemoryFile();
        SortParameters p1 = new SortParameters(array, arraySize, SHELL, gapSeq, gapSeqSize, ASCENDING, SHELL_SORT);
        System.out.println("Experiment 3 (Shell's gap) running...\n");
        ShellSort.generateShellGap(p1);
        nonRecursiveExperiment(p1, numOfTrials);     
    }
    
    public static void experiment3PrattGapA2() throws IOException
    {
        System.out.print("Enter name for Experiment 3 (Pratt's gap) runtime data file: ");
        FileIO.setTimingCSVName();
        FileIO.createCSVTimingFile();
        System.out.print("Enter name for Experiment 3 (Pratt's gap) memory usage data file: ");
        FileIO.setMemoryCSVName();
        FileIO.createCSVMemoryFile();
        SortParameters p2 = new SortParameters(array, arraySize, PRATT, gapSeq, gapSeqSize, ASCENDING, SHELL_SORT);
        System.out.println("Experiment 3 (Pratt's gap) running...\n");
        ShellSort.generatePrattGap(p2);
        nonRecursiveExperiment(p2, numOfTrials);
    }
    
    public static void experiment3KnuthGapA2() throws IOException
    {
        System.out.print("Enter name for Experiment 3 (Knuth's gap) runtime data file: ");
        FileIO.setTimingCSVName();
        FileIO.createCSVTimingFile();
        System.out.print("Enter name for Experiment 3 (Knuth's gap) memory usage data file: ");
        FileIO.setMemoryCSVName();
        FileIO.createCSVMemoryFile();
        SortParameters p3 = new SortParameters(array, arraySize, KNUTH, gapSeq, gapSeqSize, ASCENDING, SHELL_SORT);
        System.out.println("Experiment 3 (Knuth's gap) running...\n");
        ShellSort.generateKnuthGap(p3);
        nonRecursiveExperiment(p3, numOfTrials);
    }
    
    public static void experiment1A4() throws IOException
    {
        System.out.print("Enter name for Experiment 1 runtime data file: ");
        FileIO.setTimingCSVName();
        FileIO.createCSVTimingFile();
        System.out.print("Enter name for Experiment 1 memory usage data file: ");
        FileIO.setMemoryCSVName();
        FileIO.createCSVMemoryFile();
        SortParameters p = new SortParameters(array, arraySize, ASCENDING, MERGE_SORT);
        System.out.println("Experiment 1 running...\n");
        recursiveExperiment(p, numOfTrials);
    }
    
    public static void experiment2A4() throws IOException
    {
        System.out.print("Enter name for Experiment 2(Threshold = 2) runtime data file: ");
        FileIO.setTimingCSVName();
        FileIO.createCSVTimingFile();
        System.out.print("Enter name for Experiment 2(Threshold = 2) memory usage data file: ");
        FileIO.setMemoryCSVName();
        FileIO.createCSVMemoryFile();
        SortParameters p1 = new SortParameters(array, arraySize, 2, ASCENDING, MERGE_SORT_HYBRID);
        System.out.println("Experiment 2 running...\n");
        recursiveExperiment(p1, numOfTrials);
        
        
        System.out.print("Enter name for Experiment 2(Threshold = 4) runtime data file: ");
        FileIO.setTimingCSVName();
        FileIO.createCSVTimingFile();
        System.out.print("Enter name for Experiment 2(Threshold = 4) memory usage data file: ");
        FileIO.setMemoryCSVName();
        FileIO.createCSVMemoryFile();
        SortParameters p2 = new SortParameters(array, arraySize, 4, ASCENDING, MERGE_SORT_HYBRID);
        System.out.println("Experiment 2 running...\n");
        recursiveExperiment(p2, numOfTrials);
        
        System.out.print("Enter name for Experiment 2(Threshold = 8) runtime data file: ");
        FileIO.setTimingCSVName();
        FileIO.createCSVTimingFile();
        System.out.print("Enter name for Experiment 2(Threshold = 8) memory usage data file: ");
        FileIO.setMemoryCSVName();
        FileIO.createCSVMemoryFile();
        SortParameters p3 = new SortParameters(array, arraySize, 8, ASCENDING, MERGE_SORT_HYBRID);
        System.out.println("Experiment 2 running...\n");
        recursiveExperiment(p3, numOfTrials);
        
        System.out.print("Enter name for Experiment 2(Threshold = 16) runtime data file: ");
        FileIO.setTimingCSVName();
        FileIO.createCSVTimingFile();
        System.out.print("Enter name for Experiment (Threshold = 16) memory usage data file: ");
        FileIO.setMemoryCSVName();
        FileIO.createCSVMemoryFile();
        SortParameters p4 = new SortParameters(array, arraySize, 16, ASCENDING, MERGE_SORT_HYBRID);
        System.out.println("Experiment 2 running...\n");
        recursiveExperiment(p4, numOfTrials);
        
        System.out.print("Enter name for Experiment 2(Threshold = 32) runtime data file: ");
        FileIO.setTimingCSVName();
        FileIO.createCSVTimingFile();
        System.out.print("Enter name for Experiment 2(Threshold = 32) memory usage data file: ");
        FileIO.setMemoryCSVName();
        FileIO.createCSVMemoryFile();
        SortParameters p5 = new SortParameters(array, arraySize, 32, ASCENDING, MERGE_SORT_HYBRID);
        System.out.println("Experiment 2 running...\n");
        recursiveExperiment(p5, numOfTrials);
        
        System.out.print("Enter name for Experiment 2(Threshold = 64) runtime data file: ");
        FileIO.setTimingCSVName();
        FileIO.createCSVTimingFile();
        System.out.print("Enter name for Experiment 2(Threshold = 64) memory usage data file: ");
        FileIO.setMemoryCSVName();
        FileIO.createCSVMemoryFile();
        SortParameters p6 = new SortParameters(array, arraySize, 64, ASCENDING, MERGE_SORT_HYBRID);
        System.out.println("Experiment 2 running...\n");
        recursiveExperiment(p6, numOfTrials);
    }
    
    public static void experiment3A4() throws IOException
    {
        System.out.print("Enter name for Experiment 3 runtime data file: ");
        FileIO.setTimingCSVName();
        FileIO.createCSVTimingFile();
        System.out.print("Enter name for Experiment 3 memory usage data file: ");
        FileIO.setMemoryCSVName();
        FileIO.createCSVMemoryFile();
        SortParameters p = new SortParameters(array, arraySize, ASCENDING, QUICK_SORT);
        System.out.println("Experiment 3 running...\n");
        recursiveExperiment(p, numOfTrials);
    }
    
    public static void experiment4A4() throws IOException
    {
        System.out.print("Enter name for Experiment 4(Threshold = 2) runtime data file: ");
        FileIO.setTimingCSVName();
        FileIO.createCSVTimingFile();
        System.out.print("Enter name for Experiment 4(Threshold = 2) memory usage data file: ");
        FileIO.setMemoryCSVName();
        FileIO.createCSVMemoryFile();
        SortParameters p1 = new SortParameters(array, arraySize, 2, 0, 0, ASCENDING, QUICK_SORT_HYBRID);
        System.out.println("Experiment 4 running...\n");
        recursiveExperiment(p1, numOfTrials);
        
        System.out.print("Enter name for Experiment 4(Threshold = 4) runtime data file: ");
        FileIO.setTimingCSVName();
        FileIO.createCSVTimingFile();
        System.out.print("Enter name for Experiment 4(Threshold = 4) memory usage data file: ");
        FileIO.setMemoryCSVName();
        FileIO.createCSVMemoryFile();
        SortParameters p2 = new SortParameters(array, arraySize, 4, 0, 0, ASCENDING, QUICK_SORT_HYBRID);
        System.out.println("Experiment 4 running...\n");
        recursiveExperiment(p2, numOfTrials);
        
        System.out.print("Enter name for Experiment 4(Threshold = 8) runtime data file: ");
        FileIO.setTimingCSVName();
        FileIO.createCSVTimingFile();
        System.out.print("Enter name for Experiment 4(Threshold = 8) memory usage data file: ");
        FileIO.setMemoryCSVName();
        FileIO.createCSVMemoryFile();
        SortParameters p3 = new SortParameters(array, arraySize, 8, 0, 0, ASCENDING, QUICK_SORT_HYBRID);
        System.out.println("Experiment 4 running...\n");
        recursiveExperiment(p3, numOfTrials);
        
        System.out.print("Enter name for Experiment 4(Threshold = 16) runtime data file: ");
        FileIO.setTimingCSVName();
        FileIO.createCSVTimingFile();
        System.out.print("Enter name for Experiment 4(Threshold = 16) memory usage data file: ");
        FileIO.setMemoryCSVName();
        FileIO.createCSVMemoryFile();
        SortParameters p4 = new SortParameters(array, arraySize, 16, 0, 0, ASCENDING, QUICK_SORT_HYBRID);
        System.out.println("Experiment 4 running...\n");
        recursiveExperiment(p4, numOfTrials);
        
        System.out.print("Enter name for Experiment 4(Threshold = 32) runtime data file: ");
        FileIO.setTimingCSVName();
        FileIO.createCSVTimingFile();
        System.out.print("Enter name for Experiment 4(Threshold = 32) memory usage data file: ");
        FileIO.setMemoryCSVName();
        FileIO.createCSVMemoryFile();
        SortParameters p5 = new SortParameters(array, arraySize, 32, 0, 0, ASCENDING, QUICK_SORT_HYBRID);
        System.out.println("Experiment 4 running...\n");
        recursiveExperiment(p5, numOfTrials);
        
        System.out.print("Enter name for Experiment 4(Threshold = 64) runtime data file: ");
        FileIO.setTimingCSVName();
        FileIO.createCSVTimingFile();
        System.out.print("Enter name for Experiment 4(Threshold = 64) memory usage data file: ");
        FileIO.setMemoryCSVName();
        FileIO.createCSVMemoryFile();
        SortParameters p6 = new SortParameters(array, arraySize, 64, 0, 0, ASCENDING, QUICK_SORT_HYBRID);
        System.out.println("Experiment 4 running...\n");
        recursiveExperiment(p6, numOfTrials); 
    }
    
    public static void experiment5A4() throws IOException
    {
        System.out.print("Enter name for Experiment 5(Merge Sort) runtime data file: ");
        FileIO.setTimingCSVName();
        FileIO.createCSVTimingFile();
        System.out.print("Enter name for Experiment 5(Merge Sort) memory usage data file: ");
        FileIO.setMemoryCSVName();
        FileIO.createCSVMemoryFile();
        SortParameters p1 = new SortParameters(array, arraySize, ASCENDING, MERGE_SORT);
        System.out.println("Experiment 5 running...\n");
        recursiveExperiment(p1, numOfTrials);
        
        System.out.print("Enter name for Experiment 5(Merge Sort Hybrid) runtime data file: ");
        FileIO.setTimingCSVName();
        FileIO.createCSVTimingFile();
        System.out.print("Enter name for Experiment 5(Merge Sort Hybrid) memory usage data file: ");
        FileIO.setMemoryCSVName();
        FileIO.createCSVMemoryFile();
        SortParameters p2 = new SortParameters(array, arraySize, 64, ASCENDING, MERGE_SORT_HYBRID);
        System.out.println("Experiment 5 running...\n");
        recursiveExperiment(p2, numOfTrials);
    }
    
    public static void experiment6A4() throws IOException
    {
        System.out.print("Enter name for Experiment 6(Quick Sort) runtime data file: ");
        FileIO.setTimingCSVName();
        FileIO.createCSVTimingFile();
        System.out.print("Enter name for Experiment 6(Quick Sort) memory usage data file: ");
        FileIO.setMemoryCSVName();
        FileIO.createCSVMemoryFile();
        SortParameters p1 = new SortParameters(array, arraySize, ASCENDING, QUICK_SORT);
        System.out.println("Experiment 6 running...\n");
        recursiveExperiment(p1, numOfTrials);
        
        System.out.print("Enter name for Experiment 6(Quick Sort Hybrid) runtime data file: ");
        FileIO.setTimingCSVName();
        FileIO.createCSVTimingFile();
        System.out.print("Enter name for Experiment 6(Quick Sort Hybrid) memory usage data file: ");
        FileIO.setMemoryCSVName();
        FileIO.createCSVMemoryFile();
        SortParameters p2 = new SortParameters(array, arraySize, 64, 0, 0, ASCENDING, QUICK_SORT_HYBRID);
        System.out.println("Experiment 6 running...\n");
        recursiveExperiment(p2, numOfTrials); 
    }
    
    public static void experiment7A4() throws IOException
    {
        System.out.print("Enter name for Experiment 7(Shell Sort) runtime data file: ");
        FileIO.setTimingCSVName();
        FileIO.createCSVTimingFile();
        System.out.print("Enter name for Experiment 7(Shell Sort) memory usage data file: ");
        FileIO.setMemoryCSVName();
        FileIO.createCSVMemoryFile();
        SortParameters p1 = new SortParameters(array, arraySize, KNUTH, gapSeq, gapSeqSize, ASCENDING, SHELL_SORT);
        System.out.println("Experiment 7 running...\n");
        recursiveExperiment(p1, numOfTrials);
        
        System.out.print("Enter name for Experiment 7(Merge Sort Hybrid) runtime data file: ");
        FileIO.setTimingCSVName();
        FileIO.createCSVTimingFile();
        System.out.print("Enter name for Experiment 7(Merge Sort Hybrid) memory usage data file: ");
        FileIO.setMemoryCSVName();
        FileIO.createCSVMemoryFile();
        SortParameters p2 = new SortParameters(array, arraySize, 64, ASCENDING, MERGE_SORT_HYBRID);
        System.out.println("Experiment 7 running...\n");
        recursiveExperiment(p2, numOfTrials);
        
        System.out.print("Enter name for Experiment 7(Quick Sort Hybrid) runtime data file: ");
        FileIO.setTimingCSVName();
        FileIO.createCSVTimingFile();
        System.out.print("Enter name for Experiment 7(Quick Sort Hybrid) memory usage data file: ");
        FileIO.setMemoryCSVName();
        FileIO.createCSVMemoryFile();
        SortParameters p3 = new SortParameters(array, arraySize, 64, 0, 0, ASCENDING, QUICK_SORT_HYBRID);
        System.out.println("Experiment 7 running...\n");
        recursiveExperiment(p3, numOfTrials);
    }
  
    public static void runAllExperiments() throws IOException
    {
        System.out.print("Enter base file name where all experimental results will be logged: ");
        FileIO.setFileName();
        FileIO.createBaseLogFile();
        experiment1A2();
        experiment2A2();
        experiment3ShellGapA2();
        experiment3PrattGapA2();
        experiment3KnuthGapA2();
        experiment1A4();
        experiment2A4();
        experiment3A4();
        experiment4A4();
        experiment5A4();
        experiment6A4();
        experiment7A4();
    }

    //Creates a random array of integers of arbitrary size.
    public static int[] createRandomArray(int[] array, int arraySize)
    {
        Random randomNums = new Random();
        
        for (int i = 0; i < arraySize; ++i)
        {
            array[i] = randomNums.nextInt();
        }
        return array;
    }
    
    //Iterates through an array to make sure it is sorted correctly.
    public static boolean verifySortCorrectness(int[] array, SortOrder order)
    {
        boolean result = true;
        for (int i = 1; i < array.length; i++)
        {
            if(order == ASCENDING && array[i-1] > array[i]) 
            {
                result = false;
                break;
            }
            else if(order == DESCENDING && array[i-1] < array[i])
            {
                result = false;
                break;
            }
        }
        return result;
    }
}
