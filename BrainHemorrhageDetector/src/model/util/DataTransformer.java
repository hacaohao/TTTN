package model.util;

import static model.GlobalConstant.*;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import model.datastore.CoordinateInstances;
import org.opencv.core.Mat;

public class DataTransformer {
    public Instances matToInstances(Mat mat){
        List<Point> nonBackgroundPoints = matToPoints(mat);
        return new CoordinateInstances(nonBackgroundPoints).getInstances();
    }
    
    private List<Point> matToPoints(Mat mat){
        List<Point> result = new ArrayList<>();
        
        for(int x = 0; x < mat.cols(); x++){
            for(int y = 0; y < mat.rows(); y++){
                if(!mat.get(y, x).equals(BLACK_COLOR)){
                    result.add(new Point(x, y));
                }
            }
        }
        
        return result;
    }
    
    
}
