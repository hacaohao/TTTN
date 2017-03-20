package model.utils;

import java.awt.Point;
import java.util.HashMap;
import java.util.List;
import model.helper.StringHelper;
import model.io.CSVFileReader;

public class ImageGenerator {
    private String csvFilePath;
    private List<String> files;
    private final ImageUtils imgProcObj;

    public ImageGenerator() {
        this.imgProcObj = new ImageUtils();
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }

    public void setCSVFilePath(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }
    
    public void createImage(){
       HashMap<String, List<Point>> abnormalPointFromCSVFiles = getAbnormalPointsFromCSVFiles();
       writeToFile(abnormalPointFromCSVFiles);
    }
    
    private HashMap<String, List<Point>> getAbnormalPointsFromCSVFiles(){
        HashMap<String, List<Point>> abnormalPointFromCSVFiles = new HashMap<>();
        
        this.files.stream()
           .forEach(file -> abnormalPointFromCSVFiles.put(file, getAbnormalPointsFromCSVFile(file)));
        
        return abnormalPointFromCSVFiles;
    }
    
    private List<Point> getAbnormalPointsFromCSVFile(String fileName){
        String filePath = StringHelper.getAbsolutePath(this.csvFilePath, fileName);
        return CSVFileReader.readFile(filePath);
    }
    
    private void writeToFile(HashMap<String, List<Point>> abnormalPointFromCSVFiles){
        System.out.println("Start writing to File");
        
        abnormalPointFromCSVFiles
            .forEach((String key, List<Point> value) -> this.imgProcObj.writeImage(key, value));
        
        System.out.println("Finish writing to File");
    }
}
