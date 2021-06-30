## Blue-green deployment with a database on Kubernetes  [![Twitter](https://img.shields.io/twitter/follow/piotr_minkowski.svg?style=social&logo=twitter&label=Follow%20Me)](https://twitter.com/piotr_minkowski)

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

