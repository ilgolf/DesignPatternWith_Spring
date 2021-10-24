package org.example.factoryMethod.service;

import org.example.factoryMethod.entity.FoodService;
import org.example.factoryMethod.entity.FoodType;
import org.springframework.stereotype.Service;

@Service
public class ChocolateServiceImpl implements FoodService {

    @Override
    public FoodType getFoodType() {
        return FoodType.CHOCOLATE;
    }

    @Override
    public void deliverItem() {
        System.out.println("초콜릿 배달 완료!");
    }
}
