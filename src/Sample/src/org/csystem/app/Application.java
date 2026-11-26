package org.csystem.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Application {
    public static void run(String[] args)
    {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedWriter bwErr = new BufferedWriter(new OutputStreamWriter(System.err));) {
            while (true) {
                bw.write("Input text:");
                bw.flush();
                String line = br.readLine();

                if (line == null) {
                    bwErr.write("Input was terminated!...");
                    bwErr.newLine();
                    bwErr.flush();
                    break;
                }

                if (line.equals("exit"))
                    break;

                bw.write(line.toUpperCase());
                bw.newLine();
                bw.flush();
            }
        }
        catch (Exception e) {
           System.err.printf("Error occurred:%s%n",  e.getMessage());
        }
    }
}