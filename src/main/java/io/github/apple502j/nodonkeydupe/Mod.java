package io.github.apple502j.nodonkeydupe;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Mod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("nodonkeydupe");

	@Override
	public void onInitialize() {
		LOGGER.info("Initialized nodonkeydupe");
	}
}
