import com.liqiang.domain.Employee;
import com.liqiang.query.EmployeeQuery;
import com.liqiang.service.IEmployeeService;
import com.liqiang.util.PageList;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeServiceTest extends BaseTest {

    @Autowired
    private IEmployeeService employeeService;

    @Test
    public void pageTest(){
        EmployeeQuery employeeQuery = new EmployeeQuery();
        employeeQuery.setPage(1L);
        employeeQuery.setPageSize(2L);
        PageList<Employee> pageList = employeeService.query(employeeQuery);
        System.out.println(pageList.getTotal());
        for (Employee employee : pageList.getRows()) {
            System.out.println(employee);
        }
    }

    @Test
    public void testP() throws Exception{
        List<Employee> list = employeeService.getAll();
        list.forEach(System.out::println);
    }
    @Test
    public void test1() throws Exception{
        Employee  employee = new Employee("找不出来这个错不睡觉");
        employeeService.add(employee); // 测试创建dev分支时修改
    }

}
