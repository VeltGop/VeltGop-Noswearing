package xyz.veltgop.autonoswearing.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class adminjoin implements Listener {
@EventHandler
    public void adminjoin(PlayerJoinEvent event){

    Player player = event.getPlayer();
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

}
}
