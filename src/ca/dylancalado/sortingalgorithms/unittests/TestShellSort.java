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
    private static int gapSeqSize;
            
    public static boolean testShellSortShellGapAscending()
    {
        int[] expectedOutput = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        ArrayList<Integer> testGapSeq = new ArrayList<>();
        SortParameters p = new SortParameters(testArray, testArray.length, SHELL, testGapSeq, gapSeqSize, ASCENDING, SHELL_SORT);
        ShellSort.generateShellGap(p);
        ShellSort.sort(p);
        
        boolean match = Arrays.equals(testArray, expectedOutput);
        
        System.out.print("Shell sort (Shell gap) ascending test passed? ");
        return match;
    }
    
    public static boolean testShellSortShellGapDescending()
    {
        int[] expectedOutput = {20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        ArrayList<Integer> testGapSeq = new ArrayList<>();
        SortParameters p = new SortParameters(testArray, testArray.length, SHELL, testGapSeq, gapSeqSize, DESCENDING, SHELL_SORT);
        ShellSort.generateShellGap(p);
        ShellSort.sort(p);
        
        boolean match = Arrays.equals(testArray, expectedOutput);
       
        System.out.print("Shell sort (Shell gap) descending test passed? ");
        return match;
    }
    
    public static boolean testShellSortPrattGapAscending() 
    {
        int[] expectedOutput = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        ArrayList<Integer> testGapSeq = new ArrayList<>();
        SortParameters p = new SortParameters(testArray, testArray.length, PRATT, testGapSeq, gapSeqSize, ASCENDING, SHELL_SORT);
        ShellSort.generatePrattGap(p);
        ShellSort.sort(p);
      
        boolean match = Arrays.equals(testArray, expectedOutput);
        
        System.out.print("Shell sort (Pratt gap) ascending test passed? ");
        return match;
    }

    public static boolean testShellSortPrattGapDescending()
    {
        int[] expectedOutput = {20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        ArrayList<Integer> testGapSeq = new ArrayList<>();
        SortParameters p = new SortParameters(testArray, testArray.length, PRATT, testGapSeq, gapSeqSize, DESCENDING, SHELL_SORT);
        ShellSort.generatePrattGap(p);
        ShellSort.sort(p);
        
        boolean match = Arrays.equals(testArray, expectedOutput);
       
        System.out.print("Shell sort (Pratt gap) descending test passed? ");
        return match;
    }
    
    public static boolean testShellSortKnuthGapAscending()
    {
        int[] expectedOutput = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        ArrayList<Integer> testGapSeq = new ArrayList<>();
        SortParameters p = new SortParameters(testArray, testArray.length, KNUTH, testGapSeq, gapSeqSize, ASCENDING, SHELL_SORT);
        ShellSort.generateKnuthGap(p);
        ShellSort.sort(p);
      
        boolean match = Arrays.equals(testArray, expectedOutput);
        
        System.out.print("Shell sort (Knuth gap) ascending test passed? ");
        return match;
    }

    public static boolean testShellSortKnuthGapDescending()
    {
        int[] expectedOutput = {20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        ArrayList<Integer> testGapSeq = new ArrayList<>();
        SortParameters p = new SortParameters(testArray, testArray.length, KNUTH, testGapSeq, gapSeqSize, DESCENDING, SHELL_SORT);
        ShellSort.generateKnuthGap(p);
        ShellSort.sort(p);
        
        boolean match = Arrays.equals(testArray, expectedOutput);
        
        System.out.print("Shell sort (Knuth gap) descending test passed? ");
        return match;
    }
    
    public static boolean testGenerateShellGap()
    {
        int[] expectedOutput1 = {10, 5, 2, 1};
        ArrayList<Integer> testGapSeq = new ArrayList<>();
        SortParameters p1 = new SortParameters(testArray, testArray.length, SHELL, testGapSeq, gapSeqSize, ASCENDING, SHELL_SORT);
        ShellSort.generateShellGap(p1);
       
        boolean match = true;
        
        for(int i = 0; i < expectedOutput1.length; ++i)
        {
            match = p1.getGapSeq().get(i).equals(expectedOutput1[i]);
            if(match == false)
            {
                break;
            }
        }
        System.out.print("Generate Shell sequence test passed? ");
        return match;
    }
    
    public static boolean testGeneratePrattGap()
    {
        int[] expectedOutput2 = {1, 2, 3, 4, 6, 8, 9, 12};
        ArrayList<Integer> testGapSeq = new ArrayList<>();
        SortParameters p2 = new SortParameters(testArray, testArray.length, PRATT, testGapSeq, gapSeqSize, ASCENDING, SHELL_SORT);
        ShellSort.generatePrattGap(p2);
        
        boolean match = true;
        
        for(int i = 0; i < expectedOutput2.length; ++i)
        {
            match = p2.getGapSeq().get(i).equals(expectedOutput2[i]);
            if(match == false)
            {
               break;
            }
        }
       
        System.out.print("Generate Pratt sequence test passed? ");
        return match;
    }
    
    public static boolean testGenerateKnuthGap()
    {
        int[] expectedOutput3 = {1, 4};
        ArrayList<Integer> testGapSeq = new ArrayList<>();
        SortParameters p3 = new SortParameters(testArray, testArray.length, KNUTH, testGapSeq, gapSeqSize, ASCENDING, SHELL_SORT);
        ShellSort.generateKnuthGap(p3);
        
        boolean match = true;
        
        for(int i = 0; i < expectedOutput3.length; ++i)
        {
            match = p3.getGapSeq().get(i).equals(expectedOutput3[i]);
            if(match == false)
            {
               break;
            }
        }
       
        System.out.print("Generate Knuth sequence test passed? ");
        return match;
    }
    
    public static void testAllShellSortMethods()
    {
        System.out.println("Unit Tests Related to Shell Sort:\n");
        System.out.println(testShellSortShellGapAscending());
        System.out.println(testShellSortShellGapDescending());
        System.out.println(testShellSortPrattGapAscending());
        System.out.println(testShellSortPrattGapDescending());
        System.out.println(testShellSortKnuthGapAscending());
        System.out.println(testShellSortKnuthGapDescending());
        System.out.println(testGenerateShellGap());
        System.out.println(testGeneratePrattGap());
        System.out.println(testGenerateKnuthGap() + "\n");
    }
}
