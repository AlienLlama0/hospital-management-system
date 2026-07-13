javac -cp ".:lib/jdbc.jar" $(find . -name "*.java")
java --enable-native-access=ALL-UNNAMED -cp ".:lib/jdbc.jar" Main