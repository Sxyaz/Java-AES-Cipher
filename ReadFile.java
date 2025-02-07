import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFile {
	public String Read(String _path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(_path)));
	}
}