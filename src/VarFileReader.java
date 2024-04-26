import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VarFileReader {
    public static List<VariablePrice> read(String filepath){
        List<VariablePrice> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] parts = line.split(";");

                    //Extracting data

                    String name = parts[0].trim();
                    double minPrice = Double.parseDouble(parts[1].trim());
                    double maxPrice = Double.parseDouble(parts[2].trim());
                    String currency = parts[3].trim();
                    int quantity = Integer.parseInt(parts[4].trim());
                    LocalDateTime creationDateTime = LocalDateTime.parse(parts[5].trim());
                    String type = parts[6].trim();

                    //Creating Product

                    VariablePrice product = new VariablePrice(name,minPrice, maxPrice,currency,quantity,creationDateTime,type);


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