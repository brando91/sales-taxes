#!/bin/bash

function signal(){
	echo "******* $1 *******"
}

set -e
relative_path=`dirname $0`
root=`cd $relative_path/;pwd`
project=$root/sales-taxes
build=$project/build
jar=$root/app.jar

signal "Building Project"
cd $project
rm -rf $build
mkdir -p $build
javac -encoding utf8 -cp .:'lib/*' */*/*.java -d $build

cd $build
for file in ../lib/*.jar
do
	jar xf $file
done

rm -f $jar
jar cvfe $jar -C . > /dev/null
chmod 777 $jar

cd $project
signal "Running Tests"
java -cp .:$jar org.junit.runner.JUnitCore acceptance.TestSuite
signal "Done"
