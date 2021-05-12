package ssm.service;

import org.springframework.stereotype.Service;
import ssm.bean.Teacher;
import ssm.bean.TeacherExample;

import java.util.List;

public interface TeacherService {
    public Teacher getTeacherById(Integer id);
    public List<Teacher> getTeacherAll();
    public List<Teacher> getTeacherContrain(TeacherExample teacherExample);
    public void insertBatch(List<Teacher> teacherList);
}
