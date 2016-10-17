package ca.dylancalado.sortingalgorithms.unittests;

import static ca.dylancalado.sortingalgorithms.sortingcode.GapSequenceType.*;
import ca.dylancalado.sortingalgorithms.sortingcode.ShellSort;
import static ca.dylancalado.sortingalgorithms.sortingcode.SortOrder.*;
import ca.dylancalado.sortingalgorithms.sortingcode.SortParameters;
import static ca.dylancalado.sortingalgorithms.sortingcode.SortType.SHELL_SORT;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Unit tests related to shell sort.
 * 
 * @author dylan
 */
public class TestShellSort
{
    private static int[] testArray = {3, 6, 1, 10, 4, 8, 9, 2, 5, 7, 12, 11, 15, 13, 14, 19, 16, 17, 20, 18};
    static ArrayList<Integer> testGapSeq = new ArrayList<>();
    private static int gapSeqSize;
            
    public static boolean testShellSortAscending()
    {
        int[] expectedOutput = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        SortParameters p = new SortParameters(testArray, testArray.length, SHELL, testGapSeq, gapSeqSize, ASCENDING, SHELL_SORT);
        ShellSort.generateShellGap(p);
       
        ShellSort.sort(p);
        boolean match = Arrays.equals(testArray, expectedOutput);
        
        System.out.print("Shell sort ascending test passed? ");
        return match;
    }
    
    public static boolean testShellSortDescending()
    {
        int[] expectedOutput = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        SortParameters p = new SortParameters(testArray, testArray.length, SHELL, testGapSeq, gapSeqSize, DESCENDING, SHELL_SORT);
        ShellSort.generateShellGap(p);

        ShellSort.sort(p);
        boolean match = Arrays.equals(testArray, expectedOutput);

        System.out.print("Shell sort descending test passed? ");
        return match;
    }
    
    public static boolean testGenerateShellGap()
    {
        int[] expectedOutput1 = {10, 5, 2, 1};
        SortParameters p1 = new SortParameters(testArray, testArray.length, SHELL, testGapSeq, gapSeqSize, ASCENDING, SHELL_SORT);
        ShellSort.generateShellGap(p1);
        
        //Visual of the gap sequence 
        for(int i = 0; i < p1.getGapSeqSize(); ++i)
        {
            System.out.print(p1.getGapSeq().get(i));
        }
        boolean match = Arrays.asList(expectedOutput1).equals(p1.getGapSeq());
       
        System.out.print("Generate Shell sequence test passed? ");
        return match;
    }
    
    public static boolean testGeneratePrattGap()
    {
        int[] expectedOutput2 = {1, 2, 3, 4, 6, 8, 9, 12};
        SortParameters p2 = new SortParameters(testArray, testArray.length, PRATT, testGapSeq, gapSeqSize, ASCENDING, SHELL_SORT);
        ShellSort.generatePrattGap(p2);
        
        boolean match = false;
       
        System.out.print("Generate Pratt sequence test passed? ");
        return match;
    }
    
    public static boolean testGenerateKnuthGap()
    {
        int[] expectedOutput3 = {1, 4, 14, 40, 121};
        SortParameters p3 = new SortParameters(testArray, testArray.length, KNUTH, testGapSeq, gapSeqSize, ASCENDING, SHELL_SORT);
        ShellSort.generateKnuthGap(p3);
        
        boolean match = false;
       
        System.out.print("Generate Knuth sequence test passed? ");
        return match;
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
