## Blue-green deployment with a database on Kubernetes  [![Twitter](https://img.shields.io/twitter/follow/piotr_minkowski.svg?style=social&logo=twitter&label=Follow%20Me)](https://twitter.com/piotr_minkowski)

[![CircleCI](https://circleci.com/gh/piomin/sample-spring-bluegreen-with-db.svg?style=svg)](https://circleci.com/gh/piomin/sample-spring-bluegreen-with-db)

[![SonarCloud](https://sonarcloud.io/images/project_badges/sonarcloud-black.svg)](https://sonarcloud.io/dashboard?id=piomin_sample-spring-bluegreen-with-db)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=piomin_sample-spring-bluegreen-with-db&metric=bugs)](https://sonarcloud.io/dashboard?id=piomin_sample-spring-bluegreen-with-db)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=piomin_sample-spring-bluegreen-with-db&metric=coverage)](https://sonarcloud.io/dashboard?id=piomin_sample-spring-bluegreen-with-db)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=piomin_sample-spring-bluegreen-with-db&metric=ncloc)](https://sonarcloud.io/dashboard?id=piomin_sample-spring-bluegreen-with-db)

Detailed description can be found here: [Blue-green deployment with a database on Kubernetes](https://piotrminkowski.com/2021/02/18/blue-green-deployment-with-a-database-on-kubernetes/)


## Quick Start using Minikube


> For Windows, all minikube and kubectl commands should be run in an Administrator CMD shell.

### Install and start minikube

`minikube start`

Start the minikube dashboard

`minikube dashboard`

> Consider doing this in another shell as it 

#### Install Istio on the host machine and install in Minikube

Installation instructions for Istio are [here.]((https://istio.io/latest/docs/setup/install/istioctl/))

`istioctl install`

### Install Postgres in Minikube

`kubectl create -f postgresql-deployment.yaml `

### Create a Liquibase container with environment information

> See the Dockerfile for more details

`docker build -t liquibase/bg-k8s-liquibase .`

`docker push liquibase/bg-k8s-liquibase`

> You will want to change this to match your Docker Hub username.

### Create Liquibase Config Maps and Jobs

> The config map is the Liquibase changelog.

`kubectl create -f liquibase-cm-v1.yaml`

> The Job runs liquibase with the config map.

`kubectl create -f liquibase-job-v1.yaml`

> Repeat for Version 2

`kubectl create -f liquibase-cm-v2.yaml`

`kubectl create -f liquibase-job-v2.yaml`

