package ca.dylancalado.sortingalgorithms.fileio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class is for creating files and writing the data
 * produced in experiments to .csv files to be viewed in excel.
 * 
 * @author Dylan
 */
public class FileIO
{
    private static Scanner input;
    private static String fileName;
    private static String csvName;
    private static File baseFile;
    private static File csvTimingFile;
    private static File csvMemoryFile;
    private static FileWriter fw1;
    private static FileWriter fw2;
    
    public static void setFileName() throws IOException
    {
        input = new Scanner(System.in);
        fileName = input.nextLine();
        baseFile = new File(fileName);
    }
    
    public static void setTimingCSVName() throws IOException
    {
        input = new Scanner(System.in);
        csvName = input.nextLine();
        csvTimingFile = new File(baseFile + "\\" + csvName.concat(".csv"));
    }
    
    public static void setMemoryCSVName() throws IOException
    {
        input = new Scanner(System.in);
        csvName = input.nextLine();
        csvMemoryFile = new File(baseFile + "\\" + csvName.concat(".csv"));
    }
    
    public static void createBaseLogFile() throws IOException
    {
        if (baseFile.mkdir())
        {
            System.out.println(baseFile + " created successfully.\n");
        } 
        else 
        {
            System.out.println(baseFile + " already exists. The results will be stored in this same location.\n");
        }
    }
    
    public static void createCSVTimingFile() throws IOException
    {
        if (csvTimingFile.createNewFile())
        {
            System.out.println(csvTimingFile + " created successfully.\n");
        } 
        else 
        {
            System.out.println(csvTimingFile + " already exists. The results will be stored in this same location.\n.");
        }
    }
    
    public static void createCSVMemoryFile() throws IOException
    {
        if (csvMemoryFile.createNewFile())
        {
            System.out.println(csvMemoryFile + " created successfully.\n");
        } 
        else 
        {
            System.out.println(csvMemoryFile + "already exists. The results will be stored in this same location.\n.");
        }
    }
    
    public static void writeRuntimeHeader() throws IOException
    {
        fw1 = new FileWriter(csvTimingFile);
        fw1.append("InputSize,AverageSortTime,\n");
    }
    
    public static void writeMemoryUsageHeader() throws IOException
    {
        fw2 = new FileWriter(csvMemoryFile);
        fw2.append("InputSize,MemoryUsage,\n");
    }
    
    public static void writeTimingDataToCSV(int arraySize, long time) throws IOException
    {
        fw1.write(arraySize + "," + (int)time + "," + "\n");
    }
    
    public static void writeMemoryDataToCSV(int arraySize, long memoryUsage) throws IOException
    {
        fw2.write(arraySize + "," + (int)memoryUsage + "," + "\n");
    }
    
    public static void closeWriter() throws IOException
    {
        fw1.close();
        fw2.close();
    }
}
