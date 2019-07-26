package com.SteamCraft.Item;


import com.SteamCraft.SteamCraft;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IItemBase {


public ItemBase(Item.Properties props) {

    super(props.group(SteamCraft.ITEM_GROUP));

}

}
