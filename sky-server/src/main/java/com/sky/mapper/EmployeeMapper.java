package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.result.PageResult;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    //insert 语句的写法
    /*
    * insert into table(clou1,clou2,clou3,clou3) values(clou1,clou2,clou3,clou3)
    * */

//    @Insert("insert into employee(name,username,password,phone,sex,id_number,create_time,update_time,create_user,update_user,status)"
//            +"values"
//            +"(#{name},#{username},#{password},#{phone},#{sex},#{idNumber},#{createTime},#{updateTime},#{createUser},#{updateUser},#{status})")
//    void insert(Employee employee);
    //拼串时 values前面少了一个空格导致解析错误
    @Insert("insert into employee(name,username,password,phone,sex,id_number,create_time,update_time,create_user,update_user,status)"
            + " values"
            + "(#{name},#{username},#{password},#{phone},#{sex},#{idNumber},#{createTime},#{updateTime},#{createUser},#{updateUser},#{status})")
    void insert(Employee employee);

    Page<Employee> QueryPageByName(EmployeePageQueryDTO employeePageQueryDTO);
}
