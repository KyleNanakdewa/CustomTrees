package com.kylenanakdewa.bettertrees;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

/**
 * Command to generate a tree or forest, where the sender is looking.
 */
public class TreeCommand implements TabExecutor {

    @Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if(args.length>=1 && sender instanceof Player){
            // Use the expression to place a tree
            TreeExpression expression = new TreeExpression(args[0]);

            // Check if placing forest
            if(args.length>=2 && args[1].equalsIgnoreCase("forest")){
                sender.sendMessage(BetterTreesPlugin.errorColor+"Not yet implemented.");
                return false;
            }

            Player player = (Player)sender;

            boolean placed = expression.placeTree(player.getTargetBlock(null, BetterTreesPlugin.maxPlaceDistance).getLocation(), player);

            if(!placed) sender.sendMessage(BetterTreesPlugin.errorColor+"Tree placement failed.");
			return placed;
        }

        // Invalid command
        sender.sendMessage(BetterTreesPlugin.errorColor+"Invalid arguments.");
        return false;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        // Return nothing
        return Arrays.asList("");
    }
}