package ru.niksne.vanillarpc;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;
import net.fabricmc.api.ClientModInitializer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class VanillaRPC implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        String id;
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("application_id.txt")) {
            assert stream != null;
            Scanner s = new Scanner(stream).useDelimiter("\\A");
            id = s.hasNext() ? s.next() : "";
        } catch (IOException e) {
            e.printStackTrace();
            id = "1131048770109460500";
        }
        DiscordRPC lib = DiscordRPC.INSTANCE;
        lib.Discord_Initialize(id, new DiscordEventHandlers(), true, "");
        DiscordRichPresence presence = new DiscordRichPresence();
        presence.startTimestamp = System.currentTimeMillis() / 1000;
        lib.Discord_UpdatePresence(presence);
    }
}
