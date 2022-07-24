package com.cosine.customwarp.main

import com.cosine.customwarp.command.UserCommand
import com.cosine.customwarp.listener.UserListener
import org.bukkit.plugin.java.JavaPlugin

class CustomWarp : JavaPlugin() {


    override fun onEnable() {
        logger.info("커스텀 구이 플러그인 활성화")

        plugin = this

        getCommand("메뉴").executor = UserCommand()
        server.pluginManager.registerEvents(UserListener(), this)
    }

    override fun onDisable() {
        logger.info("커스텀 구이 플러그인 비활성화")
    }
}