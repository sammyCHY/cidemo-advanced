pipeline {
    agent any

    environment {
        // Docker Hub credentials stored in Jenkins credentials
        DOCKER_HUB_CREDENTIALS = credentials('docker-hub-credentials')
        // Docker Hub repository details
        DOCKER_HUB_REPO = 'fykio/cidemo'
        DOCKER_IMAGE_TAG = 'latest'
    }

    stages {
        // Stage 1: Checkout code from GitHub using GitHub App integration
        stage('Checkout Code') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/main']],
                    extensions: [],
                    userRemoteConfigs: [[
                        url: 'https://github.com/Fykio/cidemo.git',
                        credentialsId: 'github-app-credentials' // Your GitHub App credentials ID in Jenkins
                    ]]
                ])
            }
        }

        // Stage 2: Package the application using Maven
        stage('Package with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        // Stage 3: Build Docker image
        stage('Build Docker Image') {
            steps {
                script {
                    // Build the Docker image
                    dockerImage = docker.build("${env.DOCKER_HUB_REPO}:${env.DOCKER_IMAGE_TAG}", '.')
                }
            }
        }

        // Stage 4: Push Docker image to Docker Hub
        stage('Push Docker Image') {
            steps {
                script {
                    // Log in to Docker Hub User Account
                    docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
                        // Push the Docker image
                        dockerImage.push()
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}