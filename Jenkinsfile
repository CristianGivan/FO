pipeline {
    agent any
    tools{
        maven 'maven_3_9_0'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/CristianGivan/testCICD.git']])
                sh 'mvn clean install'
            }
        }
         stage('Start container'){
            steps{
                script{
                    sh 'docker build -t givanc/fo-app:latest .'
                }
            }
        }
               stage('Docker compose up'){
            steps{
                script{
                    sh 'docker compose up -d --wait'
                    sh 'docker compose ps'
                }
            }
        }
    }
}