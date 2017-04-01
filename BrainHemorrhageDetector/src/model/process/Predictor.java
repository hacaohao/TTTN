package model.process;

import java.util.List;
import java.util.function.Function;
import static java.util.stream.Collectors.toList;
import model.helper.DirectoryHelper;
import model.util.DataTransformer;
import model.util.ImageFilter;
import model.util.ImageUtils;
import org.opencv.core.Mat;
import weka.core.Instances;

public class Predictor {
    private String mDirectoryPath;
    private final ImageUtils mImageProcessingObject = new ImageUtils();
    
    public void setDirectoryPath(String directoryPath) {
        mDirectoryPath = directoryPath;
    }

    public boolean hasSick() {
        List<String> imageAbsolutePathes = getImages();
        System.out.println("xong doan 1");
        List<Mat> transformedMat = transformFromPathesToMats(imageAbsolutePathes);
        System.out.println("xong doan 2");
        List<Instances> clusteredInstances = transformFormMatsToInstances(transformedMat);
        System.out.println("xong doan 3");
        clusteredInstances.stream().forEach(System.out::println);
        
        return true;
    }
    
    private List<Mat> transformFromPathesToMats(List<String> imageAbsolutePathes){
        List<Mat> originalMats = transformListFrom(imageAbsolutePathes, this::getMatByImagePath);
        return transformListFrom(originalMats, new ImageFilter()::transform);
    }
    
    private List<Instances> transformFormMatsToInstances(List<Mat> transformedMat){
        List<Instances> originalInstances = transformListFrom(transformedMat, new DataTransformer()::matToInstances); 
        return originalInstances.stream()
                                .map(instances -> new DBscanClassifier(instances).clusterInstances())
                                .collect(toList());
    }
    
    private <T, R> List<T> transformListFrom(List<R> oldList, Function<R, T> transformFunction ){
        return oldList.stream().map(transformFunction).collect(toList());
    }
    
    private List<String> getImages(){
        List<String> allImages = new DirectoryHelper().getImageAbsolutePathesFromDirectory(mDirectoryPath);
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
