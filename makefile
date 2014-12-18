#Christian Frantzen - 000394691 - BA2 INFO
JC = javac
.SUFFIXES: .java .class
.java.class:
				$(JC) $*.java

CLASSES = \
				Node.java \
				TreatableNode.java \
				Graph.java \
				ThreadParcours.java \
				MainFile.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
				$(RM) *.class
