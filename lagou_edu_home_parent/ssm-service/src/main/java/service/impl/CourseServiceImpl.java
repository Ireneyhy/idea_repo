package service.impl;

import dao.CourseMapper;
import heying.domain.Course;
import heying.domain.CourseVo;
import heying.domain.Teacher;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CourseService;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> findCourseByCondition(CourseVo courseVo) {

        return courseMapper.findCourseByCondition(courseVo);
    }

    @Override
    public void addCourseOrTeacher(CourseVo courseVo) throws InvocationTargetException, IllegalAccessException {

        Course course = new Course();
        BeanUtils.copyProperties(course,courseVo);
        course.setCreateTime(new Date());
        course.setUpdateTime(new Date());
        courseMapper.addCourse(course);

        int id = course.getId();

        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher,courseVo);
        teacher.setCreateTime(new Date());
        teacher.setUpdateTime(new Date());
        teacher.setIsDel(0);
        teacher.setCourseId(id);
        courseMapper.addTeacher(teacher);
    }

    @Override
    public CourseVo findCourseById(int id) {

        return courseMapper.findCourseById(id);
    }

    @Override
    public void updateCourseOrTeacher(CourseVo courseVo) throws InvocationTargetException, IllegalAccessException {

        Course course = new Course();
        BeanUtils.copyProperties(course, courseVo);
        course.setUpdateTime(new Date());
        courseMapper.updateCourse(course);

        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher, courseVo);
        teacher.setCourseId(course.getId());
        teacher.setUpdateTime(new Date());
        courseMapper.updateTeacher(teacher);
    }

    @Override
    public void updateCourseStatus(int id, int status) {

        Course c = new Course();
        c.setUpdateTime(new Date());
        c.setStatus(status);
        c.setId(id);
        courseMapper.updateCourseStatus(c);
    }
}
