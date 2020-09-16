/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.e4x.mit21.dm2020MIT21;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.util.ResourceUtils;


public  class CSVParsing {

    
    public static ArrayList<TableSample> loadData(String fileName) throws IOException {
        ArrayList<TableSample> result = new ArrayList<>();
       
        Reader in = null;

        try {
            File file = ResourceUtils.getFile("classpath:"+fileName);
            in = new FileReader(file);
            Iterable<CSVRecord> records = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(in);

            for (CSVRecord record : records) {

                TableSample tableRow = new TableSample(record.get(0).trim(),record.get(1).trim(),
                        record.get(2).trim());
                result.add(tableRow);
                //System.out.println(movie);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSVParsing.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(CSVParsing.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;

    }

}
