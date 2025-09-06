package Main;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import Display.BalloonGame;
import Display.BalloonGameHardmode;
//using netbeans to build gui
public class Mainmenu extends JFrame{

	private JButton jButton2;
    private JButton jButton3;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private Label label1;
    public Mainmenu() {
        initComponents();
    }                        
    private void initComponents() {
    
        jPanel1 = new JPanel();
        jPanel3 = new JPanel();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jPanel2 = new JPanel();
        label1 = new Label();
        this.setTitle("BalloonShootingGame");
        this.setSize(800,800);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(32, 34, 37));

        jPanel3.setBackground(new Color(64, 68, 75));
        jPanel3.setLayout(new GridLayout(2, 1, 0, 10));

        jButton2.setText("Play");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton2ActionPerformed(e);
            }
        });
        jPanel3.add(jButton2);

        jButton3.setText("Hardmode");
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton3ActionPerformed(e);
            }
        });
        jPanel3.add(jButton3);

        jPanel2.setBackground(new Color(22, 38, 62));

        label1.setAlignment(Label.CENTER);
        label1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        label1.setFont(new Font("Dialog", 0, 24)); // NOI18N
        label1.setForeground(new Color(255, 255, 255));
        label1.setText("BalloonShootingGame");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addContainerGap())
        );

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(278, 278, 278)
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(279, Short.MAX_VALUE))
            .addComponent(jPanel2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(234, 234, 234)
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(335, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, BorderLayout.CENTER);

        pack();
    }// </editor-fold>                        

    private void jButton2ActionPerformed(ActionEvent e) {                                         
    	GameDisplay gd = new GameDisplay();
        gd.show();
        
        dispose();
    }                                        

    private void jButton3ActionPerformed(ActionEvent e) {                                         
    	GameDisplayHardmode gdh = new GameDisplayHardmode();
    	gdh.show();
        
        dispose();
    }                                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
    	new Mainmenu();
    }

                       
}

  
 

