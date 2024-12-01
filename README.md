**WIP**
This repo needs significant work, including:
Proper handling of conversion to GraphStream Graph (currently ineffecient)
Compatabiltiy with command line args

# TraversalExperiments  
This repo houses experiments pertaining to graph traversal. Visualization is achieved using GraphStream.

# Setup  
- This project uses maven 3.9.9
- Clone this repo
- Install the below dependency to your local maven repo (needed for visualization), so it can be accessed in the pom.xml
```xml
<dependency>
    <groupId>org.graphstream</groupId>
    <artifactId>gs-ui-swing</artifactId>
    <version>2.0</version>
</dependency>
