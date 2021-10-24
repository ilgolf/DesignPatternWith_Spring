package org.example.factoryMethod.service;

import org.example.factoryMethod.entity.FoodService;
import org.example.factoryMethod.entity.FoodType;
import org.springframework.stereotype.Service;

@Service
public class SnackServiceImpl implements FoodService {

    @Override
    public FoodType getFoodType() {
        return FoodType.SNACK;
    }

    @Override
    public void deliverItem() {
        System.out.println("과자 배달 완료!");
    }
}
