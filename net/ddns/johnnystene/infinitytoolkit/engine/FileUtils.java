package net.ddns.johnnystene.infinitytoolkit.engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public ArrayList<String> getResourceFiles(String path) throws IOException {
        ArrayList<String> filenames = new ArrayList<>();

        try (
                InputStream in = this.getClass().getResourceAsStream(path);
                BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            String resource;

            while ((resource = br.readLine()) != null) {
                filenames.add(resource);
            }
        }

        return filenames;
    }
}
