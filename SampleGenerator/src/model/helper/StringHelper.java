package model.helper;

import java.io.File;

public class StringHelper { 
    
    public static String removeCSVExtension(String fileName){
        String extension = getExtension(fileName);
        return fileName.replace(extension, "");
    }
    
    private static String getExtension(String fileName){
        return fileName.substring(fileName.lastIndexOf('.'));
    }
    
    public static String getAbsolutePath(String directoryPath, String fileName){
        return directoryPath + "/" + fileName;
    }
    
    public static String getDirectoryPath(File directory){
        return directory.getAbsolutePath().replace("\\", "/");
    }
}
