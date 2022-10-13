package controller;

import heying.domain.Course;
import heying.domain.CourseSection;
import heying.domain.CourseVo;
import heying.domain.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import service.CourseContentService;
import service.CourseService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseContentService courseContentService;

    @RequestMapping("/findCourseByCondition")
    public ResponseResult findCourseByCondition(@RequestBody CourseVo courseVo){

        List<Course> list = courseService.findCourseByCondition(courseVo);

        return new ResponseResult(true, 200, "success", list);
    }

    @RequestMapping("/courseUpload")
    public ResponseResult fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {

        if (file.isEmpty()){
            throw new RuntimeException();
        }

        String path = request.getServletContext().getRealPath("/");
        String realPath = path.substring(0, path.indexOf("ssm-web"));

        String filename = file.getOriginalFilename();
        int i = filename.lastIndexOf(".");
        String realFilename = System.currentTimeMillis() + filename.substring(i);

        String uploadPath = realPath + "/upload/";

        File file1 = new File(uploadPath, realFilename);

        if (!file1.getParentFile().exists()){
            file1.getParentFile().mkdirs();
            System.out.println("创建目录" + file1);
        }

        file.transferTo(file1);

        Map<String, String> map = new HashMap<>();
        map.put("filename", realFilename);
        map.put("filepath", "http://localhost:8080/upload/" + realFilename);

        return new ResponseResult(true, 200, "Successful", map);
    }

    @RequestMapping("/addOrUpdateCourse")
    public ResponseResult addOrUpdateCourse(@RequestBody CourseVo courseVo) throws InvocationTargetException, IllegalAccessException {

        if (courseVo.getId() == null ) {
            courseService.addCourseOrTeacher(courseVo);
            return new ResponseResult(true, 200, "Added!", null);

        } else {
            courseService.updateCourseOrTeacher(courseVo);
            return new ResponseResult(true, 200, "Updated!", null);
        }
    }

    @RequestMapping("/findCourseById")
    public ResponseResult findCourseById(int id) {

        CourseVo vo = courseService.findCourseById(id);

        return new ResponseResult(true, 200, "Successful", vo);
    }

    @RequestMapping("/updateCourseStatus")
    public ResponseResult updateCourseStatus(int id, int status) {

        courseService.updateCourseStatus(id, status);
        Map<String,Object> map = new HashMap<>();
        map.put("status",status);
        return new ResponseResult(true,200,"课程状态更新成功", map);
    }

    @RequestMapping("/findSectionAndLesson")
    public ResponseResult findSectionAndLesson(int courseId){

        List<CourseSection> list = courseContentService.findSectionAndLesson(courseId);
        return new ResponseResult(true,200,"查找成功",list);
    }

    @RequestMapping("/findCourseName")
    public ResponseResult findCourseName(Integer courseId){

        Course c = courseContentService.findCourseName(courseId);
        return new ResponseResult(true,200,"查找成功",c.getCourseName());
    }

    @RequestMapping("/addOrUpdateSection")
    public ResponseResult addOrUpdateSection(@RequestBody CourseSection section){

        if (section.getId() == 0) {
            courseContentService.addSection(section);
            return new ResponseResult(true,200,"添加成功", null);
        } else {
            courseContentService.updateSection(section);
            return new ResponseResult(true,200,"修改成功", null);
        }
    }

    @RequestMapping("/updateSectionStatus")
    public ResponseResult updateSectionStatus (int id, int status) {

        courseContentService.updateSectionStatus(id, status);
        Map<String,Object> map = new HashMap<>();
        map.put("status", status);
        return new ResponseResult(true,200,"修改成功", map);
    }
}
