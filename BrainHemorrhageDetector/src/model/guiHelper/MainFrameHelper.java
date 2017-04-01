package model.guiHelper;

import static model.GlobalConstant.*;
import java.io.File;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import model.helper.DirectoryHelper;
import model.io.IOoperator;
import model.util.Predictor;

public class MainFrameHelper {
    private final DirectoryHelper mDirectoryHelper = new DirectoryHelper();
    private final Predictor mPredictor = new Predictor();
    private final IOoperator mIOoperator = new IOoperator();
    
    public void writeResultToFile(String directoryPath){
        mPredictor.setDirectoryPath(directoryPath);
        String result = mPredictor.hasSick() ? ABNORMAL : NORMAL;
        mIOoperator.writeFile(directoryPath + ":" + result);
        mIOoperator.close();
    }
    
    public DefaultListModel<String> getImageNamesList(File directory){
        DefaultListModel<String> nameListData = new DefaultListModel<>();
        
        if(directory != null){
            List<String> imageNamesList = mDirectoryHelper.getImagesFromDirectory(directory);
            imageNamesList.forEach(nameListData::addElement);
        }
        
        if(nameListData.isEmpty()){
            nameListData.addElement(NO_FILE);
        }
        
        return nameListData;
    }
    
    public File getNewDirectory(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            return fileChooser.getSelectedFile(); 
        }  
        
        return null;
    }
    
    public boolean nonEmptyDirectory(DefaultListModel<String> imageNamesList){
        return !imageNamesList.contains(NO_FILE);
    }
}
