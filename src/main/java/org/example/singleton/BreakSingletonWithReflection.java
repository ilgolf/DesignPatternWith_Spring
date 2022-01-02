package org.example.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// 리플렉션을 통해 싱글톤을 깰 수 있다
public class BreakSingletonWithReflection {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Setting settings = Setting.getInstance();

        Constructor<Setting> constructor = Setting.class.getDeclaredConstructor();
        constructor.setAccessible(true); // private 생성자 접근
        Setting settings1 = constructor.newInstance(); // 새로운 인스턴스 만듦

        System.out.println(settings == settings1); // false
    }
}
