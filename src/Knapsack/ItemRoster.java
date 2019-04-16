package Knapsack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author peter
 *
 */
public class ItemRoster {
	
	public static List<Item> itemList;
	
	public ItemRoster(){
		itemList = new ArrayList<Item>();
		generateItems();	
	}
	

	public static void generateItems() {
        Random rand = new Random();
        for (int i = 0; i < Values.totalItems; i++) {
            Item item = new Item();
            item.setWeight(rand.nextInt(10));
            item.setPrice(rand.nextInt(10) );
            itemList.add(item);
        }
    }
}
