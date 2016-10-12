package ca.dylancalado.sortingalgorithms.sortingcode;

/**
 * This interface sits in front of each sorting algorithm and 
 * provides a sort method which takes a parameter object indicating
 * which kind of sort and other details.
 * @author dylan
 */
public interface SortFacade
{
    static void sort(SortParameters p){}
}
