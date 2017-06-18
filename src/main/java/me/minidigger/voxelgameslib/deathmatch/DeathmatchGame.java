package me.minidigger.voxelgameslib.deathmatch;

import javax.annotation.Nonnull;

import me.minidigger.voxelgameslib.game.AbstractGame;
import me.minidigger.voxelgameslib.game.GameDefinition;
import me.minidigger.voxelgameslib.game.GameInfo;
import me.minidigger.voxelgameslib.phase.phases.GracePhase;
import me.minidigger.voxelgameslib.phase.phases.LobbyPhase;
import me.minidigger.voxelgameslib.phase.phases.VotePhase;

/**
 * Created by Martin on 28.01.2017.
 */
@GameInfo(name = "Deathmatch", author = "MiniDigger", version = "v1.0", description = "Deathmatch Description")
public class DeathmatchGame extends AbstractGame {

    public DeathmatchGame() {
        super(DeathmatchPlugin.GAMEMODE);
    }

    @Override
    public void initGameFromModule() {
        setMinPlayers(2);
        setMaxPlayers(2);

        LobbyPhase lobbyPhase = createPhase(LobbyPhase.class);
        VotePhase votePhase = createPhase(VotePhase.class);
        GracePhase gracePhase = createPhase(GracePhase.class);
        DeathmatchPhase survivalGamesPhase = createPhase(DeathmatchPhase.class);

        lobbyPhase.setNextPhase(votePhase);
        votePhase.setNextPhase(gracePhase);
        gracePhase.setNextPhase(survivalGamesPhase);

        activePhase = lobbyPhase;

        loadMap();
    }

    @Override
    public void initGameFromDefinition(@Nonnull GameDefinition gameDefinition) {
        super.initGameFromDefinition(gameDefinition);

        loadMap();
    }
}
