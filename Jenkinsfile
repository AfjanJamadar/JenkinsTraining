pipeline {

    agent any

    tools {
        jdk 'Jdk-25'
        maven 'Maven-3.9.16'
    }

    environment {
        DB_USERNAME = credentials('db-username')
        DB_PASSWORD = credentials('db-password')
    }

    stages {

        stage('Checkout Source Code') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/AfjanJamadar/JenkinsTraining.git'
            }
        }

        stage('Compile') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Package Application') {
            steps {
                bat 'mvn package -DskipTests'
            }
        }
			
			stage('Stop Existing Application') {
			    steps {
			        bat '''
			        @echo off
			
			        for /f "tokens=5" %%a in ('netstat -ano ^| findstr :9091') do (
			            echo Stopping PID %%a
			            taskkill /PID %%a /F
			        )
			
			        exit /b 0
			        '''
			    }
			}
			
       stage('Deploy Application') {
		    steps {
		        bat '''
		        @echo off
		        echo Starting Spring Boot Application...
		
		        for %%f in (target\\*.jar) do (
		            start /b "" java -jar "%%f"
		        )
		
		        timeout /t 10 > nul
		
		        echo Application Started Successfully.
		        '''
		    }
		}

    }

    post {

        success {
            echo 'Pipeline executed successfully.'
        }

        failure {
            echo 'Pipeline failed.'
        }

    }

}