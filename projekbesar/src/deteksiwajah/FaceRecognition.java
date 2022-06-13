
package deteksiwajah;

import java.awt.Desktop;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.opencv.core.Mat;
import org.opencv.core.Core;
import org.opencv.core.MatOfByte;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.opencv.videoio.VideoCapture;
import org.opencv.imgcodecs.Imgcodecs;
import static org.opencv.videoio.Videoio.CAP_DSHOW;
/**
 *
 * @author TRI IKHSAN FATTAH
 */
public class FaceRecognition extends javax.swing.JFrame {
    //face detection code
    
    
    //definition
    private DaemonThread myThread = null;
    VideoCapture webSource = null;

    Mat bingkai = new Mat();
    MatOfByte mem = new MatOfByte();
    
    
    /**
     * Creates new form FaceRecognition
     */
    
    class DaemonThread implements Runnable
    {
    protected volatile boolean runnable = false;

    @Override
    public  void run()
    {
        synchronized(this)
        {
            while(runnable)
            {
                if(webSource.grab())
                {
		    	try
                        {
                            
                            webSource.retrieve(bingkai);
                            Imgcodecs.imencode(".bmp", bingkai, mem);
			    
			    Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));

			    BufferedImage buffImage = (BufferedImage) im;
			    Graphics grafis = (Graphics) displayCamera.getGraphics();
                            try{
                                grafis.drawImage(buffImage, 620, 10, -displayCamera.getWidth(), displayCamera.getHeight() -10, 0, 0, 
                                        buffImage.getWidth(), buffImage.getHeight(), null);
                            }catch(NullPointerException npe){
                                System.out.println("");
                            }
			    while (runnable == false)
                            {
                                this.wait();
                            }
			 }
			 catch(IOException | InterruptedException ex)
                         {
			    System.out.println("");
                         }
                }
            }
        }
     }
   }
//   
//    
    public FaceRecognition() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("facedetecticon3.png")).getImage());
        setSize(1080, 720);
        setLocationRelativeTo(null);
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filePilihan = new javax.swing.JFileChooser();
        menuPanel = new javax.swing.JPanel();
        aboutThisApplicationButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        takeFileButton = new javax.swing.JButton();
        takePictureButton = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        parentPanel = new javax.swing.JPanel();
        pilihFilePanel = new javax.swing.JPanel();
        titleFoto = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        uselessPanel = new javax.swing.JPanel();
        imagePath = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        coutFaceButton = new javax.swing.JButton();
        uselessPanel2 = new javax.swing.JPanel();
        imageJLabel = new javax.swing.JLabel();
        ambilFotoPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        displayFotoPanel = new javax.swing.JPanel();
        displayFoto = new javax.swing.JLabel();
        faceCount2Button = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButtonCamera = new javax.swing.JButton();
        displayCamera = new javax.swing.JLabel();
        aboutApplicationPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        myGithub = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jEditorPane2 = new javax.swing.JEditorPane();

        filePilihan.setCurrentDirectory(new java.io.File("E:\\"));

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setTitle("Face Count Detection - by Tri Ilman Almunawarah Fattah");
            setBackground(new java.awt.Color(153, 153, 153));
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            setIconImages(null);

            menuPanel.setBackground(new java.awt.Color(153, 153, 153));
            menuPanel.setLayout(new java.awt.BorderLayout(5, 5));

            aboutThisApplicationButton.setBackground(java.awt.SystemColor.activeCaption);
            aboutThisApplicationButton.setForeground(new java.awt.Color(255, 255, 255));
            aboutThisApplicationButton.setText("About");
            aboutThisApplicationButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, java.awt.Color.lightGray));
            aboutThisApplicationButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            aboutThisApplicationButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    aboutThisApplicationButtonActionPerformed(evt);
                }
            });
            menuPanel.add(aboutThisApplicationButton, java.awt.BorderLayout.PAGE_END);

            jPanel3.setBackground(new java.awt.Color(153, 153, 153));
            jPanel3.setAlignmentX(0.1F);
            jPanel3.setAlignmentY(0.1F);

            takeFileButton.setBackground(java.awt.SystemColor.activeCaption);
            takeFileButton.setForeground(new java.awt.Color(255, 255, 255));
            takeFileButton.setText("Piliih File");
            takeFileButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, java.awt.Color.lightGray));
            takeFileButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            takeFileButton.setEnabled(false);
            takeFileButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    takeFileButtonActionPerformed(evt);
                }
            });

            takePictureButton.setBackground(java.awt.SystemColor.activeCaption);
            takePictureButton.setForeground(new java.awt.Color(255, 255, 255));
            takePictureButton.setText("Take Picture");
            takePictureButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, java.awt.Color.lightGray));
            takePictureButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            takePictureButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    takePictureButtonActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
            jPanel3.setLayout(jPanel3Layout);
            jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(takeFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(takePictureButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                    .addContainerGap())
            );
            jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(takeFileButton)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(takePictureButton)
                    .addContainerGap())
            );

            menuPanel.add(jPanel3, java.awt.BorderLayout.CENTER);

            getContentPane().add(menuPanel, java.awt.BorderLayout.LINE_START);

            mainPanel.setLayout(new java.awt.BorderLayout());

            parentPanel.setLayout(new java.awt.CardLayout());

            pilihFilePanel.setLayout(new java.awt.BorderLayout());

            titleFoto.setBackground(java.awt.Color.black);
            titleFoto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
            titleFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            titleFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/deteksiwajah/imageicon.png"))); // NOI18N
            titleFoto.setText("IMAGE");
            titleFoto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, java.awt.Color.black));
            pilihFilePanel.add(titleFoto, java.awt.BorderLayout.PAGE_START);

            jPanel1.setLayout(new java.awt.GridLayout(1, 4));

            uselessPanel.setBackground(new java.awt.Color(153, 153, 153));
            uselessPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
            jPanel1.add(uselessPanel);

            imagePath.setBackground(new java.awt.Color(51, 51, 51));
            imagePath.setForeground(new java.awt.Color(255, 255, 255));
            imagePath.setText("path");
            imagePath.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
            imagePath.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    imagePathActionPerformed(evt);
                }
            });
            jPanel1.add(imagePath);

            browseButton.setBackground(java.awt.SystemColor.activeCaption);
            browseButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            browseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/deteksiwajah/imagepicture4.pnh.PNG"))); // NOI18N
            browseButton.setText("Browser");
            browseButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, java.awt.Color.lightGray));
            browseButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            browseButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    browseButtonActionPerformed(evt);
                }
            });
            jPanel1.add(browseButton);

            coutFaceButton.setBackground(java.awt.SystemColor.activeCaption);
            coutFaceButton.setText("Count Face");
            coutFaceButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 255, 255), null, java.awt.Color.lightGray));
            coutFaceButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            coutFaceButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    coutFaceButtonActionPerformed(evt);
                }
            });
            jPanel1.add(coutFaceButton);

            uselessPanel2.setBackground(new java.awt.Color(153, 153, 153));
            uselessPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
            jPanel1.add(uselessPanel2);

            pilihFilePanel.add(jPanel1, java.awt.BorderLayout.PAGE_END);

            imageJLabel.setBackground(java.awt.SystemColor.activeCaptionBorder);
            imageJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            imageJLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, java.awt.Color.lightGray, null, java.awt.Color.black));
            pilihFilePanel.add(imageJLabel, java.awt.BorderLayout.CENTER);

            parentPanel.add(pilihFilePanel, "card4");

            ambilFotoPanel.setLayout(new java.awt.BorderLayout());

            jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
            jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/deteksiwajah/webcam.png"))); // NOI18N
            jLabel2.setText("CAMERA");
            jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, java.awt.Color.black));
            ambilFotoPanel.add(jLabel2, java.awt.BorderLayout.PAGE_START);

            jPanel6.setLayout(new java.awt.GridLayout(1, 0));

            displayFotoPanel.setLayout(new java.awt.BorderLayout());

            displayFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            displayFoto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));
            displayFotoPanel.add(displayFoto, java.awt.BorderLayout.CENTER);

            faceCount2Button.setBackground(java.awt.SystemColor.activeCaption);
            faceCount2Button.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
            faceCount2Button.setText("Face Count");
            faceCount2Button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, java.awt.Color.lightGray));
            faceCount2Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            faceCount2Button.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    faceCount2ButtonActionPerformed(evt);
                }
            });
            displayFotoPanel.add(faceCount2Button, java.awt.BorderLayout.PAGE_END);

            jPanel6.add(displayFotoPanel);

            jPanel5.setLayout(new java.awt.BorderLayout());

            jButtonCamera.setBackground(java.awt.SystemColor.activeCaption);
            jButtonCamera.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
            jButtonCamera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/deteksiwajah/cameraku.png"))); // NOI18N
            jButtonCamera.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, java.awt.Color.lightGray));
            jButtonCamera.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            jButtonCamera.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButtonCameraActionPerformed(evt);
                }
            });
            jPanel5.add(jButtonCamera, java.awt.BorderLayout.PAGE_END);

            displayCamera.setBackground(new java.awt.Color(51, 51, 51));
            displayCamera.setForeground(new java.awt.Color(255, 255, 255));
            displayCamera.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));
            jPanel5.add(displayCamera, java.awt.BorderLayout.CENTER);

            jPanel6.add(jPanel5);

            ambilFotoPanel.add(jPanel6, java.awt.BorderLayout.CENTER);

            parentPanel.add(ambilFotoPanel, "card3");

            aboutApplicationPanel.setLayout(new java.awt.BorderLayout());

            jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel1.setText("TENTANG APLIKASI");
            aboutApplicationPanel.add(jLabel1, java.awt.BorderLayout.PAGE_START);

            jPanel2.setLayout(new java.awt.GridLayout(1, 0));

            jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
            jPanel2.add(jPanel7);

            myGithub.setBackground(new java.awt.Color(255, 255, 255));
            myGithub.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            myGithub.setIcon(new javax.swing.ImageIcon(getClass().getResource("/deteksiwajah/github (1).png"))); // NOI18N
            myGithub.setText("Fattah25");
            myGithub.setBorder(null);
            myGithub.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            myGithub.setMargin(new java.awt.Insets(2, 8, 2, 8));
            myGithub.setOpaque(false);
            myGithub.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    myGithubActionPerformed(evt);
                }
            });
            jPanel2.add(myGithub);

            jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
            jPanel2.add(jPanel4);

            aboutApplicationPanel.add(jPanel2, java.awt.BorderLayout.PAGE_END);

            jPanel8.setAlignmentX(0.0F);
            jPanel8.setAlignmentY(0.0F);

            jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            jLabel3.setText("Metode Pembuatan Aplikasi");

            jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            jLabel4.setText("Library yang dipakai");

            jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            jLabel5.setText("Referensi");

            jTextArea2.setColumns(20);
            jTextArea2.setRows(5);
            jTextArea2.setText("Untuk referensi, saya menggunakan banyak referensi mulai dari yoututbe, artike website dan dari website forum seperti stackoverflow\ndan sebagainya. Linknya ada di bawah ini :\n\n- https://1kb.link/5824c (link face recognition)\n- https://1kb.link/85198 (link cara memasukkan file .xml)\n- https://opencv.org/releases/ (link library OpenCV)\n- https://1kb.link/3e685 (link tutorial membuka gambar dari direktory)\n-  https://1kb.link/93c80 (cara menggunakan cardlayout)\n- https://1kb.link/fee7e (link icon)\n\n");
            jScrollPane2.setViewportView(jTextArea2);

            jEditorPane1.setText("Metode pembuatan aplikasi menggunakan tehnik waterfall dilihat dari project aplikasi yang tidak terlalu kompleks. Metode testing yang di-gunakan menggunakan tehnik whitebox testing dan blackbox testing. Koding dilakukan dengan trial and error untuk mendapatkan hasil y-ang memuaskan. menghapus eksepesi dengan try and catch yang memudahkan program dapat berjalan secara optimal (tidak termasuk performanya).");
            jEditorPane1.setDragEnabled(true);
            jEditorPane1.setName(""); // NOI18N
            jEditorPane1.setOpaque(false);
            jScrollPane1.setViewportView(jEditorPane1);

            jEditorPane2.setText("face recognition dan take picture menggunakan library openCV atau javaCV. untuk GUI, take image from directory, dan yang lain menggunakan library java swing dan java awt. Untuk algoritma pengenalan wajahnya, ditambahkan file dengan ekstensi .xml dengan nama frontal face sehingga wajah yang tidak presisi masih dapat dikenali. ");
            jScrollPane5.setViewportView(jEditorPane2);

            javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
            jPanel8.setLayout(jPanel8Layout);
            jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(jScrollPane1))
                            .addContainerGap())
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jScrollPane2)))
            );
            jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel5)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
            );

            aboutApplicationPanel.add(jPanel8, java.awt.BorderLayout.CENTER);

            parentPanel.add(aboutApplicationPanel, "card2");

            mainPanel.add(parentPanel, java.awt.BorderLayout.CENTER);

            getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

            setSize(new java.awt.Dimension(818, 539));
            setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents
      
     
    private void takeFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takeFileButtonActionPerformed
   
        parentPanel.removeAll();
        parentPanel.add(pilihFilePanel);
        parentPanel.repaint();
        parentPanel.revalidate();
        
        
        takeFileButton.isDefaultButton();
            myThread.runnable = false;
            takeFileButton.setEnabled(false);   
            takePictureButton.setEnabled(true);
            aboutThisApplicationButton.setEnabled(true);
            
            webSource.release(); 
    }//GEN-LAST:event_takeFileButtonActionPerformed

    private void takePictureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takePictureButtonActionPerformed
        parentPanel.removeAll();
        parentPanel.add(ambilFotoPanel);
        parentPanel.repaint();
        parentPanel.revalidate();
        
        webSource =new VideoCapture(0, CAP_DSHOW);
        myThread = new DaemonThread();
            Thread t = new Thread(myThread);
            t.setDaemon(true);
            myThread.runnable = true;
            t.start();
            takePictureButton.setEnabled(false);  //start button
            displayFoto.setIcon(null);
            takeFileButton.setEnabled(true);  // stop button
            aboutThisApplicationButton.setEnabled(true);
            
    }//GEN-LAST:event_takePictureButtonActionPerformed

    private void aboutThisApplicationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutThisApplicationButtonActionPerformed
        parentPanel.removeAll();
        parentPanel.add(aboutApplicationPanel);
        parentPanel.repaint();
        parentPanel.revalidate(); 
        
        try{
            myThread.runnable = false;
            aboutThisApplicationButton.setEnabled(false);   
            takePictureButton.setEnabled(true);
            takeFileButton.setEnabled(true);
            webSource.release();
        }catch(NullPointerException npe){
            System.out.println("");
        }
          
            
           
    }//GEN-LAST:event_aboutThisApplicationButtonActionPerformed

    private void imagePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imagePathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imagePathActionPerformed

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        JFileChooser browseFile = new JFileChooser("E:\\");
        //filter ekstensi file
        FileNameExtensionFilter fneFilter = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
        browseFile.addChoosableFileFilter(fneFilter);
        int showOpenDialog = browseFile.showOpenDialog(null);
        if (showOpenDialog == JFileChooser.APPROVE_OPTION){
            File fileTerpilih = browseFile.getSelectedFile();
            String pathImageTerpilih = fileTerpilih.getAbsolutePath();
            imagePath.setText(pathImageTerpilih);
            
            ImageIcon IIcon = new ImageIcon(pathImageTerpilih);
            Image img = IIcon.getImage();
            Image newing = img.getScaledInstance(imageJLabel.getWidth(), imageJLabel.getHeight(),  Image.SCALE_SMOOTH);
            IIcon = new ImageIcon(newing);
            imageJLabel.setIcon(IIcon);
        }
        
    }//GEN-LAST:event_browseButtonActionPerformed

    private void jButtonCameraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCameraActionPerformed

        
            int kembalikanNilai = filePilihan.showSaveDialog(this);
            if (kembalikanNilai == JFileChooser.APPROVE_OPTION) {
            File file = filePilihan.getSelectedFile();
            Imgcodecs.imwrite(file.getPath(), bingkai);
            imagePath.setText(file.getAbsolutePath());
            
            ImageIcon Icam = new ImageIcon(file.getAbsolutePath());
            Image img = Icam.getImage();
            Image newing = img.getScaledInstance(displayFoto.getWidth(), 480,  Image.SCALE_SMOOTH);
            Icam = new ImageIcon(newing);
            displayFoto.setIcon(Icam);
        } else {
            System.out.println("");
        }
    }//GEN-LAST:event_jButtonCameraActionPerformed

    private void coutFaceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coutFaceButtonActionPerformed
        // TODO add your handling code here:
        String detect = imagePath.getText();
        FaceDetection fc = new FaceDetection(detect);
        System.out.println(fc);
    }//GEN-LAST:event_coutFaceButtonActionPerformed

    private void faceCount2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_faceCount2ButtonActionPerformed
        // TODO add your handling code here:
        String detect = imagePath.getText();
        FaceDetection fc = new FaceDetection(detect);
        System.out.println(fc);
    }//GEN-LAST:event_faceCount2ButtonActionPerformed

    private void myGithubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myGithubActionPerformed
        // TODO add your handling code here:
        Desktop akungithub = Desktop.getDesktop();
        try {
            akungithub.browse(new URI("https://github.com/Fattah25"));
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(FaceRecognition.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_myGithubActionPerformed

    
     
    
    
  
    public static void main(String args[]) {
        
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
      
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FaceRecognition().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aboutApplicationPanel;
    private javax.swing.JButton aboutThisApplicationButton;
    private javax.swing.JPanel ambilFotoPanel;
    private javax.swing.JButton browseButton;
    private javax.swing.JButton coutFaceButton;
    private javax.swing.JLabel displayCamera;
    private javax.swing.JLabel displayFoto;
    private javax.swing.JPanel displayFotoPanel;
    private javax.swing.JButton faceCount2Button;
    private javax.swing.JFileChooser filePilihan;
    private javax.swing.JLabel imageJLabel;
    private javax.swing.JTextField imagePath;
    private javax.swing.JButton jButtonCamera;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JEditorPane jEditorPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JButton myGithub;
    private javax.swing.JPanel parentPanel;
    private javax.swing.JPanel pilihFilePanel;
    private javax.swing.JButton takeFileButton;
    private javax.swing.JButton takePictureButton;
    private javax.swing.JLabel titleFoto;
    private javax.swing.JPanel uselessPanel;
    private javax.swing.JPanel uselessPanel2;
    // End of variables declaration//GEN-END:variables
}
