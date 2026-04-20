package com.welcome;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.configuration.file.FileConfiguration;

public class Main extends JavaPlugin implements Listener {
    
    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("WelcomePlugin включен!");
    }
    
    @Override
    public void onDisable() {
        getLogger().info("WelcomePlugin выключен!");
    }
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        FileConfiguration config = getConfig();
        String message = config.getString("join-message", "§aДобро пожаловать, %player%!")
            .replace("%player%", event.getPlayer().getName());
        event.setJoinMessage(message);
    }
    
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        FileConfiguration config = getConfig();
        String message = config.getString("quit-message", "§eДо свидания, %player%!")
            .replace("%player%", event.getPlayer().getName());
        event.setQuitMessage(message);
    }
}
