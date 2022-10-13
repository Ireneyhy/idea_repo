package service;

import heying.domain.Course;
import heying.domain.CourseSection;

import java.util.List;

public interface CourseContentService {

    List<CourseSection> findSectionAndLesson(int courseId);

    Course findCourseName(int courseId);

    void addSection(CourseSection section);

    void updateSection(CourseSection section);
    void updateSectionStatus(int id, int status);
}
