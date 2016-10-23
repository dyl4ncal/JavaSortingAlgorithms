package ca.dylancalado.sortingalgorithms.fileio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class is for creating files and writing the data
 * produced in experiments to a .csv file to be viewed in excel.
 * 
 * @author Dylan
 */
public class FileIO
{
    private static Scanner input;
    private static String fileName;
    private static String csvName;
    private static File baseFile;
    private static File csvFile;
    private static FileWriter fw;
    
    public static void setFileName() throws IOException
    {
        input = new Scanner(System.in);
        fileName = input.nextLine();
        baseFile = new File(fileName);
    }
    
    public static void setCSVName() throws IOException
    {
        input = new Scanner(System.in);
        csvName = input.nextLine();
        csvFile = new File(baseFile + "\\" + csvName.concat(".csv"));
    }
    
    public static void createBaseLogFile() throws IOException
    {
        if (baseFile.mkdir())
        {
            System.out.println(baseFile + " created successfully.\n");
        } 
        else 
        {
            System.out.println(baseFile + "already exists. The results will be stored in this same location.\n");
        }
    }
    
    public static void createCSVFile() throws IOException
    {
        if (csvFile.createNewFile())
        {
            System.out.println(csvFile + " created successfully.\n");
        } 
        else 
        {
            System.out.println(csvFile + "already exists. The results will be stored in this same location.\n.");
        }
    }
    
    public static void writeRuntimeHeader() throws IOException
    {
        fw = new FileWriter(csvFile);
        fw.append("InputSize,AverageSortTime,\n");
    }
    
    public static void writeMemoryUsageHeader() throws IOException
    {
        fw = new FileWriter(csvFile);
        fw.append("InputSize,MemoryUsage,\n");
    }
    
    public static void writeTimingDataToCSV(int arraySize, long time) throws IOException
    {
        fw.write(arraySize + "," + (int)time + "," + "\n");
    }
    
    public static void closeWriter() throws IOException
    {
        fw.close();
    }
}
