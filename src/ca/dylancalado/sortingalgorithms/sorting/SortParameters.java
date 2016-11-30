package ca.dylancalado.sortingalgorithms.sorting;

import java.util.ArrayList;

/**
 * This class is used to create objects with the
 * desired sort parameters.
 * 
 * @author dylan
 */
public final class SortParameters
{
    private int[] array;
    private int leftIndex;
    private int rightIndex;
    private int arraySize;
    private int pivotPosition;
    private ArrayList<Integer> gapSeq = new ArrayList<>();
    private int gapSeqSize;
    private SortOrder order;
    private SortType type;
    private GapSequenceType gapSeqType;
    
   
    public SortParameters(){}  

    //Selection sort and insertion sort constructor.
    public SortParameters(int[] myArray, int myArraySize, SortOrder myOrder, SortType myType)
    {
        setArray(myArray);
        setArraySize(myArraySize);
        setSortOrder(myOrder);
        setSortType(myType);
    }
    
    //Shell sort constructor.
    public SortParameters(int[] myArray, int myArraySize, GapSequenceType myGapSeqType, ArrayList myGapSeq, int myGapSeqSize, SortOrder myOrder, SortType myType)
    {
        setArray(myArray);
        setArraySize(myArraySize);
        setGapSeqType(myGapSeqType);
        setGapSeq(myGapSeq);
        setGapSeqSize(myGapSeqSize);
        setSortOrder(myOrder);
        setSortType(myType);
    }  
    
    /*//Merge sort constructor.
    public SortParameters(int[] myArray, int[] myLeftArray, int[] myRightArray, int myArraySize, SortOrder myOrder, SortType myType)
    {
        setArray(myArray);
        setLeftArray(myLeftArray);
        setRightArray(myRightArray);
        setArraySize(myArraySize);
        setSortOrder(myOrder);
        setSortType(myType);
    }*/
    
    //Quick sort constructor.
    public SortParameters(int[] myArray, int myArraySize, int myLeft, int myRight, SortOrder myOrder, SortType myType)
    {
        setArray(myArray);
        setArraySize(myArraySize);
        setLeftIndex(myLeft);
        setRightIndex(myRight);
        setSortOrder(myOrder);
        setSortType(myType);
    }
   
    public int[] getArray()
    {
        return array;
    }
    
    public int getLeftIndex()
    {
        return leftIndex;
    }
    
    public int getRightIndex()
    {
        return rightIndex;
    }
    
    public int getArraySize()
    {
        return arraySize;
    }
    
    public int getPivotPosition()
    {
        return pivotPosition;
    }
    
    public SortOrder getSortOrder()
    {
        return order;
    }
    
    public SortType getSortType()
    {
        return type;
    }
    
    public GapSequenceType getGapSeqType()
    {
        return gapSeqType;
    }
    
    public ArrayList<Integer> getGapSeq()
    {
        return gapSeq;
    }
    
    public int getGapSeqSize()
    {
        return gapSeqSize;
    }
    
    public void setArray(int[] array)
    {
        this.array = array;
    }
    
    public void setLeftIndex(int leftIndex)
    {
        this.leftIndex = leftIndex;
    }
    
    public void setRightIndex(int rightIndex)
    {
        this.rightIndex = rightIndex;
    }
    
    public void setArraySize(int arraySize)
    {
        this.arraySize = arraySize;
    }
    
    public void setPivotValue(int pivotPosition)
    {
        this.pivotPosition = pivotPosition;
    }
    
    public void setSortOrder(SortOrder order)
    {
        this.order = order;
    }
    
    public void setSortType(SortType type)
    {
        this.type = type;
    }
    
    public void setGapSeqType(GapSequenceType gapSeqType)
    {
        this.gapSeqType = gapSeqType;
    }
    
    public void setGapSeq(ArrayList<Integer> gapSeq)
    {
        this.gapSeq = gapSeq;
    }
    
    public void setGapSeqSize(int gapSeqSize)
    {
        this.gapSeqSize = gapSeqSize;
    }
}
