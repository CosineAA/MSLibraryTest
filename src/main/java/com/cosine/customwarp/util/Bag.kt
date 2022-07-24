package com.cosine.customwarp.util

import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Bag(
    val slot: Int,
    private var item: ByteArray = Array(slot) { ItemStack(Material.AIR) }.toByteArrayCompress()
) {
    fun setItem(items: Array<ItemStack?>) {
        item = items.toByteArrayCompress()
    }
    fun getItem(): Array<ItemStack> = item.toItemArrayDecompress()
}