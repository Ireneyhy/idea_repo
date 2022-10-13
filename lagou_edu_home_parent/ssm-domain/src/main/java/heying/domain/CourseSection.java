package heying.domain;

import java.util.Date;
import java.util.List;

public class CourseSection {

    private int id;

    //课程id
    private int courseId;

    //章节名
    private String sectionName;

    //章节描述
    private String description;

    //排序
    private long orderNum;

    //章节状态，0:隐藏；1：待更新；2：已发布
    private long status;

    //创建时间
    private Date createTime;

    //修改时间
    private Date updateTime;

    //是否删除 0-未删除，1-已删除
    private int isDel;
    private List<CourseLesson> lesson;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(long orderNum) {
        this.orderNum = orderNum;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }

    public List<CourseLesson> getLesson() {
        return lesson;
    }

    public void setLesson(List<CourseLesson> lesson) {
        this.lesson = lesson;
    }

    @Override
    public String toString() {
        return "CourseSection{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", sectionName='" + sectionName + '\'' +
                ", description='" + description + '\'' +
                ", order_num=" + orderNum +
                ", status=" + status +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", isDel=" + isDel +
                '}';
    }

}
