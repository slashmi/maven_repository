package mavendemo.executable;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * This app verifies if an executable jar file has been downloaded from GIT repository
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException{
    
               
    	
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            if (classLoader instanceof URLClassLoader)
            {
                URLClassLoader urlClassLoader = (URLClassLoader) classLoader;
                URL [] urls = urlClassLoader.getURLs();               
                for (URL url : urls)
                {
                    File file = new File(url.getFile());
                    if (file.getPath().endsWith("taco-cloud-0.0.1-SNAPSHOT.jar"))
                    {
                        System.out.println( "Executable jar  exists");
                        return;
                    }
                }
                System.out.println( "Executable jar does not exist");
            }
       
 }
    
}

