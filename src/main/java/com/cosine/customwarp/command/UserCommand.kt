package com.cosine.customwarp.command

import com.cosine.customwarp.gui.Gui
import com.cosine.customwarp.util.Bag
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
                itemMeta = addNBTTagCompound(Bag(27)).itemMeta
            }
            return false
        }
        return false
    }
}