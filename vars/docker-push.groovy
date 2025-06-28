def call(String dockerCredId, String imageName) {
    withCredentials([usernamePassword(
           credentialsId: dockerCredId, 
            usernameVariable: 'DOCKER_USER', 
            passwordVariable: 'DOCKER_PASS')]) {
            
                sh "docker login -u ${DOCKER_USER} -p ${DOCKER_PASS}" 
                sh "docker image tag ${imageName}:latest ${DOCKER_USER}/${imageName}:latest"
                sh "docker push ${DOCKER_USER}/${imageName}:latest"
        }
}
