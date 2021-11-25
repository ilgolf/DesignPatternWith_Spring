# DesignPatternWith_Spring

안녕하세요 예비 개발자 Golf_Dev 입니다. 스프링의 핵심 디자인 패턴이 여러가지 존재합니다. 이러한 패턴들을 코드로 알아보고
개발하는 과정에서 필요한 스프링에 대한 기술도 알아볼 예정입니다. 스프링에서는 이러한 패턴들을 어떻게 적용하는지 또 스프링이 아니더라도
자바 코드를 통해 이 Repository에서 같이 디자인 패턴을 공부해봅시다.

## 대표적인 디자인 패턴

- Singleton Pattern
- Proxy Pattern
- Templete Method Pattern

## 그 외의 패턴

- FactoryMethod Pattern
- Strategy Pattern
- TempleteCallBack Pattern

----------------------------------------------------------

## 앞으로 저장될 코드 Preview

1. FactoryMethod Pattern

```java
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
```

2. TempleteCallBack Pattern

```java
package templete;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;
    String numFilepath;

    @BeforeEach
    public void setUp() {
        this.calculator = new Calculator();
        this.numFilepath = Objects.requireNonNull(getClass().getResource("/numbers.txt")).getPath();
    }

    @Test
    public void sumOfNumbers() throws IOException {
        assertEquals(calculator.calcSum(this.numFilepath), 10);
    }

    @Test
    public void multiplyOfNumbers() throws IOException {
        assertEquals(calculator.calcMultiply(this.numFilepath), 24);
    }
}
```