package com.cosine.customwarp.gui

import com.cosine.customwarp.util.Bag
import kr.msleague.msgui.gui.MSGui
import kr.msleague.msgui.gui.button.builder.MSGuiButtonBuilder
import kr.msleague.util.extensions.addNBTTagCompound
import kr.msleague.util.extensions.getNBTTagCompound
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.inventory.ItemStack

class Gui(player: Player, item: ItemStack, bag: Bag = item.getNBTTagCompound(Bag::class.java)!!) : MSGui<Any>(player, bag.slot, "가방", false, item, bag) {

    private lateinit var item: ItemStack
    private lateinit var bag: Bag

    override fun prevInit() {
        item = getObject(0)!! as ItemStack
        bag = getObject(1)!! as Bag
    }
    override fun init() {
        inventory.contents = bag.getItem()
        MSGuiButtonBuilder("d0fabe9006ae6c191c1903abc95924ca0a1ee46b18d466d17167775f1d35fa65").setDisplayName("1").setAction {
            it.whoClicked
        }.build().setSlot(this, 1)
    }

    override fun guiClick(event: InventoryClickEvent) {
        super.guiClick(event)
        if (event.click.isKeyboardClick && inventory.getItem(event.hotbarButton).isSimilar(item)) event.isCancelled = true
        else if(event.currentItem?.isSimilar(item) == true) event.isCancelled = true
    }

    override fun guiClose(event: InventoryCloseEvent) {
        super.guiClose(event)
        bag.setItem(inventory.contents)
        item.itemMeta = item.addNBTTagCompound(bag).itemMeta
    }

    fun aa() {
        MSGuiButtonBuilder("d0fabe9006ae6c191c1903abc95924ca0a1ee46b18d466d17167775f1d35fa65").setDisplayName("1").build().setSlot(this, 1)
    }
}