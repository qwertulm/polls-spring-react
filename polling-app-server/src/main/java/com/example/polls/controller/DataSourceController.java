package com.example.polls.controller;

import com.example.polls.model.TestEntity;
import com.example.polls.repository.TestEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rajeevkumarsingh on 20/11/17.
 */

@RestController
public class DataSourceController {

    @Autowired
    private TestEntityRepository repository;

    @RequestMapping(value = "/remote-data/read",  params = {"$callback", "$inlinecount", "$format", "$top"},    produces = MediaType.APPLICATION_JSON_VALUE)
    public String read(
            @RequestParam(value = "$callback") String callback,
            @RequestParam(value = "$inlinecount") String inlinecount,
            @RequestParam(value = "$format") String format,
            @RequestParam(value = "$top") String top
                       ) {
        return callback + "({\n" +
                "  \"d\" : {\n" +
                "    \"results\": [\n" +
                "      {\n" +
                "        \"OrderID\": 10268,\n" +
                "        \"EmployeeID\": 8,\n" +
                "        \"OrderDate\": \"\\/Date(838684800000)\\/\",\n" +
                "        \"RequiredDate\": \"\\/Date(841104000000)\\/\",\n" +
                "        \"ShippedDate\": \"\\/Date(838944000000)\\/\",\n" +
                "        \"ShipVia\": 3,\n" +
                "        \"Freight\": \"66.29\"\n" +
                "      },{\n" +
                "        \"OrderID\": 10268,\n" +
                "        \"EmployeeID\": 8,\n" +
                "        \"OrderDate\": \"\\/Date(838684800000)\\/\",\n" +
                "        \"RequiredDate\": \"\\/Date(841104000000)\\/\",\n" +
                "        \"ShippedDate\": \"\\/Date(838944000000)\\/\",\n" +
                "        \"ShipVia\": 3,\n" +
                "        \"Freight\": \"66.29\"\n" +
                "      }\n" +
                "    ], \"__count\": \"830\"\n" +
                "  }\n" +
                "})" + repository.findAll();
    }

}
