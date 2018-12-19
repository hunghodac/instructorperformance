/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.tdmu.baont.helper;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class FileHelper {

    public static List<String> readAllLines(String name) {
        try {
            List<String> lines = new ArrayList<String>();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(name), "UTF-8"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            bufferedReader.close();
            return lines;
        } catch (Exception ex) {
            Logger.getLogger(FileHelper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static boolean writeAllLines(String name, List<String> lines)
    {
        try {
            PrintWriter printWriter = new PrintWriter(name, "UTF-8");
            for(String line : lines)
                printWriter.println(line);
            printWriter.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(FileHelper.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
