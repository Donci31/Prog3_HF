package controller;

import model.Bullet;
import model.Fps;
import view.*;

import java.util.ArrayList;

public class BulletHandler {
    CollisionDetector detector;
    ArrayList<DrawAble> drawAbles;
    ArrayList<Fps> movables;

    public BulletHandler(CollisionDetector detector, ArrayList<DrawAble> drawAbles, ArrayList<Fps> movables) {
        this.detector = detector;
        this.drawAbles = drawAbles;
        this.movables = movables;
    }

    public void newBullet(int x, int y, int vx, int vy) {
        Bullet b;

        b = new Bullet(x, y, vx, vy);
        BulletView bView = new BulletView(b);
        drawAbles.add(bView);
        b.setView(bView);

        detector.addBullet(b);
        movables.add(b);
    }

    public void checkBullets() {
        ArrayList<Bullet> bullets = detector.getBullets();

        for (int i = 0; i < bullets.size(); i++) {
            Bullet b = bullets.get(i);
            if (b.getY() > 700 || b.hasHit()) {
                bullets.remove(b);
                drawAbles.remove(b.getView());
                movables.remove(b);
            }
        }
    }
}
