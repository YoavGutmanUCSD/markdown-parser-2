import static org.junit.Assert.*;
import org.junit.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.io.IOException;

public class MarkdownParseTest2 {
   
    @Test 
    public void getLinksCheck1() throws IOException{

        String fileName = "s1.md";
        Path fileName1 = Path.of(fileName);
        String content = Files.readString(fileName1);
        ArrayList<String> expected=new ArrayList<String>();
        expected.add("`google.com");
        expected.add("google.com");
        expected.add("ucsd.edu");

        assertEquals(( expected), MarkdownParse.getLinks(content) );
    }

    @Test 
    public void getLinksCheck2() throws IOException{
        
        String fileName = "s2.md";
        Path fileName1 = Path.of(fileName);
        String content = Files.readString(fileName1);
       ArrayList<String>  expected=new ArrayList<String>();
       expected.add("a.com");
       expected.add("a.com(())");
       expected.add("example.com");

        assertEquals((expected), MarkdownParse.getLinks(content) );
     }

    @Test
    public void getLinksCheck3() throws IOException{
        
        String fileName = "s3.md";
        Path fileName1 = Path.of(fileName);
        String content = Files.readString(fileName1);
       ArrayList<String>  expected=new ArrayList<String>();
       expected.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
      
        assertEquals((expected), MarkdownParse.getLinks(content) );
    }

}