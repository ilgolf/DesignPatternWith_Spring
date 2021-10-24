package templete;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {

    public Integer fileReadTemplate(String filepath, BufferedReaderCallback callback) throws IOException {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(filepath));
            return callback.doSomethingWithReader(br);
        }catch(IOException e) {
            System.out.println(e.getMessage());
            throw e;
        }
        finally {
            if(br != null) {
                try { br. close();}
                catch(IOException e) {System.out.println(e.getMessage());}
            }
        }
    }

    public Integer calcSum(String filepath) throws IOException {
        BufferedReaderCallback sumCallback = br -> {
            int sum = 0;
            String line;

            while((line = br.readLine()) != null) {
                sum += Integer.parseInt(line);
            }
            return sum;
        };
        return fileReadTemplate(filepath, sumCallback);

    }

    public Integer calcMultiply(String filepath) throws IOException {
        BufferedReaderCallback sumCallback = br -> {
            int multiply = 1;
            String line;

            while((line = br.readLine()) != null) {
                multiply *= Integer.parseInt(line);
            }

            return multiply;
        };

        return fileReadTemplate(filepath, sumCallback);
    }
}
