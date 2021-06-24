//This file was created in 2021

package me.marius.main;

import me.marius.listeners.BedEnterListener;
import me.marius.listeners.PhantomHandler;
import me.marius.listeners.PlayerQuitListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public final String prefix = "§8[§cBaumbalabunga§8] §7";
    public final int BED_ENTER_DELAY = 10;

    private PluginDescriptionFile pdf = this.getDescription();

    public void onEnable() {

        //getCommand("COMMAND").setExecutor(new cmd_COMMAND());

        Bukkit.getPluginManager().registerEvents(new BedEnterListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PhantomHandler(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(this), this);

        // -------------------------------
        System.out.println("----------[Baumbalabunga]----------");
        System.out.println("Plugin aktiviert");
        System.out.println("Version: " + pdf.getVersion());
        System.out.println("Author: " + pdf.getAuthors());
        System.out.println("----------[Baumbalabunga]----------");
        // -------------------------------
    }

    public void onDisable() {

        // -------------------------------
        System.out.println("----------[Baumbalabunga]----------");
        System.out.println("Plugin deaktiviert");
        System.out.println("Version: " + pdf.getVersion());
        System.out.println("Author: " + pdf.getAuthors());
        System.out.println("----------[Baumbalabunga]----------");
        // -------------------------------

    }

}