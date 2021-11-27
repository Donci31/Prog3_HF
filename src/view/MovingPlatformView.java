package view;

import model.platforms.Platform;

import javax.swing.*;
import java.awt.*;

public class MovingPlatformView extends PlatformView {
    public MovingPlatformView(Platform platform) {
        super(platform);

        image = new ImageIcon(new ImageIcon("./resources/MovingPlatform.png").getImage().getScaledInstance(source.getWidth(), source.getHeight(), Image.SCALE_SMOOTH)).getImage();
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, source.getX(), source.getY(), null);
    }
}