pipeline {
   agent {
           docker { image 'papesambandour/docker-node-alpine-16-git:1.1' }
       }

    stages {
        stage('Install caprover CLI'){
          steps{
             echo "START INSTALL CAPROVER CLI"
             sh 'npm install -g caprover'
             echo "END INSTALL CAPROVER CLI"
          }
        }

        stage('Deployment') {
            steps {
                echo 'Start deploy'
                sh 'caprover deploy -h https://captain.cortech.cloud -p ${PASSWORD_CAPROVER} -b $GIT_BRANCH -a api-memoire'
                echo 'END DEPLOY'
            }
        }
    }
}
