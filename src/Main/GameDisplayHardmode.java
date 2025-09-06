package Main;

import javax.swing.JFrame;

import Display.BalloonGameHardmode;

public class GameDisplayHardmode extends JFrame{
	public GameDisplayHardmode(){
		super("BalloonShootingGame Hardmode");
        BalloonGameHardmode game = new BalloonGameHardmode();
        this.add(game);
        this.setSize(800, 800);
        this.setResizable(false); //can't maximize
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new GameDisplay();

	}

}

