package ssm.test;



import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ssm.bean.Employee;
import ssm.bean.Teacher;
import ssm.bean.TeacherExample;
import ssm.dao.EmployeeMapper;
import ssm.dao.TeacherMapper;
import ssm.service.TeacherService;
import ssm.service.TeacherServiceImpl;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MBGTest {

    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("mbg.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    @Test
    public void test1() throws IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        TeacherService teacherService = context.getBean("teacherService", TeacherService.class);
        List<Teacher> teacherAll = teacherService.getTeacherAll();
        for (Teacher teacher : teacherAll){
            System.out.println(teacher);
        }
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andTeachernameLike("%张%");

        List<Teacher> teacherContrain = teacherService.getTeacherContrain(teacherExample);
        for (Teacher teacher : teacherContrain){
            System.out.println(teacher);
        }

        List<Teacher> teacherList = new ArrayList<>();
        for (int i = 0; i < 2000; i++){
            Teacher teacher = new Teacher();
            teacher.setTeachername(UUID.randomUUID().toString().substring(0,5));
            teacher.setSubjectName(UUID.randomUUID().toString().substring(0,5));
            teacherList.add(teacher);

        }
        teacherService.insertBatch(teacherList);

    }

    @Test
    public void test2() throws IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        TeacherService teacherService = context.getBean("teacherService", TeacherService.class);
        List<Teacher> teacherAll = teacherService.getTeacherAll();
        for (Teacher teacher : teacherAll) {
            System.out.println(teacher);
        }
    }

}
