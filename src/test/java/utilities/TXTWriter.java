package utilities;
import pojos.*;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class TXTWriter {
    public static void saveUiRegistrantsData(Registrant registrant) {

        try {
            FileWriter fw = new FileWriter(ConfigReader.getProperty("applicant_data"), false);
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

    public static void savePhysiciansData(Physician[] physiciansApi) {
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

    public static void SavePojoToFile(String filePath, Object pojoObj){
        try{
            FileWriter fw2 = new FileWriter(filePath,false);
            BufferedWriter bw = new BufferedWriter(fw2);
            bw.append(pojoObj +"\n");
            bw.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void savePasswordData(PasswordChange passwordChange){

        try {
            FileWriter fw=new FileWriter(ConfigReader.getProperty("password_data"),false);
            BufferedWriter bw=new BufferedWriter(fw);
            bw.append(passwordChange.toString()+"\n");
            bw.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void saveUiAppointmentData(Appointment appointment){

        try {
            FileWriter fw=new FileWriter(ConfigReader.getProperty("appointment_data"),true);
            BufferedWriter bw=new BufferedWriter(fw);
            bw.append(appointment.toString()+"\n");
            bw.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void saveApiTestItemsData(CTestItem[] cTestItem){

        try {
            FileWriter fw=new FileWriter(ConfigReader.getProperty("testitem_data"),true);
            BufferedWriter bw=new BufferedWriter(fw);
            bw.append(cTestItem.toString() +"\n");
            bw.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
