package model.util;

import java.io.File;
import java.util.List;
import static java.util.stream.Collectors.toList;
import model.helper.DirectoryHelper;

public class Predictor {
    private String mDirectoryPath;
    private final DirectoryHelper mDirectoryHelper = new DirectoryHelper();
    
    public void setDirectoryPath(String directoryPath) {
        mDirectoryPath = directoryPath;
    }

    public boolean hasSick() {
        List<String> imageAbsolutePathes = getImages();
        return true;
    }
    
    private List<String> getImages(){
        List<String> imageNamesList = mDirectoryHelper.getImagesFromDirectory(new File(mDirectoryPath));
        return imageNamesList.stream()
                             .map(name -> mDirectoryPath + "/" + name)
                             .collect(toList());
    } 
    
}
