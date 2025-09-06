package Display;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BalloonGameHardmode extends JPanel implements ActionListener {
	//ball red 1
    private int xRed = 250;
    private int yRed = 750;
    //ball red 2
    private int xRed2 = 550;
    private int yRed2 = 750;
    //ball red 3
    private int xRed3 = 150;
    private int yRed3 = 750;
    //ball red 4
    private int xRed4 = 350;
    private int yRed4 = 750;
    //ball red 5
    private int xRed5 = 650;
    private int yRed5 = 750;
    //ball blue 1
    private int xBlue = 400;
    private int yBlue = 750;
    //ball blue 2
    private int xBlue2 = 200;
    private int yBlue2 = 750;
    //ball size
    private int radius = 30;
    private int radiusblue = 45;
    //system
    private int score = 0;
    private int lives = 1;
    private long lastUpdateTime = System.currentTimeMillis();
    private double speed = 150;
    private boolean gameOver = false;

    public BalloonGameHardmode() {
        Timer timer = new Timer(10, this);
        timer.start();

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();
                if (!gameOver && mouseX >= xRed && mouseX <= xRed + radius && mouseY >= yRed && mouseY <= yRed + radius) {
                    xRed = (int) (Math.random() * (getWidth() - radius));
                    yRed = getHeight() - radius; 
                    score++;
                } else if (!gameOver && mouseX >= xRed2 && mouseX <= xRed2 + radius && mouseY >= yRed2 && mouseY <= yRed2 + radius) {
                    xRed2 = (int) (Math.random() * (getWidth() - radius));
                    yRed2 = getHeight() - radius; 
                    score++;
                } else if (!gameOver && mouseX >= xRed3 && mouseX <= xRed3 + radius && mouseY >= yRed3 && mouseY <= yRed3 + radius) {
                    xRed3 = (int) (Math.random() * (getWidth() - radius));
                    yRed3 = getHeight() - radius;
                    score++;
                } else if (!gameOver && mouseX >= xRed4 && mouseX <= xRed4 + radius && mouseY >= yRed4 && mouseY <= yRed4 + radius) {
                    xRed4 = (int) (Math.random() * (getWidth() - radius));
                    yRed4 = getHeight() - radius;
                    score++;
                } else if (!gameOver && mouseX >= xRed5 && mouseX <= xRed5 + radius && mouseY >= yRed5 && mouseY <= yRed5 + radius) {
                    xRed5 = (int) (Math.random() * (getWidth() - radius));
                    yRed5 = getHeight() - radius;
                    score++;
                } else if (!gameOver && mouseX >= xBlue && mouseX <= xBlue + radiusblue && mouseY >= yBlue && mouseY <= yBlue + radiusblue) {
                    xBlue = (int) (Math.random() * (getWidth() - radiusblue));
                    yBlue = getHeight() - radiusblue;
                    lives--;
                    if (lives <= 0) {
                        gameOver = true;
                    }
                } else if (!gameOver && mouseX >= xBlue2 && mouseX <= xBlue2 + radiusblue && mouseY >= yBlue2 && mouseY <= yBlue2 + radiusblue) {
                    xBlue2 = (int) (Math.random() * (getWidth() - radiusblue));
                    yBlue2 = getHeight() - radiusblue; // set y to the bottom of the frame
                    lives--;
                    if (lives <= 0) {
                        gameOver = true;
                    }
                }
                repaint();
            }
        });

        // Press "R" key to restart game
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'r') {
                    restart();
                }
            }
        });
        setFocusable(true); // Allow JPanel to receive key events
    }
    
    protected void restart() {
        xRed = (int) (Math.random() * (getWidth() - radius));
        yRed = getHeight() - radius; // set y to the bottom of the frame
        xRed2 = (int) (Math.random() * (getWidth() - radius));
        yRed2 = getHeight() - radius;
        xRed3 = (int) (Math.random() * (getWidth() - radius));
        yRed3 = getHeight() - radius;
        xRed4 = (int) (Math.random() * (getWidth() - radius));
        yRed4 = getHeight() - radius;
        xRed5 = (int) (Math.random() * (getWidth() - radius));
        yRed5 = getHeight() - radius;
        xBlue = (int) (Math.random() * (getWidth() - radiusblue));
        yBlue = getHeight() - radiusblue;
        xBlue2 = (int) (Math.random() * (getWidth() - radiusblue));
        yBlue2 = getHeight() - radiusblue; // set y to the bottom of the frame
        score = 0;
        lives = 1;
        speed = 150;
        lastUpdateTime = System.currentTimeMillis();
        gameOver = false;
        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        long currentTime = System.currentTimeMillis();
        double elapsedTime = (currentTime - lastUpdateTime) / 1000.0; //milli is 10^-3
        if (!gameOver) {
            yRed -= (int) (speed * elapsedTime);
            yRed2 -= (int) (speed * elapsedTime);
            yRed3 -= (int) (speed * elapsedTime);
            yRed4 -= (int) (speed * elapsedTime);
            yRed5 -= (int) (speed * elapsedTime);
            yBlue -= (int) (speed * elapsedTime);
            yBlue2 -= (int) (speed * elapsedTime);
            speed += 0.1;
            lastUpdateTime = currentTime;
            if (yRed <= 0) { // ball reached the top of the frame
                lives--;
                if (lives <= 0) {
                    gameOver = true;
                } else {
                    xRed = (int) (Math.random() * (getWidth() - radius));;
                    yRed = getHeight() - radius; // Spawn at the bottom of the frame 
                }
            }
            if (yRed2 <= 0) {
                lives--;
                if (lives <= 0) {
                    gameOver = true;
                } else {
                    xRed2 = (int) (Math.random() * (getWidth() - radius));;
                    yRed2 = getHeight() - radius;
                }
            }
            if (yRed3 <= 0) { 
                lives--;
                if (lives <= 0) {
                    gameOver = true;
                } else {
                    xRed2 = (int) (Math.random() * (getWidth() - radius));;
                    yRed2 = getHeight() - radius;
                }
            }
            if (yRed4 <= 0) {
                lives--;
                if (lives <= 0) {
                    gameOver = true;
                } else {
                    xRed2 = (int) (Math.random() * (getWidth() - radius));;
                    yRed2 = getHeight() - radius;
                }
            }
            if (yRed5 <= 0) { 
                lives--;
                if (lives <= 0) {
                    gameOver = true;
                } else {
                    xRed2 = (int) (Math.random() * (getWidth() - radius));;
                    yRed2 = getHeight() - radius;
                }
            }
            if (yBlue <= 0) {
            	if (lives <= 0) {
                    gameOver = true;
                } else {
                    xBlue = (int) (Math.random() * (getWidth() - radiusblue));
                    yBlue = getHeight() - radiusblue; 
                }
            }
            if (yBlue2 <= 0) {
            	if (lives <= 0) {
                    gameOver = true;
                } else {
                    xBlue2 = (int) (Math.random() * (getWidth() - radiusblue));
                    yBlue2 = getHeight() - radiusblue;
                }
            }
            repaint();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(xRed, yRed, radius, radius);
        g.setColor(Color.RED);
        g.fillOval(xRed2, yRed2, radius, radius);
        g.setColor(Color.RED);
        g.fillOval(xRed3, yRed3, radius, radius);
        g.setColor(Color.RED);
        g.fillOval(xRed4, yRed4, radius, radius);
        g.setColor(Color.RED);
        g.fillOval(xRed5, yRed5, radius, radius);
        g.setColor(Color.BLUE);
        g.fillOval(xBlue, yBlue, radiusblue, radiusblue);
        g.setColor(Color.BLUE);
        g.fillOval(xBlue2, yBlue2, radiusblue, radiusblue);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, 10, 20);
        g.drawString("Lives: " + lives, 700, 20);
        if (gameOver) {
            g.setFont(new Font("Arial", Font.BOLD, 50));
            String gameOverMessage = "Game Over! Your score is " + score;
            g.drawString(gameOverMessage, (getWidth() - g.getFontMetrics().stringWidth(gameOverMessage)) / 2, getHeight() / 2);
        }
    }
}
