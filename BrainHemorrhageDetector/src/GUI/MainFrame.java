package GUI;

import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import model.guiHelper.MainFrameHelper;
import model.helper.DirectoryHelper;
import model.helper.FileHelper;
import model.util.ImageUtils;

public class MainFrame extends javax.swing.JFrame {
    private final ImageUtils mImageProcessingObject = new ImageUtils();
    private final MainFrameHelper mController = new MainFrameHelper();
    private final DirectoryHelper mDirectoryHelper = new DirectoryHelper();
    private final FileHelper mFileHelper = new FileHelper();
    private String mDirectoryPath;
    
    public MainFrame() {
        initComponents();
        setLocationRelativeTo(null);
    }
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mButtonBrowse = new javax.swing.JButton();
        imageLabel = new javax.swing.JLabel();
        ImageNameList = new javax.swing.JScrollPane();
        mImageNameList = new javax.swing.JList<>();
        ImageContainer = new javax.swing.JScrollPane();
        mImageContainer = new javax.swing.JLabel();
        mButtonPredict = new javax.swing.JButton();
        mButtonPredictAll = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sampling tool");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        mButtonBrowse.setText("Browse");
        mButtonBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mButtonBrowseActionPerformed(evt);
            }
        });

        imageLabel.setText("Image");

        mImageNameList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                mImageNameListValueChanged(evt);
            }
        });
        ImageNameList.setViewportView(mImageNameList);

        mImageContainer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImageContainer.setViewportView(mImageContainer);

        mButtonPredict.setText("Predict");
        mButtonPredict.setEnabled(false);
        mButtonPredict.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mButtonPredictActionPerformed(evt);
            }
        });

        mButtonPredictAll.setText("Predict all");
        mButtonPredictAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mButtonPredictAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(mButtonPredict, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134)
                .addComponent(mButtonPredictAll, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(219, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(imageLabel))
                    .addComponent(mButtonBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(577, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ImageNameList, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ImageContainer)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(mButtonBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ImageNameList, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                    .addComponent(ImageContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mButtonPredictAll, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mButtonPredict, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void mButtonPredictActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mButtonPredictActionPerformed
        
    }//GEN-LAST:event_mButtonPredictActionPerformed

    private void mButtonBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mButtonBrowseActionPerformed
        File chosenDirectory = mController.getNewDirectory();
        DefaultListModel<String> imageNamesList = mController.getImageNamesList(chosenDirectory);
        
        mImageNameList.setModel(imageNamesList);      
        if(mController.nonEmptyDirectory(imageNamesList))
            mDirectoryPath = mDirectoryHelper.getDirectoryPath(chosenDirectory);
    }//GEN-LAST:event_mButtonBrowseActionPerformed
    
    private void mImageNameListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_mImageNameListValueChanged
        updateImage();
        mButtonPredict.setEnabled(true);
    }//GEN-LAST:event_mImageNameListValueChanged
       
    private void updateImage(){
        mImageProcessingObject.setFilePath(mFileHelper.getAbsolutePath(mDirectoryPath, mImageNameList.getSelectedValue()));
        ImageIcon imageIcon = new ImageIcon(mImageProcessingObject.loadImage());
        mImageContainer.setIcon(imageIcon);
    }
    
    private void mButtonPredictAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mButtonPredictAllActionPerformed
        
    }//GEN-LAST:event_mButtonPredictAllActionPerformed
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
         
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ImageContainer;
    private javax.swing.JScrollPane ImageNameList;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JButton mButtonBrowse;
    private javax.swing.JButton mButtonPredict;
    private javax.swing.JButton mButtonPredictAll;
    private javax.swing.JLabel mImageContainer;
    private javax.swing.JList<String> mImageNameList;
    // End of variables declaration//GEN-END:variables
}
