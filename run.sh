javac -d bin -cp "lib/*" $(find java -name "*.java")
java -cp "bin:lib/*" Main