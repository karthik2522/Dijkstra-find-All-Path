import java.util.Scanner;
class Dijkstra
{
	 int n,src;
	 int a[][]=new int[10][10];
	 void read_cost_adjacency_matrix()
	{
		    System.out.println("********* DIJKSTRA'S ALGORITHM *********");
		    System.out.println("Enter no. of nodes :");
		    Scanner sobj=new Scanner (System.in);
		    n=sobj.nextInt();
		    System.out.println("Enter cost adjacency matrix :");
		    for(int i=1;i<=n;i++)
		   {
			for(int j=1;j<=n;j++)
			{
				a[i][j]=sobj.nextInt();
			}
		   }
			System.out.println("Enter source vertex :");
			src=sobj.nextInt();
			sobj.close();
	}
	 
	 void find_short_distance_path()
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
System.out.println("The shortest path and distance is shown below:");
System.out.println("DEST VERTEX<-(Intermediate vertices)<-SOURCE=DISTANCE");
		 
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

public class example
{
	public static void main(String[] args) 
	{
		Dijkstra ob=new Dijkstra();
		ob.read_cost_adjacency_matrix();
		ob.find_short_distance_path();
	}
}
