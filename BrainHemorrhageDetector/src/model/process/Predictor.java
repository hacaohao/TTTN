package model.process;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;
import model.helper.DirectoryHelper;
import model.io.IOoperator;
import model.util.DataTransformer;
import model.util.ImageFilter;
import model.util.ImageUtils;
import org.opencv.core.Mat;
import weka.core.Instance;
import weka.core.Instances;

public class Predictor {
    private String mDirectoryPath;
    private final ImageUtils mImageProcessingObject = new ImageUtils();
    private final IOoperator mIOoperator = new IOoperator();
    
    public void setDirectoryPath(String directoryPath) {
        mDirectoryPath = directoryPath;
    }

    public boolean hasSick() {
        List<String> imageAbsolutePathes = getImages();
        List<Instances> clusteredInstances = imageAbsolutePathes
                                            .stream()
                                            .map(this::getMatsByImagePathes)
                                            .map(new ImageFilter()::applyFilter)
                                            .parallel()
                                            .map(new DataTransformer()::matToInstances)
                                            .map(instances -> new DBscanClassifier(instances).clusterInstances())
                                            .sequential()
                                            .collect(toList());
        clusteredInstances.forEach(instance -> System.out.println(instance.numDistinctValues(instance.numAttributes() - 1)));
        Instances test = clusteredInstances.get(0);
        Mat mat = imageAbsolutePathes.stream().map(this::getMatsByImagePathes).map(new ImageFilter()::applyFilter).collect(toList()).get(0);
        List<Point> points = getPointsByGroup(test, mat, 0);
        points.forEach(point -> mIOoperator.writeFile(point.x + "," + point.y + ",abnormal\n"));
        mIOoperator.close();
        
        return true;
    }
    
    private List<Point> getPointsByGroup(Instances predictedInstances, Mat mat, double group){
        List<Point> points = new DataTransformer().matToPoints(mat);
        List<Point> groupOfPoint = new ArrayList<>();
        int index = 0;
     
        for(Instance instance : predictedInstances){
            if(instance.classValue() == group){
                groupOfPoint.add(points.get(index));
            }
            
            index++;
        }
        
        return groupOfPoint;
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
