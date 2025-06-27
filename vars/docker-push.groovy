def call(String dockeercread-id, String imageName){

    withCredentials([usernamePassword(
            credentialsId: "${dockeercread-id}", 
            usernameVariable: 'DOCKER_USER', 
            passwordVariable: 'DOCKER_PASS')]) {
            
                sh "docker login -u ${env.DOCKER_USER} -p ${env.DOCKER_PASS}" 
                sh "docker image tag "${imageName}":latest ${env.DOCKER_USER}/"${imageName}"
                sh "docker push ${env.DOCKER_USER}/${imageName}:latest"
        }
}