package model.io;

import static model.GlobalConstant.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IOoperator {
    private PrintWriter mWriter;  
    
    public IOoperator(){
        try {
            mWriter = new PrintWriter(new FileWriter(RESULT_PATH, true));
        } catch (IOException ex) {
            Logger.getLogger(IOoperator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void writeFile(String content){
        mWriter.print(content);
    }
    public void close(){
        mWriter.close();
    }
}
