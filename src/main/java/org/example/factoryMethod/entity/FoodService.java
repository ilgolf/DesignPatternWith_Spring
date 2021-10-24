package org.example.factoryMethod.entity;

// 음식 배달의 상위 인터페이스인 FoodService
public interface FoodService {

    FoodType getFoodType();

    void deliverItem();
}
