package com.simpery.brokenore;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class BlockListener implements Listener {
    String broken_block;
    LocalTime CurrentTime;
    DateTimeFormatter Format = DateTimeFormatter.ofPattern("HH:mm:ss");
    @EventHandler(priority = EventPriority.HIGH)
    public void onBlockBreak (BlockBreakEvent event) {
        broken_block=event.getBlock().getType().name();
        if(broken_block.matches("MEKANISM_OSMIUM_ORE|MEKANISM_DEEPSLATE_OSMIUM_ORE|MEKANISM_URANIUM_ORE|MEKANISM_DEEPSLATE_URANIUM_ORE")){
            CurrentTime= LocalTime.now();
            System.out.println(event.getPlayer()+" broke: "+event.getBlock().getType());
            if(CurrentTime.format(Format)!=null){
                System.out.println("Location: X="+event.getBlock().getLocation().getX()+" Y="+event.getBlock().getLocation().getY()+" Z="+event.getBlock().getLocation().getZ()+" at time: "+CurrentTime.format(Format));
            }
            else{
                System.out.println("Location: X="+event.getBlock().getLocation().getX()+" Y="+event.getBlock().getLocation().getY()+" Z="+event.getBlock().getLocation().getZ());
            }
        }
        if(broken_block.matches("DIAMOND_ORE|DEEPSLATE_DIAMOND_ORE|ANCIENT_DEBRIS")){
            System.out.println(event.getPlayer()+" broke: "+event.getBlock().getType());
            if(CurrentTime.format(Format)!=null){
                System.out.println("Location: X="+event.getBlock().getLocation().getX()+" Y="+event.getBlock().getLocation().getY()+" Z="+event.getBlock().getLocation().getZ()+" at time: "+CurrentTime.format(Format));
            }
            else{
                System.out.println("Location: X="+event.getBlock().getLocation().getX()+" Y="+event.getBlock().getLocation().getY()+" Z="+event.getBlock().getLocation().getZ());
            }
        }
    }
}
