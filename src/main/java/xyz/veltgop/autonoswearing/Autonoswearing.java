package xyz.veltgop.autonoswearing;

import org.bukkit.plugin.java.JavaPlugin;

public final class Autonoswearing extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("[VeltgopAutoNoSwearing]言语管理插件加载成功");
        getLogger().info("[VeltgopAutoNoSwearing]本插件由Veltgop工作室开发，官网:http://www.veltgop.xyz");
        //加载成功输出到控制台

    }

    @Override
    public void onDisable() {
        getLogger().info("[VeltgopAutoNoSwearing]言语管理插件已安全卸载");
        this.saveConfig();
        getLogger().info("[VeltgopAutoNoSwearing]插件配置已保存！数据已保存！");
    }
}
