package model.io;

import java.awt.Point;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CSVFileWriter {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = System.lineSeparator();
    private static final String SAVED_PATH_ROOT = "D:\\";
    private static final String FILE_EXTENSION = ".csv";
    
    private static String savedPath;
    
    public static void writeToFile(ArrayList<Point> coordinateValues, String fileName){
        try {
            prepareFile(fileName);
            writeFile(coordinateValues);
        } catch (IOException ex) {
            Logger.getLogger(CSVFileWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void prepareFile(String fileName) throws IOException{
        savedPath = SAVED_PATH_ROOT + fileName + FILE_EXTENSION;
        System.out.println(savedPath);
        File savedFile = new File(savedPath);
        savedFile.createNewFile();
    }
    
    private static void writeFile(ArrayList<Point> coordinateValues) throws IOException{
        System.out.println("Start writing");
        FileWriter fileWriter = new FileWriter(savedPath);
        
        for(Point pointCoordinate : coordinateValues){
            fileWriter.append(String.valueOf(pointCoordinate.x));
            fileWriter.append(COMMA_DELIMITER);
            
            fileWriter.append(String.valueOf(pointCoordinate.y));
            fileWriter.append(NEW_LINE_SEPARATOR);
        }
            
        fileWriter.flush();
        fileWriter.close();
        
        System.out.println("Finish writing");
    }   
}
