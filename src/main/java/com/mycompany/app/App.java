package com.mycompany.app;


import com.lightstreamer.client.LightstreamerClient;


public class App {

    public static void main(final String[] args) throws InterruptedException {
        String alternateToken = "";
        String envToken = System.getenv("TOKEN");
        String token = envToken != null && !envToken.isEmpty() ? System.getenv("TOKEN") : alternateToken;

        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.190 Safari/537.36";

        LightstreamerClient client = new LightstreamerClient(
                "https://push-demo-lightstreamer.cloud.etoro.com",
                "PROXY_PUSH"
        );

        client.connectionDetails.setUser(token);
        client.connectionDetails.setPassword(userAgent);
        client.connectionOptions.setConnectTimeout("10000");

        client.connect();


        int failCount = 0;
        while (failCount < 10) {
            System.out.println(client.getStatus());
            Thread.sleep(4000);
            failCount++;
        }

    }
}




