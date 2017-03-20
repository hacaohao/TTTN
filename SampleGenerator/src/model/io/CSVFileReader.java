package model.io;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileReader {
    private static final String COMMA_DELIMITER = ",";

    public static List<Point> readFile(String filePath) {
        List<Point> abnormalPoints = new ArrayList<>();
        
        try {
            abnormalPoints = readCSVFile(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return abnormalPoints;
    }

    private static List<Point> readCSVFile(String filePath) throws FileNotFoundException, IOException {
        List<Point> abnormalPoints = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = br.readLine()) != null) {
            String[] coordinate = line.split(COMMA_DELIMITER);
            Point point = new Point(Integer.parseInt(coordinate[0]), Integer.parseInt(coordinate[1]));
            abnormalPoints.add(point);
        }

        br.close();
        return abnormalPoints;
    }
}
