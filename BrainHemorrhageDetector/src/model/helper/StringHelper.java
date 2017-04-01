package model.helper;

import java.io.File;
import java.util.Arrays;

public class StringHelper { 
    private static final String[] VALID_IMAGE_EXTENSION = new String[]{"jpg", "png", "jpeg"};
     
    public static boolean isImage(String fileName) {
        if(fileName == null) 
            return false;
        
        String extension = getExtension(fileName);
        return Arrays.asList(VALID_IMAGE_EXTENSION).stream().anyMatch(extension::equals);
    }
    
    public static String getExtension(String fileName){
        String[] fileNameComponents = fileName.split("\\.");
        int extensionIndex = fileNameComponents.length - 1;
        return fileNameComponents[extensionIndex];
    }
    
    public static String getAbsolutePath(String directoryPath, String fileName){
        return directoryPath + "/" + fileName;
    }
    
    public static String getDirectoryPath(File directory){
        return directory.getAbsolutePath().replace("\\", "/");
    }
}
