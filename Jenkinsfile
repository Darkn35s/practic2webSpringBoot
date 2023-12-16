pipeline{
  agent any
  tools{
      maven 'Default'
  }
  stages{
    stage('build'){
      steps{
        echo 'test-----'
        git 'https://github.com/Darkn35s/practic2webSpring'
        bat 'mvn clean install -Dmaven.test.failure.ignore=true'
        bat 'docker-compose up -d'
      }
    }
  }
}
