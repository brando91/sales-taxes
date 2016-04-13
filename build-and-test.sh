#!/bin/bash

function signal(){
	echo "******* $1 *******"
}

set -e
relative_path=`dirname $0`
root=`cd $relative_path/;pwd`
project=$root/sales-taxes
build=$project/build
jar=$project/app.jar

signal "Building Project"
rm -rf $build
mkdir -p $build
javac -encoding utf8 -cp .:$project/lib/* $project/*/*/*.java -d $build

cd $build
for file in $project/lib/*.jar
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
