package com.github.saidred.spigotTestPlugin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.AbstractHorse;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TraderLlama;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpigotTestPlugin extends JavaPlugin {
  public static JavaPlugin plugin;

  public SpigotTestPlugin() {
    plugin = this;
  }

  @Override
  public void onEnable() {
    // Event Sample
    getServer().getPluginManager().registerEvents(new testEvent(), this);
  }

  public class testEvent implements Listener {
    @EventHandler
    public void onEvent(PlayerInteractEvent event) {
      getLogger().info("<< EVENT TEST LOG START >>");
      // Event test codes.
      // Spawn target block.
      Block clickedBlock = event.getClickedBlock();
      // Detecting centerd block.
      Block centerBlock = clickedBlock.getRelative(event.getBlockFace());
      // Spawn target location.
      Location loc = centerBlock.getLocation();
      // Spawn Trader Lllama.
      TraderLlama traderLlama = (TraderLlama) loc.getWorld().spawnEntity(loc, EntityType.TRADER_LLAMA);
      // Set carpet to spawned Trader Llama.
      traderLlama.getInventory().setDecor(new ItemStack(Material.WHITE_CARPET, 1));
      getLogger().info("<< EVENT TEST LOG END >>");
    }
  }
}
