/*
	This file is part of the OdinMS Maple Story Server
    Copyright (C) 2008 Patrick Huy <patrick.huy@frz.cc>
		       Matthias Butz <matze@odinms.de>
		       Jan Christian Meyer <vimes@odinms.de>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as
    published by the Free Software Foundation version 3 as published by
    the Free Software Foundation. You may not use, modify or distribute
    this program under any other version of the GNU Affero General Public
    License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package net.server.channel.handlers;

import client.Character;
import client.Client;
import client.processor.action.PetAutopotProcessor;
import net.AbstractPacketHandler;
import net.packet.InPacket;
import server.ItemInformationProvider;
import server.StatEffect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class PetAutoPotHandler extends AbstractPacketHandler {
    private static final Logger log = LoggerFactory.getLogger(Character.class);

    @Override
    public final void handlePacket(InPacket p, Client c) {
        p.readByte();
        p.readLong();
        p.readInt();
        short slot = p.readShort();
        int itemId = p.readInt();

        Character chr = c.getPlayer();
        StatEffect stat = ItemInformationProvider.getInstance().getItemEffect(itemId);
        if (stat.getHp() > 0 || stat.getHpRate() > 0.0) {

            float estimatedHp = ((float) chr.getHp()) / chr.getCurrentMaxHp();
            float next5p = (float) (Math.ceil(estimatedHp * 100 / 5) * 5 / 100); // auto pot works in 5% interval. reflect this on server

            chr.setAutopotHpAlert(next5p, false);
        }

        if (stat.getMp() > 0 || stat.getMpRate() > 0.0) {
            float estimatedMp = ((float) chr.getMp()) / chr.getCurrentMaxMp();
            float next5p = (float) (Math.ceil(estimatedMp * 100 / 5) * 5 / 100); // auto pot works in 5% interval. reflect this on server

            chr.setAutopotMpAlert(next5p);
        }

        PetAutopotProcessor.runAutopotAction(c, slot, itemId);
    }

}
