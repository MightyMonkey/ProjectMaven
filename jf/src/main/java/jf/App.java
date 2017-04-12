package jf;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
	App instance = new App();
        System.out.println( "Hello World!" );
	int a= instance.max(4,5);
	System.out.println("max: "+a);
    }
    public int max(int a,int b)
	{
		return a;//le stagiaire est passé par là  >b ? a:b;
	}
}
