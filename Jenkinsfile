pipeline {
    agent any
    tools {
        maven 'maven-app'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
        stage ('Build') {
           steps {
                sh 'mvn -Dmaven.test.failure.ignore=true install' 
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
        stage('Docker'){
            steps {withCredentials([usernamePassword(credentialsId:'DOCKER',passwordVariable:'Itsmedantesh@42',usernameVariable:'dantesh')]) {
                sh '''
                    docker login -u ${usernameVariable} -p ${passwordVariable}
                '''
            }
            }
            post{
                success{
                    echo "Docker Login Success"
                }
                failure{
                    echo "Docker Login Failed"
                }
        
            }        
        }
    }
}
