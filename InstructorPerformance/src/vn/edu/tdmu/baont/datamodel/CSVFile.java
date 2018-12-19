/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.tdmu.baont.datamodel;

import java.util.List;
import vn.edu.tdmu.baont.helper.FileHelper;

/**
 *
 * @author User
 */
public class CSVFile {

    private String name;
    private List<String> lines;

    public CSVFile() {
    }

    public CSVFile(String name) {
        this.name = name;
    }

    public CSVFile(String name, List<String> lines) {
        this.name = name;
        this.lines = lines;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public boolean readFromDisk() {
        this.lines = FileHelper.readAllLines(name);
        return (lines != null);
    }

    public boolean writeToDisk() {
        return FileHelper.writeAllLines(name, lines);
    }
}
