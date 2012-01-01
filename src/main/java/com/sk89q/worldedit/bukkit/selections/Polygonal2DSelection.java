// $Id$
/*
 * WorldEdit
 * Copyright (C) 2010, 2011 sk89q <http://www.sk89q.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
*/

package com.sk89q.worldedit.bukkit.selections;

import java.util.Collections;
import java.util.List;

import com.sk89q.worldedit.LocalWorld;
import org.bukkit.World;
import com.sk89q.worldedit.BlockVector2D;
import com.sk89q.worldedit.bukkit.BukkitUtil;
import com.sk89q.worldedit.regions.*;

public class Polygonal2DSelection extends RegionSelection {
    protected final Polygonal2DRegionSelector selector;

    public Polygonal2DSelection(World world, Polygonal2DRegionSelector sel) {
        super(world);

        selector = sel;
    }

    public Polygonal2DSelection(World world, List<BlockVector2D> points, int minY, int maxY) {
        super(world);
        LocalWorld lWorld = BukkitUtil.getLocalWorld(world);

        // Validate input
        minY = Math.min(Math.max(0, minY), world.getMaxHeight());
        maxY = Math.min(Math.max(0, maxY), world.getMaxHeight());

        // Create and set up new selector
        selector = new Polygonal2DRegionSelector(lWorld, points, minY, maxY);
    }

    public List<BlockVector2D> getNativePoints() {
        return Collections.unmodifiableList(selector.getIncompleteRegion().getPoints());
    }

    @Override
    public Polygonal2DRegionSelector getRegionSelector() {
        return selector;
    }
}
