USE `cosmic`;

Delete from `shopitems` where `shopid` = 1339;
Delete from `shops` where `shopid` = 1339;

INSERT INTO `shops` (`shopid`, `npcid`) VALUES
(1339, 11000);

INSERT INTO `shopitems` ( `shopid`, `itemid`, `price`, `position`) VALUES
/* white scroll */
(1339, 2340000, 10000000, 61),
/* chaos scroll */
(1339, 2049100, 10000000, 60),
/* Onyx Apple */
(1339, 2022179, 10000000, 59),
/*  - Scroll for Eye Accessory for Accuracy  */
(1339, 2040200, 10000000, 58),
/*  - Scroll for Eye Accessory for INT  */
(1339, 2040205, 10000000, 57),
/*  - Scroll for Earring for INT -  */
(1339, 2040302, 10000000, 56),
/*  - Scroll for Earring for DEX 10 */
(1339, 2040318, 10000000, 55),
/*  - Scroll for Earring for LUK 10 */
(1339, 2040323, 10000000, 54),

/* - Scroll for Helmet for Accuracy - Improves the helmet's accuracy option.\nSuccess Rate 10%, Dex+2, Accuracy +4. The success rate of this scroll can be enhanced by Vega's Spell. */
(1339, 2040016, 10000000, 53),
/* - Scroll for Helmet for INT 10% - Improves INT on headwear.\nSuccess rate 10%, INT+3. The success rate of this scroll can be enhanced by Vega's Spell. */
(1339, 2040026, 10000000, 52),
/* - Scroll for Helmet for DEX 10% - Improves DEX on headwear.\nSuccess rate 10%, DEX+3. The success rate of this scroll can be enhanced by Vega's Spell. */
(1339, 2040031, 10000000, 51),


/*  - Scroll for Topwear for LUK 10 */
(1339, 2040427, 10000000, 50),
/*  - Scroll for Topwear for STR 10% - Improves strength on topwear.\nSuccess rate 10%, STR+3. The success rate of this scroll can be enhanced by Vega's Spell. */
(1339, 2040419, 10000000, 49),
/*  - Scroll for Bottomwear for Jump 10 */
(1339, 2040619, 10000000, 48),
/*  - Scroll for Bottomwear for DEX 10 */
(1339, 2040627, 10000000, 47),

/*  - Scroll for Overall Armor for DEX  */
(1339, 2040502, 10000000, 46),
/*  - Scroll for Overall for STR 10 */
(1339, 2040534, 10000000, 45),
/* Scroll for Overall Armor for INT - Improves INT on the overall armor */
(1339, 2040514, 10000000, 44),
/* Scroll for Overall Armor for LUK - Improves LUK on the overall armor */
(1339, 2040517, 10000000, 43),

/*  - Scroll for Shoes for Jump -  */
(1339, 2040705, 10000000, 42),
/*  - Scroll for Shoes for Speed -  */
(1339, 2040708, 10000000, 41),
/*  - Scroll for Gloves for ATT -  */
(1339, 2040805, 10000000, 40),
/* - Scroll for Gloves for Magic Att. - Improves magic attack on the glove.\nSuccess Rate 10%, magic defense+1, magic attack+3, INT+3. The success rate of this scroll can be enhanced by Vega's Spell. */
(1339, 2040816, 10000000, 39),
/*  - Scroll for Shield for LUK 10 */
(1339, 2040925, 10000000, 38),
/*  - Scroll for Shield for STR 10 */
(1339, 2040933, 10000000, 37),


/* - Scroll for Shield for Weapon Att. - Improves weapon attack on the shield.\nSuccess Rate 10%, W. attack+3, STR+2. The success rate of this scroll can be enhanced by Vega's Spell. */
(1339, 2040915, 10000000, 36),
/* - Scroll for Shield for Magic Att. - Improves magic attack on the shield.\nSuccess Rate 10%, magic attack+3, INT+2. The success rate of this scroll can be enhanced by Vega's Spell. */
(1339, 2040920, 10000000, 35),


/*  - Scroll for Cape for STR -  */
(1339, 2041014, 10000000, 34),
/*  - Scroll for Cape for INT -  */
(1339, 2041017, 10000000, 33),
/*  - Scroll for Cape for DEX -  */
(1339, 2041020, 10000000, 32),
/*  - Scroll for Cape for LUK -  */
(1339, 2041023, 10000000, 31),
/*  - Scroll for One-Handed Sword for  */
(1339, 2043002, 10000000, 30),
/*  - Scroll for One-Handed Sword for Magic Att. - Improves magic attack on one-handed sword.\nSuccess Rate 10%, magic attack+2, magic defense+1, INT+2. The success rate of this scroll can be enhanced by Vega's Spell. */
(1339, 2043008, 10000000, 29),
/*  - Scroll for One-Handed Axe for  */
(1339, 2043114, 10000000, 28),
/*  - Scroll for One-Handed BW for  */
(1339, 2043214, 10000000, 27),
/*  - Scroll for Wand for Magic Att */
(1339, 2043702, 10000000, 26),
/*  - Scroll for Staff for Magic Att */
(1339, 2043802, 10000000, 25),
/*  - Scroll for Two-handed Sword for  */
(1339, 2044002, 10000000, 24),
/*  - Scroll for Two-handed Axe for  */
(1339, 2044102, 10000000, 23),
/*  - Scroll for Two-handed BW for  */
(1339, 2044202, 10000000, 22),
/*  - Scroll for Spear for ATT -  */
(1339, 2044302, 10000000, 21),
/*  - Scroll for Pole Arm for ATT  */
(1339, 2044402, 10000000, 20),
/*  - Scroll for Bow for ATT -  */
(1339, 2044502, 10000000, 19),
/*  - Scroll for Crossbow for ATT -  */
(1339, 2044602, 10000000, 18),
/*  - Scroll for Claw for ATT -  */
(1339, 2044702, 10000000, 17),
/*  - Scroll for Knuckler for ATT -  */
(1339, 2044802, 10000000, 16),
/*  - Scroll for Gun for ATT -  */
(1339, 2044902, 10000000, 15),
/*  - Scroll for Shoes for ATT - Improves attack on shoes. */
(1339, 2040760, 10000000, 14),
/*  - Scroll for One-Handed Axe for ATT - Improves attack on one-handed axe. */
(1339, 2043102, 10000000, 13),
/*  - Scroll for One-Handed BW for ATT - Improves attack on one-handed blunt weapon. */
(1339, 2043202, 10000000, 12),
/*  - Scroll for Dagger for ATT - Improves attack on dagger. */
(1339, 2043302, 10000000, 11),

/*  - Scroll for Rings for STR 10% - Improves STR on Rings. */
(1339, 2041102, 10000000, 10),

/*  - Scroll for Rings for INT 10% - Improves INT on Rings. */
(1339, 2041105, 10000000, 9),

/*  - Scroll for Rings for DEX 10% - Improves DEX on Rings. */
(1339, 2041108, 10000000, 8),

/*  - Scroll for Rings for LUK 10% - Improves LUK on Rings. */
(1339, 2041111, 10000000, 7),

/*  - Scroll for Belts for STR 10% - Improves STR on Belts. */
(1339, 2041302, 10000000, 6),

/*  - Scroll for Belts for INT 10% - Improves INT on Belts. */
(1339, 2041305, 10000000, 5),

/*  - Scroll for Belts for DEX 10% - Improves DEX on Belts. */
(1339, 2041308, 10000000, 4),

/*  - Scroll for Belts for LUK 10% - Improves LUK on Belts. */
(1339, 2041311, 10000000, 3),

/*  - Scroll for Pet Equip. for  */
(1339, 2048002, 10000000, 2),
/*  - Scroll for Pet Equip. for  */
(1339, 2048005, 10000000, 1);










