package ca.dylancalado.sortingalgorithms.unittests;

import ca.dylancalado.sortingalgorithms.experimentcode.Experiment;
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
        System.out.println(testExperiment1());
        System.out.println(testExperiment2());
        System.out.println(testExperiment3() + "\n");
    }
}
