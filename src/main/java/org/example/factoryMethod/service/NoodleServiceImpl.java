package org.example.factoryMethod.service;

import org.example.factoryMethod.entity.FoodService;
import org.example.factoryMethod.entity.FoodType;
import org.springframework.stereotype.Service;

@Service
public class NoodleServiceImpl implements FoodService {

    @Override
    public FoodType getFoodType() {
        return FoodType.NOODLE;
    }

    @Override
    public void deliverItem() {
        System.out.println("라면 배달 완료!");
    }
}
