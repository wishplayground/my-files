import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Demo{
    public static void main(String[] args) throws IOException {
        /* /*io */
        /* In windows this list all Volume (C,D,E) */
        /* File[] listRoots = File.listRoots();
        System.out.println(Arrays.toString(listRoots));
        for (File file : listRoots) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                System.out.println(file2.getAbsolutePath());
            }
        } */ 
        
        System.out.println("===================================================");
        /*nio */
        /* In windows this list all Volume (C,D,E) */
        Iterable<Path> rootDirectories = FileSystems.getDefault().getRootDirectories();
        for (Path path : rootDirectories) {
            DirectoryStream<Path> folderContent = Files.newDirectoryStream(path);
            //folderContent.forEach(p -> System.out.println(p.toAbsolutePath()));//equals to below loop
            for (Path path2 : folderContent) {
                System.out.println(path2.toAbsolutePath());
            }
            
        }
    }
}