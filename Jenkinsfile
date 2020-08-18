pipeline {
  agent any
  tools
  {
    // TestMaven that we give in jekins->Mange Jenkins->Global Tool Configuration->Maven->TestMaven
    maven "TestMaven"
  }
  stages {
      
      stage('Git-Checkout') {
            steps {
              sh 'echo "First Step:Git-Checkout"'
              git 'https://github.com/rahnaalfia/POMFrameworkAug2020'
             
            }
        }
        
       stage('Build') {
            steps {
              sh 'echo "Second Step:Build"'
              sh "mvn -version"
              sh "mvn clean install"
              publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'build', reportFiles: 'TestExecutionReport.html', 
                           reportName: 'FrameworkManiaExtendedReprotFromJenkins', reportTitles: ''])
            }
        }
        stage('Test') {
            steps {
                sh 'echo "Third Step:TestNG Tests"'

            }
        }
    stage('Deploy') {
            steps {
                sh 'echo "Fourth Step:Deploy"'

            }
        }
    
stage('Email') {
            steps {
               sh 'echo "Fifth Step:Email"'
              
              
               mail to: 'rahnatest@gmail.com',
          subject: "Email Report: ${currentBuild.fullDisplayName}",
          body: "${env.BUILD_URL} has result ${currentBuild.result}"
             
             
            }
        }

   

  }
  post {
    always {
      echo 'always runs regardless of the completion status of the Pipeline run'
      // To use System.getProperty Navigate to jenkins > Manage jenkins > In-process Script Approval and There was a pending command, which I had to approve.
      emailext (to: 'rahnatest@gmail.com', replyTo: 'rahnatest@gmail.com', subject:"Extended Email Report: ${currentBuild.fullDisplayName}", body: readFile("${System.getProperty('user.home')}"+"/.jenkins/jobs/PipelineGroovyScriptedFromSCM/htmlreports/FrameworkManiaExtendedReprotFromJenkins/TestExecutionReport.html"), mimeType: 'text/html');
      // Clean Workspace
      cleanWs()
    }
    success {
      echo 'step will run only if the build is successful'
    }
    failure {
      echo 'only when the Pipeline is currently in a "failed" state run, usually expressed in the Web UI with the red indicator.'
    }
    unstable {
      echo 'current Pipeline has "unstable" state, usually by a failed test, code violations and other causes, in order to run. Usually represented in a web UI with a yellow indication.'
    }
    changed {
      echo 'can only be run if the current Pipeline is running at a different state than the previously completed Pipeline'
    }
  }
}
