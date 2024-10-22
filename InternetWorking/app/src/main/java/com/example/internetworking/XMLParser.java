package com.example.internetworking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;

public class XMLParser {

    public String getXmlFromUrl(String urlString) {
        StringBuilder xml = new StringBuilder();

        try {
            // Tạo đối tượng URL và HttpURLConnection
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Thiết lập phương thức kết nối GET
            connection.setRequestMethod("GET");

            // Đọc dữ liệu từ InputStream
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                xml.append(line);
            }

            reader.close();
            connection.disconnect();  // Ngắt kết nối sau khi hoàn tất

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Trả về chuỗi XML
        return xml.toString();
    }
}
