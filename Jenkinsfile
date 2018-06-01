node('master') 
{
   stage('ContinuousDownload') 
   {
    git 'https://github.com/selenium-saikrishna/maven.git'
   }
   stage('ContinuousBuild') 
   {
      sh 'mvn package'
   }
   stage('ContinuousDeployment')
   {
       sh 'scp /home/vagrant/.jenkins/workspace/Pipeline/webapp/target/webapp.war vagrant@10.0.0.21:/var/lib/tomcat7/webapps/qaenv.war'
   }
   stage('ContinuousTesting')
   {
       git 'https://github.com/selenium-saikrishna/TestingOnLinux.git'
  
       sh 'java -jar /home/vagrant/.jenkins/workspace/Pipeline/testing.jar'
   }
   stage('ContinuousDelivery')
   {
       input message: 'Waiting for approval for Delivery', submitter: 'Venu'
       sh 'scp /home/vagrant/.jenkins/workspace/Pipeline/webapp/target/webapp.war vagrant@10.0.0.22:/var/lib/tomcat7/webapps/prodenv.war'
   }
   
