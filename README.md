# Automation-task
This project automates essential tasks involving data processing, cleaning, and email delivery using Java. 

## Prerequisites  
- **Java 11 or higher**  
- **Maven** for dependency management  
- **Google Chrome** and the corresponding **ChromeDriver**  


## Setup  
1. Clone the repository:  
   ```bash  
   git clone https://github.com/alaawahba13/Automation-task.git  
   cd ./../TemplateMavenProject  
   ```  

2. Build the project:  
   ```bash  
   mvn clean package  
   ```  

3. Configure the application:  
   - Edit the `src/main/resources/app.properties` file:  
     ```properties  
     email=<your-email>  
     password=<your-password>  
     ```  
   - Ensure the chromedriver is placed in the `driver/` directory.  

---

## Running the Project  
### From IDE  
- Open the project in IntelliJ IDEA.  
- Run the `Main` class from `com.vois.autotask`.  

### From JAR  
- Build the JAR file:  
   ```bash  
   mvn package  
   ```  
- Run the JAR:  
   ```bash  
   java -jar target/TemplateMavenProject.jar  
   ```  

---

## Project Structure  
```  
TemplateMavenProject/  
├── src/  
│   ├── main/  
│   │   ├── java/com/vois/autotask/  
│   │   │   ├── Main.java  
│   │   │   ├── datacleaning/
│   │   │   │    ├── CalculateYears.java
│   │   │   │    ├── SorterAndDeduplicator.java
│   │   │   ├── datadelivery/
│   │   │   │    ├── Email.java
│   │   │   ├── pages/
│   │   │   │    ├── InboxPage.java
│   │   │   │    ├── LogInPage.java
│   │   └── resources/  
│   │       └── app.properties  
│   └── test/  
├── data/  
│   └── TaskData.xlsx
├── driver/  
│   └── chromedriver.exe 
├── target/  
│   └── TemplateMavenProject.jar  
└── pom.xml  
```  

### Task Execution 
https://github.com/user-attachments/assets/4fae9a7c-a54d-41a4-9318-0c5d7ff73769

### Task Data
![Screenshot 2024-11-15 210644](https://github.com/user-attachments/assets/83ce5694-9eb9-44a0-a76c-64cdacd283c2)

### Modified Task Data
![Screenshot 2024-11-15 210708](https://github.com/user-attachments/assets/e9881acd-53d6-4159-a9b1-aa8de00544a5)


