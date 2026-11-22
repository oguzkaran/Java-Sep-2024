package org.csystem.app;

import org.csystem.util.console.Console;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

class Application {
    public static RegionInfo createRegionInfo(String [] info)
    {
        String name = info[1].isBlank() ? null : info[1];
        double latitude = Double.parseDouble(info[2]);
        double longitude = Double.parseDouble(info[3]);

        return new RegionInfo(info[0], name, latitude, longitude);
    }

    public static void run(String[] args)
    {
        checkLengthEquals(1, args.length, "Wrong number of arguments");

        try (BufferedReader br = Files.newBufferedReader(Path.of(args[0]))) {
            br.readLine();

            String line;

            while ((line = br.readLine()) != null) {
                String [] info = line.split(",");

                if (info.length != 4)
                    throw new IOException("Invalid file format!...");

                RegionInfo regionInfo = createRegionInfo(info);

                Console.writeLine(regionInfo);
            }
        }
        catch (NumberFormatException ignore) {
            Console.writeErrLine("Invalid location values!...");
        }
        catch (FileNotFoundException ignore) {
            Console.writeErrLine("File not found:%s", args[0]);
        }
        catch (IOException e) {
            Console.writeErrLine("IO Error occurred:%s", e.getMessage());
        }
        catch (Exception e) {
            Console.writeErrLine("Error occurred:%s", e.getMessage());
        }
    }
}

class RegionInfo {
    private String m_id;
    private String m_regionName;
    private double m_latitude;
    private double m_longitude;

    public RegionInfo(String id, double latitude, double longitude)
    {
        this(id, null, latitude, longitude);
    }

    public RegionInfo(String id, String regionName, double latitude, double longitude)
    {
        m_id = id;
        m_regionName = regionName;
        m_latitude = latitude;
        m_longitude = longitude;
    }

    public String getId()
    {
        return m_id;
    }

    public void setId(String id)
    {
        m_id = id;
    }

    public String getRegionName()
    {
        return m_regionName;
    }

    public boolean hasRegionName()
    {
        return m_regionName != null;
    }

    public void setRegionName(String regionName)
    {
        m_regionName = regionName;
    }

    public double getLatitude()
    {
        return m_latitude;
    }

    public void setLatitude(double latitude)
    {
        m_latitude = latitude;
    }

    public double getLongitude()
    {
        return m_longitude;
    }

    public void setLongitude(double longitude)
    {
        m_longitude = longitude;
    }

    //...

    @Override
    public String toString()
    {
        return "[%s]%s(%f,%f)".formatted(m_id, m_regionName == null ? "<< UNKNOWN >>" : m_regionName, m_latitude, m_longitude);
    }
}