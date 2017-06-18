package me.minidigger.voxelgameslib.deathmatch;

import me.minidigger.voxelgameslib.feature.AbstractFeature;
import me.minidigger.voxelgameslib.feature.features.DuelFeature;
import me.minidigger.voxelgameslib.feature.features.TeamFeature;
import me.minidigger.voxelgameslib.user.User;
import me.minidigger.voxelgameslib.utils.ItemBuilder;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

import jskills.Rating;
import lombok.extern.java.Log;

@Log
public class DeathmatchFeature extends AbstractFeature {

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void tick() {

    }

    @Override
    public void init() {

    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        if (getPhase().getGame().isPlaying(e.getEntity().getUniqueId())) {

        }
    }

    @Override
    public Class[] getDependencies() {
        return new Class[]{TeamFeature.class};
    }
}
