package cn.bj.swagger.controller;

import cn.bj.swagger.entity.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 会游泳的蚂蚁
 * @Description:
 * @Date 2021/10/15 11:00
 */
@RestController
@RequestMapping("/test")
@Api("测试swagger接口")
public class TestController {

    @RequestMapping(path = "/getStudent",method = RequestMethod.GET)
    @ApiOperation("/根据学生id获取学生信息")
    @ApiImplicitParam(name = "id",value = "id",required = true,paramType = "query",dataType = "int")
    public Student getStudent(@RequestParam Integer id){
        Student student = new Student();
        student.setId(11);
        student.setAge(21);
        student.setName("全栈学习笔记");
        Map<Integer,Student> studentMap = new HashMap<>();
        studentMap.put(11,student);
        return studentMap.get(id);
    }

    @RequestMapping(path = "/getStudents",method = RequestMethod.PATCH)
    @ApiOperation("/根据学生id获取学生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "姓名",required = true,paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "age",value = "年龄",required = true,paramType = "query",dataType = "int")
    })
    public Student editStudent(@RequestParam String name, @RequestParam Integer age){
        Student student = new Student();
        student.setId(12);
        student.setName(name);
        student.setAge(age);
        return student;

    }

    @ApiOperation("/添加学生信息")
    @RequestMapping(path = "/addStudent",method = RequestMethod.POST)
    public Map<Integer,Student> addStudent(@RequestBody Student student){
        Map<Integer,Student> studentMap = new HashMap<>();
        studentMap.put(student.getId(),student);
        return studentMap;
    }

    @ApiOperation("/根据id删除学生信息")
    @RequestMapping(path = "/deleteStudent",method = RequestMethod.POST)
    public void deleteStudent(@RequestParam Integer id){

    }
}
