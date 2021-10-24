package org.example.factoryMethod.foodFactory;

import org.example.factoryMethod.entity.FoodService;
import org.example.factoryMethod.entity.FoodType;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FoodServiceFactory {

    // foodService를 담고 있어줄 Map
    private final Map<FoodType, FoodService> foodServices = new HashMap<>();

    // 생성자 주입으로 FoodService를 상속하고 있는 bean들을 주입 받는다.
    public FoodServiceFactory(List<FoodService> foodServices) {

        // foodService를 상속받는 bean이 없을 경우 IllegalArgumentException을 던진다.
        if (CollectionUtils.isEmpty(foodServices)) {
            throw new IllegalArgumentException("존재하는 foodService가 없음");
        }

        // foodService의 구현체인 bean들을 for문을 돌리면서 key는 음식 종류의 타입, value는 해당 동일한 bean을 map에 담아준다.
        for (FoodService foodService : foodServices) {
            this.foodServices.put(foodService.getFoodType(), foodService);
        }
    }

    public FoodService getService(FoodType foodType) {
        // 인자로 넘겨준 타입에 맞는 foodService의 bean을 넘겨준다.
        return foodServices.get(foodType);
    }
}
