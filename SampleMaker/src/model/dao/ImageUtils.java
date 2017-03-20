package model.dao;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import model.helper.StringHelper;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ImageUtils {

    private String filePath = "";

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    public static boolean isImage(String fileName) {
        String extension = StringHelper.getExtension(fileName);
        return extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("png") || extension.equalsIgnoreCase("jpeg");
    }
    
    public BufferedImage loadImage() {
        Mat grayMat = loadMat();

        int bufferSize = grayMat.cols() * grayMat.rows();
        byte[] data = new byte[bufferSize];
        grayMat.get(0, 0, data);

        BufferedImage grayImage = new BufferedImage(grayMat.cols(), grayMat.rows(), BufferedImage.TYPE_BYTE_GRAY);
        byte[] target = ((DataBufferByte) grayImage.getRaster().getDataBuffer()).getData();

        System.arraycopy(data, 0, target, 0, bufferSize);

        return grayImage;
    }
    
    public Mat createMask(){
        Mat mask = loadMat();
        
        Imgproc.medianBlur(mask, mask, 19); //so cu la 33
        Imgproc.threshold(mask, mask, 145, 10, Imgproc.THRESH_TOZERO_INV);
        Imgproc.medianBlur(mask, mask, 47);
        Imgproc.threshold(mask, mask, 10, 145, Imgproc.THRESH_BINARY);
        
        return mask;
    }
    
    public Mat loadMat() {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat mat = Imgcodecs.imread(this.filePath);
        Mat grayMat = new Mat(mat.height(), mat.width(), CvType.CV_8UC3);
        Imgproc.cvtColor(mat, grayMat, Imgproc.COLOR_RGB2GRAY);

        return grayMat;
    }
}
