import java.util.ArrayList;
import java.util.Map;

/**
 * Created by aawesh on 5/26/17.
 */
public class App {

    public static void main(String[] args){
        String path = "/home/aawesh/IdeaProjects/raw/record-125077.csv"; //TODO Make it geeneric path

        String time = "time";
        String breathingRate = "breathingRate";
        String minuteVentilation = "minuteVentilation";
        String sleepPosition = "sleepPosition";
        String activity = "activity";
        String heartRate = "heartRate";
        String cadence = "cadence";

        Map<String, ArrayList<String>> dataMap;

        ReadCSV readCSV = new ReadCSV(path);
        dataMap = readCSV.parse();

        System.out.println("breathing rate = " + dataMap.get(breathingRate));
        System.out.println("minute variation= " + dataMap.get(minuteVentilation));
    }
}
