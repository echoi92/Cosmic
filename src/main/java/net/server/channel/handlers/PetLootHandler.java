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
import client.inventory.Pet;
import net.AbstractPacketHandler;
import net.packet.InPacket;
import net.packet.Packet;
import server.maps.MapItem;
import server.maps.MapObject;
import server.maps.MapObjectType;
import server.maps.MapleMap;
import server.life.MonsterInformationProvider;
import server.ItemInformationProvider;
import tools.PacketCreator;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author TheRamon
 * @author Ronan
 */
public final class PetLootHandler extends AbstractPacketHandler {
    private static final Logger log = LoggerFactory.getLogger(Character.class);

    @Override
    public final void handlePacket(InPacket p, Client c) {
        Character chr = c.getPlayer();

        int petIndex = chr.getPetIndex(p.readInt());
        Pet pet = chr.getPet(petIndex);

        int whitelistPetId = chr.getPet(2).getUniqueId();
        Set<Integer> whitelist = chr.getExcluded().get(whitelistPetId);

        boolean hasWhiteList = whitelist.size() > 0;
        if (pet == null || !pet.isSummoned()) {
            c.sendPacket(PacketCreator.enableActions());
            return;
        }

        p.skip(13);
        int oid = p.readInt();
        MapObject ob = chr.getMap().getMapObject(oid);
        MapleMap map = chr.getMap();
        Set<Integer> globalDropItemIds = MonsterInformationProvider.getInstance().getGlobalDropItemIds();
        ItemInformationProvider ii = ItemInformationProvider.getInstance();

        try {
            MapItem mapitem = (MapItem) ob;

            if (mapitem.getMeso() > 0) {
                if (!chr.isEquippedMesoMagnet()) {
                    c.sendPacket(PacketCreator.enableActions());
                    return;
                }

                if (chr.isEquippedPetItemIgnore()) {
                    final Set<Integer> petIgnore = chr.getExcludedItems();
                    if (!petIgnore.isEmpty() && petIgnore.contains(Integer.MAX_VALUE)) {

                        c.sendPacket(PacketCreator.enableActions());
                        return;
                    }
                }
            } else {
                if (!chr.isEquippedItemPouch()) {
                    c.sendPacket(PacketCreator.enableActions());
                    return;
                }

                if (chr.isEquippedPetItemIgnore()) {
                    final Set<Integer> petIgnore = chr.getExcludedItems();
                    if (hasWhiteList) {
                        if (
                            !whitelist.isEmpty()
                            && !whitelist.contains(mapitem.getItem().getItemId())
                            && !globalDropItemIds.contains(mapitem.getItem().getItemId())
                            && !(mapitem.getItem().getItemId() / 10000 == 204) // is NOT scroll item
                            && !ii.isConsumeOnPickup(mapitem.getItemId()) // NOt consume on pick up item such as monster card
                        ) {
                            c.sendPacket(PacketCreator.enableActions());
                            return;
                        }
                    } else if (!petIgnore.isEmpty() && petIgnore.contains(mapitem.getItem().getItemId())) {
                        c.sendPacket(PacketCreator.enableActions());
                        return;
                    }
                }
            }

            List<MapObject> list = chr.getMap().getMapObjectsInRange(pet.getPos(), 35000, Arrays.asList(MapObjectType.ITEM));
            for (MapObject obj : list) {
                MapItem mapitem2 = (MapItem) obj;

                if (mapitem2.getMeso() > 0) {
                    if (!chr.isEquippedMesoMagnet()) {
                        c.sendPacket(PacketCreator.enableActions());
                        continue;
                    }

                    if (chr.isEquippedPetItemIgnore()) {
                        final Set<Integer> petIgnore = chr.getExcludedItems();
                        if (!petIgnore.isEmpty() && petIgnore.contains(Integer.MAX_VALUE)) {
                            c.sendPacket(PacketCreator.enableActions());
                            continue;
                        }
                    }
                } else {
                    if (!chr.isEquippedItemPouch()) {
                        c.sendPacket(PacketCreator.enableActions());
                        continue;
                    }

                    if (chr.isEquippedPetItemIgnore()) {
                        final Set<Integer> petIgnore = chr.getExcludedItems();
                        if (hasWhiteList) {
                            if (
                                !whitelist.isEmpty()
                                && !whitelist.contains(mapitem2.getItem().getItemId())
                                && !globalDropItemIds.contains(mapitem2.getItem().getItemId())
                                && !(mapitem2.getItem().getItemId() / 10000 == 204) // is NOT scroll item
                                && !ii.isConsumeOnPickup(mapitem2.getItemId()) // NOt consume on pick up item such as monster card

                            ) {
                                // remove all non-whitelist items
                                map.makeDisappearItemFromMap(mapitem2);

                                c.sendPacket(PacketCreator.enableActions());
                                continue;
                            }
                        } else if (!petIgnore.isEmpty() && petIgnore.contains(mapitem2.getItem().getItemId())) {
                            // remove ignored items
                            map.makeDisappearItemFromMap(mapitem2);

                            c.sendPacket(PacketCreator.enableActions());
                            continue;
                        }
                    }
                }
                chr.pickupItem(obj, petIndex);
            }

            chr.pickupItem(ob, petIndex);
        } catch (NullPointerException | ClassCastException e) {
            c.sendPacket(PacketCreator.enableActions());
        }
    }
}
