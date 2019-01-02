/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication56;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONArray;




/**
 *
 * @author bharadwaj
 */
public class JavaApplication56 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException  {
        // TODO code application logic here
        String bank_names_json=readFile(System.getProperty("user.home")+"/Desktop/banknames.json");
        JSONObject jsonObj=new JSONObject(bank_names_json);
        
        
        
        
        JSONArray keys = jsonObj.names ();
         
        JSONObject jbObj=new JSONObject();
        for (int i = 0; i < 1; ++i) 
        {
           JSONArray states_array=new JSONArray();
            
           String key = keys.getString (i); // Here's your key
           String value = jsonObj.getString (key); // Here's your value
           File check_existance=new File(System.getProperty("user.home")+"/Desktop/by-bank/"+"TNSC"+".json");
           if(check_existance.exists() && !check_existance.isDirectory()) 
           { 
                String bank_details_json=readFile(System.getProperty("user.home")+"/Desktop/by-bank/"+"TNSC"+".json");
                JSONObject bank_details_obj=new JSONObject(bank_details_json);
                JSONArray bank_details_arr=bank_details_obj.names();
                
                for(int j=0;j<bank_details_arr.length();j++)
                //for(int j=0;j<1;j++)
                {
                    String bank_det_inner=bank_details_arr.get(j).toString();
                    JSONObject params = bank_details_obj.getJSONObject(bank_det_inner);
                    
                    //System.out.println(params);
                    if(jbObj.has(params.get("STATE").toString()))
                    {
                        JSONArray details_already_there=jbObj.getJSONArray(params.get("STATE").toString());
                        
                        JSONObject details_state_wise=new JSONObject();
                        //details_state_wise.put("IFSC", params.get("IFSC"));
//                        details_state_wise.put("DISTRICT", params.get("DISTRICT"));
//                        details_state_wise.put("BRANCH", params.get("BRANCH"));
                        details_state_wise.put("STATE", params.get("STATE"));
                        details_already_there.put(details_state_wise);
                        jbObj.put(params.get("STATE").toString(), details_already_there);
                    }
                    else
                    {
                        JSONArray details_already_there=new JSONArray();
                        JSONObject details_state_wise=new JSONObject();
                        //details_state_wise.put("IFSC", params.get("IFSC"));
//                        details_state_wise.put("DISTRICT", params.get("DISTRICT"));
//                        details_state_wise.put("BRANCH", params.get("BRANCH"));
                        details_state_wise.put("STATE", params.get("STATE"));
                        details_already_there.put(details_state_wise);
                        jbObj.put(params.get("STATE").toString(), details_already_there);
                    }   
                }
               
               
                writeFile(jbObj.get("TAMIL NADU").toString());
           }
           else
           {
               System.out.println(i);
           }
        }
       
        String file_Names="APBL.json,KCCB.json,AJHC.json,CLBL.json,BNSB.json,RSBL.json,FINO.json,UTIB.json,BARA.json,BOTM.json,SIBL.json,SAHE.json,SPCB.json,KNSB.json,DLXB.json,MAHB.json,VASJ.json,SABR.json,EBIL.json,IBKO.json,FDRL.json,SUTB.json,MSHQ.json,KVBL.json,IBBK.json,PUNB.json,SDCB.json,MUBL.json,NGSB.json,ABPB.json,DEOB.json,BKDN.json,RRBP.json,HVBK.json,ZSBL.json,NVNM.json,BACB.json,UBIN.json,CTBA.json,MCBL.json,SRCB.json,HPSC.json,GDCB.json,NBAD.json,OIBA.json,RATN.json,DOHB.json,PSIB.json,DCBL.json,JAKA.json,JSFB.json,TJSB.json,WBSC.json,RBIS.json,NKGS.json,VVSB.json,KANG.json,VARA.json,TSAB.json,DBSS.json,KUCB.json,SKSB.json,MVCB.json,KRTH.json,ZCBL.json,DICG.json,LAVB.json,FIRN.json,SVCB.json,ITBL.json,SYNB.json,YESB.json,SUNB.json,JJSB.json,NOSC.json,TBSB.json,SCBL.json,APMC.json,HSBC.json,KACE.json,NSPB.json,BDBL.json,JANA.json,ORBC.json,JSBP.json,KAIJ.json,CNRB.json,SBLS.json,KSCB.json,GGBK.json,MHCB.json,TNSC.json,CHAS.json,CRES.json,MDCB.json,CRUB.json,AMCB.json,GBCB.json,CBIN.json,UJVN.json,STCB.json,AUCB.json,IDIB.json,KJSB.json,APGV.json,CTCB.json,ICIC.json,ICBK.json,ABNA.json,SMBC.json,ADCB.json,ESFB.json,QNBA.json,SVSH.json,ABHY.json,TDCB.json,UTKS.json,HARC.json,INDB.json,KCBL.json,SOGE.json,SBIN.json,GSCB.json,JASB.json,KKBK.json,RSCB.json,BOFA.json,ESMF.json,UOVB.json,KLGB.json,CORP.json,MSNU.json,DLSC.json,BCBM.json,AIRP.json,NICB.json,PMEC.json,SJSB.json,RABO.json,CSBK.json,DNSB.json,PYTM.json,BBKM.json,KVGB.json,ASBL.json,ANDB.json,CCBL.json,ALLA.json,COSB.json,PUCB.json,NESF.json,APGB.json,MAHG.json,DEUT.json,MSCI.json,AKJB.json,ADCC.json,PMCB.json,BNPA.json,IDUK.json,CRLY.json,NATA.json,KDCB.json,ANZB.json,IPOS.json,SVBL.json,DMKJ.json,BARC.json,NUCB.json,HDFC.json,IOBA.json,IDFB.json,SIDC.json,NMCB.json,THRS.json,TGMB.json,KOEX.json,VSBL.json,PRTH.json,CIUB.json,UCBA.json,FSFB.json,NTBL.json,JSBL.json,PKGB.json,HCBL.json,TTCB.json,BCEY.json,IBKL.json,SMCB.json,NNSB.json,NBRD.json,SURY.json,KARB.json,VIJB.json,JIOP.json,NMGB.json,PJSB.json,BKID.json,AUBL.json,SIDB.json,WPAC.json,JPCB.json,UTBI.json,CITI.json,RNSB.json,BARB.json,SHBK.json,EIBI.json,TMBL.json,DURG.json";
        String[] file_nam=file_Names.split(",");
        for(String bank_file:file_nam)
        {
            //System.out.println(bank_file);
        }
    }
    public static void writeFile(String message)
    {
        BufferedWriter bw = null;
                    FileWriter fw = null;

                   try
                   {
                      
                       new File(System.getProperty("user.home")+"/Desktop/gest").mkdir();
                       String file_name=System.getProperty("user.home")+"/Desktop/gest/twii.json";
                       File file=new File(file_name);
                       
                       boolean fvar = file.createNewFile();

                       fw = new FileWriter(file_name);
			bw = new BufferedWriter(fw);
			bw.write(message);
                   }
                   catch (Exception ex)
                   {
                       ex.printStackTrace();
                   }
                    finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
                   }
    }
    public static String readFile(String fileName) throws IOException 
    {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }
}
