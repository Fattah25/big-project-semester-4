import algoritma.ImageDetection;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.opencv.videoio.Videoio.CAP_DSHOW;

public class CountFace extends JFrame {

    private JPanel mainPanel;
    private JButton pilihFileButton;
    private JButton aboutButton;
    private JPanel displayPanel;
    private JPanel pilihFilePanel;
    private JPanel aboutPanel;
    private JButton countButton;
    private JButton browseButton;
    private JTextField pathTextField;
    private JLabel imageDisplayJLabel;
    private JPanel subMenuPanel;
    private JButton realTimeButton;
    private JPanel webCamPanel;
    private JPanel subWebCamPanel;
    private JLabel numberOfFace;
    private JLabel displayWebCam;
    private JCheckBox pauseCheckBox;
    private JEditorPane aboutEditorPane;
    private JScrollPane scrollAboutPane;
    private JButton pauseButton;
    private JButton startButton;
    private JPanel displayWebCamPanel;


    private Desktop desk;
    //----------


    File imagePathJOP = new File("E:\\doodles\\facedetecticon3.png");
    String ipJOP = imagePathJOP.getAbsolutePath();
    ImageIcon faceIcon;

    private DmnThread myThread = null;
    private VideoCapture webSource = null;
    private final Mat frame = new Mat();
    private MatOfByte mem = new MatOfByte();
    private File configFile = new File("C:\\opencv\\sources\\data\\haarcascades_cuda\\haarcascade_frontalface_alt.xml");
    private String getPathCamku = configFile.getAbsolutePath(); // Instantiating the CascadeClassifier
    private CascadeClassifier faceDetector = new CascadeClassifier(getPathCamku);
    private final MatOfRect faceDetections = new MatOfRect();



    class DmnThread implements Runnable {
        protected volatile boolean runnable = false;

        @Override
        public void run() {
            synchronized (this) {
                while (runnable) {
                    if (webSource.grab()) {
                        try {
                            webSource.retrieve(frame);
                            Graphics graph = displayWebCam.getGraphics();
                            faceDetector.detectMultiScale(frame, faceDetections);
                            try {
                                Imgcodecs.imencode(".bmp", frame, mem);
                                BufferedImage im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));


                            String det = (String.format("%s detected",
                            faceDetections.toArray().length));
                            if(faceDetections.toArray().length != 0) {
                                numberOfFace.setForeground(Color.BLUE);
                                numberOfFace.setText(det);
                            }else{
                                numberOfFace.setForeground(Color.RED);
                                numberOfFace.setText("No Face Detected");
                            }

                            if (graph.drawImage(im, 0, 0, displayWebCam.getWidth(), displayWebCam.getHeight() , 0, 0, im.getWidth(), im.getHeight(), null)) {

                                if (!runnable) {
                                    System.out.println();
                                    this.wait();
                                }
                            }}catch(NullPointerException npe){
                                System.out.println();
                            }

                        } catch (Exception e) {
                            System.out.println("Error!!!");
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }



    public CountFace(String title) {

        super(title); //method memanggil JFrame class
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();


        pilihFileButton.addActionListener(e -> {
            displayPanel.removeAll();
            displayPanel.add(pilihFilePanel);
            displayPanel.repaint();
            displayPanel.revalidate();

            pauseCheckBox.setSelected(false);
            pilihFileButton.setEnabled(false);
            realTimeButton.setEnabled(true);
            aboutButton.setEnabled(true);

            try {
                myThread.runnable = false;
                webSource.release();
            }catch(NullPointerException npe){
                System.out.println();
            }

        });

        realTimeButton.addActionListener(e -> {
            displayPanel.removeAll();
            displayPanel.add(webCamPanel);
            displayPanel.repaint();
            displayPanel.revalidate();

            webSource = new VideoCapture(0, CAP_DSHOW);
            myThread = new DmnThread();
            Thread thr = new Thread(myThread);
            thr.setDaemon(true);
            myThread.runnable = true;
            thr.start();

            pilihFileButton.setEnabled(true);
            realTimeButton.setEnabled(false);
            aboutButton.setEnabled(true);
            countButton.setEnabled(false);
            imageDisplayJLabel.setIcon(new ImageIcon(ipJOP));
        });


        aboutButton.addActionListener(e -> {
            displayPanel.removeAll();
            displayPanel.add(aboutPanel);
            displayPanel.repaint();
            displayPanel.revalidate();

            aboutButton.setEnabled(false);
            pauseCheckBox.setSelected(false);
            pilihFileButton.setEnabled(true);
            realTimeButton.setEnabled(true);
            try {
                myThread.runnable = false;
                webSource.release();
            }catch(NullPointerException npe){
                System.out.println();
            }

        });

        browseButton.addActionListener(e -> {
            JFileChooser browseFile = new JFileChooser("E:\\");
            //filter ekstensi file
            FileNameExtensionFilter fneFilter = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
            browseFile.addChoosableFileFilter(fneFilter);
            int showOpenDialog = browseFile.showOpenDialog(null);
            if (showOpenDialog == JFileChooser.APPROVE_OPTION){
                File fileTerpilih = browseFile.getSelectedFile();
                String pathImageTerpilih = fileTerpilih.getAbsolutePath();
                pathTextField.setText(pathImageTerpilih);

                //Display image dalam jlabel
                    ImageIcon ImgIcon = new ImageIcon(pathImageTerpilih);
                    Image img = ImgIcon.getImage();
                    Image newing = img.getScaledInstance(imageDisplayJLabel.getWidth(), imageDisplayJLabel.getHeight(),  Image.SCALE_SMOOTH);
                    ImgIcon = new ImageIcon(newing);
                    imageDisplayJLabel.setIcon(ImgIcon);

                imageDisplayJLabel.setText(null);
                countButton.setEnabled(true);

            }

        });

        //Count Button
        countButton.addActionListener(e -> {

            countButton.setEnabled(true);
            String filePath = pathTextField.getText();
            new ImageDetection(filePath);


        });


        pauseCheckBox.addItemListener(e -> {
            if(!pauseCheckBox.isSelected()){
                webSource = new VideoCapture(0, CAP_DSHOW);
                myThread = new DmnThread();
                Thread thr = new Thread(myThread);
                thr.setDaemon(true);
                myThread.runnable = true;
                thr.start();
            }else{
                myThread.runnable = false;
                webSource.release();
            }

        });

        aboutEditorPane.setEditorKit(JEditorPane.createEditorKitForContentType("text/html"));
        aboutEditorPane.setEnabled(true);
        //aboutButton content
        String myGihub = """
                <h1 align="center">TENTANG APLIKASI</h1>
                <h2>Metode Pembuatan Aplikasi </h2>
                Aplikasi <b>penghitung wajah</b> ini didesain dan dibuat menggunakan metode <i>waterfall</i>.
                <h2>Metode deteksi wajah</h2>
                Aplikasi <b>penghitung wajah</b> ini menerapkan fitur <i>Face Recognition</i> untuk mengenali objek wajah yang ada pada gambar ataupun video/rekaman <i>real time</i>. <i>Face Recognition</i> yang digunakan pada aplikasi ini menggunakan algoritma <font color="red"><i>Haar Cascade</i></font> dan <font color="red"><i>LBP Cascade</i></font> yang merupakan model <i>machine larning</i> yang sering digunakan dalam pembuatan aplikasi <i>object detection</i>. <i>LBP Cascade</i> memiliki kecepatan deteksi yang lebih cepat dari <i>Haar Cascade</i> namun tingkat akurasinya lebih rendah dari <i>Haar Cascade</i>. Penerapan <i>Haar Cascade</i> pada aplikasi adalah pada <i>real time webcam</i> sedangkan <i>LBP Cascade</i> digunakan untuk mendeteksi wajah pada file <i>image</i>.
                <h2><i>Library</i> yang digunakan</h2>
                <ul>
                    <li>GUI aplikasi menggunakan <b>Java Swing</b> dan <b>Java AWT</b></li>
                    <li><b>Webcam</b> dan <b><i>Face Detection</i></b> menggunakan <i>library</i> <a href="https://opencv.org/releases/">OpenCV</a></li>
                </ul>

                <h2>Layout yang digunakan</h2>
                <ul>
                    <li><b>main panel</b> menggunakan <i>border layout</i></li>
                    <li><b>Menu panel</b> menggunakan <i>flow layout</i></li>
                    <li>Transisi antar panel menggunakan<i>card layout</i></li>
                    <li>Beberapa panel menggunakan <i>Grid Layout</i> versi <a href="https://www.jetbrains.com/idea/download/#section=windows">Intellij IDEA</a></li>
                </ul>

                <h2>Referensi dan Aset</h2>
                <ul>
                    <li><a href="https://github.com/tahaemara/real-time-face-detection-using-opencv-with-java/blob/master/src/gui/FaceDetection.java">face detection real time</a>. Digunakan untuk mendeteksi wajah secara <i>real time</i></li>
                    <li><a href="https://stackoverflow.com/">Stackoverflow</a> banyak digunakan sebagai referensi untuk mengatasi bug, <i>exception</i>, sampai cara menambahkan HTML ke <i>Java Swing</i></li>
                    <li>Referensi kode untuk menambahkan file <i>image</i> menggunakan <i>Java Swing</i>. <a href="https://youtu.be/p4HV2zDcANI">Lihat di sini</a></li>
                   \s
                </ul>

                <h3>Sosial media saya :</h3>
                <div align="center"> <a href="https://github.com/Fattah25"><b>Github: Fattah25</b></a> || <a href="https://www.producthunt.com/@fattah25"><b>Producthunt: @Fattah25</b></a></div>""";
        aboutEditorPane.setText(myGihub);

        aboutEditorPane.addHyperlinkListener(e -> {
            if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED){
                desk = Desktop.getDesktop();
                try {
                    desk.browse(e.getURL().toURI());
                } catch (IOException | URISyntaxException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });

    }


    //main method ---------------
    public static void main(String[] args){

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        JFrame frame = new CountFace("Penghitung Wajah by Tri Ilman A. Fattah"); //membuat title frame

        frame.setSize(1080, 720);
        frame.setResizable(true);

        frame.setVisible(true); // menampilkan frame
        frame.setLocationRelativeTo(null);


        //icon
        File imgIconPath = new File("E:\\doodles\\facedetecticon3.png");
        String imgIP = imgIconPath.getAbsolutePath();
        ImageIcon appIcon = new ImageIcon(imgIP);
        frame.setIconImage(appIcon.getImage());


    }

}
