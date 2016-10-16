package ca.dylancalado.sortingalgorithms.unittests;

import ca.dylancalado.sortingalgorithms.sortingcode.GapSequenceType;
import static ca.dylancalado.sortingalgorithms.sortingcode.GapSequenceType.KNUTH;
import static ca.dylancalado.sortingalgorithms.sortingcode.GapSequenceType.PRATT;
import static ca.dylancalado.sortingalgorithms.sortingcode.GapSequenceType.SHELL;
import ca.dylancalado.sortingalgorithms.sortingcode.ShellSort;
import static ca.dylancalado.sortingalgorithms.sortingcode.SortOrder.ASCENDING;
import static ca.dylancalado.sortingalgorithms.sortingcode.SortOrder.DESCENDING;
import ca.dylancalado.sortingalgorithms.sortingcode.SortParameters;
import static ca.dylancalado.sortingalgorithms.sortingcode.SortType.SHELL_SORT;
import java.util.Arrays;


/**
 * Unit tests related to shell sort.
 * 
 * @author dylan
 */
public class TestShellSort
{
    private static int[] testArray = {3, 6, 1, 10, 4, 8, 9, 2, 5, 7, 12, 11, 15, 13, 14, 19, 16, 17, 20, 18};
    private static int[] gapSeq;
    private static int gapSeqSize;
    private static GapSequenceType gapSeqType;
            
    public static boolean testShellSortAscending()
    {
        int[] expectedOutput = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        SortParameters p1 = new SortParameters(testArray, 20, SHELL, 4, ASCENDING, SHELL_SORT);
       
        ShellSort.sort(p1);
        boolean match = Arrays.equals(testArray, expectedOutput);
        
        System.out.print("Shell sort ascending test passed? ");
        return match;
    }
    
    public static boolean testShellSortDescending()
    {
        int[] expectedOutput = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        SortParameters p2 = new SortParameters(testArray, 20, SHELL, 4, DESCENDING, SHELL_SORT);

        ShellSort.sort(p2);
        boolean match = Arrays.equals(testArray, expectedOutput);

        System.out.print("Shell sort descending test passed? ");
        return match;
    }
    
    public static boolean testGenerateShellGap()
    {
        int[] expectedOutput1 = {10, 5, 2, 1};
        SortParameters p = new SortParameters(testArray, 20, SHELL, 4, ASCENDING, SHELL_SORT);
        
        ShellSort.generateShellGap(p);
        System.out.print("Generate shell sequence test passed? ");
        return true;
    }
    
    public static boolean testGeneratePrattGap()
    {
        int[] expectedOutput2 = {1, 2, 3, 4, 6, 8, 9, 12};
        SortParameters p = new SortParameters(testArray, 20, PRATT, gapSeqSize, ASCENDING, SHELL_SORT);
        
        ShellSort.generatePrattGap(p);
        System.out.print("Generate pratt sequence test passed? ");
        return true;
    }
    
    public static boolean testGenerateKnuthGap()
    {
        int[] expectedOutput3 = {1, 4, 14, 40, 121};
        SortParameters p = new SortParameters(testArray, 20, KNUTH, gapSeqSize, ASCENDING, SHELL_SORT);
        
        ShellSort.generateKnuthGap(p);
        System.out.print("Generate knuth sequence test passed? ");
        return true;
    }
    
    public static void testAllShellSortMethods()
    {
        System.out.println(testShellSortAscending());
        System.out.println(testShellSortDescending());
        System.out.println(testGenerateShellGap());
        System.out.println(testGeneratePrattGap());
        System.out.println(testGenerateKnuthGap());
    }
}
