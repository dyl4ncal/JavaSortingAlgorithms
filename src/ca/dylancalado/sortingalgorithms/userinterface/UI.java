package ca.dylancalado.sortingalgorithms.userinterface;

import ca.dylancalado.sortingalgorithms.experimentcode.Experiment;
import ca.dylancalado.sortingalgorithms.fileio.FileIO;
import ca.dylancalado.sortingalgorithms.sortingcode.SortOrder;
import static ca.dylancalado.sortingalgorithms.sortingcode.SortOrder.*;
import ca.dylancalado.sortingalgorithms.unittests.*;
import java.util.Scanner;

/**
 * This Class contains the logic for the command line user interface.
 * 
 * @author dylan
 */
public class UI
{
    private static Scanner userInput = new Scanner(System.in);
    
    private static String menu = "1. Run All Experiments\n2. Run Experiment by Number\n"
                + "3. Run All Unit Tests\n4. Run Unit Test by Class/Method\n"
                + "5. Run Specific Sorts On a Generated Random Array\n6. Exit Program";
    
    public static void runUI()
    {
        while (true)
        {
            System.out.println("\nSorting Algorithms Main Menu:\n-----------------------------");
            System.out.println(menu);

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
    
    public static void runAllExperiments()
    {
        System.out.print("Enter base file name where experimental results will be logged: ");
        FileIO.getFileName();
        
        Experiment.runAllExperiments();
    }
    
    public static void runExperimentByNumber()
    {
        System.out.print("Enter file name where experimental results will be logged: ");
        FileIO.getFileName();
        
        System.out.println("Pick an experiment to run:\n"
                + "1. Experiment 1\n2. Experiment 2\n3. Experiment 3");

        switch (userInput.next())
        {
            case "1":
                Experiment.experiment1();
                break;
            case "2":
                Experiment.experiment2();
                break;
            case "3":
                Experiment.experiment3();
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }  
    }
    
    public static void runAllUnitTests()
    {
       TestSelectionSort.testAllSelectionSortMethods();
       TestInsertionSort.testAllInsertionSortMethods();
       TestShellSort.testAllShellSortMethods();
       TestExperiment.testAllExperimentMethods();
       TestSortTimer.testAllSortTimerMethods();
    }
    
    public static void selectUnitTest()
    {
        System.out.println("1. Test Methods in SelectionSort Class\n"
                + "2. Test Methods in InsertionSort Class\n"
                + "3. Test Methods in ShellSort Class\n"
                + "4. Test Methods in Experiment Class\n"
                + "5. Test Methods in SortTimer Class\n");
        
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
                break;
            case "4":
                System.out.println(TestExperiment.testCreateRandomArray());
                System.out.println(TestExperiment.testExperiment1());
                System.out.println(TestExperiment.testExperiment2());
                System.out.println(TestExperiment.testExperiment3());
                break;
            case "5":
                System.out.println(TestSortTimer.testTimeSort());
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }           
    } 
    
    public static void selectCustomScenario()
    {
        System.out.println("Specify size of array to be sorted:");
        int userSize = userInput.nextInt();
        int[] userArray = new int[userSize];
        
        Experiment.createRandomArray(userArray, userSize);
        
        System.out.println("Specify ascending or descending sort order:");
        SortOrder order;
        String userOrder = userInput.next();
        if(userOrder.equals("ascending"))
        {
            order = ASCENDING;
        }
        else if(userOrder.equals("descending"))
        {
            order = DESCENDING;
        }
        else
        {
            System.out.println("Please enter a valid sort order (ascending/descending).");
        }
        
        System.out.println("Choose the type of sort you wish to utilize:\n"
                + "1. SelectionSort\n2. InsertionSort\n3. Shell Sort");
        
        switch(userInput.next())
        {
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
        
        //provide feedback for success, memory usage, and time required for sort
        System.out.println("Sort successful? ");
        System.out.println("Memory usage: ");
        System.out.println("Time to complete sort: ");
    }
}
