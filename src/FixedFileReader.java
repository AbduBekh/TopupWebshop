import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FixedFileReader {
    public static List<FixedPrice> read(String filepath){
        List<FixedPrice> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] parts = line.split(";");

                    //Extracting data

                    String name = parts[0].trim();
                    double price = Double.parseDouble(parts[1].trim());
                    String currency = parts[2].trim();
                    int quantity = Integer.parseInt(parts[3].trim());
                    LocalDateTime creationDateTime = LocalDateTime.parse(parts[4].trim());
                    String type = parts[5].trim();

                    //Creating Product

                    FixedPrice product = new FixedPrice(name,price,currency,quantity,creationDateTime,type);

                    //Updating the list

                    products.add(product);
                } catch (Exception e) {
                    System.err.println("Error reading line: " + line);
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + filepath);
            e.printStackTrace();

        }
     return products ;
}
}

