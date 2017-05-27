import java.io.File;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by aawesh on 5/26/17.
 */
public class App {

    public static void main(String[] args){
        String filename = "record-125077.csv";// TODO read multiple files ?

        String time = "time";
        String breathingRate = "breathingRate";
        String minuteVentilation = "minuteVentilation";
        String sleepPosition = "sleepPosition";
        String activity = "activity";
        String heartRate = "heartRate";
        String cadence = "cadence";

        Map<String, ArrayList<String>> dataMap;

        ReadCSV readCSV = new ReadCSV(filename);
        dataMap = readCSV.parse();

        //TODO remove debugs
        System.out.println("dataMap.keySet() = " + dataMap.keySet());
        System.out.println("time = " + dataMap.get(time));
        System.out.println("breathing rate = " + dataMap.get(breathingRate));
        System.out.println("minuteVentilation = " + dataMap.get(minuteVentilation));
        System.out.println("sleepPosition = " + dataMap.get(sleepPosition));
        System.out.println("activity = " + dataMap.get(activity));
        System.out.println("heart rate = " + dataMap.get(heartRate));
        System.out.println("cadence = " + dataMap.get(cadence));

        runAlgorithm();
    }

    private static void runAlgorithm() {
        System.out.println("------------We have raw data--------------");
        System.out.println("------------Algorithm runs here--------------");
    }
}
