package model.utils;
import GUI.MainFrame;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.helper.StringHelper;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ImageUtils {
    private String filePath = "";
    private final List<String> VALID_NAME_EXTENSION = Arrays.asList("jpg", "png", "jpeg");

    public ImageUtils() {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
    
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    public boolean isImage(String fileName) {
        String extension = StringHelper.getExtension(fileName);
        
        boolean isValidFileName = (fileName != null) && !fileName.equalsIgnoreCase(MainFrame.NO_FILE);
        boolean isValidExtension = VALID_NAME_EXTENSION
                                   .stream()
                                   .anyMatch(ext -> ext.equalsIgnoreCase(extension));
        
        return isValidFileName && isValidExtension;
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
    
    public Mat loadMat() {
        Mat mat = Imgcodecs.imread(this.filePath);
        Mat grayMat = new Mat(mat.height(), mat.width(), CvType.CV_8UC3);
        Imgproc.cvtColor(mat, grayMat, Imgproc.COLOR_RGB2GRAY);

        return grayMat;
    }
}
