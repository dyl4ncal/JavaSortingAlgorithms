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
    private static String name;
    private static File file;
    private static FileWriter fw;
    
    public static void getFileName() throws IOException
    {
        input = new Scanner(System.in);
        name = input.nextLine();
        file = new File(name.concat(".csv"));
    }
    
    public static void createLogFile() throws IOException
    {
        if (file.createNewFile())
        {
            System.out.println(file + " created successfully.\n");
        } 
        else 
        {
            System.out.println(file + "already exists. Please choose a new name\n.");
        }
    }
    
    public static void writeRuntimeHeader() throws IOException
    {
        fw = new FileWriter(file);
        fw.append("InputSize,AverageSortTime,\n");
    }
    
    public static void writeMemoryUsageHeader() throws IOException
    {
        fw.append("InputSize,MemoryUsage,\n");
    }
    
    public static void writeDataToCSV(int arraySize, long time) throws IOException
    {
        fw.write(arraySize + "," + (int)time + "," + "\n");
    }
    
    public static void closeWriter() throws IOException
    {
        fw.close();
    }
}
