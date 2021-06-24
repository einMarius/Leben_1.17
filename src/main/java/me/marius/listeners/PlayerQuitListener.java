package me.marius.listeners;

import me.marius.main.Main;
import me.marius.utils.SleepDelayChecker;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    private Main plugin;
    private SleepDelayChecker sleepDelayChecker;

    public PlayerQuitListener(Main plugin){
        this.plugin = plugin;
        this.sleepDelayChecker = new SleepDelayChecker(plugin.BED_ENTER_DELAY);
    }

    @EventHandler
    public void onServerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        sleepDelayChecker.logOutEvent(player.getUniqueId());
    }

}
