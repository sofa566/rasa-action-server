#/bin/bash
# copy rasa-java-sdk.jar from project "rasa-java-sdk"/target to libs/rasa-java-sdk-2.3.0.jar
SDK=rasa-java-sdk.jar
SDK_VER=rasa-java-sdk-2.3.0.jar
SDK_PATH=/home/bill/Desktop/src_botfront/rasa-java-sdk
SDK_SRC=$SDK_PATH/target/$SDK
mkdir -p libs && cp $SDK_SRC libs/$SDK_VER

docker build -t sofa566/rasa_action_server:2.3.0 .
