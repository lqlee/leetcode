class Solution {
  public int numBusesToDestination(int[][] routes, int source, int target) {
    if (source == target)
      return 0;
    
    int maxStop = -1;
    for (int [] r : routes)
      for (int stp : r)
        maxStop = Math.max(maxStop, stp);
    
    if (target > maxStop)
      return -1;
    
    int rtLen = routes.length;
    int [] stops = new int [maxStop + 1];
    Arrays.fill(stops, rtLen + 1);
    
    stops[source] = 0;
    boolean isUpdated = true;
    
    while (isUpdated) {
      
      isUpdated = false;
      for (int [] rt : routes) {
        
        int numberOfBuses = rtLen + 1;
        for (int stp : rt)
          
          if ( stops[stp] < numberOfBuses )
            numberOfBuses = stops[stp];
        
        numberOfBuses ++;
        
        for (int stp : rt)
          if (stops[stp] > numberOfBuses) {
            stops[stp] = numberOfBuses;
            isUpdated = true;
          }
      }
    }
    
    return stops[target] != rtLen + 1 ?stops[target] : -1;

  }
}
