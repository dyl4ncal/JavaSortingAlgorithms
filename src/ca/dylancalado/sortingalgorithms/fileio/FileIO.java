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
    private static FileWriter fileWriter;
    
    public static void getFileName()
    {
        input = new Scanner(System.in);
        name = input.nextLine();
        file = new File(name.concat(".csv"));
    }
    
    public static void createLogFile() throws IOException
    {
        if (!file.createNewFile())
        {
            System.out.println("This file name is taken. Please choose a new name.");
        } 
        else 
        {
            System.out.println("File is created!");
        }
    }
    
    public static void writeToLogFile() throws IOException
    {
        fileWriter = new FileWriter(file);
        fileWriter.write("Test data");
        fileWriter.close();
    }
}
