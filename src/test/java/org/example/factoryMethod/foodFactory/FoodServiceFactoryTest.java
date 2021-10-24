package org.example.factoryMethod.foodFactory;

import org.example.factoryMethod.entity.FoodService;
import org.example.factoryMethod.entity.FoodType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FoodServiceFactoryTest {

    @Autowired
    private FoodServiceFactory foodServiceFactory;

    @Test
    void deliveryFood() {
        // given
        FoodType candy = FoodType.CANDY;
        FoodType snack = FoodType.SNACK;
        FoodType noodle = FoodType.NOODLE;
        FoodType choco = FoodType.CHOCOLATE;

        // when
        FoodService candyService = foodServiceFactory.getService(candy);
        FoodService snackService = foodServiceFactory.getService(snack);
        FoodService noodleService = foodServiceFactory.getService(noodle);
        FoodService chocoService = foodServiceFactory.getService(choco);

        // then
        assertEquals(candyService.getFoodType(), FoodType.CANDY);
        assertEquals(snackService.getFoodType(), FoodType.SNACK);
        assertEquals(noodleService.getFoodType(), FoodType.NOODLE);
        assertEquals(chocoService.getFoodType(), FoodType.CHOCOLATE);

        // print
        candyService.deliverItem();
        snackService.deliverItem();
        noodleService.deliverItem();
        chocoService.deliverItem();
    }
}