package me.moteloff.realisticexplosion;

import me.moteloff.realisticexplosion.listeners.DefaultListeners;
import me.moteloff.realisticexplosion.listeners.PhysicListener;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new DefaultListeners(), this);
        getServer().getPluginManager().registerEvents(new PhysicListener(this), this);

    }
}
