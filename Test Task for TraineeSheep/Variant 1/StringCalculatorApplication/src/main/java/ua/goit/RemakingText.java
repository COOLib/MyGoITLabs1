package ua.goit;

import ua.goit.actions.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class RemakingText {

    private JPanel panel;
    private JFrame frame;
    private JTextArea ta;

    private Map<String, ua.goit.actions.Action> actions = new HashMap<>();

    private void fillMap() {

        actions.put("+", new AddingAction());
        actions.put("-", new SubtractionAction());
        actions.put("*", new MultiplyingAction());
        actions.put("/", new DivisionAction());
        actions.put("sqrt", new SquareRootAction());
        actions.put("pow", new PowerAction());
        actions.put("!", new FactorialAction());
        actions.put("log", new LogarithmAction());
    }


    private Calculator calculator = new SpecificCalculator(actions);

    public void go(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel back = new JPanel(layout);
        back.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        back.setBackground(Color.DARK_GRAY);

        fillMap();

        Box buttonBox = new Box(BoxLayout.X_AXIS);

        JButton start = new JButton("Open");
        start.addActionListener(new MyStartListener());
        buttonBox.add(start);

        JButton going = new JButton("Get Result!");
        going.addActionListener(new MyGoListener());
        buttonBox.add(going);

        JButton save = new JButton("Save");
        save.addActionListener(new MySaveListener());
        buttonBox.add(save);

        panel = new JPanel();
        back.add(panel);

        ta = new JTextArea();
        JScrollPane pane = new JScrollPane(ta);
        pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        back.add(BorderLayout.CENTER,pane);
        back.add(BorderLayout.SOUTH,buttonBox);

        frame.getContentPane().add(back);
        frame.setBounds(250,300,255,300);
        frame.setVisible(true);
    }

    public class MyGoListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                String str = ta.getText();

                String result = calculator.getAnswer(str);
                ta.setText("");
                ta.append(result);

            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public class MyStartListener implements ActionListener{
        public void actionPerformed(ActionEvent e){

                JFileChooser dialog = new JFileChooser();
                dialog.setFileFilter(new FileNameExtensionFilter("Текстовые файлы", "txt"));
                dialog.showOpenDialog(frame);
                File file = dialog.getSelectedFile();

            try (FileInputStream inF = new FileInputStream(file)) {

                BufferedReader an = new BufferedReader(new InputStreamReader(inF));
                ta.setText("");
                String str;
                for (int i=0;i<file.length();i++) {
                     str = an.readLine();
                    if(str!=null){
                        ta.append(str + "\n");
                    }
                    else {
                        break;
                    }
                }
            }
            catch (Exception ex){
                ex.printStackTrace();
            }

        }
    }

    public class MySaveListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

                JFileChooser dialog = new JFileChooser();
                dialog.showSaveDialog(frame);
                File file = dialog.getSelectedFile();
                dialog.setVisible(true);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(ta.getText());
                writer.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
