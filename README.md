## todo-app

### install instructions

make sure latest docker is installed

* cd to project director
>docker-compose up

* goto 
  * [frontend] (http://localhost:4200)
  * [backend] (http://localhost:8080)



Using kubernetes

first tag and push to docker hub.
>docker login
>docker build ./front-end
>docker tag <image> jqayyum/todo-frontend
>docker push jqayyum/todo-frontend

>docker build ./back-end
>docker tag <image> jqayyum/back-frontend
>docker push jqayyum/todo-backend


make sure kubectl and minkiube is installed
>minikube start

>kubectl create -f pod-todo.yml
>kubectl port-forward todo 4200:4200
>kubectl port-forward todo 8080:8080
