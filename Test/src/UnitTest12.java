import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

//multiple item order, single warehouse with multiple items, order unfilled due to item quantity 
class UnitTest12 {

	@Test
	void test() {
		HashMap<String,Integer> order = new HashMap<String,Integer>()
         {{
             put("apple",10);
             put("orange",3);
             put("grape",4);
         }};
         ArrayList<HashMap<String,Object>> finalResult = new ArrayList<HashMap<String,Object>>()
		{{
			add(new HashMap<String,Object>()
			{{
				put("name","owd");
				put("inventory", new HashMap<String,Integer>()
				{{
					put("apple",5);
					put("orange",2);
					put("grape", 6);
					put("cucumber",3);
				}}
				
						);
			}});
		}};
		InventoryAllocator actualResult = new InventoryAllocator(finalResult);
		assertEquals("[]", actualResult.getBestShipment(order));		
	}
}

