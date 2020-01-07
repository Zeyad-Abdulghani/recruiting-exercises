import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class UnitTest13 {

	@Test
	void test() {
		HashMap<String,Integer> order = new HashMap<String,Integer>()
         {{
             put("apple",10);
             put("orange",5);
             put("grape",2);
             put("cucumber",7);
             put("banana",3);
         }};
         ArrayList<HashMap<String,Object>> finalResult = new ArrayList<HashMap<String,Object>>()
		{{
			add(new HashMap<String,Object>()
			{{
				put("name","owd");
				put("inventory", new HashMap<String,Integer>()
				{{
					put("apple",10);
					put("kiwi", 2);
				}}
				
						);
			}});
			
			add(new HashMap<String,Object>()
			{{
				put("name","dm");
				put("inventory", new HashMap<String,Integer>()
				{{
					put("orange",3);
					put("grape",2);
					put("apple", 4);
				}}	
						);
			}});
			
			add(new HashMap<String,Object>()
			{{
				put("name","fm");
				put("inventory", new HashMap<String,Integer>()
				{{
					put("orange",2);
					put("cucumber",10);
					put("banana",3);
				}}	
						);
			}});
			
		}};
		InventoryAllocator actualResult = new InventoryAllocator(finalResult);
		assertEquals("[{owd={apple=10}}, {dm={orange=3, grape=2}}, {fm={orange=2, banana=3, cucumber=7}}]", actualResult.getBestShipment(order));		
	}
}
