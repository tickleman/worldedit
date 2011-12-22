package com.sk89q.worldedit.bukkit;

import org.bukkit.World;

public class SpoutCraftBukkitWorld extends CraftBukkitWorld {
    /**
     * @param world
     * @deprecated Use {@link BukkitUtil#getLocalWorld(World)}
     */
    @Deprecated
    public SpoutCraftBukkitWorld(World world) {
        super(world);
    }
}
