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

        System.out.println("breathing rate = " + dataMap.get(breathingRate));
        System.out.println("minute variation= " + dataMap.get(minuteVentilation));


    }
}
