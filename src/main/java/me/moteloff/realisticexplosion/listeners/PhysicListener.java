package me.moteloff.realisticexplosion.listeners;

import me.moteloff.realisticexplosion.Main;
import me.moteloff.realisticexplosion.utils.Random;
import me.moteloff.realisticexplosion.utils.TNTHelper;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import java.util.List;

public class PhysicListener implements Listener {
    private final Main plugin;

    public PhysicListener(Main plugin) {
        this.plugin = plugin;
    }

    TNTHelper helper = new TNTHelper();
    Random random = new Random();

    @EventHandler
    public void onPlaceTNT(BlockPlaceEvent event) {
        Block block = event.getBlock();

        if (block.getType() != Material.TNT) {
            return;
        }

        block.setType(Material.AIR);
        helper.spawnTNT(block.getLocation());
    }

    @EventHandler
    public void onExplosion(EntityExplodeEvent event) {
        List<Block> explodeBlocks = event.blockList();

        helper.spawnFallingBlocks(explodeBlocks);
    }
}
