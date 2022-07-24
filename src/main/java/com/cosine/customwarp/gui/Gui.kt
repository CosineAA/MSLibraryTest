package com.cosine.customwarp.gui

import kr.msleague.msgui.gui.MSGui
import kr.msleague.msgui.gui.button.builder.MSGuiButtonBuilder
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.entity.Player

class Gui(player: Player) : MSGui<Unit>(player, 27, "첵스", true) {

    override fun init() {
        MSGuiButtonBuilder(Material.STAINED_GLASS_PANE, 15).setDisplayName("§f").setAction {
            val player: Player = it.whoClicked as Player
            player.playSound(player.location, Sound.UI_BUTTON_CLICK, 1F, 1F)
        }.build().setSlot(this, 0 until 27)
    }
}