
pipeline 
{
    environment 
    {
        registryCredential = "DOCKER"
    }
    agent any
    tools {
        maven 'maven-app'
    }
    stages {
        
        /*stage('Env')
        {
            def dockerHome = tool 'docker-app'
            def mavenHome  = tool 'maven-app'
            env.PATH = "${dockerHome}/bin:${mavenHome}/bin:${env.PATH}"
        } */
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
                sh 'mvn -Dmaven.test.failure.ignore=true clean install' 
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
        stage('Load') {
            steps{
                script {
                    app = docker.build("dantesh/simple-spring")
                    }
                }
            post{
                success{
                    echo "Docker Image created Successfully"
                }
                failure{
                    echo "Docker Image not created Successfully"
                }
            }    
        
        }        
    }
}
