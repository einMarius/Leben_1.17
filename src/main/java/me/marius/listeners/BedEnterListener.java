package me.marius.listeners;

import me.marius.main.Main;
import me.marius.utils.SleepDelayChecker;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class BedEnterListener implements Listener {

    private Main plugin;
    private SleepDelayChecker sleepDelayChecker;

    public BedEnterListener(Main plugin) {
        this.plugin = plugin;
        this.sleepDelayChecker = new SleepDelayChecker(plugin.BED_ENTER_DELAY);
    }

    @EventHandler
    public void onBedEnter(PlayerBedEnterEvent event){
        Player player = event.getPlayer();

        if(event.isCancelled() || event.getBedEnterResult() != PlayerBedEnterEvent.BedEnterResult.OK)
            return;

        Bukkit.broadcastMessage(plugin.prefix + "Überspringe die Nacht...");
        Bukkit.getServer().getScheduler().runTaskLater(this.plugin, new Runnable() {
            @Override
            public void run() {
                if (player.isSleeping()) {
                    sleepDelayChecker.bedEnterEvent(player.getUniqueId());
                    player.getWorld().setTime(0L);
                    player.getWorld().setStorm(false);
                    player.getWorld().setThundering(false);
                    Bukkit.broadcastMessage(plugin.prefix + "Die Nacht wurde übersprungen!");
                }
            }
        }, 100L);
    }
}
