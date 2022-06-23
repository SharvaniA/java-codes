import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class PrintInput
{

    public static void print(String... stringToPrint)
    {
        for (String value: stringToPrint)
            System.out.println(value);
        // String stringToPrint = 
        if (stringToPrint.length == 0) 
        {
            System.out.println();
        }
    }

    public static String input(String... stringToInput) throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);
        // System.out.println();
        for (String value: stringToInput)
            System.out.println(value);
        String name = reader.readLine();
        return name; 
    }
}
    // public static void main(String args[]) throws IOException 
    // {
    //     print();
    //     print("Hello World", "Sharvani");
    //     input();
    //     input("Enter your name: ");
    // }

































// import java.util.*;

// class ParamsWithMap {
//     public ParamsWithMap() 
//     {
//     }
//     public static void foo(Map<String,Object> params) 
//     {
//         String  param01 = null; 
//         Integer param02 = 0;
//         if (params.containsKey("param01")) 
//         { 
//             if (params.get("param01") instanceof String) 
//             {  
//                 System.out.println(""); 
//                 // param01 = (String)params.get("param01");
//             } 
//         } 
//         if (params.containsKey("param02")) { 
//             if (params.get("param02") instanceof Integer) 
//             { 
//                 param02 = (Integer)params.get("param02"); 
//             } 
//         } 
//         // System.out.println(param01 +" : "+param02);
//     }
//     public static void  main(String[] args) 
//     {
//         ParamsWithMap mapobj = new  ParamsWithMap();
//         Map<String,Object> parameters = new HashMap<>();
//         parameters.put("param01", "Hello Test");
//         parameters.put("param02", 5);
//         mapobj.foo(parameters);
//         mapobj.foo();
        
//         // Map<String,Object> opparameters = new HashMap<>();
//         // opparameters.put();
//     }
// }

























// // import java.io.BufferedReader;
// // import java.io.IOException;
// // import java.io.InputStreamReader;

// // class printAndInput
// // {
// // 	public static void main(String args[])
// // 	{
// // 		try
// // 		{
// // 	        ParamsWithMap mapobj = new  ParamsWithMap();
// // 	        Map<String,Object> parameters = new HashMap<>();
// // 			print("Sharvani.");
// // 			// input("Enter name: ");
// // 		}
// // 		catch (Exception e)
// // 		{
// // 			System.err.println(e.getClass().getName() + ": " + e.getMessage() );
// // 			System.exit(0);
// // 		}
// // 	}

// // 	public void foo(Map<String,Object> params) 
// // 	{
// //         String  param01 = "default"; 
// //         Integer param02 = 0;
// //         if (params.containsKey("param01")) 
// //         { 
// //             if (params.get("param01") instanceof String) 
// //             {  
// //                 param01 = (String)params.get("param01"); 
// //             } 
// //         } 
// //         if (params.containsKey("param02"))
// //         { 
// //             if (params.get("param02") instanceof Integer) 
// //             { 
// //                 param02 = (Integer)params.get("param02"); 
// //             } 
// //         } 
// //         System.out.println(param01 +" : "+param02);
// //     }

// //     public static void print(String ) 
// //     {
// //         parameters.put("param01", "Hello Test");
// //         parameters.put("param02", 5);
// //         mapobj.foo(parameters);
        
// //         Map<String,Object> opparameters = new HashMap<>();
// //         opparameters.put("param01", "Azhwani");
// //         mapobj.foo(opparameters);
// //     }
// // }

	
// 	// {
// 	// 	System.out.println(stringToPrint);
// 	// }
// 	// public static String input(String stringToInput)
// 	// {
// 	// 	try
// 	// 	{
// 	// 		InputStreamReader isr = new InputStreamReader(System.in);
// 	// 		BufferedReader reader = new BufferedReader(isr);
// 	// 		System.out.print(stringToInput);
// 	// 		String name = reader.readLine();
// 	// 	}
// 	// 	catch (Exception e)
// 	// 	{
// 	// 		System.err.println(e.getClass().getName() + ": " + e.getMessage() );
// 	// 		System.exit(0);
// 	// 	}
// 	// 	return name;
// 	// }
// // }