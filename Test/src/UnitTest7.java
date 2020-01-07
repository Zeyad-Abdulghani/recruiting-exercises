import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

// multiple item order, multiple warehouses with same items, order filled from one warehouse only
class UnitTest7 {

	@Test
	void test() {
		HashMap<String,Integer> order = new HashMap<String,Integer>()
         {{
             put("apple",10);
             put("orange",5);
             put("grape",2);
         }};
         ArrayList<HashMap<String,Object>> finalResult = new ArrayList<HashMap<String,Object>>()
		{{
			add(new HashMap<String,Object>()
			{{
				put("name","owd");
				put("inventory", new HashMap<String,Integer>()
				{{
					put("apple",10);
					put("grape",4);
					put("orange",6);
				}}
						);
			}});
			
			add(new HashMap<String,Object>()
			{{
				put("name","dm");
				put("inventory", new HashMap<String,Integer>()
				{{
					put("apple",5);
					put("grape",1);
					put("orange",6);
				}}
				
						);
			}});
			
		}};
		InventoryAllocator actualResult = new InventoryAllocator(finalResult);
		assertEquals("[{owd={orange=5, apple=10, grape=2}}]", actualResult.getBestShipment(order));		
	}
}
