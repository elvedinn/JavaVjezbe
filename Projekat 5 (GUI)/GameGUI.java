import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

public class GameGUI extends JFrame {

    private JTextField tfName, tfHealth, tfX, tfY;
    private JComboBox<String> colliderBox;
    private JButton btnStart;
    private JTextArea output;

    public GameGUI() {
        setTitle("Game Setup");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10,10));

        
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));

        inputPanel.add(new JLabel("Ime"));
        tfName = new JTextField();
        inputPanel.add(tfName);

        inputPanel.add(new JLabel("Health (0–100)"));
        tfHealth = new JTextField();
        inputPanel.add(tfHealth);

        inputPanel.add(new JLabel("X pozicija"));
        tfX = new JTextField();
        inputPanel.add(tfX);

        inputPanel.add(new JLabel("Y pozicija"));
        tfY = new JTextField();
        inputPanel.add(tfY);

        inputPanel.add(new JLabel("Kolajder"));
        colliderBox = new JComboBox<>(new String[]{"Rectangle", "Circle"});
        inputPanel.add(colliderBox);

        add(inputPanel, BorderLayout.NORTH);

        
        output = new JTextArea();
        output.setEditable(false);
        output.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(output);
        scroll.setBorder(BorderFactory.createTitledBorder("Rezultati igre"));
        add(scroll, BorderLayout.CENTER);

        
        JPanel bottomPanel = new JPanel(new BorderLayout());
        btnStart = new JButton("Pokreni igru");
        bottomPanel.add(btnStart, BorderLayout.WEST);
        add(bottomPanel, BorderLayout.SOUTH);

        
        btnStart.addActionListener(e -> startGame());
    }

    private void startGame() {
        try {
            String name = tfName.getText().trim();
            int x = Integer.parseInt(tfX.getText());
            int y = Integer.parseInt(tfY.getText());

            Collidable collider =
                colliderBox.getSelectedItem().equals("Rectangle")
                    ? new RectangleCollider(x, y, 32, 32)
                    : new CircleCollider(x, y, 16);

            Player p = new Player(name, x, y, collider);

            ArrayList<Enemy> enemies = Game.loadEnemiesFromCSV("enemies.csv");

            Game game = new Game(p);
            for (Enemy e : enemies)
                game.addEnemy(e);

            game.resolveCollisions();

            StringBuilder sb = new StringBuilder();

            sb.append(" STATUS IGRACA \n");
            sb.append(p).append("\n\n");

            sb.append(" SVI NEPRIJATELJI \n");
            for (Enemy e : game.getEnemies())
                sb.append(e).append("\n");

            sb.append("\n NEPRIJATELJI U KOLIZIJI \n");
            for (Enemy e : game.getEnemies())
                if (p.intersects(e))
                    sb.append(e.getDisplayName()).append("\n");

            sb.append("\n LOG \n");
            for (String msg : game.getEventLog())
                sb.append(msg).append("\n");

            output.setText(sb.toString());

            if (p.getHealth() <= 0)
                JOptionPane.showMessageDialog(this, "Igrac je porazen!");
            else
                JOptionPane.showMessageDialog(this, "Igra zavrsena!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Greska: " + ex.getMessage(),
                    "Problem", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new GameGUI().setVisible(true);
    }
}
