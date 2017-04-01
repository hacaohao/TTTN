package model.util;

import java.util.List;
import static java.util.stream.Collectors.toList;
import model.modelHelper.DirectoryHelper;
import org.opencv.core.Mat;

public class Predictor {
    private String mDirectoryPath;
    private final ImageUtils mImageProcessingObject = new ImageUtils();
    private final DirectoryHelper mDirectoryHelper = new DirectoryHelper();
    
    public void setDirectoryPath(String directoryPath) {
        mDirectoryPath = directoryPath;
    }

    public boolean hasSick() {
        List<String> imageAbsolutePathes = getImages();
        List<Mat> originalMats = imageAbsolutePathes.stream()
                                                 .map(this::getMatByImagePath)
                                                 .collect(toList());
        List<Mat> transformedMat = originalMats.stream()
                                               .map(ImageFilter::transform)
                                               .collect(toList());
        
        return true;
    }
    
    private List<String> getImages(){
        List<String> allImages = mDirectoryHelper.getImageAbsolutePathesFromDirectory(mDirectoryPath);
        int numOfImages = allImages.size();
        int startIndex = (int) (Math.ceil(numOfImages / 2.0f) - 1);
        int endIndex = numOfImages - 1;
        return allImages.subList(startIndex, endIndex);
    } 
    
    private Mat getMatByImagePath(String filePath){
        mImageProcessingObject.setFilePath(filePath);
        return mImageProcessingObject.loadMat();
    }
}
