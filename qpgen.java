package qpgen1;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.*; 
import java.util.*; 

public class qpgen {
	public static void fixQno()
	{
		LogManager logmgr = LogManager.getLogManager();
		Logger log= logmgr.getLogger(Logger.GLOBAL_LOGGER_NAME);
		log.log(Level.INFO,"QPGen:FixQno");
                try
			{ 
			     	Scanner scan=new Scanner(System.in);
		 		
		   		Connection con = editmode.connect();
				Statement printall=con.createStatement();
			
				String sql="SELECT QSUBJECT FROM QBANK";
				ResultSet r = printall.executeQuery(sql);
                                System.out.println("Subject List");
				int count=0;
				while(r.next())
				{
					count++;
				}
				 r = printall.executeQuery(sql);
		 		String s[]=new String[count];
		 		String qsubject;
          			s[0]=r.getString("qsubject");
        			int j=1;
				while ( r.next() ) 
				{	int flag=0;
				  	qsubject=r.getString("qsubject");
				 	for(int i=0;i<j;i++)
				 	{
				 		if(s[i].equals(qsubject))
				 		{
				 			flag=1;
				 			break;
				 		}
				 	
				         }
						 if(flag==0)
						 {
				 			 //s[i]=new String;
				 			s[j]=qsubject;
				 			j++;
				 		}
					}

						for(int i=0;i<j;i++)
						{
							System.out.println(s[i]);
						}
					System.out.println("Enter Subject");
					String qsub=scan.next();
					
                                         con = editmode.connect();
					Statement print=con.createStatement();
					System.out.println("Topic List");
					sql="SELECT DISTINCT QTOPIC FROM QBANK WHERE QSUBJECT ='"+qsub+"';";
                                        
					ResultSet a = print.executeQuery(sql);
                                        
				        count=0;
					while(a.next())
					{
						count++;
					}
					a= print.executeQuery(sql);
		 			String []s2=new String[count];
                                       
                                      
          			        j=0;
                                       String qtopic;
					while ( a.next() )
				       {
					int flag=0;
				 	 qtopic=a.getString("qtopic");
				 	/*for(int i=0;i<j;i++)
				 	{
				 			if(s2[i].equals(qtopic))
				 			{
				 				flag=1;
				 				break;
				 			}
				 	
				 	}
				 	if(flag==0)
				 	{
				 	// s2[i]=new String;
                                            //System.out.println(qtopic);
				 		s2[j]=qtopic;
				 		j++;
				 	}*/
                                        System.out.println(qtopic);
				       }
					/*for(int i=0;i<j;i++)
					{
							System.out.println(s2[i]);
					}*/
					System.out.println("Enter topic");
				
					String topic=scan.next();
					int arr[]=new int[100];
	                            print=con.createStatement();
				    sql="SELECT QSUBJECT,QTOPIC,QNOS FROM QBANK";
				    ResultSet d=print.executeQuery(sql);
				    int i=0;
                    while(d.next())
                    {
                	
                	  String subj=d.getString("qsubject");
                	  String top=d.getString("qtopic");
                	  int no=d.getInt("qnos");
                	  if(subj.equals(qsub)&&(top.equals(topic)))
                	  {
                		
                		  arr[i]=no;
                		  i=i+1;
                	  }
                   }
                int n;
           
                System.out.println("enter the number of questions");
                n=scan.nextInt();
                

                 ArrayList<Integer> list = new ArrayList<Integer>();
       			 for (int k=0; k<i; k++) {
            			list.add(new Integer(k));
       				 }
        		Collections.shuffle(list);
        		int []qno=new int[100];
             if(n<i)
             {
             }
             else
             {  n=i;
                System.out.println("The no. of questions of the topic are "+n);
             }
             if(n!=0)
             {
        		for(int k=0;k<n;k++)
              	{
               	 		qno[k]=arr[list.get(k)];
               	}
                        System.out.println("the question numbers are-");
                       
                        for(int k=0;k<n;k++)
                               System.out.println(qno[k]);
             }          

           }	 
                catch (Exception e)
                 {
                 System.err.println("Got an exception! ");
                 System.err.println(e.getMessage());
                }


	}
}
