package main;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

class T {
    public static void main(String[] args) {
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        List<String> zoneList = new ArrayList<String>(zoneIds);
        Collections.sort(zoneList);
        for (String zoneId : zoneList) {
            if (zoneId.toLowerCase().contains("Baku".toLowerCase()))
                System.out.println(zoneId);
        }
    }
}