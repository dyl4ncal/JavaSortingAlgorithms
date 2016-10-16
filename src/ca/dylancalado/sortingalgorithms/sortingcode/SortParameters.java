package ca.dylancalado.sortingalgorithms.sortingcode;

/**
 * This class is used to create objects with the
 * desired sort parameters.
 * 
 * @author dylan
 */
public class SortParameters
{
    private int[] array;
    private int arraySize;
    private int[] gapSeq;
    private int gapSeqSize;
    private SortOrder order;
    private SortType type;
    private GapSequenceType gapSeqType;
   
    public SortParameters()
    {
        //set safe defaults
    }  

    public SortParameters(int[] myArray, int myArraySize, SortOrder myOrder, SortType myType)
    {
        setArray(myArray);
        setArraySize(myArraySize);
        setSortOrder(myOrder);
        setSortType(myType);
    }
    
    public SortParameters(int[] myArray, int myArraySize, GapSequenceType myGapSeqType, int myGapSeqSize, SortOrder myOrder, SortType myType)
    {
        setArray(myArray);
        setArraySize(myArraySize);
        setGapSeqType(myGapSeqType);
        setGapSeqSize(myGapSeqSize);
        setSortOrder(myOrder);
        setSortType(myType);
    }          
   
    public int[] getArray()
    {
        return array;
    }
    
    public int getArraySize()
    {
        return arraySize;
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
    
    public int[] getGapSeq()
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
    
    public void setArraySize(int arraySize)
    {
        this.arraySize = arraySize;
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
    
    public void setGapSeq(int[] gapSeq)
    {
        this.gapSeq = gapSeq;
    }
    
    public void setGapSeqSize(int gapSeqSize)
    {
        this.gapSeqSize = gapSeqSize;
    }
}
