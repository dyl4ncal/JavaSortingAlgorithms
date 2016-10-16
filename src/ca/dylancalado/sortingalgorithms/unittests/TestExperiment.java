package ca.dylancalado.sortingalgorithms.unittests;

import ca.dylancalado.sortingalgorithms.experimentcode.Experiment;
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
        
        boolean match = testArray != null;
        System.out.print("Create random array test passed? ");
        return match;
    }

    public static boolean testExperiment1()
    {
        Experiment.experiment1();
      
        return true;
    }
    
    public static boolean testExperiment2()
    {
        Experiment.experiment2();
      
        return true;
    }
    
    public static boolean testExperiment3()
    {
        Experiment.experiment3();
      
        return true;
    }
    
    public static void testAllExperimentMethods()
    {
        System.out.println(testCreateRandomArray());
        System.out.println(testExperiment1());
        System.out.println(testExperiment2());
        System.out.println(testExperiment3());
    }
}
