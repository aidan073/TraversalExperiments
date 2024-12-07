**WIP**  

# TraversalExperiments  
This repo houses experiments pertaining to graph traversal. Visualization is achieved using GraphStream.

# Setup  
- This project uses maven 3.9.9
- Clone this repo  
- cd to project root "traversalexperiments"
- Install the below dependency to your local maven repo (needed for visualization), so it can be accessed in the pom.xml
```xml
<dependency>
    <groupId>org.graphstream</groupId>
    <artifactId>gs-ui-swing</artifactId>
    <version>2.0</version>
</dependency>
```  
- Run the following command:
```bash
mvn clean install
```
# Usage  
  
**Example Usages:**  
```
mvn exec:java -Dexec.mainClass="com.aidan.traversalexperiments.App" -Dexec.args="--traverse DFS connected-graph"  
```
```
mvn exec:java -Dexec.mainClass="com.aidan.traversalexperiments.App" -Dexec.args="--search BFS binary-tree" 
```
``` 
mvn exec:java -Dexec.mainClass="com.aidan.traversalexperiments.App" -Dexec.args="--pipeline speedNodesTraverse"  
```
  
**Flags:**  
--traverse <traversal_method> <graph_type>  
  
--search <search_method> <graph_type>  

--pipeline <pipeline_name>  

**traversal_method/search_method options:**  
DFS  
BFS 

**graph_type options:**  
binary-tree  
connected-graph  

**pipeline options:**  
speedEdgesSearch  
speedEdgesTraverse  
speedNodesSearch  
speedEdgesSearch
