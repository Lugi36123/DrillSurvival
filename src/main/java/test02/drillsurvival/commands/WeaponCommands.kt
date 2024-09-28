package test02.drillsurvival.commands

import com.google.common.collect.Multimap
import org.bukkit.Material
import org.bukkit.attribute.Attributable
import org.bukkit.attribute.Attribute
import org.bukkit.attribute.AttributeModifier
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.plugin.java.JavaPlugin
import java.util.Arrays
import java.util.UUID
import kotlin.uuid.Uuid

private val stack = ItemStack(Material.AIR)
private var meta: ItemMeta? = null

class WeaponCommands: CommandExecutor{
    override fun onCommand(p0: CommandSender, p1: Command, p2: String, p3: Array<out String?>): Boolean {
        val p = p0 as Player

        val asdasd = AttributeModifier(
            UUID.randomUUID(), "damage", -1.0,
            AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND
        )
        val asdasda = AttributeModifier(
            UUID.randomUUID(), "damage", 1000.0,
            AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND
        )

        stack.type = Material.DIAMOND_SWORD
        meta = stack.itemMeta
        meta?.setDisplayName("§e드릴")
        meta?.lore = Arrays.asList("§f앞에 있는 모든 것을 갈아버리는 드릴",
            "/무기획득 또는 /weapon으로 획득할수 있다.")
        meta?.setCustomModelData(1)
        meta?.isUnbreakable = true
        meta?.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, asdasd)
        meta?.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, asdasda)
        meta?.addItemFlags(ItemFlag.HIDE_UNBREAKABLE)
        meta?.addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
        stack.itemMeta = meta
        stack.amount = 1

        p.inventory.addItem(stack)

        return false
    }
}