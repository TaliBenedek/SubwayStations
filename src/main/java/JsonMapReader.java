import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class JsonMapReader
{
    SubwayLines lines;

    public SubwayLines readJsonAsMap() throws IOException
    {
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("SubwayLines.json"));
        SubwayLines lines = gson.fromJson(reader, SubwayLines.class);
        reader.close();
        return lines;
    }
}
