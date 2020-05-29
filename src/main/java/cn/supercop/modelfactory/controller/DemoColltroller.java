package cn.supercop.modelfactory.controller;

import cn.supercop.modelfactory.mapper.DemoMapper;
import cn.supercop.modelfactory.pojo.TestObj;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhouyongcai
 * @create_time 2020/5/28 15:54
 * @note：
 */
@Controller
@RequestMapping("test")
@Api(value = "Api", description = "springBoot-swagger-mybatis测试")  // 对整个api-controller的一个描述
public class DemoColltroller {

    @Autowired
    private DemoMapper registerDataSourceMapper;

    /**
     *  @ApiImplicitParam:  paramType="query"
     *     header-->放在请求头。请求参数的获取：@RequestHeader(代码中接收注解)
     *     query-->用于get请求的参数拼接。请求参数的获取：@RequestParam(代码中接收注解)
     *     path（用于restful接口）-->请求参数的获取：@PathVariable(代码中接收注解)
     *     body-->放在请求体。请求参数的获取：@RequestBody(代码中接收注解)
     *     form（不常用）
     *
     * RequestMethod:
     *
     *  GET（SELECT）：从服务器查询，可以在服务器通过请求的参数区分查询的方式。  
     *  POST（CREATE）：在服务器新建一个资源，调用insert操作。  
     *  PUT（UPDATE）：在服务器更新资源，调用update操作。  
     *  DELETE（DELETE）：从服务器删除资源，调用delete语句
     */

    /**
     * mybatis基于注解  select
     * @param age
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectTestByAnnotation", method = RequestMethod.GET)
    @ApiOperation(value = "selectTestByAnnotation", notes = "mybatis基于注解  select")
    @ApiImplicitParam(paramType = "query", name = "age", value = "年龄", required = true, dataType = "Integer")
    public List<TestObj> selectTestByAnnotation(@RequestParam(value = "age") Integer age) {
        return registerDataSourceMapper.selectTestByAnnotation(age);
    }

    /**
     * mybatis基于注解  insert
     * @param testObj
     * @return
     */
    @ResponseBody
    @ApiOperation(value = "insertTestByAnnotation", notes = "mybatis基于注解  insert")
    @RequestMapping(value = "/insertTestByAnnotation", method = RequestMethod.POST)
    public Integer insertTestByAnnotation(@RequestBody TestObj testObj) {
        Integer insertCount = registerDataSourceMapper.insertTestByAnnotation(testObj);
        return insertCount;
    }

    /**
     * mybatis基于注解  delete
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteTestByAnnotation", method = RequestMethod.DELETE)
    @ApiOperation(value = "deleteTestByAnnotation", notes = "mybatis基于注解  delete")
    @ApiImplicitParam(paramType = "query", name = "testName", value = "删除的姓名", required = true, dataType = "String")
    public Integer deleteTestByAnnotation(@RequestParam(value = "testName") String name) {
        return registerDataSourceMapper.deleteTestByAnnotation(name);
    }

    /**
     * mybatis基于注解  update
     * @param age
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateTestByAnnotation", method = RequestMethod.PUT)
    @ApiOperation(value = "updateTestByAnnotation", notes = "mybatis基于注解  update")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "age", value = "年龄条件", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "name", value = "修改的姓名", required = true, dataType = "String")})
    public Integer updateTestByAnnotation(@RequestParam(value = "age") Integer age, @RequestParam(value = "name") String name){
        return registerDataSourceMapper.updateTestByAnnotation(name, age);
    }

    /**
     * mybatis基于xml的select
     * @param age
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectTestByXml", method = RequestMethod.GET)
    @ApiOperation(value = "selectTestByXml", notes = "mybatis基于xml的select测试")
    @ApiImplicitParam(paramType = "query", name = "age", value = "年龄", required = true , dataType = "int")
    public List<TestObj> selectTestByXml(@RequestParam(value = "age") Integer age) {
        return registerDataSourceMapper.selectTestByXml(age);
    }

    /**
     * mybatis基于xml的delete
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteTestByXml", method = RequestMethod.DELETE)
    @ApiOperation(value = "deleteTestByXml", notes = "mybatis基于xml的delete测试")
    @ApiImplicitParam(paramType = "query", name = "name", value = "通过姓名删除", required = true, dataType = "string")
    public Integer deleteTestByXml(@RequestParam(value = "name") String name) {
        return registerDataSourceMapper.deleteTestByXml(name);
    }

    /**
     * mybatis基于xml的update
     * @param testObj
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateTestByXml", method = RequestMethod.PUT)
    @ApiOperation(value = "updateTestByXml", notes = "mybatis基于xml的update测试")
    public Integer updateTestByXml(@RequestBody TestObj testObj) {
        return registerDataSourceMapper.updateTestByXml(testObj);
    }

    /**
     * mybatis基于xml的insert
     * @param testObj
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/insertTestByXml", method = RequestMethod.POST)
    @ApiOperation(value = "insertTestByXml", notes = "mybatis基于xml的insert测试")
    public Integer insertTestByXml(@RequestBody TestObj testObj) {
        return registerDataSourceMapper.insertTestByXml(testObj);
    }

}
