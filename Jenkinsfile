//allocation of executors happens here
//Master Agent NODE in Jenkins
//This allocation is not a topic for freeStyle Jobs, 
//That is why in Pipeline we can make Parallel RUN, 
//allocated multiple nodes, SAVE State of Stages,....
node {
     
    try {
        stage('Checkout src-code') {
            git 'https://github.com/azatsatklichov/vatinfo'
        }
          
        stage('Clean Verify') {
            bat 'mvn clean  install'   
            //bat 'mvn clean  install -Dmaven.test.skip=true'   
            //bat 'mvn clean  install -DskipTests=true'  
        }
        
        stage('Archiving and Test Gen') {
            archiveArtifacts 'target/*.jar'
            step([$class: 'JUnitResultArchiver', testResults: 'target/surefire-reports/TEST-*.xml'])
            publishHTML([allowMissing: false, 
                            alwaysLinkToLastBuild: false, 
                            keepAll: false, 
                            reportDir: 'target/site/jacoco/', 
                            reportFiles: 'index.html', 
                            reportName: 'Code Coverage', 
                            reportTitles: ''])
        }
        // def  prj_path = "c:\\Users\\ASUS\\.jenkins\\workspace\\vatinfo-pipeline\\vatinfo-pipeline"
        //   dir (prj_path){
        //         stage('Clean Verify') { 
        //             bat 'mvn clean  install -DskipTests=true'  
        //           sh 'ls -l'
        //     }
        // }  
        
        
        // if (env.BRANCH_NAME == "develop") {
        //     stage('Docker') {
        //         sh 'mvn docker:build -DpushImage'
        //     }
        // } 
        
        //stage('Sending Success Notification') {
            //emailext body: 'Habar Uchyn Pochta Ulgamy, kop sagbolun', replyTo: 'azatsatklichov@gmail.com', subject: 'Berekella - Mail', to: 'azats@seznam.cz'
            notify('Build Success')
        //} 
    } catch (err) {
        echo "Caught: ${err}"
        currentBuild.result = 'FAILURE'
        //stage('Sending Fail Notification') {
        notify('Fail Notification')
        //}
    }

}

def notify(status) {
    emailext (
        to: 'azats@seznam.cz', 
        subject: "${status}: Job: '${env.JOB_NAME} [${env.BUILD_NUMBER}]' ",
        body: "Habar Uchyn Pochta Ulgamy, kop sagbolun. </br> Job:  </br> <a href='${env.BUILD_URL}'>'${env.JOB_NAME} [${env.BUILD_NUMBER}]'</a>", 
        replyTo: 'azatsatklichov@gmail.com'
    )
}