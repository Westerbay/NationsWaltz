mkdir -p build
cd src
clear
javac -d ../build Main.java
if [ $? -ne 0 ] 
then
	exit 1
fi
cd ../build
java Main
