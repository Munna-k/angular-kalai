pipeline {
    agent any
    stages{
        stage('Build') {
            steps{
                /* pull code from github 
                git credentialsId: 'Github', url: 'https://github.com/Munna-k/angular-kalai.git', branch: 'master' */
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
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
