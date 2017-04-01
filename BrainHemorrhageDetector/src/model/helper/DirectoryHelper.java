package model.helper;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class DirectoryHelper {  
    public List<String> getImagesFromDirectory(File directory){
        FileHelper fileHelper = new FileHelper();
        return Arrays.asList(directory.listFiles())
                     .stream()
                     .map(file -> file.getName())
                     .filter(fileHelper::isImage)
                     .collect(toList());
    }
}
