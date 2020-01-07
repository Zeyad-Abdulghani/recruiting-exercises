import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

//Single item order,single warehouse with zero quantity, order unfilled due to quantity
class UnitTest2 {

	@Test
	void test() {
		HashMap<String,Integer> order = new HashMap<String,Integer>()
         {{
             put("apple",1);
         }};
         ArrayList<HashMap<String,Object>> finalResult = new ArrayList<HashMap<String,Object>>()
		{{
			add(new HashMap<String,Object>()
			{{
				put("name","owd");
				put("inventory", new HashMap<String,Integer>()
				{{
					put("apple",0);
				}}
						);
			}});
		}};
		InventoryAllocator actualResult = new InventoryAllocator(finalResult);
		assertEquals("[]", actualResult.getBestShipment(order));		
	}
}
