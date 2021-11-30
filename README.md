# Spring Boot Sample With Zero Config

This is a sample project to use Eclipse JKube plugins.

### Steps to use

Make sure that Kubernetes/OpenShift cluster or Minikube/minishift is running. In case, if anything of this is not running, you can
run minishift/minikube to test this application by using following command.



#### For OpenShift
```
minishift start
```
Below command will create your OpenShift resource descriptors.
```
mvn clean oc:resource -Popenshift
```

Now start S2I build  by hitting the build goal.
```
mvn package oc:build -Popenshift
```

Below command will deploy your application on OpenShift cluster.
```
mvn oc:deploy -Popenshift
```
