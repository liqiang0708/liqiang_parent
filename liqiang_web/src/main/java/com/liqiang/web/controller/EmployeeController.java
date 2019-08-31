package com.liqiang.web.controller;


import com.liqiang.domain.Employee;
import com.liqiang.query.EmployeeQuery;
import com.liqiang.service.IEmployeeService;
import com.liqiang.util.AjaxResult;
import com.liqiang.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    //添加功能的接口:url 有参数,有返回值
    @RequestMapping(method = RequestMethod.PUT)//不再写url,而是根据不同的请求方式来区分不同的路径
    @ResponseBody
    public AjaxResult add(@RequestBody Employee employee) //@RequestBody 接受前端请求里传递json就用这种方式
    {
        System.out.println("添加成功");
        return AjaxResult.me();
    }

    //删除功能接口: url 有参数,有返回值
    //直接在url里面占位{id}   删除不同的id就发送包含这个id值的url ：employee/1 、employee/2
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public AjaxResult del(@PathVariable("id")Long id){
        System.out.println("删除成功"+id);
        return AjaxResult.me();
    }
    //修改功能接口: url 有参数（id,对象）,有返回值
    @RequestMapping(value = "{id}",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult update(@PathVariable("id")Long id,@RequestBody Employee employee){
        System.out.println("修改成功"+id+employee);
        return AjaxResult.me();
    }

    //查询一个
    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public  Employee getById(@PathVariable("id") Long id){
        Employee employee = new Employee("youyou");
        employee.setId(id);
        return employee;
    }

    //查询所有
    @ResponseBody
    @RequestMapping(method = RequestMethod.PATCH)
    public List<Employee> list(){
        return employeeService.getAll();
    }

    // 高级查询
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public PageList<Employee> query(@RequestBody EmployeeQuery query){
        return employeeService.query(query);
        //return new PageList<>();
    }


}
