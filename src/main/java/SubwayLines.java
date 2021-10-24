import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SubwayLines extends HashMap<String, String[]>
{
    public String[] getConnectedStations(String stationName, SubwayStations stations)
    {
        String objectId = stations.getObjectId(stationName);
        ArrayList<String> connections = new ArrayList<>();
        Iterator<Entry<String, String[]>> it = this.entrySet().iterator();
        while(it.hasNext())
        {
            String[] line = it.next().getValue();
            for(int index = 0; index < line.length; index++)
            {
                if(line[index].equals(objectId))
                {
                    if(!connections.contains(stations.getName(line[index-1])))
                    {
                        connections.add(stations.getName(line[index - 1]));
                    }
                    if(!connections.contains(stations.getName(line[index+1])))
                    {
                        connections.add(stations.getName(line[index + 1]));
                    }
                }
            }
        }
        return connections.toArray(new String[0]);
    }
}
