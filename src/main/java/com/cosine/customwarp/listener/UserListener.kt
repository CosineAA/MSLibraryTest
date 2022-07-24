package com.cosine.customwarp.listener

import com.cosine.customwarp.command.Tag
import com.cosine.customwarp.main.plugin
import kr.msleague.util.coroutine.SynchronizationContext
import kr.msleague.util.coroutine.schedule
import kr.msleague.util.extensions.getNBTTagCompound
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent

class UserListener : Listener {

    @EventHandler
    fun click(event : PlayerInteractEvent) {
        val player = event.player
        val item = player.inventory.itemInMainHand
        item.getNBTTagCompound(Tag::class.java) ?.apply {
            player.sendMessage("§6[ MS ] §f플라이 상태입니다.")
            val time = (20 * (3600 * hour)) + (20 * (60 * minute))
            plugin.schedule(SynchronizationContext.ASYNC) {
                switchContext(SynchronizationContext.SYNC)
                player.allowFlight = true
                waitFor(time.toLong())
                player.allowFlight = false
                player.sendMessage("§6[ MS ] §f플라이가 끝났습니다.")
            }
        }
    }
}