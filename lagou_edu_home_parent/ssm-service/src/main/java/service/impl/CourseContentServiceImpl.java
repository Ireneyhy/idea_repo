package service.impl;

import dao.CourseContentMapper;
import heying.domain.Course;
import heying.domain.CourseSection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CourseContentService;

import java.util.Date;
import java.util.List;

@Service
public class CourseContentServiceImpl implements CourseContentService {

    @Autowired
    private CourseContentMapper courseContentMapper;

    @Override
    public List<CourseSection> findSectionAndLesson(int courseId) {

        return courseContentMapper.findSectionAndLesson(courseId);
    }

    @Override
    public Course findCourseName(int courseId) {

        return courseContentMapper.findCourseName(courseId);
    }

    @Override
    public void addSection(CourseSection section) {

        section.setCreateTime(new Date());
        section.setUpdateTime(new Date());
        courseContentMapper.addSection(section);
    }

    @Override
    public void updateSection(CourseSection section) {

        section.setUpdateTime(new Date());
        courseContentMapper.updateSection(section);

    }

    @Override
    public void updateSectionStatus(int id, int status) {

        CourseSection section = new CourseSection();
        section.setId(id);
        section.setStatus(status);
        section.setUpdateTime(new Date());
        courseContentMapper.updateSectionStatus(section);
    }
}
