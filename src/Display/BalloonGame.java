package Display;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BalloonGame extends JPanel implements ActionListener {
    private int xRed = 250;
    private int yRed = 750;
    //ball red 2
    private int xRed2 = 550;
    private int yRed2 = 750;
    //ball red 3
    private int xRed3 = 150;
    private int yRed3 = 750;
    //ball blue
    private int xBlue = 400;
    private int yBlue = 750;
    private int radius = 50;
    private int score = 0;
    private int lives = 3;
    private long lastUpdateTime = System.currentTimeMillis();
    private double speed = 100;
    private boolean gameOver = false;

    public BalloonGame() {
        Timer timer = new Timer(10, this);
        timer.start();

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
            	int mouseX = e.getX();
                int mouseY = e.getY();
                if (!gameOver && mouseX >= xRed && mouseX <= xRed + radius && mouseY >= yRed && mouseY <= yRed + radius) {
                    xRed = (int) (Math.random() * (getWidth() - radius));
                    yRed = getHeight() - radius; // set y to the bottom of the frame
                    score++;
                } else if (!gameOver && mouseX >= xRed2 && mouseX <= xRed2 + radius && mouseY >= yRed2 && mouseY <= yRed2 + radius) {
                    xRed2 = (int) (Math.random() * (getWidth() - radius));
                    yRed2 = getHeight() - radius; 
                    score++;
                } else if (!gameOver && mouseX >= xRed3 && mouseX <= xRed3 + radius && mouseY >= yRed3 && mouseY <= yRed3 + radius) {
                    xRed3 = (int) (Math.random() * (getWidth() - radius));
                    yRed3 = getHeight() - radius;
                    score++;
                } else if (!gameOver && mouseX >= xBlue && mouseX <= xBlue + radius && mouseY >= yBlue && mouseY <= yBlue + radius) {
                    xBlue = (int) (Math.random() * (getWidth() - radius));
                    yBlue = getHeight() - radius; 
                    lives--;
                    if (lives <= 0) {
                        gameOver = true;
                    }
                }
                repaint();
            }
        });

        // press 'r' to restart the game
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'r') {
                    restart();
                }
            }
        });
        setFocusable(true); // JPanel receive key events
    }
    
    protected void restart() {
        xRed = (int) (Math.random() * (getWidth() - radius));
        yRed = getHeight() - radius; // set y to the bottom of the frame
        xRed2 = (int) (Math.random() * (getWidth() - radius));
        yRed2 = getHeight() - radius;
        xRed3 = (int) (Math.random() * (getWidth() - radius));
        yRed3 = getHeight() - radius;
        xBlue = (int) (Math.random() * (getWidth() - radius));
        yBlue = getHeight() - radius;
        score = 0;
        lives = 3;
        speed = 100;
        lastUpdateTime = System.currentTimeMillis();
        gameOver = false;
        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        long currentTime = System.currentTimeMillis();
        double elapsedTime = (currentTime - lastUpdateTime) / 1000.0;
        if (!gameOver) {
            yRed -= (int) (speed * elapsedTime); //time that make the ball float
            yRed2 -= (int) (speed * elapsedTime);
            yRed3 -= (int) (speed * elapsedTime);
            yBlue -= (int) (speed * elapsedTime);
            speed += 0.1;
            lastUpdateTime = currentTime;
            if (yRed <= 0) { // when ball reached the top of the frame, lives will be decrease.
                lives--;
                if (lives <= 0) {
                    gameOver = true;
                } else {
                    xRed = (int) (Math.random() * (getWidth() - radius));;
                    yRed = getHeight() - radius; // to make the ball spawn at the bottom of frame
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
            if (yBlue <= 0) {
            	if (lives <= 0) {
                    gameOver = true;
                } else {
                    xBlue = (int) (Math.random() * (getWidth() - radius));
                    yBlue = getHeight() - radius; 
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
        g.setColor(Color.BLUE);
        g.fillOval(xBlue, yBlue, radius, radius);
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
