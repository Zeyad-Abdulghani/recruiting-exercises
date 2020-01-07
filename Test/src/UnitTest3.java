import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

//Single item order, multiple warehouses with same item, order filled by splitting across multiple warehouses.
class UnitTest3 {

	@Test
	void test() {
		HashMap<String,Integer> order = new HashMap<String,Integer>()
         {{
             put("apple",10);
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
					put("apple",5);
				}}
						);
			}});
			
		}};
		InventoryAllocator actualResult = new InventoryAllocator(finalResult);
		assertEquals("[{owd={apple=5}}, {dm={apple=5}}]", actualResult.getBestShipment(order));		
	}
}
