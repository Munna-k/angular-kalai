pipeline {
    agent any
    tools {
    maven 'maven-3.9.0' 
  }
    stages{
        stage('Build') {
            steps{
                /* pull code from github 
                git credentialsId: 'Github', url: 'https://github.com/Munna-k/angular-kalai.git', branch: 'master' 
                 */
                sh 'mvn clean install'
            }
        }
        stage('test') {
            steps {
                echo "testing"
            }
        }
        stage('deploying') {
            steps {
                echo "deploying"
            }
        }
    }
}
