package dev.odd.scaryplayer;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class ScaryPlayer implements ModInitializer {
    public static final String MOD_ID = "scaryplayer";

    public static final Tag<Item> SCARY_TAG;

    @Override
    public void onInitialize() { }

    static {
        SCARY_TAG = TagRegistry.item(new Identifier(MOD_ID, "scary"));
    }
}
