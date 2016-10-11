package nio;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by hjh on 16-7-27.
 */
public class PathTest {
    public static void main(String[] args){
        Path path = Paths.get(".");
        System.out.println(path.getNameCount());
        System.out.println(path.getRoot());
        Path absolutePath = path.toAbsolutePath();
        System.out.println(absolutePath);
        System.out.println(absolutePath.getRoot());
        System.out.println(absolutePath.getNameCount());
        System.out.println(absolutePath.getName(3));
        Path path2 = Paths.get("g:","publish","codes");
        System.out.println(path2);
    }
}
