package me.moteloff.realisticexplosion.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.util.Vector;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TNTHelper {

    Random random = new Random();
    List<Material> exceptions = Arrays.asList(Material.AIR, Material.WATER, Material.LAVA);


    public TNTPrimed spawnTNT(Location location) {
        TNTPrimed tnt = location.getWorld().spawn(location.add(0.5, 0.25, 0.5), TNTPrimed.class);

        tnt.setVelocity(new Vector(0, 0.25, 0));
        tnt.teleport(location);

        return tnt;
    }

    public void spawnFallingBlocks(List<Block> blocks) {
        int count = 10;
        blocks = filterBlocks(blocks);
        if (blocks.size() == 0) {
            return;
        }

        while (count >= 0) {
            int randomInt = random.random(blocks.size()-1);

            Block block = blocks.get(randomInt);
            Material type = block.getType();

            FallingBlock fallingBlock = block.getLocation().getWorld().spawnFallingBlock(block.getLocation().add(random.random(2.0), 0.25, random.random(2.0)), type, (byte) 1);
            fallingBlock.setVelocity(new Vector(random.random(-0.3, 0.3),random.random(0.4, 1.0), random.random(-0.3, 0.3)));

            count--;
        }
    }

    private List<Block> filterBlocks(List<Block> blocks) {
        Predicate<Block> predicate = block -> (!exceptions.contains(block.getType()));
        return blocks.stream().filter(predicate).collect(Collectors.toList());
    }
}
