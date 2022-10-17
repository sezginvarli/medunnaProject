package utilities;

import pojos.Registrant;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class TXTWriter {
    public static void saveUiRegistrantsData(Registrant registrant) {

        try {
            FileWriter fw = new FileWriter(ConfigReader.getProperty("applicant_data"), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append(registrant.toString() + "\n");
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveUiRegistrantsData(Registrant[] registrants) {

        try {
            FileWriter fw = new FileWriter(ConfigReader.getProperty("applicants_api_data"), true);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < registrants.length; i++) {
                bw.append(registrants[i].toString() + "\n");
            }
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void savePhysiciansData(Physicians[] physiciansApi) {
        try {
            FileWriter fw = new FileWriter(ConfigReader.getProperty("physicians_api_data"), false);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < physiciansApi.length; i++) {
                bw.append(physiciansApi[i].toString() + "\n");
            }
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
