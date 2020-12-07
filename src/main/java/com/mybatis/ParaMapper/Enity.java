package com.mybatis.ParaMapper;

import com.mybatis.Entity.attribute;
import com.mybatis.Entity.car;

public interface Enity {
    int carNumber();
    int busNumberA();
    int busNumberB();
    car CarCondition();
    attribute Subquery();
    void insertcar(car tmp);
    void updatacar(car tmp);
    void deletecar(int car_id);
}
