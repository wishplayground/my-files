import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class NIOFileWalker {
    public static void main(String[] args) {
        
        Path targetPath = Paths.get("/home/wishva/Downloads");
        try {
            Files.walkFileTree(targetPath, new MySimpleFileVisitor());
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
}

class MySimpleFileVisitor extends SimpleFileVisitor<Path>{

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(Files.isDirectory(file)) System.out.println(file.toAbsolutePath());//when visit file
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException { //
        

        return FileVisitResult.CONTINUE;
    }

}
