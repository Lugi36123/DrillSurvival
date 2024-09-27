package test02.drillsurvival

import net.minecraft.server.Main
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import test02.drillsurvival.commands.*
import test02.drillsurvival.event.*

class DrillSurvival : JavaPlugin() {

    companion object{
    }

    override fun onEnable() {
        // Plugin startup logic
        logger.info("Enable DrillSurvival")
        getServer().getPluginManager().registerEvents(RightClickOnDrill(), this)
        getServer().getPluginCommand("무기획득")?.setExecutor(WeaponCommands())
    }

    override fun onDisable() {
        // Plugin shutdown logic
        logger.info("Disable DrillSurvival")
    }


}
