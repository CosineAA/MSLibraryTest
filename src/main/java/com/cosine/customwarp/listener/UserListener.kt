package com.cosine.customwarp.listener

import com.cosine.customwarp.gui.Gui
import com.cosine.customwarp.util.Bag
import kr.msleague.util.extensions.getNBTTagCompound
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractAtEntityEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.EquipmentSlot

class UserListener : Listener {

    @EventHandler
    fun click(event : PlayerInteractAtEntityEvent) {
        val player = event.player
        val entity = event.rightClicked as Player
        if (event.hand == EquipmentSlot.OFF_HAND) return
        val item = entity.inventory.helmet
        item.getNBTTagCompound(Bag::class.java) ?.apply {
            Gui(player, item, this)
        }
    }
    @EventHandler
    fun click(event : PlayerInteractEvent) {
        val player = event.player
        val item = player.inventory.itemInMainHand
        item.getNBTTagCompound(Bag::class.java) ?.apply {
            Gui(player, item, this)
        }
    }
}