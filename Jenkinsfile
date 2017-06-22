#!groovy

node {
    stage('Checkout sources') {
        checkout scm
    }
    stage('Compile, build and test server') {
        sh "mvn --batch-mode clean package -Denvironment=prod"
    }
    stage('Report server tests results') {
        junit 'target/surefire-reports/TEST-*.xml, target/failsafe-reports/TEST-*.xml'
    }
    stage('Tag sources') {
        if (env.BRANCH_NAME == 'master') {
            sh "git tag ${getNewVersion()}"
            sh "git push origin HEAD:${env.BRANCH_NAME} --tags"
        } else {
            skipStep()
        }
    }
    stage('Build and push docker image') {
        if (env.BRANCH_NAME == 'master') {
            wrap([$class: 'ConfigFileBuildWrapper',
                  managedFiles: [[fileId: 'maven-settings',
                                  variable: 'MAVEN_SETTINGS']]]
            ) {
                sh "mvn --batch-mode versions:set -DnewVersion='${getNewVersion()}' -DgenerateBackupPoms=false"
                sh "mvn --batch-mode docker:build --settings ${env.MAVEN_SETTINGS}"
            }
        } else {
            skipStep()
        }
    }
    stage('Deploy new version') {
        if (env.BRANCH_NAME == 'master') {
            sh "docker service update ${getServiceName()} --image=pvardanega/${getServiceName()}:${getNewVersion()}"
        } else {
            skipStep()
        }
    }
}

private void skipStep() {
    echo "Skipped because not master branch"
}

private String getNewVersion() {
    return new Date().format("yyyy-MM-dd") + "-b${env.BUILD_NUMBER}"
}

private String getServiceName() {
    return env.JOB_NAME.split('/')[0]
}