package service;

import heying.domain.Course;
import heying.domain.CourseVo;
import heying.domain.Teacher;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface CourseService {

    List<Course> findCourseByCondition(CourseVo courseVo);

    void addCourseOrTeacher(CourseVo courseVo) throws InvocationTargetException, IllegalAccessException;

    CourseVo findCourseById(int id);

    void updateCourseOrTeacher(CourseVo courseVo) throws InvocationTargetException, IllegalAccessException;

    void updateCourseStatus(int id, int status);
}
