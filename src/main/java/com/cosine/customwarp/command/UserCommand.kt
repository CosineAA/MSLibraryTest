package com.cosine.customwarp.command

import com.cosine.customwarp.util.Bag
import kr.msleague.util.extensions.addNBTTagCompound
import kr.msleague.util.extensions.percent
import kr.msleague.util.locale.l10nDisplayName
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
    fun aaa(player: Player) {
        player.inventory.itemInMainHand.apply {
            player.sendMessage(l10nDisplayName)
        }
        if (30.0.percent()) {
            player.sendMessage("성공")
        } else {
            player.sendMessage("실패")
        }
    }
}