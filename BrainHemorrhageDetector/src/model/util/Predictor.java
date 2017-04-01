package model.util;

import java.util.List;
import java.util.function.Function;
import static java.util.stream.Collectors.toList;
import model.helper.DirectoryHelper;
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
        List<Mat> originalMats = transformListFrom(imageAbsolutePathes, this::getMatByImagePath);
        List<Mat> transformedMat = transformListFrom(originalMats, ImageFilter::transform);
        List<Instances> originalInstances = transformListFrom(transformedMat, DataTransformer::matToInstances); 
        
        return true;
    }
    
    private <T, R> List<T> transformListFrom(List<R> oldList, Function<R, T> transformFunction ){
        return oldList.stream().map(transformFunction).collect(toList());
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
