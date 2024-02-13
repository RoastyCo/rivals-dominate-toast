package net.silveros.kits.items;

import net.silveros.kits.Abilities;
import net.silveros.kits.ItemAbility;
import net.silveros.kits.ItemRegistry;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class ItemsGoblin extends Items{
    @Override
    protected void prepareFeatures() {
        generateSteal(0);
        generateGive(1);
        generateSneaky(3);
        generateSwarm(1);
    }
    @Override
    protected void prepareArmor() {
        generateGoblinChestplate();
        generateGoblinLeggings();
        generateGoblinBoots();
        ItemRegistry.SKULL_Goblin = getSkull(Skulls.GOBLIN, "Goblin Head");
    }
    private static void generateSteal(int cost) {
        ItemAbility item = getBlankAbility(cost, Abilities.STEAL);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(LIGHT_PURPLE + "Ability: Steal " + itemCost(cost));
        meta.setLore(addLore(
                WHITE + ITALIC + "Steals an energy",
                WHITE + ITALIC + "from a nearby enemy",
                DARK_AQUA + "Costs " + cost + " energy: 3 second cooldown"
        ));

        item.setItemMeta(meta);
        ItemRegistry.ABILITY_Steal = item;
    }
    private static void generateGive(int cost) {
        ItemAbility item = getBlankAbility(cost, Abilities.GIVE);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(LIGHT_PURPLE + "Ability: Give " + itemCost(cost));
        meta.setLore(addLore(
                WHITE + ITALIC + "Gives an energy",
                WHITE + ITALIC + "to nearby allies",
                DARK_AQUA + "Costs " + cost  + " energy: 3 second cooldown"
        ));

        item.setItemMeta(meta);
        ItemRegistry.ABILITY_Give = item;
    }
    private static void generateSneaky(int cost) {
        ItemAbility item = getBlankAbility(cost, Abilities.SNEAKY);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(LIGHT_PURPLE + "Ability: Sneaky " + itemCost(cost));
        meta.setLore(addLore(
                WHITE + ITALIC + "Gives you invisibility for a short time.",
                WHITE + ITALIC + "If you hit an enemy within 8 seconds",
                WHITE + ITALIC + "It will deal substantial damage",
                WHITE + ITALIC + "but will take away your invisibility",
                DARK_AQUA + "Costs " + cost + " energy: 20 second cooldown"
        ));

        item.setItemMeta(meta);
        ItemRegistry.ABILITY_Sneaky = item;
    }
    private static void generateSwarm(int cost) {
        ItemAbility item = getBlankAbility(cost, Abilities.SWARM);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(LIGHT_PURPLE + "Ability: Swarm " + itemCost(cost));
        meta.setLore(addLore(
                WHITE + ITALIC + "Gives you and nearby allies",
                WHITE + ITALIC + "a speed boost for a short time",
                DARK_AQUA + "Costs " + cost + " energy: 30 second cooldown"
        ));

        item.setItemMeta(meta);
        ItemRegistry.ABILITY_Swarm = item;
    }
    private static void generateGoblinChestplate() {
        ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta)item.getItemMeta();

        meta.setColor(Color.LIME);
        meta.addEnchant(Enchantment.BINDING_CURSE, 1, true);

        item.setItemMeta(meta);
        ItemRegistry.ARMOR_GoblinChestplate = item;
    }
    private static void generateGoblinLeggings() {
        ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta)item.getItemMeta();

        meta.setColor(Color.LIME);
        meta.addEnchant(Enchantment.BINDING_CURSE, 1, true);

        item.setItemMeta(meta);
        ItemRegistry.ARMOR_GoblinLeggings = item;
    }
    private static void generateGoblinBoots() {
        ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta)item.getItemMeta();

        meta.setColor(Color.LIME);
        meta.addEnchant(Enchantment.BINDING_CURSE, 1, true);

        item.setItemMeta(meta);
        ItemRegistry.ARMOR_GoblinBoots = item;
    }
}