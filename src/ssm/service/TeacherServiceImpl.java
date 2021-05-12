package ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.bean.Teacher;
import ssm.bean.TeacherExample;
import ssm.dao.TeacherMapper;

import java.util.List;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService{
    @Autowired
    TeacherMapper teacherDao;


    @Override
    public Teacher getTeacherById(Integer id) {
        return teacherDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Teacher> getTeacherAll() {
        return teacherDao.selectByExample(null);
    }

    @Override
    public List<Teacher> getTeacherContrain(TeacherExample teacherExample) {

        return teacherDao.selectByExample(teacherExample);
    }

    @Override
    public void insertBatch(List<Teacher> teacherList) {
        teacherDao.insertBatch(teacherList);
    }
}
