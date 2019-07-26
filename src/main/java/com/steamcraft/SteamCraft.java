package com.steamcraft;

import com.steamcraft.Init.BlockSC;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;


import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;
import java.util.Optional;



// The value here should match an entry in the META-INF/mods.toml file
@Mod(SteamCraft.MOD_ID)
public class SteamCraft
{
    public static final String MOD_ID = "steamcraft";

    public static final Logger LOGGER = LogManager.getLogger();

    public static final ItemGroup ITEM_GROUP = new ItemGroup(MOD_ID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockSC.blueStone);
        }
    };

    public SteamCraft() {
        // Create proxy instance. DistExecutor.runForDist also returns the created object, so you
        // could store that in a variable if you need it.
        // We cannot use method references here because it could load classes on invalid sides.
        //noinspection Convert2MethodRef
        DistExecutor.runForDist(
                () -> () -> new Proxy.Client(),
                () -> () -> new Proxy.Server()
        );
    }

    /**
     * Get the version of the mod. In a development environment, the version will always be "NONE".
     *
     * @return The version number, or NONE
     */

    @Nonnull
    public static String getVersion() {
        Optional<? extends ModContainer> o = ModList.get().getModContainerById(MOD_ID);
        if (o.isPresent()) {
            return o.get().getModInfo().getVersion().toString();
        }
        return "NONE";
    }

    /**
     * Determines if the mod is a dev build. Sometimes it is useful to register objects or event
     * handlers for debugging purposes, but you may not want these to make it into release builds.
     * <p>
     * This method is a bit naive, as it assumes that if the version is "NONE" we are in a
     * development environment. But it works. If you know a better way, let me know.
     *
     * @return True if this is a development environment, false otherwise.
     */
    public static boolean isDevBuild() {
        String version = getVersion();
        return "NONE".equals(version);
    }

    /**
     * Convenience method for creating {@link ResourceLocation}s. These are needed frequently, and
     * the namespace will typically be your mod ID. This creates a {@link ResourceLocation} with the
     * mod ID as the namespace and the given path. Note that this can throw an exception if the path
     * is invalid.
     *
     * @param path The path of the resource
     * @return A ResourceLocation equivalent to {@code "mod_id:path"}
     */
    @Nonnull
    public static ResourceLocation getId(String path) {
        return new ResourceLocation(MOD_ID, path);
    }




    }


