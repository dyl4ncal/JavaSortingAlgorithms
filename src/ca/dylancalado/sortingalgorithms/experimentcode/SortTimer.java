/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.dylancalado.sortingalgorithms.experimentcode;

/**
 * This class contains the code which times the runtime of any sorting algorithm.
 * 
 * @author Dylan
 */
public class SortTimer
{
   public static long timeSort()
    {
        long tStart = System.currentTimeMillis();
        long tFinish = System.currentTimeMillis();
        
        long elapsedTime = tFinish - tStart;
        return elapsedTime;
    }
}
