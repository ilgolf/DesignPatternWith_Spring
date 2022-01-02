package org.example.singleton;

import java.io.Serializable;

public class Setting implements Serializable {

    /**
     * private 생성자로 인스턴스를 만들지 못하게 제한
     */
    private Setting() {}

    /**
     * JVM에서 클래스를 로딩 해올 때 동기 화를 시켜 주기 때문에 이를 이용해 Thread-safe하다.
     * 내부 클래스는 호출 시에만 생성 되기 때문에 자원 낭비를 줄일 수 있다.
     */
    private static final class SettingsHolder {
        private static final Setting INSTANCE = new Setting();
    }

    /**
     * 내부 클래스에서 인스턴스를 미리 생성해서 던져 주므로 이상의 코드가 필요하지 않다.
     * @return
     */
    public static Setting getInstance() {
        return SettingsHolder.INSTANCE;
    }

    /**
     * 역직렬화로 싱글톤이 깨지는 경우가 있는데 Serializable에 있는 메서드를 구현하여
     * getInstance를 반환하여 싱글톤을 유지할 수 있다.
     * @return
     */
    protected Object readResolve() {
        return getInstance();
    }
}
