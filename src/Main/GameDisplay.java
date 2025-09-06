package Main;

import javax.swing.JFrame;

import Display.BalloonGame;

public class GameDisplay extends JFrame{
	public GameDisplay(){
		super("BalloonShootingGame");
        BalloonGame game = new BalloonGame();
        this.add(game);
        this.setSize(800, 800);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new GameDisplay();

	}

}
