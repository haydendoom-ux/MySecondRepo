import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class MenuInterface extends JFrame implements ActionListener {

 
    JTextArea textArea;
    JPanel panel;

    JMenuItem dateTimeItem;
    JMenuItem saveItem;
    JMenuItem colorItem;
    JMenuItem exitItem;

  
    Color savedGreenColor;

    public MenuInterface() {


        setTitle("Menu Interface Program");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

      
        textArea = new JTextArea();
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);


        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Options");

    
        dateTimeItem = new JMenuItem("Show Date and Time");
        saveItem = new JMenuItem("Save to log.txt");
        colorItem = new JMenuItem("Change Background Color");
        exitItem = new JMenuItem("Exit");

     
        dateTimeItem.addActionListener(this);
        saveItem.addActionListener(this);
        colorItem.addActionListener(this);
        exitItem.addActionListener(this);

       
        menu.add(dateTimeItem);
        menu.add(saveItem);
        menu.add(colorItem);
        menu.add(exitItem);

  
        menuBar.add(menu);

     
        setJMenuBar(menuBar);

        Random random = new Random();

        int greenValue = random.nextInt(156) + 100;

        savedGreenColor = new Color(0, greenValue, 0);


        add(panel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Option 1: Show date and time
        if (e.getSource() == dateTimeItem) {

            LocalDateTime now = LocalDateTime.now();

            DateTimeFormatter format =
                    DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");

            textArea.setText(
                    "Current Date and Time: " + now.format(format));
        }

        // Option 2: Save text area to log.txt
        else if (e.getSource() == saveItem) {

            try {

                FileWriter writer = new FileWriter("log.txt");

                writer.write(textArea.getText());

                writer.close();

                JOptionPane.showMessageDialog(this,
                        "Text saved to log.txt");

            } catch (IOException ex) {

                JOptionPane.showMessageDialog(this,
                        "Error saving file");
            }
        }

        // Option 3: Change background color
        else if (e.getSource() == colorItem) {

            panel.setBackground(savedGreenColor);

            // Change text area background too
            textArea.setBackground(savedGreenColor);

            // Make text visible
            textArea.setForeground(Color.BLACK);
        }

        // Option 4: Exit
        else if (e.getSource() == exitItem) {

            System.exit(0);
        }
    }

    public static void main(String[] args) {

        new MenuInterface();
    }
}