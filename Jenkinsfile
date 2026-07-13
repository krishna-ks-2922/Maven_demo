pipeline {

    agent { label 'linux-agent' }

    options {
        timestamps()
        timeout(time: 1, unit: 'HOURS')
        skipDefaultCheckout(true)
    }

    tools {
        maven 'Maven'
    }

    environment {
        JAVA_HOME = '/usr/lib/jvm/java-21-openjdk-amd64'
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
    }

    stages {

        stage('Start') {
            steps {
                echo '=========================================='
                echo "Maven Build Started: ${new Date()}"
                echo '=========================================='
            }
        }

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Check Tools') {
            steps {
                sh '''
                    echo "JAVA_HOME=$JAVA_HOME"

                    echo "Java version:"
                    java -version

                    echo "Java compiler version:"
                    javac -version

                    echo "Java executable:"
                    which java

                    echo "Java compiler executable:"
                    which javac

                    echo "Maven version:"
                    mvn -version
                '''
            }
        }

        stage('Parallel Maven Build') {
            steps {
                sh '''
                    echo "Starting Maven build with 2 threads..."
                    mvn -T 2 clean package
                '''
            }
        }

        stage('Run Odd-Even Application') {
            steps {
                sh '''
                    echo "Running Odd-Even application..."

                    java -cp odd-even/target/odd-even-1.0-SNAPSHOT.jar \
                    com.krishna.OddEven 10
                '''
            }
        }

        stage('Run Number-Sign Application') {
            steps {
                sh '''
                    echo "Running Number-Sign application..."

                    java -cp number-sign/target/number-sign-1.0-SNAPSHOT.jar \
                    com.krishna.NumberSign -5
                '''
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts(
                    artifacts: '**/target/*.jar',
                    fingerprint: true,
                    allowEmptyArchive: false
                )
            }
        }
    }

    post {

        always {
            junit(
                testResults: '**/target/surefire-reports/*.xml',
                allowEmptyResults: true
            )

            archiveArtifacts(
                artifacts: '**/target/surefire-reports/**',
                allowEmptyArchive: true
            )

            echo '=========================================='
            echo "Maven Build Finished: ${new Date()}"
            echo '=========================================='
        }

        success {
            echo 'MAVEN PARALLEL BUILD SUCCESS'
        }

        failure {
            echo 'MAVEN BUILD FAILED'
        }
    }
}