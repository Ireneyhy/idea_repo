package dao;

import heying.domain.Course;
import heying.domain.CourseVo;
import heying.domain.Teacher;

import java.util.List;

public interface CourseMapper {

    List<Course> findCourseByCondition(CourseVo courseVo);

    void addCourse(Course course);

    void addTeacher(Teacher teacher);

    CourseVo findCourseById(int id);

    void updateCourse(Course course);

    void updateTeacher(Teacher teacher);

    void updateCourseStatus(Course course);
}
