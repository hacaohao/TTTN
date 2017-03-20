package model.utils;
import java.awt.Point;
import java.util.List;
import model.helper.StringHelper;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;

public class ImageUtils {
    private static final int IMAGE_WIDTH = 512;
    private static final int IMAGE_HEIGHT = 512;
    private static final int ABNORMAL_COLOR = 0x080808;
    
    public ImageUtils() {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
    
    public void writeImage(String fileName, List<Point> abnormalPoints){
        byte[] data = prepareData(abnormalPoints);
        Mat mat = new Mat(IMAGE_WIDTH, IMAGE_HEIGHT, CvType.CV_8UC1, new Scalar(0));
        mat.put(0, 0, data);
        
        System.out.println(StringHelper.removeCSVExtension(fileName));
        Imgcodecs.imwrite(StringHelper.removeCSVExtension(fileName), mat);
    }
    
    private byte[] prepareData(List<Point> abnormalPoints){
        byte[] data = new byte[IMAGE_WIDTH * IMAGE_HEIGHT];
        abnormalPoints.stream().forEach(point -> setAbnormalPoint(point, data));
        
        return data;
    }
    
    private void setAbnormalPoint(Point abnormalPoint, byte[] data){
        int offset = IMAGE_HEIGHT*(abnormalPoint.y - 1) + abnormalPoint.x;
        data[offset] = (byte) ABNORMAL_COLOR;
    } 
}
