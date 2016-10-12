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
        
        for(int i = 0; i < 10; ++i)
        {
            System.out.print(testArray[i]);
            if(i < 9)
            {
                System.out.print(", ");
            }
        }
        
        if(testArray != null)
        {
            System.out.print("\nCreate random array test passed? ");
            return true;
        }
        else
        {
            System.out.print("Create random array test passed? ");
            return false;
        }
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
    
    public static boolean testAllExperimentMethods()
    {
        return true;
    }
}
