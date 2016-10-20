package ca.dylancalado.sortingalgorithms.unittests;

import ca.dylancalado.sortingalgorithms.experimentcode.Experiment;
import ca.dylancalado.sortingalgorithms.sortingcode.SortOrder;
import java.io.IOException;
/**
 * Unit tests related to experiments.
 * 
 * @author Dylan
 */
public class TestExperiment
{
    public static boolean testCreateRandomArray()
    {
        int[] testArray = new int[10];
        Experiment.createRandomArray(testArray, 10);
        boolean match = (testArray != null);
        
        System.out.print("Create random experimental array test passed? ");
        return match;
    }
    
    public static boolean testVerifySortCorrectnessAscending()
    {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        boolean expectedOutput = true;
       
        System.out.print("Verify sort correctness ascending test passed? ");
        return Experiment.verifySortCorrectness(array, SortOrder.ASCENDING) == expectedOutput;
    }
    
    public static boolean testVerifySortCorrectnessDescending()
    {
        int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        boolean expectedOutput = true;
        
        System.out.print("Verify sort correctness descending test passed? ");
        return Experiment.verifySortCorrectness(array, SortOrder.DESCENDING) == expectedOutput;
    }

    public static boolean testExperiment1() throws IOException
    {
        Experiment.experiment1();
        System.out.print("Experiment 1 test passed? ");
        return false;
    }
    
    public static boolean testExperiment2() throws IOException
    {
        Experiment.experiment2();
        System.out.print("Experiment 2 test passed? ");
        return false;
    }
    
    public static boolean testExperiment3() throws IOException
    {
        Experiment.experiment3();
        System.out.print("Experiment 3 test passed? ");
        return false;
    }
    
    public static void testAllExperimentMethods() throws IOException
    {
        System.out.println(testCreateRandomArray());
        System.out.println(testVerifySortCorrectnessAscending());
        System.out.println(testVerifySortCorrectnessDescending());
        System.out.println(testExperiment1());
        System.out.println(testExperiment2());
        System.out.println(testExperiment3() + "\n");
    }
}
