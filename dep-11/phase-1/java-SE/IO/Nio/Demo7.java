import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Demo7{
    public static void main(String[] args) throws Exception {
        
        Path path = Paths.get("async.txt");
        Files.createFile(path);
        try(var channel = AsynchronousFileChannel.open(path,StandardOpenOption.WRITE)){
            String msg = "This is what i want to write";
            ByteBuffer bytes = Charset.defaultCharset().encode(msg);
            channel.write(bytes, 0, null, new CompletionHandler<Integer,Object>() {

                @Override
                public void completed(Integer result, Object attachment) {
                    System.out.println("File saved");
                }

                @Override
                public void failed(Throwable exc, Object attachment) {
                    System.out.println("Failed to save the file");
                }
                
                
            });

            System.out.println("-----------------------------------");
            System.out.println("I'm not blocked working now");
            Thread.sleep(500);
        }
    }
}