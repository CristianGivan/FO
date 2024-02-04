pipeline {
    agent any
    tools{
        maven 'maven_3_9_0'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/release']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/CristianGivan/FO.git']])
                sh 'mvn clean install'
            }
        }
        stage('remove the  container'){
            steps{
                script{
                    sh 'docker rm -f fo-app'
                }
            }
        }
        stage('remove the  image'){
            steps{
                script{
                    sh 'docker rmi -f  givanc/fo-app:latest'
                }
            }
        }
        stage('Create image'){
            steps{
                script{
                    sh 'docker build -t givanc/fo-app:latest .'
                }
            }
        }
        stage('Start container'){
                    steps{
                        script{
                            sh 'docker compose up -d --wait'
                        }
                    }
                }
        stage('Push image to Hub'){
            steps{
                script{
                    withCredentials([string(credentialsId: 'DockerHubPWD', variable: 'DockerHubPWD')]) {
                    sh 'docker login -u givanc -p ${DockerHubPWD}'
                    sh 'docker push givanc/fo-app'
                    }
                }
            }
        }
    }
}
