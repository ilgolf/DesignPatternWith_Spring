package org.example.factoryMethod.service;

import org.example.factoryMethod.entity.FoodService;
import org.example.factoryMethod.entity.FoodType;
import org.springframework.stereotype.Service;

@Service
public class CandyServiceImpl implements FoodService {

    @Override
    public FoodType getFoodType() {
        return FoodType.CANDY;
    }

    @Override
    public void deliverItem() {
        System.out.println("사탕 배달 완료!");
    }
}
