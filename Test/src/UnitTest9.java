import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class UnitTest9 {

	@Test
	void test() {
		HashMap<String,Integer> order = new HashMap<String,Integer>()
         {{
             put("apple",10);
             put("orange",5);
         }};
         ArrayList<HashMap<String,Object>> finalResult = new ArrayList<HashMap<String,Object>>()
		{{
			add(new HashMap<String,Object>()
			{{
				put("name","owd");
				put("inventory", new HashMap<String,Integer>()
				{{
					put("apple",5);
				}}
				
						);
			}});
			
			add(new HashMap<String,Object>()
			{{
				put("name","dm");
				put("inventory", new HashMap<String,Integer>()
				{{
					put("apple",7);
					put("orange",2);
				}}
						);
			}});
			
		}};
		InventoryAllocator actualResult = new InventoryAllocator(finalResult);
		assertEquals("[]", actualResult.getBestShipment(order));		
	}
}
