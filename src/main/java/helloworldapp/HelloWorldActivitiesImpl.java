package helloworldapp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class HelloWorldActivitiesImpl implements HelloWorldActivities {

    @Override
    public String composeGreeting(String name) {
        return "Hello " + name + "!";
    }

    @Override
    public String fetchDataFromApi(){
        try{
            URL url = new URL("https://api.artic.edu/api/v1/artworks");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            String coll = httpURLConnection.getRequestMethod();
            httpURLConnection.connect();

            // read the response from API
            Scanner sc = new Scanner(url.openStream());
            StringBuilder stringBuilder = new StringBuilder();
            while(sc.hasNext()){
                stringBuilder.append(sc.nextLine());
            }
            sc.close();
            return stringBuilder.toString();
        }catch (IOException e){
                throw new RuntimeException("Error fetching data from API\", e");
        }

    }
}