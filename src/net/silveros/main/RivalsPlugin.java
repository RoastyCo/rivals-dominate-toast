package net.silveros.main;

import net.silveros.commands.RivalsCommands;
import net.silveros.entity.RivalsTags;
import net.silveros.entity.User;
import net.silveros.events.AbilityEvents;
import net.silveros.events.PlayerEvents;
import net.silveros.kits.ItemRegistry;
import net.silveros.kits.Kit;
import net.silveros.kits.KitArcher;
import net.silveros.utility.Color;
import net.silveros.utility.Util;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class RivalsPlugin extends JavaPlugin implements Color {
    public static List<User> players = new ArrayList<>();
    public static RivalsCore core = new RivalsCore();

    public static final String WELCOME_MESSAGE = LIGHT_PURPLE + "Welcome to Rivals: Dominate!";

    @Override
    public void onEnable() {
        Util.initialize(this);
        Util.print(GREEN + "Enabling test plugin...");

        //item and kit initialization
        ItemRegistry.init();
        Kit.init();

        //register events & commands
        Util.registerEvent(new AbilityEvents());
        Util.registerEvent(new PlayerEvents());

        Util.registerCommand("kit", new RivalsCommands(this));

        //misc & tick
        this.startTicking();
    }

    //Main tick loop
    private void startTicking() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (User user : players) {
                    user.onTick();
                }

                if (getWorld() != null) {
                    core.onTick(getWorld());
                }
            }
        }.runTaskTimer(this, 0L, 1L);
    }

    @Override
    public void onDisable() {
        Util.print(RED + "Disabling test plugin...");
    }

    public static void addPlayer(Player player) {
        players.add(new User(player.getUniqueId()));
        Util.print("Added player " + player.getName() + ":" + player.getUniqueId());
    }

    public static void removePlayer(Player player) {
        User user = Util.getUserFromId(player.getUniqueId());
        if (user != null) {
            players.remove(user);
            Util.print("Removed player " + player.getName() + ":" + player.getUniqueId());
        } else {
            Util.print("Could not remove player " + player.getName() + ":" + player.getUniqueId());
        }
    }

    /**Can return null!*/
    public static World getWorld() {
        if (!players.isEmpty()) {
            World world = players.get(0).getPlayer().getWorld();
            return world;
        }

        return null;
    }
}
