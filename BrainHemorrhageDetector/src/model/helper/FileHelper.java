package model.helper;

import java.util.Arrays;

public class FileHelper { 
    private static final String[] VALID_IMAGE_EXTENSION = new String[]{"jpg", "png", "jpeg"};
     
    public boolean isImage(String fileName) {
        if(fileName == null) 
            return false;
        
        String extension = getExtension(fileName);
        return Arrays.asList(VALID_IMAGE_EXTENSION).stream().anyMatch(extension::equals);
    }
    
    private String getExtension(String fileName){
        String[] fileNameComponents = fileName.split("\\.");
        int extensionIndex = fileNameComponents.length - 1;
        return fileNameComponents[extensionIndex];
    }
    
    public String getAbsolutePath(String directoryPath, String fileName){
        return directoryPath + "/" + fileName;
    }
}
