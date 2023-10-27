import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannel;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Demo5 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("something.txt", args);

        try(var channel = AsynchronousFileChannel.open(path, StandardOpenOption.READ)){
            ByteBuffer buffer =  ByteBuffer.allocate(1024);
            Future<Integer> future = channel.read(buffer, 0);//while this is executing
            CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() ->{
                try{
                    future.get();
                    buffer.flip();
                    return Charset.defaultCharset().decode(buffer).toString();
                }catch(Exception e){
                    e.printStackTrace();
                }
            });

            completableFuture.thenAccept(t ->{
                buffer.flip();
                System.out.println(Charset.defaultCharset().decode(buffer));
            });
            //lest's do something else here
            System.out.println("====================================================");
            System.out.println("I can Execute this code. I'm not blocked");
            completableFuture.thenAccept(System.out::println);
            System.out.println("Finally");
        }
    }
}
