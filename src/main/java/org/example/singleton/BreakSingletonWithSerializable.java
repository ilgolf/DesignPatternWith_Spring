package org.example.singleton;

import java.io.*;

public class BreakSingletonWithSerializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Setting settings = Setting.getInstance();
        Setting settings1;

        // 객체를 직렬화하여 파일로 만든다.
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("settings.obj"))) {
            out.writeObject(settings);
        }


        try (ObjectInput in = new ObjectInputStream(new FileInputStream("settings.obj"))) {
            settings1 = (Setting) in.readObject();
        }

        System.out.println(settings == settings1);
    }
}
