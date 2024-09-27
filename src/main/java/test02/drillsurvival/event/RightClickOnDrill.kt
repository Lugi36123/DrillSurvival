package test02.drillsurvival.event

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.craftbukkit.v1_20_R4.entity.CraftEntity
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractAtEntityEvent
import org.bukkit.event.player.PlayerInteractEntityEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.entity.*
import org.bukkit.craftbukkit.v1_20_R4.entity.CraftLivingEntity
import org.bukkit.damage.DamageSource
import org.bukkit.damage.DamageType
import org.bukkit.entity.Pose
import org.bukkit.profile.PlayerTextures
import java.net.URL

class RightClickOnDrill : Listener{
    @EventHandler
    fun interactEvent(e: PlayerInteractAtEntityEvent){
        var p = e.player
        var en = e.rightClicked as LivingEntity
        var i = p.itemInHand

        if (i.type == Material.DIAMOND_SWORD &&
            i.itemMeta?.customModelData == 1){

            if (en.health == 0.0){
            }else{
                en.damage(2.0, p)

                p.sendMessage(en.lastDamage.toString())



                Bukkit.getServer().worlds.forEach{world ->
                    world.spawnParticle(Particle.SQUID_INK,en.location,10)
                    world.playSound(p.location, Sound.ENTITY_EXPERIENCE_ORB_PICKUP,1f,1f)
                }

                if(p.health > 19){
                }else{
                    p.health = p.health + 1
                }
            }

        }else{
            p.sendMessage("드릴 아님")
        }
    }
}