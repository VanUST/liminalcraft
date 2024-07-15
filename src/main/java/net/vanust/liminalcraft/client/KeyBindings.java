package net.vanust.liminalcraft.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.vanust.liminalcraft.LiminalCraft;

public class KeyBindings {
    public static final KeyBindings INSTANCE = new KeyBindings();

    private KeyBindings() {}

    private static final String CATEGORY = "key." + LiminalCraft.MOD_ID ;

    public final KeyMapping recharge = new KeyMapping(
            "key." + LiminalCraft.MOD_ID + ".recharge",
            KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_R,-1),
            CATEGORY
    );
}
