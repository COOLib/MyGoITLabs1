package ua.goit;

import org.hibernate.Session;
import ua.goit.actions.Action;
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
    private JFrame history;
    private JTextArea area;
    private JPanel historyPanel;

    private Map<String, Action> actions = new HashMap<>();

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

    public void go() {

        fillMap();
        setUpCalcWindow();
    }

    private void setUpCalcWindow() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel back = new JPanel(layout);
        back.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        back.setBackground(Color.DARK_GRAY);

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

        JButton history = new JButton("History");
        save.addActionListener(new MyHistoryListener());
        buttonBox.add(history);

        panel = new JPanel();
        back.add(panel);

        ta = new JTextArea();
        JScrollPane pane = new JScrollPane(ta);
        pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        back.add(BorderLayout.CENTER, pane);
        back.add(BorderLayout.SOUTH, buttonBox);

        frame.getContentPane().add(back);
        frame.setBounds(600, 400, 330, 300);
        frame.setVisible(true);
    }

    public class MyGoListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try {
                String str = ta.getText();
                Calculation calculation = new Calculation();
                String result = calculator.getAnswer(str);

                Session session = HibernateUtil.getSessionFactory().getCurrentSession();
                session.beginTransaction();

                calculation.setFormula(str);
                calculation.setAnswer(result);

                session.save(calculation);
                session.getTransaction().commit();

                ta.setText("");
                ta.append(result);
            } catch (Exception ex) {

                ta.setText("Please, write the correct formula \ninstead this message!");
            }
        }
    }

    public class MyStartListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            JFileChooser dialog = new JFileChooser();
            dialog.setFileFilter(new FileNameExtensionFilter("Text files", "txt"));
            dialog.showOpenDialog(frame);
            File file = dialog.getSelectedFile();

            try (FileInputStream inF = new FileInputStream(file)) {

                BufferedReader an = new BufferedReader(new InputStreamReader(inF));
                ta.setText("");
                String str;

                for (int i = 0; i < file.length(); i++) {
                    str = an.readLine();

                    if (str != null) {
                        ta.append(str + "\n");
                    } else {
                        break;
                    }
                }
            } catch (Exception ex) {

                JOptionPane.showMessageDialog(frame, "Any text file was not chosen!");
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
                JOptionPane.showMessageDialog(frame, "Any text file was not chosen to save result!");
            }
        }
    }

    public class MyHistoryListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            setHistoryPanel();

            Calculation calc = new Calculation();
            calc.getFormula();
        }
    }

    private void setHistoryPanel() {

        history = new JFrame("History");
        history.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel back = new JPanel(layout);
        back.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        back.setBackground(Color.DARK_GRAY);

        historyPanel = new JPanel();
        back.add(historyPanel);

        area = new JTextArea();
        JScrollPane pane = new JScrollPane(area);
        pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        back.add(BorderLayout.CENTER, pane);

        history.getContentPane().add(back);
        history.setBounds(550, 350, 330, 300);
        history.setVisible(true);
    }
}



