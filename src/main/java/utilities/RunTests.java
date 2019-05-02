package utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import smoke.LoginPageTest;

public class RunTests {

       public static void run(String[] args) throws IOException {
    	ClassLoader loader = new RunTests().getClass().getClassLoader();

              TestNG mytestng =new TestNG();
              //Create an instance of XML Suite and assign a name for it. 
             XmlSuite mySuite = new XmlSuite();
             mySuite.setName("IBCG2_Smoke_Suite");
             XmlTest myTest = new XmlTest(mySuite);
             myTest.setName("Test");
             
             Map<String, String> parameters = new HashMap<String, String>();
             parameters.put("browser", "chrome");
             parameters.put("environment", "QAI");
              myTest.setParameters(parameters);
              
              List<XmlClass> myClasses = new ArrayList<XmlClass>() ;
              XmlClass myClass = new XmlClass();
              XmlClass myClass2 = new XmlClass();
              myClass.setName("utilities.DriverInit");
              myClasses.add(myClass);
              
              myClass2.setName("smoke.LoginPageTest");
              myClasses.add(myClass2);
              
//              myClasses.add(new XmlClass("utilities.DriverInit"));
//              myClasses.add(new XmlClass("smoke.LoginPageTest"));
              myTest.setXmlClasses(myClasses);
              
              List<XmlTest> myTests = new ArrayList<XmlTest>() ;
              myTests.add(myTest);
              mySuite.setTests(myTests);
              
              List<XmlSuite> mySuites = new ArrayList<XmlSuite>() ;
              mySuites.add(mySuite);
              
              mytestng.setXmlSuites(mySuites);
              
              File myfile = new File("testng.xml");
              FileWriter writer = new FileWriter(myfile);
              writer.write(mySuite.toXml());
                 System.out.println( mySuite.toXml());
              writer.close();
            
           
              mytestng.run();
              
                     
       }
       

}

