package model.modelHelper;

import java.io.File;

public class URIHelper {
    public String getAbsolutePath(String directoryPath, String fileName){
        return directoryPath + "/" + fileName;
    }
    
    public String getDirectoryPath(File directory){
        return directory.getAbsolutePath().replace("\\", "/");
    }
}
