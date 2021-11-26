# BioAgent
Bio Agent is used to extract information from multiple service providers. It is based on Java Agent DEvelopment framework (JADE). The following code is used to create an agent to print "Hello World!" and prints its name. 

```java
import jade.core.Agent;

  public class HelloAgent extends Agent 
  { 
      protected void setup() 
      { 
          System.out.println("Hello World!");
          System.out.println("My name is "+ getLocalName()); 
      }
  }
```
To comile and run above agent, use the following commands

<pre>
javac HelloAgent.java 
java jade.Boot BioAgent:HelloAgent
</pre>

For further reading visit my blog, <a href="https://shahshakir.wordpress.com/2012/01/02/inter-platform-agent-mobility-with-jade-4-1-and-jipms-1-2/">Inter-Platform Agent Mobility with JADE and JIPMS </a> ,briefly explains how to make an agent mobile. 
