package ca.dylancalado.sortingalgorithms.userinterface;

import ca.dylancalado.sortingalgorithms.experimentcode.Experiment;
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
        
                System.out.println(TestSelectionSort.testSelectionSort());
                break;
            case "2":
                System.out.println(TestInsertionSort.testInsertionSort());
                break;
            case "3":
                
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
        //ask user for array size
        //ask user for ascending/descending order
        //provide feedback for success, memory usage, and time required for sort
    }
}
