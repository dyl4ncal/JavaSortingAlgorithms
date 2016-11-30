package ca.dylancalado.sortingalgorithms.unittests;

import ca.dylancalado.sortingalgorithms.experiments.Experiment;
import ca.dylancalado.sortingalgorithms.sorting.SortOrder;
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
    
    public static void testAllExperimentMethods() throws IOException
    {
        System.out.println("Unit Tests Related to Experiments:\n");
        System.out.println(testCreateRandomArray());
        System.out.println(testVerifySortCorrectnessAscending());
        System.out.println(testVerifySortCorrectnessDescending()+ "\n");
    }
}
