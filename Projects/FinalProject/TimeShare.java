import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TimeShare {

    static Queue InputQueue = new Queue();
    static Queue ActiveJob = new Queue();
    static Queue Completed = new Queue();
    static int Runtime = 0;
    static double Idletime = 0;
    static double UsageTime = 0;
    static double WaitTime = 0;

    public static void main (String[] args) throws FileNotFoundException {
        String file = (args[0]);
        fillInputQueue(file);
        printHeader();
        jobRunner();
        OutputResults();
    }

    private static void OutputResults() {
        double numTasks = 0;
        while (!Completed.isEmpty()){
            System.out.println(Completed.peek());
            Completed.dequeue();
            numTasks+=1;
        }
        System.out.println("Average Wait Time:  "+WaitTime/numTasks);
        System.out.println("CPU Usage:          "+UsageTime);
        System.out.println("CPU Idle:           "+Idletime);
        System.out.println("CPU Usage (%):      "+100*(UsageTime/(UsageTime+Idletime)));
    }

    private static void jobRunner() {
        while(!InputQueue.isEmpty() || !ActiveJob.isEmpty()) {
                //Creates temp Job that represents head of Input queue
                //When The Input Queue is not empty
                // if the arrival time of its head is equal to the
                // runtime add it to the active job queue and delete it from the Input Queue
                if(!InputQueue.isEmpty()) {
                    Job temp = (Job) InputQueue.peek();
                    if (temp.arrivalTime == Runtime) {
                        ActiveJob.enqueue(temp);
                        InputQueue.dequeue();
                    }
                }
                //When the Active job queue is not empty check to see if the head of the queue is finished
                //if so update the turnaround time, add it to the finish queue and dequeue it
                if (!ActiveJob.isEmpty()) {
                    Job temp2 = (Job) ActiveJob.peek();
                    if (temp2.startTime + temp2.runTime == Runtime) {
                        temp2.turnTime = Runtime - temp2.arrivalTime;
                        Completed.enqueue(temp2);
                        ActiveJob.dequeue();
                    }
                }

                //Begins job at front of queue if not already started
                if (!ActiveJob.isEmpty()) {
                    Job temp3 = (Job) ActiveJob.peek();
                    if ((temp3.arrivalTime <= Runtime) && temp3.startTime < 0) {
                        temp3.startTime = Runtime;
                        temp3.waitTime = Runtime - temp3.arrivalTime;
                        WaitTime += Runtime - temp3.arrivalTime;
                        ActiveJob.update(temp3);
                    }
                }

                //checks idle time and active time
                if(ActiveJob.isEmpty()&&!InputQueue.isEmpty()){
                    Idletime+=1;
                }
                else if(!ActiveJob.isEmpty()){
                    UsageTime+=1;
                }

                //Increments your clock
                Runtime++;
        }
    }

    private static void printHeader() {
        System.out.println("Job ID      Arrival Time        Start Time      Run Time        Wait Time       Turnaround");
        System.out.println("------------------------------------------------------------------------------------------");
    }

    private static void fillInputQueue(String arg) throws FileNotFoundException {

        Scanner JobReader = new Scanner(new File(arg)).useDelimiter(",");
        while (JobReader.hasNext()){
            String Name = JobReader.next();
            int Arrival = JobReader.nextInt();
            int Run = JobReader.nextInt();
            new Job(Name, Arrival, Run);
            InputQueue.enqueue(new Job(Name, Arrival, Run));
        }
    }

}
