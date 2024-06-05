#!/bin/sh
mvn clean -Dmaven.repo.local=/home/cschmitz/.m2/repository package -Dmaven.test.skip=true
