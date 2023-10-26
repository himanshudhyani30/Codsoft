package TASK2;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGradeCalculator{
    public static void main(String[] args){
        JFrame f = new JFrame("STUDENT GRADE CALCULATOR");
        f.setBounds(100,100,500,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);

        JLabel l = new JLabel("ENTER MARKS OF STUDENT OUT OF 100");
        l.setBounds(120,10,250,20);

        JLabel l2 = new JLabel("-------------------------------------------------------------");
        l2.setBounds(120,20,250,20);

        JLabel l3 = new JLabel("SUBJECT 1");
        l3.setBounds(120,50,70,20);
        JTextField j = new JTextField();
        j.setBounds(280,50,80,20);

        JLabel l4 = new JLabel("SUBJECT 2");
        l4.setBounds(120,80,70,20);
        JTextField j1 = new JTextField();
        j1.setBounds(280,80,80,20);

        JLabel l5 = new JLabel("SUBJECT 3");
        l5.setBounds(120,110,70,20);
        JTextField j2 = new JTextField();
        j2.setBounds(280,110,80,20);

        JLabel l6 = new JLabel("SUBJECT 4");
        l6.setBounds(120,140,70,20);
        JTextField j3 = new JTextField();
        j3.setBounds(280,140,80,20);

        JLabel l7 = new JLabel("SUBJECT 5");
        l7.setBounds(120,170,70,20);
        JTextField j4 = new JTextField();
        j4.setBounds(280,170,80,20);


        JButton c = new JButton("Calculate");
        c.setBounds(260, 220, 100, 30);

        JLabel r = new JLabel("");
        r.setBounds(80, 260, 350, 20);


        c.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    float marks1 = Float.parseFloat(j.getText());
                    float marks2 = Float.parseFloat(j1.getText());
                    float marks3 = Float.parseFloat(j2.getText());
                    float marks4 = Float.parseFloat(j3.getText());
                    float marks5 = Float.parseFloat(j4.getText());

                    float totalMarks = marks1 + marks2 + marks3 + marks4 + marks5;
                    float Percentage = (totalMarks / 500) * 100;
                    String grade = calculategrade(Percentage);

                    String result = "Total Marks= " + totalMarks + "  |   Percentage= " + Percentage + "%" + "  |  Grade: " + grade;
                    r.setText(result);
                }
                catch (NumberFormatException ex) {
                    r.setText("Please enter valid marks for all subjects.");
                }
            }
        });

        f.add(l);
        f.add(l2);
        f.add(l3);
        f.add(j);
        f.add(l4);
        f.add(j1);
        f.add(l5);
        f.add(j2);
        f.add(l6);
        f.add(j3);
        f.add(l7);
        f.add(j4);
        f.add(c);
        f.add(r);
        f.setVisible(true);
    }
    public static String calculategrade(double percentage){
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}
