import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Reusablecomponents1 {




    public  List getData() throws IOException, CsvValidationException {

        List<Object> list=new ArrayList<>();
        String filePath = System.getProperty("user.dir") + "/src/main/resources/data.csv";
        FileReader fileReader = new FileReader(filePath);
        CSVReader reader = new CSVReader(fileReader);
        reader.readNext(); //skip header
        String[] line;
        while ((line=reader.readNext()) != null) {
            Random random = new Random();
            int randomNumber = random.nextInt(9000) + 1000;
            String email = line[1].replace("@gmail.com",randomNumber+"9@gmail.com");
            System.out.println(email+"--------------------------------------");
            AuthPojo pojo=new AuthPojo(line[0],email);
            list.add(pojo);
        }
        for (Object l:list) {
            System.out.println(l.toString());
        }
     return list;

    }
}

