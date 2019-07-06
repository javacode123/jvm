package jvm2;

import java.util.ArrayList;
import java.util.List;

/**
 * java���ڴ��������,����20M�ڴ� 
 * VM Args��-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author zjl
 *
 */
public class HeapOnOutOfMemory {
	
	static class OOMObject {}

	public static void main(String[] agrs) {
		List<OOMObject> list = new ArrayList<OOMObject>();
		
		while(true) {
			list.add(new OOMObject());
		}
		
	}
	
}
