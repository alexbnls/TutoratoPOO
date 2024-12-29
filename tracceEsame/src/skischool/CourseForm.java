package skischool;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class CourseForm {
    private JComboBox comboBox1;
    private JButton elencaButton;
    private JTextArea textArea1;
    private JPanel mainPanel;
    private CourseList courseList;

    public CourseForm(CourseList courseList) {
        this.courseList = courseList;

        elencaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                List<Course> courses;
                int index = comboBox1.getSelectedIndex();

                if(index == 0)
                    courses = courseList.getCourses("SnowboardCourse");
                else if(index == 1)
                    courses = courseList.getCourses("SkiCourse");
                else
                    throw new IllegalArgumentException("seleziona corso!");

                for(Course course: courses)
                    textArea1.append(course.toString() + "\n");
            }
        });
    }

    public static void main(String[] args) {
        CourseList courseList = new CourseList();
        courseList.addCourse(new SkiCourse("abc", 5, new GregorianCalendar(2002, Calendar.NOVEMBER, 13), 6));
        courseList.addCourse(new SkiCourse("cba", 7, new GregorianCalendar(2002, Calendar.FEBRUARY, 1), 6));
        courseList.addCourse(new SkiCourse("def", 8, new GregorianCalendar(2002, Calendar.MAY, 15), 6));

        courseList.addCourse(new SnowboardCourse("fda", 9, new GregorianCalendar(2016, Calendar.APRIL, 4), 5));
        courseList.addCourse(new SnowboardCourse("pop", 7, new GregorianCalendar(2016, Calendar.DECEMBER, 25), 5));
        courseList.addCourse(new SnowboardCourse("lel", 10, new GregorianCalendar(2016, Calendar.JANUARY, 11), 5));

        JFrame frame = new JFrame("CourseForm");
        frame.setContentPane(new CourseForm(courseList).mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
