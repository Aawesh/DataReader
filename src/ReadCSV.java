import sun.rmi.runtime.Log;

import java.io.BufferedReader;
import java.io.File;
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

    private String filePath;
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

    public ReadCSV(String filename){
        String absolutePath = new File("").getAbsolutePath();
        this.filePath = absolutePath.substring(0,absolutePath.lastIndexOf("/")+1) + "raw/" + filename;
    }

    public Map<String, ArrayList<String>> parse(){
        boolean header = true;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            //TODO Remove debugs
            System.out.println("path = " + filePath);
            System.out.println("delimeter = " + delimeter);
            System.out.println("line = " + line);

            while ((line = br.readLine()) != null) {
                if(header){
                    header = false;
                }else{
                    // use comma as separator
                    String[] data = line.split(delimeter);
                    if(data.length == 7){
                        timeList.add(ifNull(data[0]));
                        breathingRateList.add(ifNull(data[1]));
                        minuteVentilationList.add(ifNull(data[2]));
                        sleepPositionList.add(ifNull(data[3]));
                        activityList.add(ifNull(data[4]));
                        heartRateList.add(ifNull(data[5]));
                        cadenceList.add(ifNull(data[6]));
/*
                        System.out.println("data[0] = " + ifNull(data[0]));
                        System.out.println("data[1] = " + ifNull(data[1]));
                        System.out.println("data[2] = " + ifNull(data[2]));
                        System.out.println("data[3] = " + ifNull(data[3]));
                        System.out.println("data[4] = " + ifNull(data[4]));
                        System.out.println("data[5] = " + ifNull(data[5]));
                        System.out.println("data[6] = " + ifNull(data[6]));*/
                    }else{
                        //TODO LOG the error
                        System.out.println("error: BAD DATA");
                    }

                }
            }
            dataMap.put(time,timeList);
            dataMap.put(breathingRate,breathingRateList);
            dataMap.put(minuteVentilation,minuteVentilationList);
            dataMap.put(sleepPosition,sleepPositionList);
            dataMap.put(activity,activityList);
            dataMap.put(heartRate,heartRateList);
            dataMap.put(cadence,cadenceList);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataMap;
    }

    public static String ifNull(String data){
        if(data == null || data.equals("") || data.equals("nan")){
            return "0";
        }else{
            return data;
        }
    }
}
