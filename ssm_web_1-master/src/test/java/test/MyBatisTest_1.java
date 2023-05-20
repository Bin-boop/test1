package test;

import com.itheima.pojo.Course;
import com.itheima.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MyBatisTest_1 {
    @Test
    //查询 id=2 的课程信息
    public void findByIdTest() {
        // 通过工具类生成SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        Course course =
                session.selectOne("com.itheima.mapper.CourseMapper.findById", 2);
        System.out.println(course);
        session.commit();
        // 关闭SqlSession
        session.close();
    }

    @Test
    //查询出所有计算机学院开设的课程信息
    public void findBySid() {
        // 通过工具类生成SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        List<Object> course =
                session.selectList("com.itheima.mapper.CourseMapper.findBySid", 1);
        for(Object o : course){
            System.out.println(o);
        }
        session.commit();
        // 关闭SqlSession
        session.close();
    }

    @Test
    //将 id=4 这⻔课程的课时数修改为 32+8=40
    public void updateCourse() {
        // 通过工具类生成SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        Course course =
                session.selectOne("com.itheima.mapper.CourseMapper.findById", 4);
        course.setHours(40);
        int result =
                session.update("com.itheima.mapper.CourseMapper.updateCourse",
                        course);
        if (result > 0) {
            System.out.println("成功更新" + result + "条数据");
        } else {
            System.out.println("更新数据失败");
        }
        System.out.println(course);
        session.commit();
        // 关闭SqlSession
        session.close();
    }

    @Test
    //插入一条新的课程记录: names=”大数据存储“,hours=32,schools =1
    public void addCourse() {
        // 通过工具类生成SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        Course course = new Course();
        course.setName("大数据存储");
        course.setHours(32);
        course.setSid(1);
        int result =
                session.insert("com.itheima.mapper.CourseMapper.addCourse", course);
        if (result > 0) {
            System.out.println("成功插入" + result + "条数据");
        } else {
            System.out.println("插入数据失败");
        }
        System.out.println(course);
        session.commit();
        // 关闭SqlSession
        session.close();
    }

    @Test
    //输出所有的学院开设的课程信息
    public void findAllTest() {
        // 通过工具类生成SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        List<Object> course =
                session.selectList("com.itheima.mapper.CourseMapper.findAll");
        for(Object o : course){
            System.out.println(o);
        }
        session.commit();
        // 关闭SqlSession
        session.close();
    }
}
