package cn.supercop.modelfactory.mapper;

import cn.supercop.modelfactory.pojo.TestObj;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zhouyongcai
 * @create_time 2020/5/28 14:17
 * @note：
 */
@Mapper
public interface DemoMapper {

    /**
     * mybatis注解方式 select
     *
     * #{age} 是参数的Integer age
     * @param age
     * @return
     */
    @Select("select name, age from test where age = #{age} ")
    List<TestObj> selectTestByAnnotation(Integer age);

    /**
     * mybatis注解方式 insert
     *
     * #{name} , #{age} 这两个参数是Test对象中的两个属性
     * @param testObj
     * @return 返回插入数据的数量
     */
    @Insert("insert into testObj (name, age) values ( #{name} , #{age} ) ")
    Integer insertTestByAnnotation(TestObj testObj);

    /**
     * mybatis注解方式 delete
     * @param name
     * @return
     */
    @Delete("delete from test where name = #{name}")
    Integer deleteTestByAnnotation(String name);

    /**
     * mybatis注解方式 update
     * @param name
     * @return
     */
    @Update("update test set name = #{name} where age= #{age}")
    Integer updateTestByAnnotation(String name, Integer age);

    /**
     * mybatis xml方式: insert, 具体的配置文件看 mybatis/mapper/testObj.xml
     * @param testObj
     * @return
     */
    Integer insertTestByXml(TestObj testObj);

    /**
     * mybatis xml方式: update, 具体的配置文件看 mybatis/mapper/testObj.xml
     * @param testObj
     * @return
     */
    Integer updateTestByXml(TestObj testObj);

    /**
     * mybatis xml方式: delete, 具体的配置文件看 mybatis/mapper/test.xml
     * @param name
     * @return
     */
    Integer deleteTestByXml(String name);

    /**
     * mybatis xml方式: select, 具体的配置文件看 mybatis/mapper/test.xml
     * @param age
     * @return
     */
    List<TestObj> selectTestByXml(Integer age);


}
