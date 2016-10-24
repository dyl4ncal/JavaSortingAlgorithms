package ca.dylancalado.sortingalgorithms.userinterface;

import ca.dylancalado.sortingalgorithms.experimentcode.*;
import ca.dylancalado.sortingalgorithms.fileio.FileIO;
import ca.dylancalado.sortingalgorithms.sortingcode.*;
import static ca.dylancalado.sortingalgorithms.sortingcode.GapSequenceType.SHELL;
import static ca.dylancalado.sortingalgorithms.sortingcode.SortOrder.*;
import static ca.dylancalado.sortingalgorithms.sortingcode.SortType.SHELL_SORT;
import ca.dylancalado.sortingalgorithms.unittests.*;
import static ca.dylancalado.sortingalgorithms.unittests.TestSortTimer.*;
import java.io.IOException;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This Class contains the logic for the command line user interface.
 * 
 * @author dylan
 */
public class UI
{
    private static final Scanner userInput = new Scanner(System.in);
    
    public static void runUI() throws IOException
    {
        while (true)
        {
            System.out.println("\nSorting Algorithms Main Menu:\n-----------------------------");
            System.out.println("1. Run All Experiments\n2. Run Experiment by Number\n"
                + "3. Run All Unit Tests\n4. Run Unit Tests by Class\n"
                + "5. Set Up Custom Sorting Scenario\n6. Exit Program");
            
            switch (userInput.next()) 
            {
                case "1":
                    runAllExperiments();
                    break;
                case "2":
                    runExperimentByNumber();
                    break;
                case "3":
                    runAllUnitTests();
                    break;
                case "4":
                    selectUnitTest();
                    break;
                case "5":
                    selectCustomScenario();
                    break;
                case "6":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }
    
    public static void runAllExperiments() throws IOException
    {
        System.gc();
        MemoryUsage.getMemoryCurrentlyUsed();
        Experiment.runAllExperiments();
        System.out.println("All experiments complete");
    }
    
    public static void runExperimentByNumber() throws IOException
    {
        System.out.print("Enter base file name where experimental results will be logged: ");
        FileIO.setFileName();
        FileIO.createBaseLogFile();
        
        System.out.println("Pick an experiment to run:\n"
                + "1. Experiment 1\n2. Experiment 2\n3. Experiment 3");

        System.gc();
        MemoryUsage.getMemoryCurrentlyUsed();
        switch (userInput.next())
        {
            case "1":
                Experiment.experiment1();
                System.out.println("Experiment complete");
                break;
            case "2":
                Experiment.experiment2();
                System.out.println("Experiments complete");
                break;
            case "3":
                Experiment.experiment3ShellGap();
                Experiment.experiment3PrattGap();
                Experiment.experiment3KnuthGap();
                System.out.println("Experiment complete");
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }  
    }
    
    public static void runAllUnitTests() throws IOException
    {
       TestSelectionSort.testAllSelectionSortMethods();
       TestInsertionSort.testAllInsertionSortMethods();
       TestShellSort.testAllShellSortMethods();
       TestExperiment.testAllExperimentMethods();
       TestSortTimer.testAllSortTimerMethods();
       TestMemoryUsage.testAllMemoryUsageMethods();
    }
    
    public static void selectUnitTest() throws IOException
    {
        System.out.println("1. Test Methods in SelectionSort Class\n"
                + "2. Test Methods in InsertionSort Class\n"
                + "3. Test Methods in ShellSort Class\n"
                + "4. Test Methods in Experiment Class\n"
                + "5. Test Methods in SortTimer Class\n"
                + "6. Test Methods in MemoryUsage Class\n");
        
        switch (userInput.next())
        {
            case "1":
                System.out.println(TestSelectionSort.testSelectionSortSwap());
                System.out.println(TestSelectionSort.testSelectionSortAscending());
                System.out.println(TestSelectionSort.testSelectionSortDescending());
                break;
            case "2":
                System.out.println(TestInsertionSort.testInsertionSortAscending());
                System.out.println(TestInsertionSort.testInsertionSortDescending());
                break;
            case "3":
                System.out.println(TestShellSort.testGenerateShellGap());
                System.out.println(TestShellSort.testGeneratePrattGap());
                System.out.println(TestShellSort.testGenerateKnuthGap());
                System.out.println(TestShellSort.testShellSortShellGapAscending());
                System.out.println(TestShellSort.testShellSortShellGapDescending());
                System.out.println(TestShellSort.testShellSortPrattGapAscending());
                System.out.println(TestShellSort.testShellSortPrattGapDescending());
                System.out.println(TestShellSort.testShellSortKnuthGapAscending());
                System.out.println(TestShellSort.testShellSortKnuthGapDescending());
                break;
            case "4":
                System.out.println(TestExperiment.testCreateRandomArray());
                System.out.println(TestExperiment.testVerifySortCorrectnessAscending());
                System.out.println(TestExperiment.testVerifySortCorrectnessDescending());
                break;
            case "5":
                System.out.println(testStartTimer());
                System.out.println(testEndTimer());
                System.out.println(testCalculateSortTime());
                System.out.println(testCalculateAverageSortTime());
                break;
            case "6":
                ///////////////////////////////////////////////////////
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }           
    } 
    
    //Method which lets the user fabricate their own sorting scenario.
    public static void selectCustomScenario()
    {
        System.out.println("Note: For the most accurate results, run your scenario more than once and ignore the first output of results.");
        SortParameters p = new SortParameters();
        System.out.println("Specify size of array to be sorted(Positive Integer):");
        
        int userSize = userInput.nextInt();
        p.setArraySize(abs(userSize));
        
        int[] userArray = new int[abs(userSize)];
        
        Experiment.createRandomArray(userArray, userSize);
        p.setArray(userArray);
        
        System.out.println("Specify sort order you wish to use:\n1. Ascending\n2. Descending");
        String userOrder = userInput.next();
        switch (userOrder.toLowerCase())
        {
            case "1":
                p.setSortOrder(ASCENDING);
                break;
            case "2":
                p.setSortOrder(DESCENDING);
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
        
        System.out.println("Choose the type of sort you wish to utilize:\n"
                + "1. SelectionSort\n2. InsertionSort\n3. Shell Sort");
       
        switch(userInput.next())
        {
            case "1":
                System.gc();
                MemoryUsage.getMemoryCurrentlyUsed();
                System.out.println("Experiment running...");
                p.setSortType(SortType.SELECTION_SORT);
                SortTimer.startTimer();
                SelectionSort.sort(p);
                SortTimer.endTimer();
                break;
            case "2":
                System.gc();
                MemoryUsage.getMemoryCurrentlyUsed();
                System.out.println("Experiment running...");
                p.setSortType(SortType.INSERTION_SORT);             
                SortTimer.startTimer();
                InsertionSort.sort(p);
                SortTimer.endTimer();               
                break;
            case "3":  
                System.out.println("Select a gap sequence type:\n1. Shell sequence\n2. Pratt sequence\n3. Knuth sequence");
                
                ArrayList<Integer> gapSeq = new ArrayList<>();
                
                switch(userInput.next())
                {
                    case "1":
                        ShellSort.generateShellGap(p);
                        break;
                    case "2":
                        ShellSort.generatePrattGap(p);
                        break;
                    case "3":
                        ShellSort.generateKnuthGap(p);
                        break;
                    default:
                        System.out.println("Invalid Input");
                        break;
                }
                System.gc();
                MemoryUsage.getMemoryCurrentlyUsed();
                System.out.println("Experiment running...");
                SortParameters p1 = new SortParameters(userArray, userSize, SHELL, gapSeq, p.getGapSeqSize(), p.getSortOrder(), SHELL_SORT);
                p.setSortType(SortType.SHELL_SORT);
                SortTimer.startTimer();
                ShellSort.sort(p);
                SortTimer.endTimer();              
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
        
        //provide user feedback for success, memory usage, and time required for sort.
        System.out.println("Sort successful? " + Experiment.verifySortCorrectness(p.getArray(), p.getSortOrder()));
        System.out.println("Time to complete sort: " + SortTimer.calculateSortTime() + " nanoseconds");
        System.out.println("Memory usage: " + MemoryUsage.calculateMemoryUsage() + " bytes");     
    }
}
