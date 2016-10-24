package ca.dylancalado.sortingalgorithms.main;

import ca.dylancalado.sortingalgorithms.userinterface.UI;
import java.io.IOException;

/**
 * This class runs the UI, which takes care of running 
 * the experiments, performing unit tests, etc.
 * 
 * For accurate performance test results, it is crucial to warm up the JVM before collecting your final experiment data!
 *
 * @author dylan
 */
public class Main
{
    public static void main(String[] args) throws IOException 
    {
        UI.runUI();
    }
}