// import MyJarMyTools.*;
import java.io.IOException;
class Sample
{
	public static void main(String args[]) throws Exception
	{
		PrintInput obj = new PrintInput();
		obj.print("Sharvani");
		obj.input("Enter your name: ");
		obj.print();
		obj.input();
	}
}