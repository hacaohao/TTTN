package model.datastore;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;

public class CoordinateInstances {
    private static final String X_ATTRIBUTE_NAME = "x";
    private static final String Y_ATTRIBUTE_NAME = "y";
    private static final String CLASS_NAME = "class";
    private static final String RELATION_NAME = "DataMiningDataset";
    
    private final List<Point> mSampleData;

    public CoordinateInstances(List<Point> sampleData) {
        mSampleData = new ArrayList<>(sampleData);
    }  
    
    public Instances getInstances(){
        FastVector header = getHeader();
        int capacity = mSampleData.size();
        Instances instances = new Instances(RELATION_NAME, header, capacity);
        
        for(int instanceIndex = 0; instanceIndex < capacity; instanceIndex++){
            Instance instance = new DenseInstance(header.size());
            
            instance.setValue((Attribute)header.get(0), mSampleData.get(instanceIndex).x);
            instance.setValue((Attribute)header.get(1), mSampleData.get(instanceIndex).y);
             
            instances.add(instance);
        }
        
        return instances;
    }
    
    private FastVector getHeader(){
        int numOfColumn = 3;
        FastVector wekaHeader = new FastVector(numOfColumn);
        
        Attribute attribute = new Attribute(X_ATTRIBUTE_NAME);
        wekaHeader.add(attribute);
        
        attribute = new Attribute(Y_ATTRIBUTE_NAME);
        wekaHeader.add(attribute);
        
        attribute = new Attribute(CLASS_NAME);
        wekaHeader.add(attribute);
        
        return wekaHeader;
    }  
}
