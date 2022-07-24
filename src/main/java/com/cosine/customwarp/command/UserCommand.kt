package com.cosine.customwarp.command

import kr.msleague.util.extensions.addNBTTagCompound
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class UserCommand : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender is Player) {
            val player: Player = sender
            player.inventory.itemInMainHand.apply {
                itemMeta = addNBTTagCompound(Tag(0, 1)).itemMeta
            }
            //Gui(player)
            return false
        }
        return false
    }
}