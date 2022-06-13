
package deteksiwajah;

import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;


class FaceDetection {

     FaceDetection(String pathImageTerpilih) {
    File configFile = new File("C:\\openCVfile\\opencv\\sources\\data\\haarcascades\\haarcascade_frontalface_alt.xml");
    String getPathku = configFile.getAbsolutePath(); // Instantiating the CascadeClassifier
    Mat src = Imgcodecs.imread(pathImageTerpilih);
      
      CascadeClassifier klasifikasi = new CascadeClassifier(getPathku);

      // Detecting the face in the snap
      MatOfRect faceDetections = new MatOfRect();
      klasifikasi.detectMultiScale(src, faceDetections);
      String det = (String.format("Mendeteksi %s wajah manusia", 
         faceDetections.toArray().length));
      ImageIcon faceIcon = new ImageIcon("facedetecticon3.png");
      JOptionPane.showMessageDialog(null, det, "Face Count Dialog by Tri Ilman", JOptionPane.PLAIN_MESSAGE, faceIcon);
      
    }
}
