pipeline {
    environment {
        registry = "mehakdogra0067/scientific_calculator"
        registryCredential = 'docker-hub-credentials'
        dockerImage = ''
        dockerImageLatest = ''
  }
    agent any
    stages {
        stage ('SCM Checkout') {
            steps {
                git credentialsId: 'github-credentials', url: 'https://github.com/MehakDogra7/Calculator_SPE.git'
            }
        }

        stage('Maven Build'){
                steps {
                     sh 'mvn clean test package'
                }
        }

        stage('Docker Image Build') {
          steps{
            script {
              dockerImage = docker.build registry + ":${env.BUILD_NUMBER}"
              dockerImageLatest = docker.build registry + ":latest"
            }
          }
        }

        stage('Push Docker Image') {
              steps{
                script {
                  docker.withRegistry( '', registryCredential ) {
                    dockerImage.push()
                    dockerImageLatest.push()
                  }
                }
              }
        }

        stage('Remove Unused docker image') {
          steps{
            sh "docker rmi $registry:${env.BUILD_NUMBER}"
            sh "docker rmi $registry:latest"
          }
        }

        stage ('Deploy Code to Production Host') {
            steps {
                ansiblePlaybook installation: 'Ansible', playbook: 'calculator-playbook.yml'
            }
        }
    }
}