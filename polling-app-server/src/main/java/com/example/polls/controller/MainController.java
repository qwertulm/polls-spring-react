package com.example.polls.controller;

import com.example.polls.repository.PollRepository;
import com.example.polls.repository.TestEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.example.polls.model.TestEntity;

/**
 * Created by rajeevkumarsingh on 20/11/17.
 */

@RestController
public class MainController {

    @Autowired
    private TestEntityRepository repository;
    
    private final static String PUBLIC_PATH = "/Users/pete/PycharmProjects/spring-security-react-ant-design-polls-app/spring-security-react-ant-design-polls-app/polling-app-client/build/";

    @RequestMapping(value = "**")
    public FileSystemResource index() {
        return new FileSystemResource(PUBLIC_PATH + "index.html");
    }


    @RequestMapping(value = "/data-source")
    public FileSystemResource dataSourceIndex() {
        return new FileSystemResource(PUBLIC_PATH + "index.html");
    }



    @GetMapping(value = "/static/media/{file_name}",produces = "image/svg+xml")
    @ResponseBody
    public FileSystemResource staticMedia(@PathVariable("file_name") String fileName) {
        return new FileSystemResource(PUBLIC_PATH + "static/media/" + fileName);
    }

    @GetMapping(value = "/html/{file_name}",produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public FileSystemResource staticHtml(@PathVariable("file_name") String fileName) {
        return new FileSystemResource(PUBLIC_PATH + "html/" + fileName);
    }

    @GetMapping(value = "/json/{file_name}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public FileSystemResource staticJson(@PathVariable("file_name") String fileName) {
        return new FileSystemResource(PUBLIC_PATH + "json/" + fileName);
    }

    @GetMapping(value = "/static/css/{file_name}",produces = MediaType.ALL_VALUE)
    @ResponseBody
    public FileSystemResource staticFileCSS(@PathVariable("file_name") String fileName) {
        return new FileSystemResource(PUBLIC_PATH + "static/css/" + fileName);
    }

    @GetMapping(value = "/static/js/{file_name}",produces = MediaType.ALL_VALUE)
    @ResponseBody
    public FileSystemResource staticFileJS(@PathVariable("file_name") String fileName) {
        return new FileSystemResource(PUBLIC_PATH + "static/js/" + fileName);
    }

    @GetMapping(value = "/public/{file_name}",produces = MediaType.ALL_VALUE)
    @ResponseBody
    public FileSystemResource publicFile(@PathVariable("file_name") String fileName) {
        return new FileSystemResource(PUBLIC_PATH + fileName);
    }

    @GetMapping(value = "/test",produces = MediaType.ALL_VALUE)
    @ResponseBody
    public String publicTest() {
        TestEntity te = new TestEntity("fjsdflkvsdl");
        repository.save(te);

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/polling");
        dataSource.setUsername("polling_app");
        dataSource.setPassword("1111");

        JdbcTemplate template = new JdbcTemplate(dataSource);
        SqlRowSet sqlRowSet = template.queryForRowSet("SELECT\n" +
                "    table_schema || '.' || table_name as column\n" +
                "FROM\n" +
                "    information_schema.tables\n" +
                "WHERE\n" +
                "    table_type = 'BASE TABLE'\n" +
                "AND\n" +
                "    table_schema NOT IN ('pg_catalog', 'information_schema');");
        String tables = "Tables in polling:\n";
        while (sqlRowSet.next()) {
            tables = tables + sqlRowSet.getString("column") + "\n";
        }
        return "{\"response\": \"" + tables + "\"}";
    }
}
