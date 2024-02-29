package com.simpery.brokenore;

import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;

public final class Brokenore extends JavaPlugin{

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new BlockListener(), this);
    }

    @Override
    public void onDisable() {
        System.out.println("Bye byee");
    }
}
