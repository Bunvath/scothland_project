package uk.ac.bris.cs.scotlandyard.model;

import com.google.common.collect.ImmutableList;

import javax.annotation.Nonnull;

import com.google.common.collect.ImmutableSet;
import uk.ac.bris.cs.scotlandyard.model.Board.GameState;
import uk.ac.bris.cs.scotlandyard.model.ScotlandYard.Factory;

import java.beans.PropertyEditorManager;
import java.lang.instrument.UnmodifiableModuleException;
import java.util.List;
import java.util.Optional;

/**
 * cw-model
 * Stage 1: Complete this class
 */
public final class MyGameStateFactory implements Factory<GameState> {

	@Nonnull
	@Override
	public GameState build(
			GameSetup setup,
			Player mrX,
			ImmutableList<Player> detectives) {
		// TODO

		final class MyGameState implements GameState{
		  	private GameSetup setup;
		  	private ImmutableSet<Piece> remaining;
		  	private ImmutableSet<LogEntry> log;
		  	private Player mrX;
		  	private List<Player> detective;
		  	private List<Player> everyone;
		  	private ImmutableSet<Move> moves;
		  	private ImmutableSet<Piece> winner;
		  	private MyGameState(final GameSetup setup, final ImmutableSet<Piece> remaining,
								final ImmutableSet<LogEntry> log,final Player mrX, final List<Player> detective){
		  		if(setup.rounds.isEmpty()) throw new IllegalArgumentException();

		  		for(final var p : detectives){
		  			if(p.has(ScotlandYard.Ticket.DOUBLE) || p.has(ScotlandYard.Ticket.SECRET)){
		  				throw new IllegalArgumentException();
					}
				}
		  		this.setup = setup;
		  		this.remaining = remaining;
		  		this.log = log;
		  		this.mrX = mrX;
		  		this.detective = detective;
			}

			@Override
			public GameSetup getSetup() {
		  		return setup;
			}
			@Override
			public ImmutableSet<Piece> getPlayers(){
				return remaining;
			}
			@Override
			public Optional<Integer> getDetectiveLocation(Piece.Detective detective){
				for(final var p : detectives){
					if(p.piece() == detective) return Optional.of(p.location());
				}
				return Optional.empty();
			}
			@Override
			public  Optional<TicketBoard> getPlayerTickets(Piece piece){
				return null;

			}
			@Override
			public ImmutableList<LogEntry> getMrXTravelLog(){
				return null;
			}
			@Override
			public ImmutableSet<Piece> getWinner(){
				return null;
			}
			@Override
			public ImmutableSet<Move> getAvailableMoves(){
				return null;
			}
			@Override
			public GameState advance(Move move){
				return null;
			}
		}
		return new MyGameState(setup, ImmutableSet.of(Piece.MrX.MRX), ImmutableList.of(LogEntry.), mrX, detectives);
	}
}
