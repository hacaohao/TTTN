package model.util;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import static model.GlobalConstant.*;
import model.datastore.CoordinateInstances;
import org.opencv.core.Mat;
import weka.core.Instances;

public class DataTransformer {
    public Instances matToInstances(Mat mat){
        List<Point> nonBackgroundPoints = matToPoints(mat);
        return new CoordinateInstances(nonBackgroundPoints).getInstances();
    }
    
    public List<Point> matToPoints(Mat mat){
        List<Point> result = new ArrayList<>();
        
        for(int x = 0; x < mat.cols(); x++){
            for(int y = 0; y < mat.rows(); y++){
                if(mat.get(y, x)[0] != BLACK_COLOR){
                    result.add(new Point(x, y));
                } else {
                }
            }
        }
        
        return result;
    }  
}
