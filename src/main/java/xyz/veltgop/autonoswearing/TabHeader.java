package xyz.veltgop.autonoswearing;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.*;

public class TabHeader implements TabCompleter {


    @Override

    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 1) {
        List<String> list = new ArrayList<>();
        list.add("reload");
        list.add("help");
        return list;
        }
            return null;




    }
        }
