import java.util.Scanner;
class Dijkstra
{
	 int n,src;
	 int a[][]=new int[10][10];
	 void read_matrix()
	{
		    System.out.println("********* DIJKSTRA'S ALGORITHM *********");
		    System.out.println("Enter no. of nodes :");
		    Scanner obj=new Scanner (System.in);
		    n=obj.nextInt();
		    System.out.println("Enter cost Matrix :");
		    for(int i=1;i<=n;i++)
		   {
			for(int j=1;j<=n;j++)
			{
				a[i][j]=sobj.nextInt();
			}
		   }
			System.out.println("Enter source vertex :");
			src=obj.nextInt();
			obj.close();
	}
	 
	 void find_path()
	 {
		 int i,j,v,min,u=0;
		 int d[]=new int[10];
		 int p[]=new int[10];
		 int s[]=new int[10];
		 for(i=1;i<=n;i++)
		 {
				d[i]=a[src][i];
				p[i]=src;
				s[i]=0;
		 }
		 
		 s[src]=1;
		 d[src]=0;
		 //find shortest distance & the path to other vertices
		 for(i=1;i<n;i++)
		 {
			 for(j=1,min=999;j<=n;j++)
			 {
				 if(s[j]==0 && d[j]<min)
				 {
					 min=d[j];
					 u=j;
				 }
			 }//end of j for loop
		  
			 s[u]=1;
			 
			 for(v=1;v<=n;v++)
			{
					if(s[v]==0 && d[u]+a[u][v]<d[v])
					{
						d[v]=d[u]+a[u][v];
						p[v]=u;
					}
			}//end of v for loop 
		 }//end of i for loop
System.out.println("The shortest path From Source to Destination:");
		 
		 for(j=1;j<=n;j++)
		 {
			 if(d[j]==9999)
				 System.out.println(j+"<-"+src+"="+d[j]);
			 else if(d[j]==0)
		 		  System.out.println(j+"<-"+src+"="+d[j]);
		 	 else
		 	 {	 
		 		 i=j;
		 		 while(i!=src)
		 		 {
		 			 System.out.print(i+"<-");
		 			 i=p[i];
		 		 }
		 		 System.out.println(i+"="+d[j]);
		 	 }
		 }//end of j for loop
 }
}

public class Dijkstra1
{
	public static void main(String[] args) 
	{
		Dijkstra ob=new Dijkstra();
		ob.read_matrix();
		ob.find_path();
	}
}
