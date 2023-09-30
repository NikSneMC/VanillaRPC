package com.niksne.vanillarpc;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;
import net.fabricmc.api.ClientModInitializer;

public class VanillaRPC implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        DiscordRPC lib = DiscordRPC.INSTANCE;
        lib.Discord_Initialize("1131048770109460500", new DiscordEventHandlers(), true, ""); // new logo
//        lib.Discord_Initialize("1157515441816748062", new DiscordEventHandlers(), true, ""); // old logo
        DiscordRichPresence presence = new DiscordRichPresence();
        presence.startTimestamp = System.currentTimeMillis() / 1000;
        lib.Discord_UpdatePresence(presence);
    }
}
