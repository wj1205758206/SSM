package ssm.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ssm.bean.Teacher;
import ssm.service.TeacherService;

import java.util.List;


@Controller
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @RequestMapping("/getTeacher")
    public String getTeacher(@RequestParam(value = "id", defaultValue = "1") Integer id, Model model){
        Teacher teacher = teacherService.getTeacherById(id);
        model.addAttribute("teacher",teacher);
        return "success";
    }

    @RequestMapping("/getTeacherAll")
    public String getTeacherAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum, Model model){
        PageHelper.startPage(pageNum,5);
        List<Teacher> teacherAll = teacherService.getTeacherAll();

        //可以封装分页对象
        PageInfo<Teacher> teacherPageInfo = new PageInfo<>(teacherAll,6);
        System.out.println("当前页码：" + teacherPageInfo.getPageNum());
        System.out.println("总页码：" + teacherPageInfo.getPages());
        System.out.println("总记录数：" + teacherPageInfo.getTotal());
        System.out.println("当前页记录数：" + teacherPageInfo.getSize());
        System.out.println("当前页的PageSize：" + teacherPageInfo.getPageSize());
        System.out.println("前一页：" + teacherPageInfo.getPrePage());
        System.out.println("后一页：" + teacherPageInfo.getNextPage());
        System.out.println("查询结果：" + teacherPageInfo.getList());

        int[] navigatepageNums = teacherPageInfo.getNavigatepageNums();

        model.addAttribute("teacherPageInfo",teacherPageInfo);
        return "success";
    }
}
