import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reusablecomponents {




    public  List getData() throws IOException, CsvValidationException {

        List<Object> list=new ArrayList<>();
        String filePath = System.getProperty("user.dir") + "/src/main/resources/data.csv";
        FileReader fileReader = new FileReader(filePath);
        CSVReader reader = new CSVReader(fileReader);
        reader.readNext(); //skip header
        String[] line;
        while ((line=reader.readNext()) != null) {
            System.out.println(line.length);
            AuthPojo pojo=new AuthPojo(line[0],line[1]);
            list.add(pojo);
        }
        for (Object l:list) {
            System.out.println(l.toString());
        }
     return list;

    }
}

