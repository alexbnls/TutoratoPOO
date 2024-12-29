package skischool;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CourseList {
    private List<Course> corsi;

    public CourseList()
    {
        corsi = new ArrayList<>();
    }

    private final Comparator<Course> dataComparator = new Comparator<Course>() {
        @Override
        public int compare(Course o1, Course o2) {
            return o1.getDataInizio().compareTo(o2.getDataInizio());
        }
    };

    public void addCourse(Course course)
    {
        corsi.add(course);
        corsi.sort(dataComparator);
    }

    public Course getCourse(int i)
    {
        if(corsi.size() < i)
            throw new IllegalArgumentException("corso non presente, indice troppo alto");

        return corsi.get(i);
    }

    public Course removeCourse(int i)
    {
        if(corsi.size() < i)
            throw new IllegalArgumentException("corso non presente, indice troppo alto");

        return corsi.remove(i);
    }

    public ArrayList<Course> getCourses(String type)
    {
        ArrayList<Course> c = new ArrayList<>();

        for(Course course: corsi)
        {
            if(course.getCourseName().equals(type))
                c.add(course);
        }

        return c;
    }

}
