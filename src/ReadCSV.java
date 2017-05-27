import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aawesh on 5/26/17.
 */
public class ReadCSV {

    private String path;
    private String delimeter = ",";
    private String line = "";

    private Map<String, ArrayList<String>> dataMap = new HashMap<String, ArrayList<String>>();

    private String time = "time";
    private String breathingRate = "breathingRate";
    private String minuteVentilation = "minuteVentilation";
    private String sleepPosition = "sleepPosition";
    private String activity = "activity";
    private String heartRate = "heartRate";
    private String cadence = "cadence";

    private ArrayList<String> timeList = new ArrayList<String>();
    private ArrayList<String> breathingRateList = new ArrayList<String>();
    private ArrayList<String> minuteVentilationList = new ArrayList<String>();
    private ArrayList<String> sleepPositionList = new ArrayList<String>();
    private ArrayList<String> activityList = new ArrayList<String>();
    private ArrayList<String> heartRateList = new ArrayList<String>();
    private ArrayList<String> cadenceList = new ArrayList<String>();

    public ReadCSV(String path){
        this.path = path;
    }

    public Map<String, ArrayList<String>> parse(){
        boolean header = true;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            System.out.println("path = " + path);
            System.out.println("delimeter = " + delimeter);
            System.out.println("line = " + line);

            while ((line = br.readLine()) != null) {
                if(header){
                    header = false;
                }else{
                    // use comma as separator
                    String[] data = line.split(delimeter);
                    System.out.println("data = " + data[3]);

                    timeList.add(ifNull(data[0]));
                    breathingRateList.add(ifNull(data[1]));
                    minuteVentilationList.add(ifNull(data[2]));
//                    sleepPositionList.add(ifNull(data[3]));
//                    activityList.add(ifNull(data[4]));
//                    heartRateList.add(ifNull(data[5]));
//                    cadenceList.add(ifNull(data[6]));

                    System.out.println("data[0] = " + data[0]);
                    System.out.println("data[1] = " + data[1]);
                    System.out.println("data[2] = " + data[2]);
//                    System.out.println("data[3] = " + data[3]);
//                    System.out.println("data[4] = " + data[4]);
//                    System.out.println("data[5] = " + data[5]);
//                    System.out.println("data[6] = " + data[6]);
                }
            }
            dataMap.put(time,timeList);
            dataMap.put(breathingRate,breathingRateList);
            dataMap.put(minuteVentilation,minuteVentilationList);
//            dataMap.put(sleepPosition,sleepPositionList);
//            dataMap.put(activity,activityList);
//            dataMap.put(heartRate,heartRateList);
//            dataMap.put(cadence,cadenceList);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataMap;
    }

    public static String ifNull(String data){
        if(data == null){
            return "";
        }else{
            return data;
        }
    }
}
