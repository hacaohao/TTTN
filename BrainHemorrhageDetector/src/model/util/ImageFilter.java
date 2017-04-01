package model.util;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class ImageFilter {
    public Mat applyFilter(Mat mat){
        Imgproc.medianBlur(mat, mat, 27);
        Imgproc.threshold(mat, mat, 165, 0, Imgproc.THRESH_TOZERO);
        
        return mat;
    }
}
