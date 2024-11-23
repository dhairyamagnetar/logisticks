pipeline {
    agent any

    environment {
        BACKEND_IMAGE = 'keshavchandak/logisticks-backend'
        FRONTEND_IMAGE = 'keshavchandak/logisticks-frontend'
        DOCKER_TAG = 'latest'
    }

    stages {
        stage('Build Backend') {
            steps {
                dir('backend') {
                    sh '/var/lib/jenkins/.sdkman/candidates/gradle/8.11.1/bin/gradle clean build'
                }
            }
        }
        stage('Build Frontend') {
            steps {
                dir('frontend') {
                    sh 'npm install'
                    sh 'npm run build'
                }
            }
        }
        stage('Dockerize') {
            steps {
                sh 'docker-compose build'
            }
        }
        stage('Push to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerHubCredentials') {
                        // Push backend image
                        docker.image("${BACKEND_IMAGE}:${DOCKER_TAG}").push()

                        // Push frontend image
                        docker.image("${FRONTEND_IMAGE}:${DOCKER_TAG}").push()
                    }
                }
            }
        }
        stage("Deploy via ansible") {
            steps {
                ansiblePlaybook(
                    installation: 'Ansible',
                    inventory: 'inventory/inventory.ini',
                    playbook: 'playbook/deploy.yml',
                )
            }
        }
    }
}
