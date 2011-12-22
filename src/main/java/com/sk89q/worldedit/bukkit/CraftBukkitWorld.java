package com.sk89q.worldedit.bukkit;

import org.bukkit.World;

public class CraftBukkitWorld extends BukkitWorld {
    /**
     * @param world
     * @deprecated Use {@link BukkitUtil#getLocalWorld(World)}
     */
    @Deprecated
    public CraftBukkitWorld(World world) {
        super(world);
    }
}
