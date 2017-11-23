/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author Olive Tamondong
 * @version    2017.11.23
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private int[] dayCounts;
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     * @param logfile The file to be analyzed 
     */
    public LogAnalyzer(String logfile)
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        dayCounts = new int[28];
        // Create the reader to obtain the data.
        reader = new LogfileReader(logfile);
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }
    
    
    /**
     * Return number of accesses recorded in the log file.
     * @return The total number of accesses in the log file.
     * 
     * Exercise 7.13 and 7.14
     */
    public int numberOfAccesses()
    {
        int total = 0;
        for(int hour=0; hour< hourCounts.length; hour++)
        { 
            total += hourCounts[hour];
        }
        return total;
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    /** 
     * @return Return the busiest hour in the log file.
     * hours are from 0-23.
     */
    public int busiestHour()
    {
      int busiestHr = 0;
      for(int hour=0; hour< hourCounts.length; hour++)
        { 
            if(hourCounts[busiestHr] < hourCounts[hour])
            {
                busiestHr = hour;
            }
              
        } 
        return busiestHr ;
       
    }
    
    //print the busiest hour
    public void printBusiestHour()
    { 
        System.out.println("Busiest Hour: " + busiestHour());
    }
    
    
    
    
    /** 
     * @return Return the quietest hour in the log file.
     * hours are from 0-23.
     */
    public int quietestHour()
    {
      int quietestHr = 0;
      for(int hour=0; hour< hourCounts.length; hour++)
        { 
            if(hourCounts[quietestHr] > hourCounts[hour])
            {
               quietestHr = hour;
            }
              
        } 
        return quietestHr ;
       
    }
    
    //print the quietest hour
    public void printQuietestHour()
    { 
        System.out.println("Quietest Hour: " + quietestHour());
    }
    
    public int busiestTwoHour()
    {
     int busiestTwoHour = 0;
     int busiestTwoHourCounts = 0;
     for(int hour = 0; hour<hourCounts.length - 1; hour++)
     {   
         //add the counts for the two hours
         int twoHourCounts = hourCounts[hour] + hourCounts[hour + 1]; 
         if(twoHourCounts > busiestTwoHourCounts)
         {
             busiestTwoHour = hour;
             busiestTwoHourCounts = twoHourCounts;    
         }
     }
        return busiestTwoHour;
        //return busiestTwoHourCounts; CAN YOU ONLY MAKE ONE RETURN.
    }
    
    public void printBusiestTwoHour()
    {
        System.out.println("Busiest Two Hour starts at hour: " + busiestTwoHour() );
    }
    
   
    // PROBLEM: KEEPS SAYING OUT OF BOUND. ASK PROFESSOR.
    // /**
     // * Analyze the hourly access data from the log file.
     // */
    // public void analyzeDailyData()
    // {
        // while(reader.hasNext()) {
            // LogEntry entry = reader.next();
            // int day = entry.getDay();
            // dayCounts[day -1]++;
        // }
    // }
    
    // /**
     // * @return Returns the busiest DAY 
     // */
    
    // public int busiestDay()
    // {
        // analyzeDailyData();
        // int busiestDay = 0;
        // for( int day = 0; day < dayCounts.length; day++)
        // {
          // if (dayCounts[busiestDay] < dayCounts[day])
          // {
              // busiestDay = day;
          // }
        // }
        // return busiestDay;
         
    // }
    
    // public void printBusiestDay()
    // { 
        // System.out.println("Busiest Day: " + busiestDay());
    // }
    
    
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
        
    }
}
