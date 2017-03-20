package model.utils;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;
import model.io.CSVFileWriter;

public class CoordinateGetter {
    private Polygon polygon;

    public void setPolygon(Polygon polygon) {
        this.polygon = polygon;
    }
    
    public void getCoordinateByPolygon(String fileName){
        ArrayList<Point> coordinateValues = new ArrayList<>();
        Rectangle boundaryBox = this.polygon.getBounds();
        
        double minX = boundaryBox.getMinX();
        double maxX = boundaryBox.getMaxX();
        double minY = boundaryBox.getMinY();
        double maxY = boundaryBox.getMaxY();
        
        for(int x = (int) minX; x <= maxX; x++){
            for(int y = (int) minY; y <= maxY; y++){
                if(this.polygon.contains(x, y)){
                    coordinateValues.add(new Point(x, y));
                }
            }
        }
        
        CSVFileWriter.writeToFile(coordinateValues, fileName);
    }
}
