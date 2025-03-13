pipeline {
    agent any

    stages {
        // Stage 1: Checkout code from GitHub using GitHub PAT
        stage('Checkout Code') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/main']],
                    extensions: [],
                    userRemoteConfigs: [[
                        url: 'https://github.com/sammyCHY/cidemo-advanced.git',
                        credentialsId: 'sammychy-pat' // Your GitHub credentials ID in Jenkins
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
                sh 'docker build -t cidemo:${BUILD_ID} .'
            }
        }

        // Stage 4: Push Docker image to Docker Hub
        stage('Push Docker Image') {
            steps {
                withDockerRegistry([credentialsId: "DockerHub-pat", url: ""]) {
                    sh 'docker push cidemo:${BUILD_ID}'
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
