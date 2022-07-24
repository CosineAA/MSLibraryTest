package com.cosine.customwarp.command

import com.cosine.customwarp.util.Bag
import kr.msleague.util.extensions.addNBTTagCompound
import kr.msleague.util.extensions.checkFunc
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
            checkFunc {
                player.inventory.itemInMainHand.apply {
                    itemMeta = addNBTTagCompound(Bag(27)).itemMeta
                }
            }.apply { // 앞에 Object
                player.sendMessage(toString())
            }
//            checkFunc {
//                player.inventory.itemInMainHand.apply {
//                    itemMeta = addNBTTagCompound(Bag(27)).itemMeta
//                }
//            }.also { test -> // 앞에 Object
//                test.toString()
//                this // 클래스
//            }
//          apply -> this, also -> this를 쓰거나 람다로 이름 지정
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