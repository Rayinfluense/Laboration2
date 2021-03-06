import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.List;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    List<Point> imagePoints = new ArrayList<>();
    List<String> imageFilePaths = new ArrayList<>();
    List<BufferedImage> bufferedImages = new ArrayList<>();

    void setImagePosition(int x, int y, String imageFilePath){
        Point point = new Point(x,y);
        imagePoints.add(point);
        imageFilePaths.add(imageFilePath);

        try {
            //bufferedImages.add(ImageIO.read(DrawPanel.class.getResourceAsStream(imageFilePath)));
            bufferedImages.add(ImageIO.read(new File(imageFilePath)));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i = 0 ; i < imagePoints.size() ; i++){
            g.drawImage(bufferedImages.get(i), (int)Math.round(imagePoints.get(i).getX())+100*i, (int)Math.round(imagePoints.get(i).getY()), null);
        }
        imagePoints.clear();
        imageFilePaths.clear();
        bufferedImages.clear();

        // see javadoc for more info on the parameters
    }
}
