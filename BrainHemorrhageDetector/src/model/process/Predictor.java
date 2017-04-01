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
        long start = System.currentTimeMillis();
        List<Instances> clusteredInstances = imageAbsolutePathes
                                            .stream()
                                            .map(this::getMatsByImagePathes)
                                            .map(new ImageFilter()::applyFilter)
                                            .parallel()
                                            .map(new DataTransformer()::matToInstances)
                                            .map(instances -> new DBscanClassifier(instances).clusterInstances())
                                            .sequential()
                                            .collect(toList());
        System.out.println(System.currentTimeMillis() - start);
        
        return true;
    }
    
    private List<String> getImages(){
        List<String> allImages = new DirectoryHelper().getImageAbsolutePathesFromDirectory(mDirectoryPath);
        int numOfImages = allImages.size();
        int startIndex = (int) (Math.ceil(numOfImages / 2.0f) - 1);
        int endIndex = numOfImages - 1;
        return allImages.subList(startIndex, endIndex);
    } 
    
    private Mat getMatsByImagePathes(String filePath){
        mImageProcessingObject.setFilePath(filePath);
        return mImageProcessingObject.loadMat();
    }
}
