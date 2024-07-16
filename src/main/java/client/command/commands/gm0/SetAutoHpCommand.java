package client.command.commands.gm0;

import client.Character;
import client.Client;
import client.SkillFactory;
import client.command.Command;

public class SetAutoHpCommand extends Command {
    {
        setDescription("Set autopot hp level");
    }

    @Override
    public void execute(Client c, String[] params) {
        Character player = c.getPlayer();
        player.setAutopotHpAlert(Integer.parseInt(params[0]) / 100.0f, true);
    }
}
