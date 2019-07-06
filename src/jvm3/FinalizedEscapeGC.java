package jvm3;

// ��������������,ִֻ��һ��  finalize ����
public class FinalizedEscapeGC {

	public static FinalizedEscapeGC SAVE_HOOK = null;
	
	public void isActive() {
		System.out.println("alive");
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize method executed!");
		// ����һ��ǿ����
		SAVE_HOOK = this;
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		SAVE_HOOK = new FinalizedEscapeGC();
		
		SAVE_HOOK = null;
		System.gc();
		// ˯5�룬ִ��finalize����
		Thread.sleep(500);
		
		if (SAVE_HOOK == null) {
			System.out.println("die");
		} else {
			SAVE_HOOK.isActive();
		}
		
		SAVE_HOOK = null;
		System.gc();
		// ˯5�룬ִ��finalize����
		Thread.sleep(500);
		
		if (SAVE_HOOK == null) {
			System.out.println("die");
		} else {
			SAVE_HOOK.isActive();
		}
		
	}

}
