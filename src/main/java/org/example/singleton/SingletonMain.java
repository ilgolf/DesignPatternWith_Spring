package org.example.singleton;

public class SingletonMain {

    public static void main(String[] args) {
        Setting set1 = Setting.getInstance();
        Setting set2 = Setting.getInstance();

        System.out.println(set1 == set2); // 하나의 인스턴스로만 이루어지기 때문에 true 출력
    }
}
