stage("Pull source code"){
	node("master"){
		git 'https://github.com/jpenekusu/sample-java-project.git'
		sh "mvn install"
	}
}
