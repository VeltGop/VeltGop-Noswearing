package xyz.veltgop.autonoswearing.events;

import me.leoko.advancedban.bukkit.BukkitMain;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;
import xyz.veltgop.autonoswearing.Autonoswearing;

public class automute implements Listener {
    Plugin plugin = Autonoswearing.getPlugin(Autonoswearing.class);
    public void automute(AsyncPlayerChatEvent event){


        Player player = (Player) event.getPlayer();

        if (player.hasPermission("veltgop.muted")){
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("MutedMessage")));

        }
    }
}
