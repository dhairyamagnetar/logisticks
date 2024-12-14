pipeline {
    agent any

    environment {
        BACKEND_IMAGE = 'dhairyamagnetar/logisticks-backend'
        FRONTEND_IMAGE = 'dhairyamagnetar/logisticks-frontend'
        DOCKER_TAG = 'latest'
        PATH="/var/lib/jenkins/.sdkman/candidates/gradle/8.11.1/bin:$PATH"
        K8S_AUTH_KUBECONFIG="~/.kube/config"
    }

    stages {
        stage('Build Backend') {
            steps {
                dir('backend') {
                    sh 'gradle clean build'
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
                sh 'chmod 600 ${VAULT_PASSWORD_FILE}'
                ansiblePlaybook(
                    installation: 'Ansible',
                    inventory: 'inventory.ini',
                    playbook: 'deploy.yml',
                    extras: '--vault-password-file=${VAULT_PASSWORD_FILE}'
                )
            }
        }
    }
}
