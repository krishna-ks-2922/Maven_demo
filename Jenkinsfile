pipeline {
    agent { label 'linux-agent' }

    tools {
        maven 'Maven'
    }

    stages {
        stage('Check Tools') {
            steps {
                sh '''
                    java -version
                    mvn -version
                '''
            }
        }

        stage('Parallel Maven Build') {
            steps {
                sh '''
                    mvn -T 2 clean package
                '''
            }
        }

        stage('Run Applications') {
            steps {
                sh '''
                    echo "Running Odd-Even application"
                    java -cp odd-even/target/odd-even-1.0-SNAPSHOT.jar \
                    com.krishna.OddEven 10

                    echo "Running Number-Sign application"
                    java -cp number-sign/target/number-sign-1.0-SNAPSHOT.jar \
                    com.krishna.NumberSign -5
                '''
            }
        }
    }

    post {
        always {
            junit testResults: '**/target/surefire-reports/*.xml',
                  allowEmptyResults: true
        }

        success {
            echo 'Maven parallel build completed successfully!'
        }

        failure {
            echo 'Maven build failed.'
        }
    }
}