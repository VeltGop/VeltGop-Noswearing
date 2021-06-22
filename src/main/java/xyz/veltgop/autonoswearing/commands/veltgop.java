package xyz.veltgop.autonoswearing.commands;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import xyz.veltgop.autonoswearing.Autonoswearing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class veltgop implements CommandExecutor{
    Plugin plugin = Autonoswearing.getPlugin(Autonoswearing.class);

public veltgop() {
        }

public boolean onCommand(CommandSender Sender, Command command, String s, String[] args) {
        if (Sender instanceof Player) {
        Player player = (Player)Sender;

                String version = "1.0.0";
                String httplianjie = "http://www.veltgop.xyz/api/v2/plugins/veltgop/noswearing/version/?uuid=B4228BE4-6AE3-8A12-5453-5A11CF6AB8A5";
                if (player.hasPermission("veltgop.admin")){
                        try {
                                //创建一个url对象来指向要采集信息的网址
                                URL url = new URL(httplianjie);
                                //将读取到的字节转化为字符
                                InputStreamReader inStrRead = new InputStreamReader(url.openStream(),"utf-8");
                                //读取InputStreamReader转化成的字符
                                BufferedReader bufRead = new BufferedReader(inStrRead);
                                //读到的内容不为空
                                while (bufRead.readLine() != null) {
                                        if (bufRead.readLine() == version){
                                                player.sendMessage("您好！管理员" + player.getPlayer() + "!您的VeltgopNoSwearing版本已为最新版！");
                                        } else {
                                                player.sendMessage("您好！管理员" + player.getPlayer() + "!您的VeltgopNoSwearing版本不是最新版！请更新插件！");
                                                player.sendMessage("插件下载地址: http://www.veltgop.xyz/download/veltgop/noswearing/" + bufRead.readLine() + ".jar");
                                        }
                                }
                                bufRead.close();
                        } catch (IOException e) {
                                e.printStackTrace();
                        }

                }
        if (args[0].equalsIgnoreCase("help")) {
        player.sendMessage("§a/sm 检查更新");
        player.sendMessage("§a/sm reload重载配置");
        }

        if (args[0].equalsIgnoreCase("reload")) {
        player.sendMessage("重载中...");
        Plugin plugin = Autonoswearing.getPlugin(Autonoswearing.class);
        Autonoswearing.Main.reloadConfig();
        }

        player.sendMessage("[MengAntiSwearing]重载完毕！");
        return true;
        } else {
        System.out.println("该指令只能由玩家执行!");
        return false;
        }
        }
        }