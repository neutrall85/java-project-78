#Makefile

run-dist:
	./build/install/app/bin/app

run:
	./gradlew run

install-dist:
	./gradlew clean installDist

lint:
	./gradlew checkstyleMain
	./gradlew checkstyleTest

build:
	./gradlew clean
	./gradlew installDist

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

.PHONY: build
