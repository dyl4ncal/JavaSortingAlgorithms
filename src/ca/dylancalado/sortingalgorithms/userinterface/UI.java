package ca.dylancalado.sortingalgorithms.userinterface;

import ca.dylancalado.sortingalgorithms.experiments.Experiment;
import ca.dylancalado.sortingalgorithms.experiments.SortTimer;
import ca.dylancalado.sortingalgorithms.sorting.InsertionSort;
import ca.dylancalado.sortingalgorithms.sorting.SortParameters;
import ca.dylancalado.sortingalgorithms.sorting.ShellSort;
import ca.dylancalado.sortingalgorithms.sorting.SelectionSort;
import ca.dylancalado.sortingalgorithms.sorting.MergeSort;
import ca.dylancalado.sortingalgorithms.sorting.SortType;
import ca.dylancalado.sortingalgorithms.fileio.FileIO;
import static ca.dylancalado.sortingalgorithms.sorting.GapSequenceType.SHELL;
import static ca.dylancalado.sortingalgorithms.sorting.SortOrder.*;
import static ca.dylancalado.sortingalgorithms.sorting.SortType.SHELL_SORT;
import ca.dylancalado.sortingalgorithms.unittests.*;
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
    
    //Method to provide a user friendly menu to navigate and use the program to perform experiments, run unit tests, etc.
    public static void runUI() throws IOException
    {
        System.out.print("\nNote: For accurate performance data, warm up the JVM by running any experiment\nonce when you first execute this program. Ignore the data it outputs.\n");
        while (true)
        {
            System.out.println("\nSorting Algorithms Main Menu:\n-----------------------------");
            System.out.println("1. Run All Experiments\n2. Run Experiment by Number\n"
                + "3. Run All Unit Tests\n4. Run Related Unit Tests\n"
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
    
    //Method to run all experiments at once.
    public static void runAllExperiments() throws IOException
    {
        Experiment.runAllExperiments();
        System.out.println("All experiments complete");
    }
    
    //Method to run individual experiments.
    public static void runExperimentByNumber() throws IOException
    {
        System.out.print("Enter base file name where experimental results will be logged: ");
        FileIO.setFileName();
        FileIO.createBaseLogFile();
        
        System.out.println("Pick an experiment to run:\n\n(A2) are experiments from assignment 2.\n(A4) are experiments from assignment 4.\n"
                + "1. Experiment 1(A2)\n2. Experiment 2(A2)\n3. Experiment 3(A2)\n"
                + "4. Experiment 1(A4)\n5. Experiment 2(A4)\n6. Experiment 3(A4)\n7. Experiment 4(A4)\n"
                + "8. Experiment 5(A4)\n9. Experiment 6(A4)\n10. Experiment 7(A4)\n");

        switch (userInput.next())
        {
            case "1":
                Experiment.experiment1A2();
                System.out.println("Selection sort experiment complete!");
                break;
            case "2":
                Experiment.experiment2A2();
                System.out.println("Insertion sort experiment complete!");
                break;
            case "3":
                Experiment.experiment3ShellGapA2();
                Experiment.experiment3PrattGapA2();
                Experiment.experiment3KnuthGapA2();
                System.out.println("Shell sort experiments complete!");
                break;
            case "4":
                Experiment.experiment1A4();
                System.out.println("Merge sort experiment complete!");
                break;
            case "5":
                Experiment.experiment2A4();
                System.out.println("Merge sort hybrid experiment complete!");
                break;
            case "6":
                Experiment.experiment3A4();
                System.out.println("Quick sort experiment complete!");
                break;
            case "7":
                Experiment.experiment4A4();
                System.out.println("Quick sort hybrid experiment complete!");
                break;
            case "8":
                Experiment.experiment5A4();
                System.out.println("MergeVs.mergeHybrid experiment complete!");
                break;
            case "9":
                Experiment.experiment6A4();
                System.out.println("QuickVs.quickHybrid experiment complete!");
                break;
            case "10":
                Experiment.experiment7A4();
                System.out.println("ShellVs.mergeHybridVs.quickHybrid experiment complete!");
                break;    
            default:
                System.out.println("Invalid Input");
                break;
        }  
    }
    
    //Method to run all unit tests at once.
    public static void runAllUnitTests() throws IOException
    {
       TestSelectionSort.testAllSelectionSortMethods();
       TestInsertionSort.testAllInsertionSortMethods();
       TestShellSort.testAllShellSortMethods();
       TestMergeSort.testAllMergeSortMethods();
       TestQuickSort.testAllQuickSortMethods();
       TestMergeSortHybrid.testAllMergeSortHybridMethods();
       TestQuickSortHybrid.testAllQuickSortHybridMethods();
       TestExperiment.testAllExperimentMethods();
       TestSortTimer.testAllSortTimerMethods();
    }
    
    //Method to select related groups of unit tests.
    public static void selectUnitTest() throws IOException
    {
        System.out.println("1. Run Test Methods in SelectionSort Class\n"
                + "2. Run Test Methods in InsertionSort Class\n"
                + "3. Run Test Methods in ShellSort Class\n"
                + "4. Run Test Methods in MergeSort Class\n"
                + "5. Run Test Methods in QuickSort Class\n"
                + "6. Run Test Methods in MergeSortHybrid Class\n"
                + "7. Run Test Methods in QuickSortHybrid Class\n"
                + "8. Run Test Methods in Experiment Class\n"
                + "9. Run Test Methods in SortTimer Class\n");
        
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
                System.out.println(TestMergeSort.testMergeSortMerge());
                System.out.println(TestMergeSort.testMergeSortAscending());
                System.out.println(TestMergeSort.testMergeSortDescending());
                break;
            case "5":
                System.out.println(TestQuickSort.testQuickSortGetPivotValue());
                System.out.println(TestQuickSort.testQuickSortAscending());
                System.out.println(TestQuickSort.testQuickSortDescending());
                break;
            case "6":
                System.out.println(TestMergeSortHybrid.testMergeSortHybridAscending());
                System.out.println(TestMergeSortHybrid.testMergeSortHybridDescending());
                break;
            case "7":
                System.out.println(TestQuickSortHybrid.testQuickSortHybridAscending());
                System.out.println(TestQuickSortHybrid.testQuickSortHybridDescending());
                break;
            case "8":
                System.out.println(TestExperiment.testCreateRandomArray());
                System.out.println(TestExperiment.testVerifySortCorrectnessAscending());
                System.out.println(TestExperiment.testVerifySortCorrectnessDescending());
                break;
            case "9":
                System.out.println(TestSortTimer.testStartTimer());
                System.out.println(TestSortTimer.testEndTimer());
                System.out.println(TestSortTimer.testCalculateSortTime());
                System.out.println(TestSortTimer.testCalculateAverageSortTime());
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }           
    } 
    
    //Method which lets the user fabricate their own sorting scenario.
    public static void selectCustomScenario()
    {
        System.out.println("\nNote: For the most accurate results, run your scenario more than once\nand ignore the output of the first results.\n");
        SortParameters p = new SortParameters();
        System.out.println("Specify size of array to be sorted(Positive Integer):");
        
        int userSize = userInput.nextInt();
        p.setArraySize(abs(userSize));
        
        int[] userArray = new int[abs(userSize)];
        
        Experiment.createRandomArray(userArray, userSize);
        p.setArray(userArray);
        
        System.out.println("\nSpecify sort order you wish to use:\n1. Ascending\n2. Descending");
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
        
        System.out.println("\nChoose the type of sort you wish to utilize:\n"
                + "1. Selection Sort\n2. Insertion Sort\n3. Shell Sort"
                + "\n4. Merge Sort\n5. Merge Sort Hybrid\n6. Quick Sort\n7. Quick Sort Hybrid");
       
        switch(userInput.next())
        {
            case "1":
                System.out.println("Experiment running...");
                p.setSortType(SortType.SELECTION_SORT);
                SortTimer.startTimer();
                SelectionSort.sort(p);
                SortTimer.endTimer();
                break;
            case "2":
                System.out.println("Experiment running...");
                p.setSortType(SortType.INSERTION_SORT);             
                SortTimer.startTimer();
                InsertionSort.sort(p);
                SortTimer.endTimer();               
                break;
            case "3":  
                System.out.println("\nSelect a gap sequence type:\n1. Shell sequence\n2. Pratt sequence\n3. Knuth sequence");
                
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
                System.out.println("Experiment running...");
                SortParameters p1 = new SortParameters(userArray, userSize, SHELL, gapSeq, p.getGapSeqSize(), p.getSortOrder(), SHELL_SORT);
                p.setSortType(SortType.SHELL_SORT);
                SortTimer.startTimer();
                ShellSort.sort(p);
                SortTimer.endTimer();              
                break;
            case "4":
                System.out.println("Experiment running...");
                p.setSortType(SortType.MERGE_SORT);
                SortTimer.startTimer();
                MergeSort.sort(p);
                SortTimer.endTimer();
                break;
            case "5":
                System.out.println("Experiment running...");
                p.setSortType(SortType.MERGE_SORT_HYBRID);
                SortTimer.startTimer();
                MergeSort.sort(p);
                SortTimer.endTimer();
                break;
            case "6":
                System.out.println("Experiment running...");
                p.setSortType(SortType.QUICK_SORT);
                SortTimer.startTimer();
                MergeSort.sort(p);
                SortTimer.endTimer();
                break;
            case "7":
                System.out.println("Experiment running...");
                p.setSortType(SortType.QUICK_SORT_HYBRID);
                SortTimer.startTimer();
                MergeSort.sort(p);
                SortTimer.endTimer();
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
        
        //provide user feedback for success, memory usage, and time required for sort.
        System.out.println("\nSort successful? " + Experiment.verifySortCorrectness(p.getArray(), p.getSortOrder()));
        System.out.println("Time to complete sort: " + SortTimer.calculateSortTime() + " nanoseconds");
        System.out.println("Memory usage: ");    
    }
}
