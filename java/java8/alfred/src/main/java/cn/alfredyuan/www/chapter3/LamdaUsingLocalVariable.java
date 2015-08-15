package cn.alfredyuan.www.chapter3;

public class LamdaUsingLocalVariable
{
	private int instanceVariable = 10086;
	
	public int getInstanceVariable()
	{
		return instanceVariable;
	}

	public void setInstanceVariable(int instanceVariable)
	{
		this.instanceVariable = instanceVariable;
	}

	public static void main(String[] args)
	{
		int portNumber = 22;
		Runnable r = () -> System.out.println(portNumber);
		new Thread(r).start();
		new Thread(
				() -> System.out.println(new LamdaUsingLocalVariable().getInstanceVariable())
			).start();;
		
	}
}
