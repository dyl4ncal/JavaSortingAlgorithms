package ca.dylancalado.sortingalgorithms.userinterface;

import ca.dylancalado.sortingalgorithms.experimentcode.Experiment;
import ca.dylancalado.sortingalgorithms.sortingcode.SortOrder;
import static ca.dylancalado.sortingalgorithms.sortingcode.SortOrder.ASCENDING;
import static ca.dylancalado.sortingalgorithms.sortingcode.SortOrder.DESCENDING;
import ca.dylancalado.sortingalgorithms.unittests.TestExperiment;
import ca.dylancalado.sortingalgorithms.unittests.TestInsertionSort;
import ca.dylancalado.sortingalgorithms.unittests.TestSelectionSort;
import ca.dylancalado.sortingalgorithms.unittests.TestShellSort;
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

                    break;
            }
        }
    }
    
    public static void runAllExperiments()
    {
        //Ask user base file name where results will be logged.
        Experiment.runAllExperiments();
    }
    
    public static void runExperimentByNumber()
    {
        //Ask user file name where results will be logged.
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
        }  
    }
    
    public static void runAllUnitTests()
    {
       TestSelectionSort.testAllSelectionSortMethods();
       TestInsertionSort.testAllInsertionSortMethods();
       TestShellSort.testAllShellSortMethods();
       TestExperiment.testAllExperimentMethods();
    }
    
    public static void selectUnitTest()
    {
        System.out.println("1. Test SelectionSort Methods\n"
                + "2. Test InsertionSort Methods\n"
                + "3. Test ShellSort Methods\n"
                + "4. Test Experiment Methods\n");
        
        switch (userInput.next())
        {
            case "1":
                System.out.println(TestSelectionSort.testSwap());
                System.out.println(TestSelectionSort.testSelectionSortAscending());
                System.out.println(TestSelectionSort.testSelectionSortDescending());
                break;
            case "2":
                System.out.println(TestInsertionSort.testInsertionSortAscending());
                System.out.println(TestInsertionSort.testInsertionSortDescending());
                break;
            case "3":
                System.out.println(TestShellSort.testShellSortAscending());
                System.out.println(TestShellSort.testShellSortDescending());
                System.out.println(TestShellSort.testGenerateShellGap());
                System.out.println(TestShellSort.testGeneratePrattGap());
                System.out.println(TestShellSort.testGenerateKnuthGap());
                break;
            case "4":
                System.out.println(TestExperiment.testCreateRandomArray());
                break;
            default:
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
                break;
        }
        
        //provide feedback for success, memory usage, and time required for sort
    }
}
