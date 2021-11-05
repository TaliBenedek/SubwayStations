import java.util.*;

public class Node implements Comparable<Node>
{
    private SubwayStations.Station station;
    private double distance = Integer.MAX_VALUE; //distance from source node
    private List<SubwayStations.Station> shortestPath = new ArrayList<>();
    private List<Node> neighbors = new ArrayList<>();
    private Node previous;

    public Node(SubwayStations.Station station)
    {
        this.station = station;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        Node node = (Node) o;
        return this.station.equals(node.station);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(station);
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }

    public double getDistance()
    {
        return distance;
    }

    public void setShortestPath(List<SubwayStations.Station> shortestPath)
    {
        this.shortestPath = shortestPath;
    }

    @Override
    public String toString()
    {
        return "Node:" + station.toString();
    }

    public void addToPath(Node node)
    {
        shortestPath.add(node.getStation());
    }

    public List<SubwayStations.Station> getShortestPath()
    {
        return shortestPath;
    }

    public void addNeighbor(Node node)
    {
        neighbors.add(node);
    }

    public List<Node> getNeighbors()
    {
        return neighbors;
    }

    public SubwayStations.Station getStation()
    {
        return station;
    }

    public void setPrevious(Node node)
    {
        previous = node;
    }

    public Node getPrevious()
    {
        return previous;
    }

    @Override
    public int compareTo(Node o)
    {
        return Double.compare(this.distance, o.distance);
    }
}
