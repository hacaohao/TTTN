package model.process;

import java.util.logging.Level;
import java.util.logging.Logger;
import weka.clusterers.MakeDensityBasedClusterer;
import weka.core.Instances;

public class DBscanClassifier {
    private Instances mDataSample;
    private MakeDensityBasedClusterer mClusterer;
    
    public DBscanClassifier(Instances instances){ 
        try {
            mDataSample = instances;   
            mClusterer = new MakeDensityBasedClusterer();
            mClusterer.buildClusterer(instances);
        } catch (Exception ex) {
            Logger.getLogger(DBscanClassifier.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    public Instances clusterInstances(){
        Instances predictedData = new Instances(mDataSample);
        predictedData.setClassIndex(predictedData.numAttributes() - 1);
        
        for (int i = 0; i < mDataSample.numInstances(); i++) {
            try {
                double clsLabel = mClusterer.clusterInstance(mDataSample.get(i));    
                predictedData.instance(i).setClassValue(clsLabel);
            } catch (Exception ex) {
                Logger.getLogger(DBscanClassifier.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return predictedData;
    }
}
