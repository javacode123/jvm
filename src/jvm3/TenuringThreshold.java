package jvm3;

public class TenuringThreshold {
	
	private static final int _1MB = 1024 * 1024;
	/**
	 * VM������-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
	 * -XX:+PrintTenuringDistribution
	 * MaxTenuringThreshold = 1 ʱ�� ��ʾ����һ�� mimorGC�Ϳ��Խ��������
	 * @throws InterruptedException 
	 */
	public static void test() throws InterruptedException {
		byte[] allocation1, allocation2, allocation3;
		allocation1 = new byte[_1MB / 4];
		allocation2 = new byte[_1MB * 4];
		allocation3 = new byte[_1MB * 4];
		allocation3 = null;
		allocation3 = new byte[_1MB * 4];
		System.out.println(allocation3);
	}
	
	public static void main(String[] args) throws InterruptedException {
		test();
	}

}
