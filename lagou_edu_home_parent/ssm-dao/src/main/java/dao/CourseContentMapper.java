package dao;

import heying.domain.Course;
import heying.domain.CourseSection;

import java.util.List;

public interface CourseContentMapper {

    List<CourseSection> findSectionAndLesson(int id);

    Course findCourseName(int id);

    void addSection(CourseSection section);

    void updateSection(CourseSection section);

    void updateSectionStatus(CourseSection section);
}
