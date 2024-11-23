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
                    // Push backend image
                    sh "docker tag ${BACKEND_IMAGE}:latest ${BACKEND_IMAGE}:${DOCKER_TAG}"
                    sh "docker push ${BACKEND_IMAGE}:${DOCKER_TAG}"

                    // Push frontend image
                    sh "docker tag ${FRONTEND_IMAGE}:latest ${FRONTEND_IMAGE}:${DOCKER_TAG}"
                    sh "docker push ${FRONTEND_IMAGE}:${DOCKER_TAG}"
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
