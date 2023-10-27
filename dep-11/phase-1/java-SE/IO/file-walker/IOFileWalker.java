import java.io.File;

public class IOFileWalker{
    public static void main(String[] args) {
        String target = "/home/wishva/Desktop/";
        File fileRef = new File(target);
        /* File[] fileList = fileRef.listFiles();
        System.out.println(fileRef.getName() + "content");
        System.out.println("=============================");
        for (File file : fileList) {
            System.out.println();
            System.out.println(file.isDirectory() ? "Directory": "File" +"-" + file.getAbsolutePath());
        } */

        listDirectoryContent(fileRef);
    }

    public static void listDirectoryContent(File directory){
        System.out.println(directory.getName() + "  Content");
        System.out.println("==============================");
        File[] listFiles = directory.listFiles();

        for (File file : listFiles) {
            System.out.println(file.getAbsolutePath());
            if(file.isDirectory()) listDirectoryContent(file);
        }
    }
}