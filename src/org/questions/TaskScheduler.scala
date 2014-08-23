package org.questions

/*
 * 
There are at most eight servers in a data center. 
Each server has got a capacity/memory limit. 
There can be at most 8 tasks that need to be scheduled on those servers. Each task requires certain capacity/memory to run, and each server can handle multiple tasks as long as the capacity limit is not hit. Write a program to see if all of the given tasks can be scheduled or not on the servers? 

Ex: 
Servers capacity limits: 8, 16, 8, 32 
Tasks capacity needs: 18, 4, 8, 4, 6, 6, 8, 8 
For this example, the program should say 'true'. 

Ex2: 
Server capacity limits: 1, 3 
Task capacity needs: 4 
For this example, program should return false. 
 * 
 */
object TaskScheduler extends App{
    val servers = List(6)
	  val tasks = List(1)
  
	def canScheduleTasksOnServers(s1: List[Int],t: List[Int]): Boolean = {
	  def schedule(currentTask: Int,remainingTasks: List[Int], currentServers: List[Int]):Boolean = {
		  if(remainingTasks == Nil) currentServers.exists(p => p-currentTask >= 0) 
		  else if ((currentServers.forall(p => p-currentTask < 0))) false 
		  else {
			  schedule(remainingTasks.head,remainingTasks.tail, (currentServers.sorted.map(x => if(x-currentTask >= 0) (x-currentTask) else x)).toList) 
		  }
	  } 
	  schedule(t.head,t.tail,s1)
	}
	
	println("Can Schedule " + canScheduleTasksOnServers(servers,tasks))
	
}
