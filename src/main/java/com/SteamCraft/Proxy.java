package com.SteamCraft;

import com.SteamCraft.Init.BlockSC;
import com.SteamCraft.Init.ItemSC;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class Proxy {
    Proxy() {
        // Life-cycle events
        FMLJavaModLoadingContext.get().getModEventBus().addListener(Proxy::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(Proxy::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(Proxy::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(BlockSC::registerAll);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ItemSC::registerAll);

        // Other events
        MinecraftForge.EVENT_BUS.register(this);
    }

    /**
     * Called after registry events, so we know blocks, items, etc. are registered
     *
     * @param event The event
     */
    private static void commonSetup(FMLCommonSetupEvent event) {
        SteamCraft.LOGGER.debug("commonSetup for Steam Craft");
    }

    /**
     * Send IMC messages to other mods
     *
     * @param event The event
     */
    private static void enqueueIMC(final InterModEnqueueEvent event) {
    }

    /**
     * Receive and process IMC messages from other mods
     *
     * @param event The event
     */
    private static void processIMC(final InterModProcessEvent event) {
    }

    /**
     * One of several events fired when a server (integrated or dedicated) is starting up. Here, we
     * can register commands and classes which process resources. For example, if you have a machine
     * with custom recipes, you would register your resource manager and reload resources as the
     * server is starting. We will cover that in a later episode.
     *
     * @param event The event
     */
    @SubscribeEvent
    public void serverStarting(FMLServerStartingEvent event) {

    }

    /**
     * In addition to everything handled by SideProxy, this will handle client-side resources. This
     * is where you would register things like models and color handlers.
     */
    static class Client extends Proxy {
        Client() {
            FMLJavaModLoadingContext.get().getModEventBus().addListener(Client::clientSetup);
        }

        private static void clientSetup(FMLClientSetupEvent event) {
        }
    }

    /**
     * Only created on dedicated servers.
     */
    static class Server extends Proxy {
        Server() {
            FMLJavaModLoadingContext.get().getModEventBus().addListener(Server::serverSetup);
        }

        private static void serverSetup(FMLDedicatedServerSetupEvent event) {
        }
    }
}
