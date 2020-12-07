package com.mybatis;

import com.mybatis.Entity.attribute;
import com.mybatis.Entity.car;
import com.mybatis.ParaMapper.Enity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class main {
    public static void main(String[] args) {

        String resource = "config.xml";
        InputStream inputStream = null;

        {
            try {
                inputStream = Resources.getResourceAsStream(resource);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            Enity enity = session.getMapper(Enity.class);
            int cars = enity.carNumber();     //查询车辆总数
                System.out.println(cars);

            int busA= enity.busNumberA();   //查询bus的总数方法一
                System.out.println(busA);
            int busB = enity.busNumberB();  //查询bus的总数方法二
            System.out.println(busB);

            car CarConditiona = enity.CarCondition();   //多表查询
               System.out.println(CarConditiona.toString());
            attribute Subquerya = enity.Subquery();   //子查询
                System.out.println(Subquerya.toString());


            car tmp = new car(3,"suv","3",2);             //插入
            enity.insertcar(tmp);
            car updatacar = new car (2,"suv","2020202020",2);   //  修改
            enity.updatacar(updatacar);


            enity.deletecar(3);      //删除字段

            session.commit();
        }

    }


}
