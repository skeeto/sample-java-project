stage("Get source code"){
	node("master"){
		checkout scm
		////git 'https://github.com/jpenekusu/sample-java-project.git'
	}
}

stage("Build"){
	node("master"){
		sh "mvn compile -DskipTests"
	}
}

stage("Build"){
	node("master"){
		sh "mvn test"
	}
}
