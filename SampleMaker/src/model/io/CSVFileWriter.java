package model.io;

import java.awt.Point;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CSVFileWriter {
    private static final String FILE_NAME = "coordinate.csv";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = System.lineSeparator();
    private static final String SAVED_PATH = "D:\\";
    
    public static void writeToFile(ArrayList<Point> coordinateValues){
        try {
            prepareFile();
            writeFile(coordinateValues);
        } catch (IOException ex) {
            Logger.getLogger(CSVFileWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void prepareFile() throws IOException{
        File savedFile = new File(SAVED_PATH + FILE_NAME);
        
        if(!savedFile.isFile()) {
            savedFile.createNewFile();
        }
    }
    
    private static void writeFile(ArrayList<Point> coordinateValues) throws IOException{
        FileWriter fileWriter = new FileWriter(SAVED_PATH + FILE_NAME);
        
        for(Point pointCoordinate : coordinateValues){
            fileWriter.append(String.valueOf(pointCoordinate.x));
            fileWriter.append(COMMA_DELIMITER);
            
            fileWriter.append(String.valueOf(pointCoordinate.y));
            fileWriter.append(NEW_LINE_SEPARATOR);
        }
            
        fileWriter.flush();
        fileWriter.close();
    }   
}
