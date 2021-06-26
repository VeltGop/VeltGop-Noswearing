package xyz.veltgop.autonoswearing;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.veltgop.autonoswearing.commands.veltgop;
import xyz.veltgop.autonoswearing.events.adminjoin;
import xyz.veltgop.autonoswearing.events.automute;
import xyz.veltgop.autonoswearing.events.linstenrchat;

import java.util.Objects;

public final class Autonoswearing extends JavaPlugin {
    public static Autonoswearing Main;
    public static String notice;

    public Autonoswearing() {
        Main = this;
    }
    @Override
    public void onEnable() {
        getLogger().info("[VeltgopAutoNoSwearing]言语管理插件加载成功");
        getLogger().info("[VeltgopAutoNoSwearing]本插件由Veltgop工作室开发，官网:http://www.veltgop.xyz");
        //加载成功输出到控制台
        this.getConfig().options().copyDefaults();
        this.saveDefaultConfig();//重置插件配置
        this.getServer().getPluginManager().registerEvents(new adminjoin(), this);
        this.getServer().getPluginManager().registerEvents(new linstenrchat(), this);
        this.getServer().getPluginManager().registerEvents(new automute(), this);
        this.getCommand("sm").setExecutor(new veltgop());
        Objects.requireNonNull(Bukkit.getPluginCommand("vmc")).setTabCompleter(new TabHeader());


    }

    @Override
    public void onDisable() {
        getLogger().info("[VeltgopAutoNoSwearing]言语管理插件已安全卸载");

        getLogger().info("[VeltgopAutoNoSwearing]插件配置已保存！数据已保存！");
    }
}
