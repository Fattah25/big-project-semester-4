package algoritma;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;

import javax.swing.*;
import java.io.File;

public class ImageDetection extends JFrame {

    public ImageDetection(String filePath) {


        File configFile = new File("C:\\openCVfile\\opencv\\sources\\data\\lbpcascades\\lbpcascade_frontalface_improved.xml");
        String getPathku = configFile.getAbsolutePath();

        Mat src = Imgcodecs.imread(filePath);

        CascadeClassifier klasifikasi = new CascadeClassifier(getPathku);


        // Detecting the face in the snap

            MatOfRect faceDetections = new MatOfRect();
            klasifikasi.detectMultiScale(src, faceDetections);

            String det = (String.format("Mendeteksi %s wajah manusia",
                    faceDetections.toArray().length));

            //image absolute path and JOptionPane
            File imagePathJOP = new File("E:\\doodles\\facedetecticon3.png");
            String ipJOP = imagePathJOP.getAbsolutePath();
            ImageIcon faceIcon = new ImageIcon(ipJOP);
            JOptionPane.showMessageDialog(null, det, "Face Count Dialog by Tri Ilman", JOptionPane.PLAIN_MESSAGE, faceIcon);

    }
}
