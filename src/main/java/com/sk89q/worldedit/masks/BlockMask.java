package com.sk89q.worldedit.masks;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.LocalPlayer;
import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.blocks.BaseBlock;

public class BlockMask implements Mask {

    protected Set<BaseBlock> blocks;

    public BlockMask() {
        blocks = new HashSet<BaseBlock>();
    }

    public BlockMask(Set<BaseBlock> types) {
        this.blocks = types;
    }

    public BlockMask(BaseBlock block) {
        this();
        add(block);
    }

    public void add(BaseBlock block) {
        blocks.add(block);
    }

    public void addAll(Collection<BaseBlock> blocks) {
        blocks.addAll(blocks);
    }

    public void prepare(LocalSession session, LocalPlayer player, Vector target) {
    }

    public boolean matches(EditSession editSession, Vector pos) {
        BaseBlock block = editSession.getBlock(pos);
        return  blocks.contains(block)
                || blocks.contains(new BaseBlock(block.getType(), -1));
   }
}
