package skischool;

import java.util.GregorianCalendar;

public interface Course {
    String getCourseName();
    int getMinimumNumberOfParticipants();
    int getMaximumNumberOfParticipants();
    int getNumberOfParticipants();
    GregorianCalendar getDataInizio();
    boolean addParticipant();
    boolean isCourseActivated();
}
