package xyz.veltgop.autonoswearing.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;
import xyz.veltgop.autonoswearing.Autonoswearing;

import java.util.Iterator;


public class linstenrchat implements Listener {
    //监听事件
    Plugin plugin = Autonoswearing.getPlugin(Autonoswearing.class);
    //初始化插件变量
    @EventHandler
    public void linstenrchat(AsyncPlayerChatEvent event){
        //监听事件头

        Player player = (Player) event.getPlayer();//获取触发事件的玩家
        String message = event.getMessage();//获取玩家发送的消息

        for(int i = 0; i < this.plugin.getConfig().getStringList("NoWordList").size(); ++i){
            //获取违禁词列表
            if (message.contains((CharSequence)this.plugin.getConfig().getStringList("NowordList").get(i))) {
                //如果聊天内容出现列表中的词执行如下
                if (player.hasPermission("veltgop.bypass")) {
                    //检测是否有绕过权限
                    player.sendMessage("您的发言包含违禁词，但你绕过了");
                    //有则通知绕过
                } else {
                    //没有绕过权限执行以下
                    event.setCancelled(true);
                    //取消玩家发言事件
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Message")));
                    //向玩家发送配置中的消息
                    Iterator var5 = Bukkit.getServer().getOnlinePlayers().iterator();

                    }
                }
            Iterator var5 = Bukkit.getServer().getOnlinePlayers().iterator();
                    while(var5.hasNext()) {
                        Player player1 = (Player)var5.next();
                        if (player1.hasPermission("veltgop.notice")) {
                            player1.sendMessage(ChatColor.RED + "玩家" + player + "发送了违禁词");
                            //通知管理员
                        }
                    }

        }

    }


}

