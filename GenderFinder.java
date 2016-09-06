import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.IOException;


public class GenderFinder {

    public static void main(String[] args) {
        try {
            BufferedReader br = null;
            br = new BufferedReader(new FileReader("C:/Users/Nipun/faculty_salaries.csv"));
            FileWriter writer = new FileWriter("faculty_salaries_with_gender.csv");
            String line = "";
            String cvsSplitBy = ",";
            String myKey = ""; // Removed GenderAPI Key due to open-sourcing

            while ((line = br.readLine()) != null) {
                String faculty_name = line.split(cvsSplitBy)[0];
                URL url = new URL("https://gender-api.com/get?key=" + myKey + "&name=" + faculty_name);
                writer.append(faculty_name);
                writer.append(',');
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("Error: " + conn.getResponseCode());
                }
                InputStreamReader input = new InputStreamReader(conn.getInputStream());
                BufferedReader reader = new BufferedReader(input);
                String result = reader.readLine();
                writer.append(result);
                writer.append('\n');
                writer.flush();
                conn.disconnect();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
