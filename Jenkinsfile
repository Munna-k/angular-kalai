// Declarative //
pipeline {
  agent any
  stages {
  stage('Build') {
  steps {
  echo 'Building..'
  sh 'make'
  archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true 
  }
  }
  stage('Test') {
  steps {
  echo 'Testing..'
  }
  }
  stage('Deploy') {
  steps {
  echo 'Deploying....'
  }
  }
  }
}
// Script //
node {
  stage('Build') {
  echo 'Building....'
  sh 'make' 
  archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true 
  }
  stage('Test') {
  echo 'Building....'
  }
  stage('Deploy') {
  echo 'Deploying....'
  }
}
