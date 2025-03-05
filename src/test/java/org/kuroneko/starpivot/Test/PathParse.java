package org.kuroneko.starpivot.Test;

import org.apache.hadoop.fs.Path;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URISyntaxException;

public class PathParse {

    @Test
    public void test() throws URISyntaxException {
        Path path = new Path("hdfs://localhost:9000/star-pivot/config");
        URI uri = path.toUri();

        URI uri1 = new URI("hdfs://localhost:9000/star-pivot/config");
        System.out.println(uri.getPath());
        System.out.println(uri1.getPath());
    }
}
