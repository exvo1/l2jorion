package l2jorion.game.handler.vote;

import l2jorion.Config;
import l2jorion.game.handler.voice.Vote;
import l2jorion.game.handler.vote.engine.VoteBase;
import l2jorion.game.model.actor.instance.L2PcInstance;
import l2jorion.util.random.Rnd;

/**
 * @author Vilmis
 */
public class L2TopOnline extends VoteBase
{
	@Override
	public void reward(L2PcInstance player)
	{
		if (Rnd.get(100) < Config.VOTE_REWARD_CHANCE)
		{
			Vote.giveReward(player);
		}
		else
		{
			player.sendMessage("Thank you! Unfortunately, but this time you didn't get reward. Better luck next time.");
		}
		
		Vote.showHtm(player);
	}
	
	@Override
	public String getApiEndpoint(L2PcInstance player)
	{
		return String.format("http://l2top.online/avote/%s/%s", getPlayerIp(player), Config.VOTE_L2TOPONLINE_ID);
	}
	
	@Override
	public void setVoted(L2PcInstance player)
	{
		player.setLastL2TopOnline(System.currentTimeMillis());
	}
}