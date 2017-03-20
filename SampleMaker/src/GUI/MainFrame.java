package GUI;
import java.awt.Cursor;
import java.awt.Dimension;
import java.io.File;
import java.util.Arrays;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import model.utils.CoordinateGetter;
import model.utils.ImageUtils;
import model.helper.StringHelper;

public class MainFrame extends javax.swing.JFrame {
    public static final String NO_FILE = "No file";
    
    private String directoryPath;
    private final ImageUtils imgProcObj;
    private final CoordinateGetter coordinateGetter;

    public MainFrame() {
        initComponents();
        this.imagePane.setPreferredSize(new Dimension(512, 512));
        setLocationRelativeTo(null);
        
        this.directoryPath = "";
        this.imgProcObj = new ImageUtils();
        this.coordinateGetter = new CoordinateGetter();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        browseButton = new javax.swing.JButton();
        imageLabel = new javax.swing.JLabel();
        ImageNameList = new javax.swing.JScrollPane();
        imageNameList = new javax.swing.JList<>();
        ImageContainer = new javax.swing.JScrollPane();
        imagePane = new component.ImagePane();
        applyButton = new javax.swing.JButton();
        sampleButton = new javax.swing.JButton();
        viewButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sampling tool");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        browseButton.setText("Browse");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        imageLabel.setText("Image");

        imageNameList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                imageNameListValueChanged(evt);
            }
        });
        ImageNameList.setViewportView(imageNameList);

        imagePane.setPreferredSize(new java.awt.Dimension(520, 520));

        javax.swing.GroupLayout imagePaneLayout = new javax.swing.GroupLayout(imagePane);
        imagePane.setLayout(imagePaneLayout);
        imagePaneLayout.setHorizontalGroup(
            imagePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        imagePaneLayout.setVerticalGroup(
            imagePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 539, Short.MAX_VALUE)
        );

        ImageContainer.setViewportView(imagePane);

        applyButton.setText("Apply");
        applyButton.setEnabled(false);
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });

        sampleButton.setText("Sample Mode");
        sampleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sampleButtonActionPerformed(evt);
            }
        });

        viewButton.setText("View Mode");
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ImageNameList, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ImageContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(imageLabel))
                    .addComponent(browseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(viewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sampleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(applyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(290, 290, 290))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(browseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(imageLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(viewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sampleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ImageNameList)
                    .addComponent(ImageContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(applyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private File getDirectory(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            return fileChooser.getSelectedFile(); 
        }  
        
        return null;
    }
    
    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        // TODO add your handling code here:
        File directory = getDirectory();
        
        if(directory != null){
            this.directoryPath = StringHelper.getDirectoryPath(directory);
            DefaultListModel<String> nameListData = getNameListDataFromDirectory(directory);
            this.imageNameList.setModel(nameListData);
        } 
    }//GEN-LAST:event_browseButtonActionPerformed

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        String chosenFileName = this.imageNameList.getSelectedValue();
        
        this.coordinateGetter.setPolygon(this.imagePane.getPolygon());
        this.coordinateGetter.getCoordinateByPolygon(chosenFileName);
    }//GEN-LAST:event_applyButtonActionPerformed

    private void imageNameListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_imageNameListValueChanged
        // TODO add your handling code here:
        String chosenFile = this.imageNameList.getSelectedValue();
        
        if (this.imgProcObj.isImage(chosenFile)) {
            String pathToSelectedFile = StringHelper.getAbsolutePath(directoryPath, chosenFile);
            this.imgProcObj.setFilePath(pathToSelectedFile);
            updateImage(); 
        }
    }//GEN-LAST:event_imageNameListValueChanged

    private void sampleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sampleButtonActionPerformed
        this.imagePane.setIsGetSample(true);
        setCursor(Cursor.CROSSHAIR_CURSOR);
    }//GEN-LAST:event_sampleButtonActionPerformed

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
        this.imagePane.setIsGetSample(false);
        setCursor(Cursor.DEFAULT_CURSOR);
    }//GEN-LAST:event_viewButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        this.imagePane.clearPolygon();
    }//GEN-LAST:event_clearButtonActionPerformed
    
    private void updateImage(){
        this.imagePane.setBackgroundImage(imgProcObj.loadImage());
        this.applyButton.setEnabled(true);
    }
    
    private DefaultListModel<String> getNameListDataFromDirectory(File directory){
        DefaultListModel<String> nameListData = new DefaultListModel<>();
        
        Arrays.stream(directory.listFiles())
                  .filter(file -> this.imgProcObj.isImage(file.getName()))
                  .map(File::getName)
                  .forEach(name -> nameListData.addElement(name));
            
        if(nameListData.isEmpty()){
            nameListData.addElement(NO_FILE);
        }
        
        return nameListData;
    }
    
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
    private javax.swing.JButton applyButton;
    private javax.swing.JButton browseButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JList<String> imageNameList;
    private component.ImagePane imagePane;
    private javax.swing.JButton sampleButton;
    private javax.swing.JButton viewButton;
    // End of variables declaration//GEN-END:variables
}
