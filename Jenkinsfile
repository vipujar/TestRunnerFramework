pipeline {
    agent {
        docker { image 'maven:3.5.3-jdk-8-alpine' }
    }
    stages {
        stage('Test') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}