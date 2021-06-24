package me.marius.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SleepDelayChecker {

    private final Map<UUID, Long> sleepList;    // Zeichnet auf, wann ein Spieler zuletzt schlafen gegangen ist
    private final int bedEnterDelay;           // Die Verzögerung zwischen den Versuchen zu schlafen


    public SleepDelayChecker(int bedEnterDelay) {
        this.bedEnterDelay = bedEnterDelay;

        sleepList = new HashMap<>();
    }


    public long whenCanPlayerSleep(UUID uuid) {
        if ( ! sleepList.containsKey(uuid))
            return 0L;

        long currentTime = System.currentTimeMillis() / 1000L;
        long deltaTime = currentTime - sleepList.get(uuid);

        if(deltaTime < bedEnterDelay) {
            return (long) bedEnterDelay - deltaTime;
        }

        return 0L;
    }



    public void bedEnterEvent(UUID uuid) {
        long currentTime = System.currentTimeMillis() / 1000L;
        sleepList.put(uuid, currentTime);
    }

    public void logOutEvent(UUID uuid) {
        sleepList.remove(uuid);
    }

}
