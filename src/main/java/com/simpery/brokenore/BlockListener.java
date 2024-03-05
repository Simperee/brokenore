package com.simpery.brokenore;

import com.simpery.brokenore.DiscordHook;
import com.simpery.brokenore.DiscordHook.EmbedObject;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class BlockListener implements Listener {
    String broken_block;
    String block_coord;
    String player;
    String playerName;
    LocalTime CurrentTime;
    DateTimeFormatter Format = DateTimeFormatter.ofPattern("HH:mm:ss");
    @EventHandler(priority = EventPriority.HIGH)
    public void onBlockBreak (BlockBreakEvent event) throws IOException {
        broken_block=event.getBlock().getType().name();
        player=String.valueOf(event.getPlayer());
        playerName = player.replace("CraftPlayer{name=", "").replace("}", "");
        block_coord=("Location: X="+event.getBlock().getLocation().getX()+" Y="+event.getBlock().getLocation().getY()+" Z="+event.getBlock().getLocation().getZ());
        CurrentTime= LocalTime.now();
        if(broken_block.matches("MEKANISM_OSMIUM_ORE|MEKANISM_DEEPSLATE_OSMIUM_ORE|MEKANISM_URANIUM_ORE|MEKANISM_DEEPSLATE_URANIUM_ORE")){
            System.out.println(playerName+" broke: "+broken_block);
            if(CurrentTime.format(Format)!=null){
                System.out.println(block_coord+" at time: "+CurrentTime.format(Format));
            }
            else{
                System.out.println(block_coord);
            }
        }
        if(broken_block.matches("DIAMOND_ORE|DEEPSLATE_DIAMOND_ORE|ANCIENT_DEBRIS")){
            System.out.println(playerName+" broke: "+broken_block);
            DiscordHook webhook = new DiscordHook("https://discord.com/api/webhooks/1212802166293790800/DkVVu-zddMk1rjCJ-T2wO0hc6bJG_NG23xRfdDxQgewVOduFlE7XbHMFUDDtKElVe3N_");
            webhook.setUsername("I touch little kids");
            webhook.setAvatarUrl("https://mc-heads.net/avatar/"+playerName+".png");
            EmbedObject embed = new EmbedObject();
            embed.setTitle(playerName);
            embed.setDescription("Ore broken: "+broken_block);

            if(CurrentTime.format(Format)!=null){
                System.out.println(block_coord+" at time: "+CurrentTime.format(Format));
                embed.setFooter(CurrentTime.format(Format));
            }
            else{
                System.out.println(block_coord);
            }
            webhook.addEmbed(embed);
            webhook.execute();
        }
    }
}
