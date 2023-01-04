package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Scanner {
    public static void main(String[] args) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec("docker run --network host -t scanner arp 192.168.1.1/24 --json ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        List<String> lines = new ArrayList<String>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        JsonParser data = new JsonParser();
        String parsedData = data.parse(lines);
        JsonSender jsonSender = new JsonSender();
        jsonSender.send("http://192.168.1.133:5044",parsedData);

    }





}
