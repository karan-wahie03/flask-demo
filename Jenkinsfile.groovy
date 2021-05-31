properties([
    parameters([
        gitParameter(branch: '',
                     branchFilter: 'origin/(.*)',
                     defaultValue: 'master',
                     description: '',
                     name: 'BRANCH',
                     quickFilterEnabled: false,
                     selectedValue: 'NONE',
                     sortMode: 'NONE',
                     tagFilter: '*',
                     useRepository: 'https://github.com/karan-wahie03/flask-demo.git/',
                     type: 'PT_BRANCH')
    ])
])


node("master") {

try {

    STATUS = 'STARTED'
    CCODE = 'warning'
    GIT_COMMIT_HASH="Unable to fetch, yet to git clone !!"

    stage('Clean workspace before build') {
    deleteDir()
    }

    STATUS = 'FAILED'
    CCODE = 'danger'

    stage('Code checkout') {
      checkout([$class: 'GitSCM',
      branches: [[name: '*/$BRANCH']],
      gitTool: 'Default',
      userRemoteConfigs: [[credentialsId: 'Jenkins-Monotype-Github',
      url: 'https://github.com/karan-wahie03/flask-demo.git/']]]
      )
    }

  stage('Build Image') {

    }

stage("Deploy Image") {


  }

    STATUS = 'SUCCESS'
    CCODE = 'good'



  }


  catch (error) {
    throw error
  }

}
