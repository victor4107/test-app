package org.e4x.mit21.dm2020MIT21;

import java.util.ArrayList;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExamSampleApplication implements CommandLineRunner {

    @Autowired
    TableSampleRepository tableSampleRepository;

    public static void main(String[] args) {
        SpringApplication.run(ExamSampleApplication.class, args);
    }

    @Transactional
    @Override
    public void run(String... arg0) throws Exception {
        System.out.println("Begin");

        String fileName = "data/exam_var13.csv";

        ArrayList<TableSample> dataPopulating
                = CSVParsing.loadData(fileName);

        for (TableSample newRow : dataPopulating) {

            tableSampleRepository.save(newRow);
        }
        
        System.out.println(tableSampleRepository.findAll());
        System.out.println("End");
    }

}
