package model.helper;

import GUI.MainFrame;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class StringHelper { 
    private static final List<String> VALID_NAME_EXTENSION = Arrays.asList("jpg", "png", "jpeg");
    
    public static boolean isImage(String fileName) {
        String extension = StringHelper.getExtension(fileName);
        
        boolean isValidFileName = (fileName != null) && !fileName.equalsIgnoreCase(MainFrame.NO_FILE);
        boolean isValidExtension = VALID_NAME_EXTENSION
                                   .stream()
                                   .anyMatch(ext -> ext.equalsIgnoreCase(extension));
        
        return isValidFileName && isValidExtension;
    }
    
    public static String getExtension(String fileName){
        return fileName.substring(fileName.indexOf('.', fileName.lastIndexOf('/')) + 1);
    }
    
    public static String getAbsolutePath(String directoryPath, String fileName){
        return directoryPath + "/" + fileName;
    }
    
    public static String getDirectoryPath(File directory){
        return directory.getAbsolutePath().replace("\\", "/");
    }
}
